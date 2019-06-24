package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetViewBestArticle {
    @SerializedName("ARTICLE")@Expose private String Article;
    @SerializedName("QTY")@Expose private String Qty;
    @SerializedName("NETT")@Expose private String Nett;

    public String getArticle() {
        return Article;
    }
    public String getQty() {
        return Qty;
    }
    public String getNett() {
        return Nett ;
    }
  }
