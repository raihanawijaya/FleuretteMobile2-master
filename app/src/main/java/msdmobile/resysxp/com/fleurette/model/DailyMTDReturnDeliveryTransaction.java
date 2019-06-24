package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DailyMTDReturnDeliveryTransaction {
    @SerializedName("CODE") @Expose private String Code;
    @SerializedName("TRX_NO") @Expose private String TrxNo;
    @SerializedName("CTGR_CODE")@Expose private String CtgrCode;
    @SerializedName("TRX_DATE")@Expose private String TrxDate;
    @SerializedName("QTY") @Expose private String Qty;
    @SerializedName("GROSS") @Expose private String Gross;

    public String getCode() {
        return Code;
    }
    public String getTrxNo() {
        return TrxNo;
    }
    public String getCtgrCode() {
        return CtgrCode;
    }
    public String getTrxDate() {
        return TrxDate;
    }
    public String getQty() {
        return Qty;
    }
    public String getGross() {
        return Gross;
    }

  }
