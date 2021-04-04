package model;

import com.google.gson.annotations.SerializedName;

public class Stats {
    @SerializedName("hp")
    private Integer hp;

    @SerializedName("hpperlevel")
    private Integer hpperlevel;

    @SerializedName("mp")
    private Integer mp;

    @SerializedName("mpperlevel")
    private Integer mpperlevel;

    @SerializedName("movespeed")
    private Integer movespeed;

    @SerializedName("armor")
    private Integer armor;

    @SerializedName("armorperlevel")
    private Double armorperlevel;

    @SerializedName("spellblock")
    private Integer spellblock;

    @SerializedName("spellblockperlevel")
    private Double spellblockperlevel;

    @SerializedName("attackrange")
    private Integer attackrange;

    @SerializedName("hpregen")
    private Integer hpregen;

    @SerializedName("hpregenperlevel")
    private Integer hpregenperlevel;

    @SerializedName("mpregen")
    private Integer mpregen;

    @SerializedName("mpregenperlevel")
    private Integer mpregenperlevel;

    @SerializedName("crit")
    private Integer crit;

    @SerializedName("critperlevel")
    private Integer critperlevel;

    @SerializedName("attackdamage")
    private Integer attackdamage;

    @SerializedName("attackdamageperlevel")
    private Integer attackdamageperlevel;

    @SerializedName("attackspeedperlevel")
    private Double attackspeedperlevel;

    @SerializedName("attackspeed")
    private Double attackspeed;
}
