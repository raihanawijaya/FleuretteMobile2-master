package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PROC_STR_MTD_NETT_PLAN_RESPONSE {
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("dataMtdTransaction")
    @Expose
    private PROC_STR_MTD_NETT_PLAN_MODEL dataMtdTransaction;
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

    public PROC_STR_MTD_NETT_PLAN_MODEL getDataMtdTransaction() {
        return dataMtdTransaction;
    }

    public void setDataMtdTransaction(PROC_STR_MTD_NETT_PLAN_MODEL dataMtdTransaction) {
        this.dataMtdTransaction = dataMtdTransaction;
    }

    public CountTodayModel getCountToday() {
        return countToday;
    }

    public void setCountToday(CountTodayModel countToday) {
        this.countToday = countToday;
    }
}
