package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DailyMTDSalesArticleTransaction {
    @SerializedName("ARTICLE")          @Expose private String Article;
    @SerializedName("MTD_QTY")          @Expose private String MtdQty;
    @SerializedName("MTD_NETT")         @Expose private String MtdNett;
    @SerializedName("MTD_NETT_TOTAL")   @Expose private String MtdNettTotal;

    public String getArticle() {return Article;}

    public String getMtdQty() {
        return MtdQty;
    }

    public String getMtdNett() {
        return MtdNett;
    }

    public String getMtdNettTotal() {
        return MtdNettTotal;
    }


}
