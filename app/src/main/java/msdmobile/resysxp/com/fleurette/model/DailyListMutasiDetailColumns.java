package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DailyListMutasiDetailColumns {
    @SerializedName("TRX_CODE_DTL") @Expose private String TrxCodeDtl;
    @SerializedName("ARTICLE_CODE")@Expose private String ArticleCode;
    @SerializedName("TRX_QTY") @Expose private String TrxQty;

    public String getTrxCodeDtl() {
        return TrxCodeDtl;
    }
    public String getArticleCode() {
        return ArticleCode;
    }
    public String getTrxQty() {
        return TrxQty;
    }
  }
