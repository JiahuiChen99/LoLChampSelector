import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Champion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class main {
    public static ArrayList<Champion> loadChampionData() throws FileNotFoundException{

        Gson gson = new Gson();

        Type championsListType = new TypeToken<ArrayList<Champion>>(){}.getType();

        return gson.fromJson(new FileReader("src/main/resources/champions.json"), championsListType);
    }
}
