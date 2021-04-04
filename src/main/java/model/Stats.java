package model;

import com.google.gson.annotations.SerializedName;

public class Stats {
    @SerializedName("hp")
    private Float hp;

    @SerializedName("hpperlevel")
    private Integer hpperlevel;

    @SerializedName("mp")
    private Float mp;

    @SerializedName("mpperlevel")
    private Float mpperlevel;

    @SerializedName("movespeed")
    private Integer movespeed;

    @SerializedName("armor")
    private Integer armor;

    @SerializedName("armorperlevel")
    private Float armorperlevel;

    @SerializedName("spellblock")
    private Float spellblock;

    @SerializedName("spellblockperlevel")
    private Float spellblockperlevel;

    @SerializedName("attackrange")
    private Integer attackrange;

    @SerializedName("hpregen")
    private Float hpregen;

    @SerializedName("hpregenperlevel")
    private Float hpregenperlevel;

    @SerializedName("mpregen")
    private Float mpregen;

    @SerializedName("mpregenperlevel")
    private Float mpregenperlevel;

    @SerializedName("crit")
    private Integer crit;

    @SerializedName("critperlevel")
    private Integer critperlevel;

    @SerializedName("attackdamage")
    private Float attackdamage;

    @SerializedName("attackdamageperlevel")
    private Float attackdamageperlevel;

    @SerializedName("attackspeedperlevel")
    private Float attackspeedperlevel;

    @SerializedName("attackspeed")
    private Float attackspeed;
}
