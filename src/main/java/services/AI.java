package services;

import model.Dictionary;
import model.Keyword;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AI {
    public static List<String> parseUserInput(String userInput) {

        // Sanitize user input by replacing all special characters
        userInput = userInput.replaceAll("[^a-zA-Z0-9]", " ");
        List<String> tokens = Arrays.asList(userInput.split(" "));

        for (String token:tokens) {
            System.out.println(token);
        }

        return tokens;
    }

    public static String determineIntent(List<String> userInput) throws FileNotFoundException {

        ArrayList<Keyword> intents = DataLoader.loadKeywords();
        for (Keyword keyword: intents) {
            for (String text: keyword.getText()) {
                if (userInput.contains(text)) {
                    return keyword.getToken();
                }
            }
        }

        return null;
    }

    public static String getResponse(String token){

        switch (Dictionary.valueOf(token)){
            case DIFFICULTY:
                return "Ashe";
            case GREETING:
                return "Hello";
            case SAYOUNARA:
                return "Bye";
            case CHAMPION_INFO:
                break;
            default:

        }
        return null;
    }
}
