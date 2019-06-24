package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DiscCodeModel {
    @SerializedName("DISC_CODE") @Expose private String discCode;
    @SerializedName("MTD_QTY")   @Expose private String mtdQty;
    @SerializedName("MTD_NETT")  @Expose private String mtdNett;

    public String getDiscCode() {
        return discCode;
    }
    public void setDiscCode(String discCode) {
        this.discCode = discCode;
    }

    public String getMtdQty() {
        return mtdQty;
    }
    public void setMtdQty(String mtdQty) {
        this.mtdQty = mtdQty;
    }

    public String getMtdNett() {
        return mtdNett;
    }
    public void setMtdNett(String mtdNett) {
        this.mtdNett = mtdNett;
    }
}
