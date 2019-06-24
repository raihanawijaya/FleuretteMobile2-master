package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetViewEntryTransactionResponse {
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("dataTransaction")
    @Expose

    private List<GetViewEntryTransactionModel> dataTransaction = null;

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

    public List<GetViewEntryTransactionModel> getDataTransaction() {
        return dataTransaction;
    }

    public void setDataTransaction(List<GetViewEntryTransactionModel> dataTransaction) {
        this.dataTransaction = dataTransaction;
    }
}
