package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataMtdTransactionResponse {
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("dataMtdTransaction")
    @Expose
    private DataMtdTransactionModel dataMtdTransaction;
    @SerializedName("countToday")
    @Expose
    private CountTodayModel countToday;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataMtdTransactionModel getDataMtdTransaction() {
        return dataMtdTransaction;
    }

    public void setDataMtdTransaction(DataMtdTransactionModel dataMtdTransaction) {
        this.dataMtdTransaction = dataMtdTransaction;
    }

    public CountTodayModel getCountToday() {
        return countToday;
    }

    public void setCountToday(CountTodayModel countToday) {
        this.countToday = countToday;
    }
}
