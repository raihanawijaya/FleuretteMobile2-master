package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DailyListMutasiHeaderColumns {
    @SerializedName("TRX_CODE_HDR") @Expose private String TrxCodeHdr;
    @SerializedName("STORE_CODE") @Expose private String StoreCode;
    @SerializedName("SACK_CODE") @Expose private String SackCode;
    @SerializedName("TRX_DATE") @Expose private String TrxDate;
    @SerializedName("TRX_TO") @Expose private String TrxTo;
    @SerializedName("TRX_TO_NAME") @Expose private String TrxToName;
    @SerializedName("TTL_QTY") @Expose private String TtlQty;

    public String getTrxCodeHdr() {
        return TrxCodeHdr;
    }
    public String getStoreCode() { return StoreCode;}
    public String getSackCode() {
        return SackCode;
    }
    public String getTrxDate() {
        return TrxDate;
    }
    public String getTrxTo() {
        return TrxTo;
    }
    public String getTrxToName() {
        return TrxToName;
    }
    public String getTtlQty() {
        return TtlQty;
    }

  }
