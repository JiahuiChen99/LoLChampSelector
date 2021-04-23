package model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RoleItem {
    @SerializedName("Fighter")
    ArrayList<Item> fighterItems;

    @SerializedName("Tank")
    ArrayList<Item> tankItems;

    @SerializedName("Assassin")
    ArrayList<Item> assassinItems;

    @SerializedName("Marksman")
    ArrayList<Item> marksmanItems;

    @SerializedName("Support")
    ArrayList<Item> supportItems;

    @SerializedName("Mage")
    ArrayList<Item> mageItems;

    public ArrayList<Item> getFighterItems() {
        return fighterItems;
    }

    public ArrayList<Item> getTankItems() {
        return tankItems;
    }

    public ArrayList<Item> getAssassinItems() {
        return assassinItems;
    }

    public ArrayList<Item> getMarksmanItems() {
        return marksmanItems;
    }

    public ArrayList<Item> getSupportItems() {
        return supportItems;
    }

    public ArrayList<Item> getMageItems() {
        return mageItems;
    }
}
