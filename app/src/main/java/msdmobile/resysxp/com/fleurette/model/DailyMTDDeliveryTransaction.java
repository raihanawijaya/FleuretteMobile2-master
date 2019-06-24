package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DailyMTDDeliveryTransaction {
    @SerializedName("CODE") @Expose private String Code;
    @SerializedName("TRX_NO") @Expose private String TrxNo;
    @SerializedName("ARTICLE")@Expose private String Article;
    @SerializedName("COLOUR")@Expose private String Colour;
    @SerializedName("SIZE")@Expose private String Size;
    @SerializedName("TRX_DLV_DATE")@Expose private String TrxDlvDate;
    @SerializedName("QTY") @Expose private String Qty;
    @SerializedName("GROSS") @Expose private String Gross;

    public String getCode() {
        return Code;
    }
    public String getTrxNo() {
        return TrxNo;
    }
    public String getArticle() {
        return Article;
    }
    public String getColour() {
        return Colour;
    }
    public String getSize() {
        return Size;
    }
    public String getTrxDlvDate() {
        return TrxDlvDate;
    }
    public String getQty() {
        return Qty;
    }
    public String getGross() {
        return Gross;
    }

  }
