package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Champion {

    @SerializedName("id")
    private String id;

    @SerializedName("key")
    private String key;

    @SerializedName("name")
    private String name;

    @SerializedName("title")
    private String title;

    @SerializedName("blurb")
    private String blurb;

    @SerializedName("info")
    private Info info;

    @SerializedName("image")
    private Image image;

    @SerializedName("tags")
    private List<String> tags = null;

    @SerializedName("partype")
    private String partype;

    @SerializedName("stats")
    private Stats stats;


    public String getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getBlurb() {
        return blurb;
    }

    public Info getInfo() {
        return info;
    }

    public Image getImage() {
        return image;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getPartype() {
        return partype;
    }

    public Stats getStats() {
        return stats;
    }
}
