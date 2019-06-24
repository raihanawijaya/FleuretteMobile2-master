package msdmobile.resysxp.com.fleurette.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataResponses {
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("TRX_SALES_DETAIL")
    @Expose
    private List<DataModel> tRXSALESDETAIL = null;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<DataModel> getDataModel() {
        return tRXSALESDETAIL;
    }

    public void setDataModel(List<DataModel> tRXSALESDETAIL) {
        this.tRXSALESDETAIL = tRXSALESDETAIL;
    }

}
