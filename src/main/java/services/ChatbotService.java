package services;

import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.lolcampselector.grpc.Chatapi;
import com.lolcampselector.grpc.ChatbotGrpc;
import io.grpc.stub.StreamObserver;
import model.ChampionAbility;

import java.io.FileNotFoundException;

public class ChatbotService extends ChatbotGrpc.ChatbotImplBase {

    private final AI nako = new AI();

    @Override
    public void sendMessage(Chatapi.Message request, StreamObserver<Chatapi.chatbotResponse> responseObserver) {

        Chatapi.chatbotResponse.Builder response = Chatapi.chatbotResponse.newBuilder();


        System.out.println(request.getMessage());
        String userInput = AI.parseUserInput(request.getMessage());

        // Determine intent
        DetectIntentResponse token = null;

        token = this.nako.determineIntent(userInput);

        try {
            response.setMessage(nako.getResponse(token));
            if(token.getQueryResult().getParameters().getFieldsMap().get("Champion") != null){
                response.setChampion(token.getQueryResult().getParameters().getFieldsMap().get("Champion").getStringValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Send the response back to the client
        responseObserver.onNext(response.build());

        // Close the call
        responseObserver.onCompleted();
    }

    @Override
    public void getChampionAbility(Chatapi.championAbilityRequest request, StreamObserver<Chatapi.Message> responseObserver) {
        String requested_champion = request.getChampion();
        String ability = request.getAbility();

        Chatapi.Message.Builder response = Chatapi.Message.newBuilder();
        this.nako.getChampions().forEach(champion -> {
            if (champion.getName().equalsIgnoreCase(requested_champion)) {

                ChampionAbility championAbility = this.nako.getChampionsAbilities().get(champion.getName().toUpperCase());

                // TODO: Match champion
                switch (ability) {
                    case "Passive":
                        response.setMessage(championAbility.getPassive());
                        break;
                    case "Q":
                        response.setMessage(championAbility.getQ());
                        break;
                    case "W":
                        response.setMessage(championAbility.getW());
                        break;
                    case "E":
                        response.setMessage(championAbility.getE());
                        break;
                    case "R":
                        response.setMessage(championAbility.getR());
                        break;
                }
            }
        });

        // Send the response back to the client
        responseObserver.onNext(response.build());

        // Close the call
        responseObserver.onCompleted();

    }

    @Override
    public void getChampionInformation(Chatapi.Message request, StreamObserver<Chatapi.championInformationRequest> responseObserver) {
        String requested_champion = request.getMessage();

        Chatapi.Info.Builder championInfo = Chatapi.Info.newBuilder();
        Chatapi.championInformationRequest.Builder response = Chatapi.championInformationRequest.newBuilder();


        this.nako.getChampions().forEach(champion -> {
            if (champion.getName().equalsIgnoreCase(requested_champion)) {
                response.setChampion(champion.getName());

                response.setTitle(champion.getTitle());

                championInfo.setAttack(champion.getInfo().getAttack().toString());
                championInfo.setDefense(champion.getInfo().getDefense().toString());
                championInfo.setMagic(champion.getInfo().getMagic().toString());
                championInfo.setDifficulty(champion.getInfo().getDifficulty().toString());

                response.setInfo(championInfo);

                ChampionAbility championAbility = this.nako.getChampionsAbilities().get(champion.getName().toUpperCase());
                response.putAbilities("passive", championAbility.getPassive());
                response.putAbilities("q", championAbility.getQ());
                response.putAbilities("w", championAbility.getW());
                response.putAbilities("e", championAbility.getE());
                response.putAbilities("r", championAbility.getR());
                response.addAllTags(champion.getTags());

                response.putAbilitiesIcons("passive", champion.getSpells().get(4));
                response.putAbilitiesIcons("q", champion.getSpells().get(0));
                response.putAbilitiesIcons("w", champion.getSpells().get(1));
                response.putAbilitiesIcons("e", champion.getSpells().get(2));
                response.putAbilitiesIcons("r", champion.getSpells().get(3));

                responseObserver.onNext(response.build());

                // Close the call
                responseObserver.onCompleted();
            }
        });
    }
}
