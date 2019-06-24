package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataModel {
    @SerializedName("STORE_CODE")
    @Expose
    private String sTORECODE;
    @SerializedName("TRX_DATE")
    @Expose
    private String tRXDATE;
    @SerializedName("ARTICLE")
    @Expose
    private String aRTICLE;
    @SerializedName("SLS_CODE")
    @Expose
    private String sLSCODE;
    @SerializedName("QTY")
    @Expose
    private Integer qTY;

    public String getSTORECODE() {
        return sTORECODE;
    }

    public void setSTORECODE(String sTORECODE) {
        this.sTORECODE = sTORECODE;
    }

    public String getTRXDATE() {
        return tRXDATE;
    }

    public void setTRXDATE(String tRXDATE) {
        this.tRXDATE = tRXDATE;
    }

    public String getARTICLE() {
        return aRTICLE;
    }

    public void setARTICLE(String aRTICLE) {
        this.aRTICLE = aRTICLE;
    }

    public String getSLSCODE() {
        return sLSCODE;
    }

    public void setSLSCODE(String sLSCODE) {
        this.sLSCODE = sLSCODE;
    }

    public Integer getQTY() {
        return qTY;
    }

    public void setQTY(Integer qTY) {
        this.qTY = qTY;
    }
}

