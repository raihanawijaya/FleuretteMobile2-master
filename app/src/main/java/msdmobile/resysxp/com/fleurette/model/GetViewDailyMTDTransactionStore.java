package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetViewDailyMTDTransactionStore {
    @SerializedName("TRX_DATE")    @Expose    private String tRXDATE;
    @SerializedName("STORE_CODE")    @Expose    private String sTORECODE;
    @SerializedName("QTY")    @Expose    private String qTY;
    @SerializedName("NETT")    @Expose    private String nETT;
    @SerializedName("NETT_LY")    @Expose    private String nETTLY;
    @SerializedName("MTD_QTY")    @Expose    private String mTDQTY;
    @SerializedName("MTD_NETT")    @Expose    private String mTDNETT;
    @SerializedName("MTD_PLAN")    @Expose    private String mTDPLAN;
    @SerializedName("MTD_NETT_LY")    @Expose    private String mTDNETTLY;


    public String getTRXDATE() {
        return tRXDATE;
    }
    public void setTRXDATE(String tRXDATE) {
        this.tRXDATE = tRXDATE;
    }

    public String getSTORECODE() {
        return sTORECODE;
    }
    public void setSTORECODE(String sTORECODE) {
        this.sTORECODE = sTORECODE;
    }

    public String getQTY() {
        return qTY;
    }
    public void setQTY(String qTY) {
        this.qTY = qTY;
    }

    public String getNETT() {
        return nETT;
    }
    public void setNETT(String nETT) {
        this.nETT = nETT;
    }

    public String getNETTLY() {
        return nETTLY;
    }
    public void setNETTLY(String nETTLY) {
        this.nETTLY = nETTLY;
    }

    public String getMTDQTY() {
        return mTDQTY;
    }
    public void setMTDQTY(String mTDQTY) {
        this.mTDQTY = mTDQTY;
    }

    public String getMTDNETT() {
        return mTDNETT;
    }
    public void setMTDNETT(String mTDNETT) {
        this.mTDNETT = mTDNETT;
    }

    public String getMTDPLAN() {
        return mTDPLAN;
    }
    public void setMTDPLAN(String mTDPLAN) {
        this.mTDPLAN = mTDPLAN;
    }

    public String getMTDNETTLY() {
        return mTDNETTLY;
    }
    public void setMTDNETTLY(String mTDNETTLY) {
        this.mTDNETTLY = mTDNETTLY;
    }
}
