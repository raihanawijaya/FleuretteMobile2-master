package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetViewDailyMTDTransactionStoreResponse {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("dataTransaction")
    @Expose
    private GetViewDailyMTDTransactionStore dataTransaction = null;

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

    public GetViewDailyMTDTransactionStore getDataTransaction() {
        return dataTransaction;
    }

    public void setDataTransaction(GetViewDailyMTDTransactionStore dataTransaction) {
        this.dataTransaction = dataTransaction;
    }
}
