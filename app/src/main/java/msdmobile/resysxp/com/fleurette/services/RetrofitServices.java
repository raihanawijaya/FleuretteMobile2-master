package msdmobile.resysxp.com.fleurette.services;

public class RetrofitServices {
    public static DataAPIInterface sendDataRequest(){
        return APIClient.getAPIClient().create(DataAPIInterface.class);
    }
}
