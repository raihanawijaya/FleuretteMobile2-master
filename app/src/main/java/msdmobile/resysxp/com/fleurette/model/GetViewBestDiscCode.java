package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetViewBestDiscCode {
    @SerializedName("DISC_CODE")@Expose private String DiscCode;
    @SerializedName("QTY")@Expose private String Qty;
    @SerializedName("NETT")@Expose private String Nett;

    public String getDiscCode() {
        return DiscCode;
    }
    public String getQty() {
        return Qty;
    }
    public String getNett() {
        return Nett ;
    }
  }
