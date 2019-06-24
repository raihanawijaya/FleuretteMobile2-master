package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetViewMtdDiscCodeTransactionStore {
    @SerializedName("SALES_CODE") @Expose private String salesCode;
    @SerializedName("MTD_QTY")   @Expose  private String mtdQty;
    @SerializedName("MTD_NETT")  @Expose  private String mtdNett;


    public String getSalesCode() {
        return salesCode;
    }
    public void setSalesCode(String salesCode) {
        this.salesCode = salesCode;
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
