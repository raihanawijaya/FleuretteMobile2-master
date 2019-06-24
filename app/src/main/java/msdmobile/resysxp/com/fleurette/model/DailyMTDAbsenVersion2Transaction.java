package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DailyMTDAbsenVersion2Transaction {
    @SerializedName("TRX_CODE")   @Expose    private Integer trxcode;
    @SerializedName("STORE_CODE") @Expose    private String storecode;
    @SerializedName("Y_CODE")   @Expose    private String ycode;
    @SerializedName("M_CODE")  @Expose    private String mcode;
    @SerializedName("NIK_CODE")    @Expose    private String nikcode;
    @SerializedName("STORE_NAME")    @Expose    private String storename;
    @SerializedName("CHIEF_NAME")    @Expose    private String chiefname;
    @SerializedName("NIK_NAME")    @Expose    private String nikname;
    @SerializedName("HARI_KERJA")    @Expose    private String harikerja;
    @SerializedName("HARI_BESAR")    @Expose    private String haribesar;
    @SerializedName("JAM_LEMBUR")    @Expose    private String jamlembur;
    @SerializedName("LAIN_LAIN")    @Expose    private String lainlain;
    @SerializedName("RESI_POS")    @Expose    private String resipos;
    @SerializedName("ADMIN")    @Expose    private String admin;
    @SerializedName("ATK")    @Expose    private String atk;
    @SerializedName("POT_SO")    @Expose    private String potso;
    @SerializedName("POT_SERAGAM")    @Expose    private String potseragam;
    @SerializedName("POT_CASH_BON")    @Expose    private String potcashbon;
    @SerializedName("TJ_KOM")    @Expose    private String tjkom;
    @SerializedName("TJ_TRANSPORT")    @Expose    private String tjtransport;
    @SerializedName("TJ_MAKAN")    @Expose    private String tjmakan;

    public Integer get_trx_code() {
        return trxcode;
    }
    public String get_store_code() {return storecode;}
    public String get_y_code() {return ycode;}
    public String get_m_Code() {return mcode;}
    public String get_nik_code() {return nikcode;}
    public String get_store_name() {return storename;}
    public String get_chief_name() {return chiefname;}
    public String get_nik_name() {return nikname;}
    public String get_hari_kerja() {return harikerja;}
    public String get_hari_besar() {return haribesar;}
    public String get_jam_lembur() {return jamlembur;}
    public String get_lain_lain() {return lainlain;}
    public String get_resi_pos() {return resipos;}
    public String get_admin() {return admin;}
    public String get_atk() {return atk;}
    public String get_pot_so() {return potso;}
    public String get_pot_seragam() {return potseragam;}
    public String get_pot_cash_bon() {return potcashbon;}
    public String get_tj_kom() {return tjkom;}
    public String get_tj_transport() {return tjtransport;}
    public String get_tj_makan() {return tjmakan;}


}
