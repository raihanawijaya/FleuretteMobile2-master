package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetViewListDiscount {
    @SerializedName("DISC_CODE") @Expose private String DiscCode;
    @SerializedName("DISC_PCT")   @Expose  private String DiscPct;
    @SerializedName("USE_THIS_PRICE")  @Expose  private String UseThisPrice;
    @SerializedName("THIS_PRICE")  @Expose  private String ThisPrice;

    public String getDiscCode() {
        return DiscCode;
    }
    public String getDiscPct() {
        return DiscPct;
    }
    public String getUseThisPrice() {
        return UseThisPrice;
    }
    public String getThisPrice() {
        return ThisPrice;
    }
}
