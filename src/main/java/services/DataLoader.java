package services;

import com.google.errorprone.annotations.DoNotCall;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import model.Champion;
import model.ChampionAbility;
import model.Keyword;
import model.RoleItem;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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

    public static HashMap<String, ChampionAbility> loadChampionAbilities() {
        HashMap<String, ChampionAbility> championsAbilities = new HashMap<>();
        Type championAbilitiesListType = new TypeToken<ArrayList<ChampionAbility>>(){}.getType();

        try{

            ArrayList<ChampionAbility> abilities = gson.fromJson(new FileReader("src/main/resources/champions_abilities.json"), championAbilitiesListType);

            for (ChampionAbility ability: abilities) {
                championsAbilities.put(ability.getChampionName(), ability);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return championsAbilities;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    /**
     * Under normal circumstances, there's no need to call this method.
     * Use this function if there's a need to update the dataset, won't
     * be used because the fetch is very slow.
     *
     * @param champions
     */
    @DoNotCall
    public static void loadChampionExtraData(ArrayList<Champion> champions) {
        InputStream fetchAPI;
        String baseURL = "http://ddragon.leagueoflegends.com/cdn/11.9.1/data/en_US/champion/";

        for (Champion champion: champions) {
            try {
                fetchAPI = new URL(baseURL + champion.getId() + ".json").openStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(fetchAPI, StandardCharsets.UTF_8));
                String jsonChamp = readAll(reader);
                JsonObject jsonChampData = new JsonParser().parse(jsonChamp).getAsJsonObject();

                JsonElement skins = jsonChampData.getAsJsonObject("data").getAsJsonObject(champion.getId()).get("skins");
                JsonElement spells = jsonChampData.getAsJsonObject("data").getAsJsonObject(champion.getId()).get("spells");
                champion.setLore(jsonChampData.getAsJsonObject("data").getAsJsonObject(champion.getId()).get("lore").toString());
                for (JsonElement skin: (JsonArray) skins) {
                    JsonObject skinObject = skin.getAsJsonObject();
                    champion.addSkins(Integer.valueOf(skinObject.get("num").toString()));
                }

                // Abilities photos
                for (JsonElement spell : (JsonArray) spells) {
                    JsonObject spellObject = spell.getAsJsonObject();
                    champion.addSpells(spellObject.get("image").getAsJsonObject().get("full").toString().replaceAll("\"", ""));
                }

                // Passive photos
                champion.addSpells(jsonChampData.getAsJsonObject("data")
                        .getAsJsonObject(champion.getId()).get("passive")
                        .getAsJsonObject().get("image").getAsJsonObject()
                        .get("full").toString().replaceAll("\"", ""));
            }catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
