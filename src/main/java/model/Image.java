package model;

import com.google.gson.annotations.SerializedName;

public class Image {
    @SerializedName("full")
    private String full;

    @SerializedName("sprite")
    private String sprite;

    @SerializedName("group")
    private String group;

    @SerializedName("x")
    private Integer x;

    @SerializedName("y")
    private Integer y;

    @SerializedName("w")
    private Integer w;

    @SerializedName("h")
    private Integer h;

}
