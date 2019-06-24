package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataMtdTransactionModel {
    @SerializedName("store_code")
    @Expose
    private String storeCode;
    @SerializedName("y_id")
    @Expose
    private Integer yId;
    @SerializedName("m_id")
    @Expose
    private Integer mId;
    @SerializedName("trx_qty")
    @Expose
    private String trxQty;
    @SerializedName("nett")
    @Expose
    private String nett;

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

    public void setNett(String nett) {
        this.nett = nett;
    }
}
