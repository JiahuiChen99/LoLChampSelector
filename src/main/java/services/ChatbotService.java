package services;

import com.lolcampselector.grpc.Chatapi;
import com.lolcampselector.grpc.ChatbotGrpc;
import io.grpc.stub.StreamObserver;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ChatbotService extends ChatbotGrpc.ChatbotImplBase {

    //private final AI nako = new AI();

    @Override
    public void sendMessage(Chatapi.Message request, StreamObserver<Chatapi.chatbotResponse> responseObserver) {

        Chatapi.chatbotResponse.Builder response = Chatapi.chatbotResponse.newBuilder();


        System.out.println(request.getMessage());
        String userInput = AI.parseUserInput(request.getMessage());

        // Determine intent
        String token = null;

        token = AI.determineIntent(userInput);

        //try {
            //response.setMessage(AI.getResponse(token, userInput));
            response.setMessage(token);
        /*} catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

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
}
