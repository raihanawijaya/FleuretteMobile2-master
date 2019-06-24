package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DailyMTDAbsenTransaction {
    @SerializedName("TRX_CODE")   @Expose    private Integer trxcode;
    @SerializedName("STORE_CODE") @Expose    private String storecode;
    @SerializedName("Y_CODE")   @Expose    private String ycode;
    @SerializedName("M_CODE")  @Expose    private String mcode;
    @SerializedName("NIK_CODE")    @Expose    private String nikcode;
    @SerializedName("HARI_KERJA")    @Expose    private String harikerja;
    @SerializedName("HARI_BESAR")    @Expose    private String haribesar;
    @SerializedName("HARI_LEMBUR")    @Expose    private String harilembur;
    @SerializedName("STORE_NAME")    @Expose    private String storename;
    @SerializedName("CHIEF_NAME")    @Expose    private String chiefname;
    @SerializedName("NIK_NAME")    @Expose    private String nikname;

    public Integer get_trx_code() {
        return trxcode;
    }
    public String get_store_code() {return storecode;}
    public String get_y_code() {return ycode;}
    public String get_m_Code() {return mcode;}
    public String get_nik_code() {return nikcode;}
    public String get_hari_kerja() {return harikerja;}
    public String get_hari_besar() {return haribesar;}
    public String get_hari_lembur() {return harilembur;}
    public String get_store_name() {return storename;}
    public String get_chief_name() {return chiefname;}
    public String get_nik_name() {return nikname;}
}
