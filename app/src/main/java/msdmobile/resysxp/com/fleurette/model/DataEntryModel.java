package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataEntryModel {
    @SerializedName("trx_code")
    @Expose
    private Integer trxCode;
    @SerializedName("store_code")
    @Expose
    private String storeCode;
    @SerializedName("article_code")
    @Expose
    private String articleCode;
    @SerializedName("sales_code")
    @Expose
    private String salesCode;
    @SerializedName("trx_date")
    @Expose
    private String trxDate;
    @SerializedName("trx_qty")
    @Expose
    private Integer trxQty;
    @SerializedName("article_price")
    @Expose
    private Integer articlePrice;
    @SerializedName("gross")
    @Expose
    private Integer gross;
    @SerializedName("disc_pct")
    @Expose
    private Float discPct;
    @SerializedName("nett")
    @Expose
    private String nett;

    public Integer getTrxCode() {
        return trxCode;
    }

    public void setTrxCode(Integer trxCode) {
        this.trxCode = trxCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(String articleCode) {
        this.articleCode = articleCode;
    }

    public String getSalesCode() {
        return salesCode;
    }

    public void setSalesCode(String salesCode) {
        this.salesCode = salesCode;
    }

    public String getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(String trxDate) {
        this.trxDate = trxDate;
    }

    public Integer getTrxQty() {
        return trxQty;
    }

    public void setTrxQty(Integer trxQty) {
        this.trxQty = trxQty;
    }

    public Integer getArticlePrice() {
        return articlePrice;
    }

    public void setArticlePrice(Integer articlePrice) {
        this.articlePrice = articlePrice;
    }

    public Integer getGross() {
        return gross;
    }

    public void setGross(Integer gross) {
        this.gross = gross;
    }

    public Float getDiscPct() {
        return discPct;
    }

    public void setDiscPct(Float discPct) {
        this.discPct = discPct;
    }

    public String getNett() {
        return nett;
    }

    public void setNett(String nett) {
        this.nett = nett;
    }
}
