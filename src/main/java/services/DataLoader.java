package services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Champion;
import model.Item;
import model.Keyword;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DataLoader {
    private static final Gson gson = new Gson();

    public static ArrayList<Champion> loadChampionData() throws FileNotFoundException{

        Type championsListType = new TypeToken<ArrayList<Champion>>(){}.getType();

        return gson.fromJson(new FileReader("src/main/resources/champions.json"), championsListType);
    }

    public static ArrayList<Keyword> loadKeywords() throws FileNotFoundException {

        Type keywordsListType = new TypeToken<ArrayList<Keyword>>(){}.getType();

        return gson.fromJson(new FileReader("src/main/resources/intents.json"), keywordsListType);

    }

    public static ArrayList<Item> loadChampionItem() throws FileNotFoundException{

        Type itemListType = new TypeToken<ArrayList<Item>>(){}.getType();

        return gson.fromJson(new FileReader("src/main/resources/champions.json"), itemListType);
    }
}
