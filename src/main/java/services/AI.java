package services;

import model.Champion;
import model.Dictionary;
import model.Keyword;

import java.io.FileNotFoundException;
import java.util.*;

import model.Dictionary;

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

        return null;
    }

    public static String getResponse(String token, String userInput) throws FileNotFoundException {

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
