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

    public String getFull() {
        return full;
    }

    public String getSprite() {
        return sprite;
    }

    public String getGroup() {
        return group;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Integer getW() {
        return w;
    }

    public Integer getH() {
        return h;
    }
}
