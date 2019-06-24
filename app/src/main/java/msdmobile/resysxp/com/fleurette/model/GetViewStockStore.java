package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetViewStockStore {
    @SerializedName("INFO")@Expose private String Info;
    @SerializedName("QTY")@Expose private String Qty;

    public String getInfo() {
        return Info;
    }
    public String getQty() {
        return Qty;
    }

  }
