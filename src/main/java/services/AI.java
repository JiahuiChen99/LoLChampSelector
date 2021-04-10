package services;

import model.Champion;
import model.Dictionary;
import model.Keyword;

import java.io.FileNotFoundException;
import java.util.*;


public class AI {

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
    public static String determineIntent(String userInput) throws FileNotFoundException {

        ArrayList<Keyword> intents = DataLoader.loadKeywords();
        for (Keyword keyword: intents) {
            for (String text: keyword.getText()) {
                if (userInput.contains(text)) {
                    return keyword.getToken();
                }
            }
        }

        return "DONT_UNDERSTAND";
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
}

