package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetViewGuidance {
    @SerializedName("CODE")@Expose private String Code;
    @SerializedName("INFO")@Expose private String Info;

    public String getCode() {return Code;}
    public String getInfo() {return Info;}

  }
