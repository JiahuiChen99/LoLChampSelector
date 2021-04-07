package model;

import com.google.gson.annotations.SerializedName;

public class Info {
    @SerializedName("attack")
    private Integer attack;

    @SerializedName("defense")
    private Integer defense;

    @SerializedName("magic")
    private Integer magic;

    @SerializedName("difficulty")
    private Integer difficulty;


    public Integer getAttack() {
        return attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public Integer getMagic() {
        return magic;
    }

    public Integer getDifficulty() {
        return difficulty;
    }
}
