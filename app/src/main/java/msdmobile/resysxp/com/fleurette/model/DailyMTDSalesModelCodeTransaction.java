package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DailyMTDSalesModelCodeTransaction {
    @SerializedName("MODEL_CODE")       @Expose private String ModelCode;
    @SerializedName("MTD_QTY")          @Expose private String MtdQty;
    @SerializedName("MTD_NETT")         @Expose private String MtdNett;
    @SerializedName("MTD_NETT_TOTAL")   @Expose private String MtdNettTotal;

    public String getModelCode() {
        return ModelCode;
    }

    public void setModelCode(String storeCode) {
        this.ModelCode = ModelCode;
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
