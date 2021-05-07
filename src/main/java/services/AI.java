package services;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.dialogflow.v2.*;
import com.google.common.collect.Lists;
import model.*;
import model.Dictionary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class AI {

    private static final String PROJECT_ID = "lol-champ-selector-nlp-lutb";
    private static final String LANGUAGE_CODE = "en";

    private GoogleCredentials credentials = null;
    private SessionsSettings sessionsSettings = null;
    private SessionsClient sessionsClient = null;
    private SessionName session = null;

    public AI() {

        try {
            credentials = GoogleCredentials.fromStream(new FileInputStream("src/main/resources/nako_nlp.json"))
                    .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));

            credentials.toBuilder().build();

            SessionsSettings.Builder settingsBuilder = SessionsSettings.newBuilder();

            sessionsSettings = settingsBuilder.setCredentialsProvider(FixedCredentialsProvider.create(credentials)).build();

            sessionsClient = SessionsClient.create(sessionsSettings);
            session = SessionName.of(PROJECT_ID, LANGUAGE_CODE);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Sanitize user's input by removing all special characters
     * and splits them into tokens
     * @param userInput
     * @return List of tokens
     */
    public static String parseUserInput(String userInput) {

        // Sanitize user input by replacing all special characters
        return userInput.replaceAll("[^a-zA-Z0-9]", " ");

    }

    /**
     * Determines user's input intent - simple statements
     * @param userInput
     * @return
     * @throws FileNotFoundException
     */
    public String determineIntent(String userInput)  {


        // DialogFlow gRPC client

        // You can specify a credential file by providing a path to GoogleCredentials.
        // Otherwise credentials are read from the GOOGLE_APPLICATION_CREDENTIALS environment variable.



            TextInput.Builder textInput = TextInput.newBuilder().setText("hello").setLanguageCode(LANGUAGE_CODE);

            QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();

            DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);
            return response.toString();
//        return "DONT_UNDERSTAND";
    }

    public static String getResponse(String token, String userInput) throws FileNotFoundException {

        HashMap<String, Keyword> intents = DataLoader.loadIntents();
        Keyword keyword;
        Random randomizer = new Random();

        switch (Dictionary.valueOf(token)){
            case DIFFICULTY:
                String difficulty = "";
                keyword = intents.get("DIFFICULTY");
                for (String text : keyword.getText()) {
                    if (userInput.contains(text)) {
                        difficulty = text;
                        break;
                    }
                }
                return recommendChampionByDifficulty(difficulty);
            case GREETING:
                keyword = intents.get("GREETING");
                int randomGreeting = randomizer.nextInt(keyword.getResponses().size());
                return keyword.getResponses().get(randomGreeting);
            case SAYOUNARA:
                keyword = intents.get("SAYOUNARA");
                int randomSayounara = randomizer.nextInt(keyword.getResponses().size());
                return keyword.getResponses().get(randomSayounara);
            case CHAMPION_INFO:
                String toBeRemovedFromUserInput = "";
                keyword = intents.get("CHAMPION_INFO");
                for (String text : keyword.getText()) {
                    if (userInput.contains(text)) {
                        toBeRemovedFromUserInput = text;
                        break;
                    }
                }
                String championName = userInput.replace(toBeRemovedFromUserInput, "");
                // Remove all spaces
                championName = championName.replaceAll("\\s","");
                return tellChampionInfo(championName);
            case ROLE:
                String role = "";
                keyword = intents.get("ROLE");
                for (String text : keyword.getText()) {
                    if (userInput.contains(text)) {
                        role = text;
                        break;
                    }
                }

                return recommendChampionByRole(role);
            case ITEMS_ROLE:
                toBeRemovedFromUserInput = "";
                keyword = intents.get("ITEMS_ROLE");

                for (String text : keyword.getText()) {
                    if (userInput.contains(text)) {
                        toBeRemovedFromUserInput = text;
                        break;
                    }
                }

                role = userInput.replace(toBeRemovedFromUserInput, "");
                // Remove all spaces
                role = role.replaceAll("\\s","");
                return recommendItemByRole(role);
            case THANKS:
                keyword = intents.get("THANKS");
                int randomThanks = randomizer.nextInt(keyword.getResponses().size());
                return keyword.getResponses().get(randomThanks);
            case DONT_UNDERSTAND:
                return "Sorry I don't understand what you said \uD83D\uDE25";
            default:
        }
        return "Sorry I don't understand what you said \uD83D\uDE25";
    }

    public static String recommendChampionByDifficulty(String difficulty) throws FileNotFoundException {
        Random randomizer = new Random();

        ArrayList<Champion> champions = DataLoader.loadChampionData();

        // Structure that stores the champions ID that matches the difficulty that the user wants
        ArrayList<Integer> championsMatchesCriteria = new ArrayList<>();
        int bottom = 0;
        int top = 0;

        switch (difficulty) {
            case "very easy":
                top =  2;
                break;
            case "easy":
                bottom = 3;
                top =  4;
                break;
            case "medium":
                bottom = 5;
                top =  6;
                break;
            case "difficult":
                bottom = 7;
                top =  8;
                break;
            case "very difficult":
                bottom = 9;
                top =  10;
                break;
        }

        int championIndex = 0;
        for (Champion champion: champions) {
            int championDifficulty = champion.getInfo().getDifficulty();

            if ( championDifficulty >= bottom && championDifficulty <= top) {
                championsMatchesCriteria.add(championIndex);
            }

            championIndex++;
        }

        // Randomize the selection
        int randomChampionID = randomizer.nextInt(championsMatchesCriteria.size());
        return champions.get(championsMatchesCriteria.get(randomChampionID)).getName();
    }

    public static String recommendChampionByRole(String role){
        Random randomizer = new Random();
        ArrayList<Champion> champions = new ArrayList<>();

        try{
            champions = DataLoader.loadChampionData();
        }catch (Exception e){
            System.out.println(e);
        }

        // Structure that stores the champions ID that matches the role that the user wants
        ArrayList<Integer> championsMatchesRole = new ArrayList<>();

        for (int i = 0; i < champions.size(); i++) {

            for(int j = 0; j < champions.get(i).getTags().size(); j++){
                if ( champions.get(i).getTags().get(j).equalsIgnoreCase(role)) {
                    championsMatchesRole.add(i);
                    break;
                }
             }

        }

        // Randomize the selection
        int randomChampionID = randomizer.nextInt(championsMatchesRole.size());

        return champions.get(championsMatchesRole.get(randomChampionID)).getName();

    }

    public static String tellChampionInfo(String championName){
        ArrayList<Champion> champions = new ArrayList<>();

        try {
            champions = DataLoader.loadChampionData();
        }catch (Exception e){
            System.out.println(e);
        }

        for (Champion champion : champions) {
            if (champion.getName().equalsIgnoreCase(championName)) {
                return champion.getBlurb();
            }
        }

        return "Champion doesn't exist \uD83D\uDE2D";
    }

    public static String recommendItemByRole(String role) {
        Random randomizer = new Random();
        RoleItem roleItems = new RoleItem();

        try {
             roleItems = DataLoader.loadChampionItem();
        }catch (Exception e){
            System.out.println(e);
        }
        ArrayList<Item> items = new ArrayList<>();

        switch (role) {
            case "fighter":
                items = roleItems.getFighterItems();
                break;
            case "tank":
                items = roleItems.getTankItems();
                break;
            case "assassin":
                items = roleItems.getAssassinItems();
                break;
            case "marksman":
                items = roleItems.getMarksmanItems();
                break;
            case "support":
                items = roleItems.getSupportItems();
                break;
            case "mage":
                items = roleItems.getMageItems();
                break;
        }
        // Randomize the selection
        int randomItem = randomizer.nextInt(items.size());

        return items.get(randomItem).getName();
    }
}

