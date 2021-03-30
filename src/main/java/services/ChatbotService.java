package services;

import com.lolcampselector.grpc.Chatapi;
import com.lolcampselector.grpc.ChatbotGrpc;
import io.grpc.stub.StreamObserver;

public class ChatbotService extends ChatbotGrpc.ChatbotImplBase {

    @Override
    public void sendMessage(Chatapi.Message request, StreamObserver<Chatapi.Message> responseObserver) {

        Chatapi.Message.Builder response = Chatapi.Message.newBuilder();

        response.setMessage("This is an echo: " + request.getMessage());

        System.out.println(request.getMessage());

        // Send the response back to the client
        responseObserver.onNext(response.build());

        // Close the call
        responseObserver.onCompleted();
    }

    @Override
    public void getMessage(Chatapi.EmptyMessge request, StreamObserver<Chatapi.APIResponse> responseObserver) {

    }
}
