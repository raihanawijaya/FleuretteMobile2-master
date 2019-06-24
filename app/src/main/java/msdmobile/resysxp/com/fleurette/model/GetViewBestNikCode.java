package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetViewBestNikCode {
    @SerializedName("NIK_CODE")@Expose private String NikCode;
    @SerializedName("QTY")@Expose private String Qty;
    @SerializedName("NETT")@Expose private String Nett;

    public String getNikCode() {
        return NikCode;
    }
    public String getQty() {
        return Qty;
    }
    public String getNett() {
        return Nett ;
    }
  }
