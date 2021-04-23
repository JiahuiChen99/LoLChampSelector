package services;

import com.lolcampselector.grpc.Chatapi;
import com.lolcampselector.grpc.ChatbotGrpc;
import io.grpc.stub.StreamObserver;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ChatbotService extends ChatbotGrpc.ChatbotImplBase {

    @Override
    public void sendMessage(Chatapi.Message request, StreamObserver<Chatapi.chatbotResponse> responseObserver) {

        Chatapi.chatbotResponse.Builder response = Chatapi.chatbotResponse.newBuilder();


        System.out.println(request.getMessage());
        String userInput = AI.parseUserInput(request.getMessage());

        // Determine intent
        String token = null;
        try {
            token = AI.determineIntent(userInput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            response.setMessage(AI.getResponse(token, userInput));
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
        super.getChampionAbility(request, responseObserver);
    }
}
