package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginModel {
    @SerializedName("NIK_CODE")    @Expose    private String nIKCODE;
    @SerializedName("NIK_NAME")    @Expose    private String nIKNAME;
    @SerializedName("STORE_CODE")  @Expose    private String sTORECODE;
    @SerializedName("STORE_NAME")  @Expose    private String sTORENAME;

    public String getNIKCODE() {
        return nIKCODE;
    }
    public String getNIKNAME() {
        return nIKNAME;
    }
    public String getSTORECODE() {
        return sTORECODE;
    }
    public String getsTORENAME() {
        return sTORENAME;
    }


}
