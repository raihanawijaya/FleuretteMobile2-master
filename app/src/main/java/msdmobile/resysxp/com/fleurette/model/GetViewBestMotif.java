package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetViewBestMotif {
    @SerializedName("MOTIF")@Expose private String Motif;
    @SerializedName("QTY")@Expose private String Qty;
    @SerializedName("NETT")@Expose private String Nett;

    public String getMotif() {
        return Motif;
    }
    public String getQty() {
        return Qty;
    }
    public String getNett() {
        return Nett ;
    }
  }
