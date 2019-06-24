package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetViewDailyTransactionStore {
    @SerializedName("TRX_DATE")
    @Expose
    public String TRX_DATE;
    @SerializedName("QTY")
    @Expose
    public String QTY;
    @SerializedName("NETT")
    @Expose
    public String NETT;

    public GetViewDailyTransactionStore(String TRX_DATE, String QTY, String NETT) {
        this.TRX_DATE = TRX_DATE;
        this.QTY = QTY;
        this.NETT = NETT;
    }

    public String getTRX_DATE() {
        return TRX_DATE;
    }

    public void setTRX_DATE(String TRX_DATE) {
        this.TRX_DATE = TRX_DATE;
    }

    public String getQTY() {
        return QTY;
    }

    public void setQTY(String QTY) {
        this.QTY = QTY;
    }

    public String getNETT() {
        return NETT;
    }

    public void setNETT(String NETT) {
        this.NETT = NETT;
    }
}
