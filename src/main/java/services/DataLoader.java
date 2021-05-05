package services;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import model.Champion;
import model.Keyword;
import model.RoleItem;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

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

    public static RoleItem loadChampionItem() throws FileNotFoundException{

        // TODO: Add ItemStat class since it's different from Stats
        return gson.fromJson(new FileReader("src/main/resources/items2.json"), RoleItem.class);
    }

    public static HashMap<String, Keyword> loadIntents(){
        HashMap<String, Keyword> intents = new HashMap<>();

        ArrayList<Keyword> keywords = new ArrayList<>();
        try {
            keywords = DataLoader.loadKeywords();
        }catch (Exception e){
            System.out.println(e);
        }

        // Save all keywords
        for (Keyword keyword: keywords) {
            intents.put(keyword.getToken(), keyword);
        }

        return intents;
    }

    public static void loadChampionAbilities() {
        //HashMap<String, > championsAbilities = new HashMap<>();

        //gson.fromJson(new FileReader("src/main/resources/champions_abilities.json"));

        try{
            JsonObject allChampions = new JsonParser().parse(new FileReader("src/main/resources/champions_abilities.json")).getAsJsonObject();
        }catch (Exception e){
            System.out.println(e);
        }


    }
}
