package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Champion {
    @SerializedName("version")
    private String version;

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

}
