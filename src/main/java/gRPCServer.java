import io.grpc.Server;
import io.grpc.ServerBuilder;
import model.Champion;
import services.ChatbotService;
import services.DataLoader;

import java.io.IOException;
import java.util.ArrayList;

public class gRPCServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        Server server = ServerBuilder.
                forPort(9090).addService(new ChatbotService()).build();

        server.start();


//        ArrayList<Champion> champions = DataLoader.loadChampionData();
        System.out.println("Chatbot server started @ " + server.getPort());

        server.awaitTermination();
    }
}
