package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DailyMTDOpnameTransaction {
    @SerializedName("TRX_CODE")   @Expose    private Integer trxcode;
    @SerializedName("STORE_CODE") @Expose    private String storecode;
    @SerializedName("TRX_DATE")   @Expose    private String trxdate;
    @SerializedName("CTGR_CODE")  @Expose    private String ctgrcode;
    @SerializedName("TRX_QTY")    @Expose    private String trxqty;
    @SerializedName("MTD_QTY")    @Expose    private String mtdqty;

    public Integer get_trx_code() {
        return trxcode;
    }
    public String get_store_code() {return storecode;}
    public String get_trx_date() {return trxdate;}
    public String get_ctgr_Code() {return ctgrcode;}
    public String get_trx_qty() {return trxqty;}
    public String get_mtd_qty() {return mtdqty;}
}
