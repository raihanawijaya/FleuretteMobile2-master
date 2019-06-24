package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DailyMTDSalesCtgrCodeTransaction {
    @SerializedName("CTGR_CODE")        @Expose private String CtgrCode;
    @SerializedName("MTD_QTY")          @Expose private String MtdQty;
    @SerializedName("MTD_NETT")         @Expose private String MtdNett;
    @SerializedName("MTD_NETT_TOTAL")   @Expose private String MtdNettTotal;

    public String getCtgrCode() {
        return CtgrCode;
    }

    public void setCtgrCode(String storeCode) {
        this.CtgrCode = CtgrCode;
    }

    public String getMtdQty() {
        return MtdQty;
    }

    public void setMtdQty(String MtdQty) {
        this.MtdQty = MtdQty;
    }

    public String getMtdNett() {
        return MtdNett;
    }

    public void setMtdNett(String mtdNett) {
        this.MtdNett = MtdNett;
    }

    public String getMtdNettTotal() {
        return MtdNettTotal;
    }

    public void setMtdNettTotal(String mtdNettTotal) {
        this.MtdNettTotal = MtdNettTotal;
    }
}
