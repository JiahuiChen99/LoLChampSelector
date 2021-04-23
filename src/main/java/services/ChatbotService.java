package services;

import com.lolcampselector.grpc.Chatapi;
import com.lolcampselector.grpc.ChatbotGrpc;
import io.grpc.stub.StreamObserver;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ChatbotService extends ChatbotGrpc.ChatbotImplBase {

    @Override
    public void sendMessage(Chatapi.Message request, StreamObserver<Chatapi.Message> responseObserver) throws FileNotFoundException {

        Chatapi.Message.Builder response = Chatapi.Message.newBuilder();


        System.out.println(request.getMessage());
        String userInput = AI.parseUserInput(request.getMessage());

        // Determine intent
        String token = null;
        try {
            token = AI.determineIntent(userInput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        response.setMessage(AI.getResponse(token, userInput));

        // Send the response back to the client
        responseObserver.onNext(response.build());

        // Close the call
        responseObserver.onCompleted();
    }

    @Override
    public void getMessage(Chatapi.EmptyMessge request, StreamObserver<Chatapi.APIResponse> responseObserver) {

    }
}
