package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataTransactionModel {
    @SerializedName("ROWID")
    @Expose
    private Integer rOWID;
    @SerializedName("UNIQUEID")
    @Expose
    private String uNIQUEID;
    @SerializedName("NIK_CODE")
    @Expose
    private String nIKCODE;
    @SerializedName("ARTICLE")
    @Expose
    private String aRTICLE;
    @SerializedName("WARNA")
    @Expose
    private String wARNA;
    @SerializedName("SIZE")
    @Expose
    private String sIZE;
    @SerializedName("PRICE")
    @Expose
    private Integer pRICE;
    @SerializedName("QTY")
    @Expose
    private Integer qTY;
    @SerializedName("GROSS")
    @Expose
    private Integer gROSS;
    @SerializedName("DISC_CODE")
    @Expose
    private String dISCCODE;
    @SerializedName("NETT")
    @Expose
    private String nETT;

    public Integer getROWID() {
        return rOWID;
    }

    public void setROWID(Integer rOWID) {
        this.rOWID = rOWID;
    }

    public String getUNIQUEID() {
        return uNIQUEID;
    }

    public void setUNIQUEID(String uNIQUEID) {
        this.uNIQUEID = uNIQUEID;
    }

    public String getNIKCODE() {
        return nIKCODE;
    }

    public void setNIKCODE(String nIKCODE) {
        this.nIKCODE = nIKCODE;
    }

    public String getARTICLE() {
        return aRTICLE;
    }

    public void setARTICLE(String aRTICLE) {
        this.aRTICLE = aRTICLE;
    }

    public String getWARNA() {
        return wARNA;
    }

    public void setWARNA(String wARNA) {
        this.wARNA = wARNA;
    }

    public String getSIZE() {
        return sIZE;
    }

    public void setSIZE(String sIZE) {
        this.sIZE = sIZE;
    }

    public Integer getPRICE() {
        return pRICE;
    }

    public void setPRICE(Integer pRICE) {
        this.pRICE = pRICE;
    }

    public Integer getQTY() {
        return qTY;
    }

    public void setQTY(Integer qTY) {
        this.qTY = qTY;
    }

    public Integer getGROSS() {
        return gROSS;
    }

    public void setGROSS(Integer gROSS) {
        this.gROSS = gROSS;
    }

    public String getDISCCODE() {
        return dISCCODE;
    }

    public void setDISCCODE(String dISCCODE) {
        this.dISCCODE = dISCCODE;
    }

    public String getNETT() {
        return nETT;
    }

    public void setNETT(String nETT) {
        this.nETT = nETT;
    }
}
