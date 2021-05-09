package services;

import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.lolcampselector.grpc.Chatapi;
import com.lolcampselector.grpc.ChatbotGrpc;
import io.grpc.stub.StreamObserver;

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
        String champion = request.getChampion();
        String ability = request.getAbility();

        Chatapi.Message.Builder response = Chatapi.Message.newBuilder();

        // TODO: Match champion
        switch (ability){
            case "Passive":
                response.setMessage("https://d28xe8vt774jo5.cloudfront.net/champion-abilities/0103/ability_0103_P1.webm");
                break;
            case "Q":
                response.setMessage("https://d28xe8vt774jo5.cloudfront.net/champion-abilities/0103/ability_0103_Q1.webm");
                break;
            case "W":
                response.setMessage("https://d28xe8vt774jo5.cloudfront.net/champion-abilities/0103/ability_0103_W1.webm");
                break;
            case "E":
                response.setMessage("https://d28xe8vt774jo5.cloudfront.net/champion-abilities/0103/ability_0103_E1.webm");
                break;
            case "R":
                response.setMessage("https://d28xe8vt774jo5.cloudfront.net/champion-abilities/0103/ability_0103_R1.webm");
                break;
        }

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

                response.putAbilities("ability1", "a");
                response.addAllTags(champion.getTags());

                responseObserver.onNext(response.build());

                // Close the call
                responseObserver.onCompleted();
            }
        });
    }
}
