import io.grpc.Server;
import io.grpc.ServerBuilder;
import services.ChatbotService;

import java.io.IOException;

public class gRPCServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        Server server = ServerBuilder.
                forPort(9090).addService(new ChatbotService()).build();

        server.start();

        System.out.println("Chatbot server started @" + server.getPort());

        server.awaitTermination();
    }
}
