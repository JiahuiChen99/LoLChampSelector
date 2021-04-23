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

    public Float getHp() {
        return hp;
    }

    public Integer getHpperlevel() {
        return hpperlevel;
    }

    public Float getMp() {
        return mp;
    }

    public Float getMpperlevel() {
        return mpperlevel;
    }

    public Integer getMovespeed() {
        return movespeed;
    }

    public Integer getArmor() {
        return armor;
    }

    public Float getArmorperlevel() {
        return armorperlevel;
    }

    public Float getSpellblock() {
        return spellblock;
    }

    public Float getSpellblockperlevel() {
        return spellblockperlevel;
    }

    public Integer getAttackrange() {
        return attackrange;
    }

    public Float getHpregen() {
        return hpregen;
    }

    public Float getHpregenperlevel() {
        return hpregenperlevel;
    }

    public Float getMpregen() {
        return mpregen;
    }

    public Float getMpregenperlevel() {
        return mpregenperlevel;
    }

    public Integer getCrit() {
        return crit;
    }

    public Integer getCritperlevel() {
        return critperlevel;
    }

    public Float getAttackdamage() {
        return attackdamage;
    }

    public Float getAttackdamageperlevel() {
        return attackdamageperlevel;
    }

    public Float getAttackspeedperlevel() {
        return attackspeedperlevel;
    }

    public Float getAttackspeed() {
        return attackspeed;
    }
}
