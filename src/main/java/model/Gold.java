package model;

import com.google.gson.annotations.SerializedName;

public class Gold {
    @SerializedName("base")
    private Integer base;

    public Integer getBase() {
        return base;
    }

    public Boolean getPurchasable() {
        return purchasable;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getSell() {
        return sell;
    }

    @SerializedName("purchasable")
    private Boolean purchasable;

    @SerializedName("total")
    private Integer total;

    @SerializedName("sell")
    private Integer sell;
}
