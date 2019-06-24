package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponses {
    @SerializedName("error")  @Expose    private Boolean error;
    @SerializedName("msg")    @Expose    private String msg;
    @SerializedName("dataLogin") @Expose private LoginModel loginModel;

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

    public LoginModel getDataLogin() {
        return loginModel;
    }

    public void setDataLogin(LoginModel loginModel) {
        this.loginModel = loginModel;
    }

}
