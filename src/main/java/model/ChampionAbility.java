package model;

import java.util.HashMap;

public class ChampionAbility {

    private String champion;
    private HashMap<String, String> abilities = new HashMap<>();

    public String getChampion() {
        return this.champion;
    }

    public String getAbilityURL(String ability) {
        return abilities.get(ability);
    }

}
