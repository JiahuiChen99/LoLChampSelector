package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Item {

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("colloq")
    private String colloq;

    @SerializedName("plaintext")
    private String plaintext;

    @SerializedName("into")
    private List<String> into = null;

    @SerializedName("image")
    private Image image;

    @SerializedName("gold")
    private Gold gold;

    @SerializedName("tags")
    private List<String> tags = null;

    @SerializedName("maps")
    private Maps maps;

    @SerializedName("stats")
    private Stats stats;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getColloq() {
        return colloq;
    }

    public String getPlaintext() {
        return plaintext;
    }

    public List<String> getInto() {
        return into;
    }

    public Image getImage() {
        return image;
    }

    public Gold getGold() {
        return gold;
    }

    public List<String> getTags() {
        return tags;
    }

    public Maps getMaps() {
        return maps;
    }

    public Stats getStats() {
        return stats;
    }
}
