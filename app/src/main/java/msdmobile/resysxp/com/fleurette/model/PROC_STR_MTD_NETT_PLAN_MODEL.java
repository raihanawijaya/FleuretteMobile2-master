package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PROC_STR_MTD_NETT_PLAN_MODEL {
    @SerializedName("STORE_CODE")    @Expose    private String storeCode;
    @SerializedName("Y_ID")    @Expose    private Integer yId;
    @SerializedName("M_ID")    @Expose    private Integer mId;
    @SerializedName("TRX_QTY")    @Expose    private String trxQty;
    @SerializedName("NETT")    @Expose    private String nett;
    @SerializedName("PLAN")    @Expose    private String plan;
    @SerializedName("NETT_LY")    @Expose    private String nett_ly;


    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public Integer getYId() {
        return yId;
    }

    public void setYId(Integer yId) {
        this.yId = yId;
    }

    public Integer getMId() {
        return mId;
    }

    public void setMId(Integer mId) {
        this.mId = mId;
    }

    public String getTrxQty() {
        return trxQty;
    }

    public void setTrxQty(String trxQty) {
        this.trxQty = trxQty;
    }

    public String getNett() {
        return nett;
    }

    public String getPlan() {
        return plan;
    }

    public String getNettly() {return nett_ly; }

    public void setNett(String nett) {
        this.nett = nett;
    }
}
