package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountTodayModel {
    @SerializedName("qty")
    @Expose
    private String qty;
    @SerializedName("nett")
    @Expose
    private String nett;

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getNett() {
        return nett;
    }

    public void setNett(String nett) {
        this.nett = nett;
    }
}
