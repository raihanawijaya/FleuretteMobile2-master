package msdmobile.resysxp.com.fleurette.services;

import msdmobile.resysxp.com.fleurette.model.ArticleResponse;
import msdmobile.resysxp.com.fleurette.model.DailyListMutasiDetailResponse;
import msdmobile.resysxp.com.fleurette.model.DailyListMutasiHeaderResponse;
import msdmobile.resysxp.com.fleurette.model.DailyMTDAbsenTransactionResponse;
import msdmobile.resysxp.com.fleurette.model.DailyMTDAbsenVersion2TransactionResponse;
import msdmobile.resysxp.com.fleurette.model.DailyMTDDeliveryTransactionResponse;
import msdmobile.resysxp.com.fleurette.model.DailyMTDOpnameTransactionResponse;
import msdmobile.resysxp.com.fleurette.model.DailyMTDReturnDeliveryTransactionResponse;
import msdmobile.resysxp.com.fleurette.model.DailyMTDSalesArticleTransactionResponse;
import msdmobile.resysxp.com.fleurette.model.DailyMTDSalesCodeTransactionResponse;
import msdmobile.resysxp.com.fleurette.model.DailyMTDSalesCtgrCodeTransactionResponse;
import msdmobile.resysxp.com.fleurette.model.DailyMTDSalesModelCodeTransactionResponse;
import msdmobile.resysxp.com.fleurette.model.DataMtdTransactionResponse;
import msdmobile.resysxp.com.fleurette.model.DeleteOpnameResponse;
import msdmobile.resysxp.com.fleurette.model.DeleteUpdateAbsensiResponse;
import msdmobile.resysxp.com.fleurette.model.DeleteUpdateAbsensiVersion2Response;
import msdmobile.resysxp.com.fleurette.model.DeleteUpdateMutasiHeaderResponse;
import msdmobile.resysxp.com.fleurette.model.DeleteUpdateMutasiResponse;
import msdmobile.resysxp.com.fleurette.model.DeleteUpdateTransactionResponse;
import msdmobile.resysxp.com.fleurette.model.DiscCodeResponse;
import msdmobile.resysxp.com.fleurette.model.GetViewBestArticleResponse;
import msdmobile.resysxp.com.fleurette.model.GetViewBestDiscCodeResponse;
import msdmobile.resysxp.com.fleurette.model.GetViewBestMotifResponse;
import msdmobile.resysxp.com.fleurette.model.GetViewBestNikCodeResponse;
import msdmobile.resysxp.com.fleurette.model.GetViewDailyMTDTransactionStoreResponse;
import msdmobile.resysxp.com.fleurette.model.GetViewDailyTransactionStoreResponse;
import msdmobile.resysxp.com.fleurette.model.GetViewEntryTransactionResponse;
import msdmobile.resysxp.com.fleurette.model.GetViewGuidanceResponse;
import msdmobile.resysxp.com.fleurette.model.GetViewListDiscountResponse;
import msdmobile.resysxp.com.fleurette.model.GetViewStockStoreResponse;
import msdmobile.resysxp.com.fleurette.model.InputAbsensiResponse;
import msdmobile.resysxp.com.fleurette.model.InputAbsensiVersion2Response;
import msdmobile.resysxp.com.fleurette.model.InputMutasiDetailResponse;
import msdmobile.resysxp.com.fleurette.model.InputMutasiHeaderResponse;
import msdmobile.resysxp.com.fleurette.model.InputOpnameResponse;
import msdmobile.resysxp.com.fleurette.model.InputTransactionResponse;
import msdmobile.resysxp.com.fleurette.model.LoginResponses;
import msdmobile.resysxp.com.fleurette.model.PROC_STR_MTD_NETT_PLAN_RESPONSE;
import msdmobile.resysxp.com.fleurette.model.UpdateOpnameResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface DataAPIInterface {
    /*
    @FormUrlEncoded
    @POST("GetLogin.php")
    Call<LoginResponses> GetLogin(@Field("P_NIK_CODE") String NIKCode, @Field("P_PASSWORD") String password ,@Field("P_STORE_CODE") String storecode);
   */

    @FormUrlEncoded
    @POST("GetLoginVersion.php")
    Call<LoginResponses> GetLoginVersion(@Field("P_NIK_CODE") String NIKCode,
                                         @Field("P_PASSWORD") String password,
                                         @Field("P_STORE_CODE") String storecode,
                                         @Field("P_APP_VERSION") String version);


    @FormUrlEncoded
    @POST("GetViewEntryTransaction.php")
    Call<GetViewEntryTransactionResponse> getDataTransaction(@Field("STORE_CODE") String storecode,
                                                             @Field("TRX_DATE") String trxDate);
    @FormUrlEncoded
    @POST("GetViewDailyMTDDeliveryTransaction.php")
    Call<DailyMTDDeliveryTransactionResponse> getDailyTrxDelivery(@Field("P_STORE_CODE") String storeCode,
                                                                  @Field("P_TRX_DATE") String trx_date);
    @FormUrlEncoded
    @POST("GetViewListDiscount.php")
    Call<GetViewListDiscountResponse> getDataTransaction(@Field("P_STORE_CODE") String storecode);

    @FormUrlEncoded
    @POST("GetViewGuidance.php")
    Call<GetViewGuidanceResponse> getViewGuidance(@Field("P_STORE_CODE") String storecode);

    @FormUrlEncoded
    @POST("GetViewDailyTransactionStore.php")
    Call<GetViewDailyTransactionStoreResponse> getViewDailyTransactionStore(
            @Field("P_STORE_CODE") String P_STORE_CODE,
            @Field("P_Y_CODE") String P_Y_CODE,
            @Field("P_M_CODE") String P_M_CODE);

    @FormUrlEncoded
    @POST("GetViewBestArticle.php")
    Call<GetViewBestArticleResponse> GetViewBestArticle(@Field("P_STORE_CODE") String storeCode,
                                                        @Field("P_TRX_DATE") String trx_date);
    @FormUrlEncoded
    @POST("GetViewBestMotif.php")
    Call<GetViewBestMotifResponse> GetViewBestMotif(@Field("P_STORE_CODE") String storeCode,
                                                    @Field("P_TRX_DATE") String trx_date);
    @FormUrlEncoded
    @POST("GetViewBestDiscCode.php")
    Call<GetViewBestDiscCodeResponse> GetViewBestDiscCode(@Field("P_STORE_CODE") String storeCode,
                                                          @Field("P_TRX_DATE") String trx_date);

    @FormUrlEncoded
    @POST("GetViewBestNikCode.php")
    Call<GetViewBestNikCodeResponse> GetViewBestNikCode(@Field("P_STORE_CODE") String storeCode,
                                                        @Field("P_TRX_DATE") String trx_date);


    @FormUrlEncoded
    @POST("GetViewStockStore.php")
    Call<GetViewStockStoreResponse> GetViewStockStore(@Field("P_STORE_CODE") String storeCode,
                                                      @Field("P_TRX_DATE") String trx_date);

    @FormUrlEncoded
    @POST("GetViewDailyMtdTransactionStore.php")
    Call<GetViewDailyMTDTransactionStoreResponse> getViewDailyMTDTransactionStore(
            @Field("P_TRX_DATE") String trxdate,
            @Field("P_STORE_CODE") String storeCode);

    @FormUrlEncoded
    @POST("GetViewMtdDiscCodeStore.php")
        Call<DiscCodeResponse> GetViewMtdDiscCodeStore(
            @Field("P_STORE_CODE") String P_STORE_CODE,
            @Field("P_Y_CODE") String P_Y_CODE,
            @Field("P_M_CODE") String P_M_CODE);

 /*
    @FormUrlEncoded
    @POST("getViewEntryTransaction.php")
    Call<GetViewEntryTransactionResponse> getViewEntry(@Field("STORE_CODE") String storecode,
                                                       @Field("TRX_DATE") String trxDate
                                                       );
*/

    @FormUrlEncoded
    @POST("getViewMtdTransaction.php")
    Call<DataMtdTransactionResponse> getMtdTransaction(@Field("STORE_CODE") String storecode,
                                                       @Field("TRX_DATE") String trx_date,
                                                       @Field("Y_ID") String y_id,
                                                       @Field("M_ID") String m_id);


    @FormUrlEncoded
    @POST("PROC_STR_MTD_NETT_PLAN.php")
    Call<PROC_STR_MTD_NETT_PLAN_RESPONSE> GET_PROC_STR_MTD_NETT_PLAN(@Field("STORE_CODE") String storecode,
                                                                     @Field("TRX_DATE") String trx_date,
                                                                     @Field("Y_ID") String y_id,
                                                                     @Field("M_ID") String m_id);

    @FormUrlEncoded
    @POST("getViewDailyMTDSalesCtgrCodeTransaction.php")
    Call<DailyMTDSalesCtgrCodeTransactionResponse> getDailyTrxCtgr(@Field("STORE_CODE") String storeCode,
                                                                   @Field("TRX_DATE") String trx_date);



    @FormUrlEncoded
    @POST("getViewDailyMTDReturnDeliveryTransaction.php")
    Call<DailyMTDReturnDeliveryTransactionResponse> getDailyTrxReturnDelivery(@Field("STORE_CODE") String storeCode, @Field("TRX_DATE") String trx_date);

    @FormUrlEncoded
    @POST("getViewDailyListMutasiHeader.php")
    Call<DailyListMutasiHeaderResponse> getDataMutasiHeader(@Field("STORE_CODE") String storeCode, @Field("TRX_DATE") String trx_date);

    @FormUrlEncoded
    @POST("getViewDailyListMutasiDetail.php")
    Call<DailyListMutasiDetailResponse> getDataMutasiDetail(@Field("TRX_CODE_HDR") String trxcodehdr);


    @FormUrlEncoded
    @POST("getViewDailyMTDSalesModelCodeTransaction.php")
    Call<DailyMTDSalesModelCodeTransactionResponse> getDailyTrxModel(@Field("STORE_CODE") String storeCode, @Field("TRX_DATE") String trx_date);

    @FormUrlEncoded
    @POST("getViewDailyMTDOpnameTransaction.php")
    Call<DailyMTDOpnameTransactionResponse> getDailyTrxOpname(@Field("STORE_CODE") String storeCode, @Field("TRX_DATE") String trx_date);

    @FormUrlEncoded
    @POST("getViewDailyMTDAbsenTransaction.php")
    Call<DailyMTDAbsenTransactionResponse> getDailyTrxAbsen(@Field("STORE_CODE") String storeCode, @Field("TRX_DATE") String trx_date);

    @FormUrlEncoded
    @POST("getViewDailyMTDAbsenVersion2Transaction.php")
    Call<DailyMTDAbsenVersion2TransactionResponse> getDailyTrxAbsenVersion2(@Field("STORE_CODE") String storeCode, @Field("TRX_DATE") String trx_date);


    @FormUrlEncoded
    @POST("getViewDailyMTDSalesArticleTransaction.php")
    Call<DailyMTDSalesArticleTransactionResponse> getDailyTrxArticle(@Field("STORE_CODE") String storeCode, @Field("TRX_DATE") String trx_date);


    @FormUrlEncoded
    @POST("InputTransaction.php")
    Call<InputTransactionResponse> InputTransaction(@Field("TRX_DATE") String trxdate,
                                                    @Field("STORE_CODE") String storeCode,
                                                    @Field("NIK_CODE") String nikCode,
                                                    @Field("UNIQUEID") String uniqueID,
                                                    @Field("PRICE") String price,
                                                    @Field("DISC_CODE") String discCode,
                                                    @Field("QTY") String qty);
    @FormUrlEncoded
    @POST("InputMutasiDetail.php")
    Call<InputMutasiDetailResponse> InputMutasiDetail(@Field("TRX_CODE_HDR") String trxcodehdr,
                                                      @Field("ARTICLE_CODE") String articlecode,
                                                      @Field("TRX_QTY") String qty);
    @FormUrlEncoded
    @POST("InputMutasiHeader.php")
    Call<InputMutasiHeaderResponse> InputMutasiHeader(@Field("STORE_CODE") String storecode,
                                                      @Field("SACK_CODE") String sackcode,
                                                      @Field("TRX_DATE") String trxdate,
                                                      @Field("TRX_TO") String trxto);
    @FormUrlEncoded
    @POST("DeleteMutasiHeader.php")
    Call<DeleteUpdateMutasiHeaderResponse> DeleteMutasiHeader(@Field("TRX_CODE") String trxCode);

    @FormUrlEncoded
    @POST("InputOpname.php")
    Call<InputOpnameResponse> InputOpname(@Field("STORE_CODE") String storecode,
                                          @Field("TRX_DATE") String trxdate,
                                          @Field("CTGR_CODE") String ctgrCode,
                                          @Field("TRX_QTY") String qty);

    @FormUrlEncoded
    @POST("UpdateOpname.php")
    Call<UpdateOpnameResponse> UpdateOpname(@Field("TRX_CODE") String trx_code, @Field("TRX_QTY") String qty);



    @FormUrlEncoded
    @POST("InputAbsensi.php")
    Call<InputAbsensiResponse> InputAbsensi(@Field("STORE_CODE") String StoreCode,
                                            @Field("Y_CODE") String YearCode,
                                            @Field("M_CODE") String MonthCode,
                                            @Field("NIK_CODE") String NikCode,
                                            @Field("HARI_KERJA") String HariKerja,
                                            @Field("HARI_BESAR") String HariBesar,
                                            @Field("HARI_LEMBUR") String HariLembur);

    @FormUrlEncoded
    @POST("InputAbsensiVersion2.php")
    Call<InputAbsensiVersion2Response> InputAbsensiVersion2(@Field("STORE_CODE") String StoreCode,
                                                            @Field("Y_CODE") String YearCode,
                                                            @Field("M_CODE") String MonthCode,
                                                            @Field("NIK_CODE") String NikCode,
                                                            @Field("HARI_KERJA") String HariKerja,
                                                            @Field("JAM_LEMBUR") String JamLembur,
                                                            @Field("HARI_BESAR") String HariBesar,
                                                            @Field("LAIN_LAIN") String LainLain,
                                                            @Field("RESI_POS") String ResiPos,
                                                            @Field("ADMIN") String Admin,
                                                            @Field("ATK") String Atk,
                                                            @Field("POT_SO") String PotSo,
                                                            @Field("POT_SERAGAM") String PotSeragam,
                                                            @Field("POT_CASH_BON") String PotCashBon,
                                                            @Field("TJ_KOM") String TjKom,
                                                            @Field("TJ_TRANSPORT") String TjTrans,
                                                            @Field("TJ_MAKAN") String TjMakan);


    @FormUrlEncoded
    @POST("UpdateAbsensi.php")
    Call<DeleteUpdateAbsensiResponse> UpdateAbsensi(
            @Field("TRX_CODE") String trx_code,
            @Field("STORE_CODE") String StoreCode,
            @Field("Y_CODE") String YearCode,
            @Field("M_CODE") String MonthCode,
            @Field("NIK_CODE") String NikCode,
            @Field("HARI_KERJA") String HariKerja,
            @Field("HARI_BESAR") String HariBesar,
            @Field("HARI_LEMBUR") String HariLembur);


    @FormUrlEncoded
    @POST("UpdateAbsensiVersion2.php")
    Call<DeleteUpdateAbsensiVersion2Response> UpdateAbsensiVersion2(
            @Field("TRX_CODE") String trx_code,
            @Field("STORE_CODE") String StoreCode,
            @Field("Y_CODE") String YearCode,
            @Field("M_CODE") String MonthCode,
            @Field("NIK_CODE") String NikCode,
            @Field("HARI_KERJA") String HariKerja,
            @Field("JAM_LEMBUR") String JamLembur,
            @Field("HARI_BESAR") String HariBesar,
            @Field("LAIN_LAIN") String LainLain,
            @Field("RESI_POS") String ResiPos,
            @Field("ADMIN") String Admin,
            @Field("ATK") String Atk,
            @Field("POT_SO") String PotSo,
            @Field("POT_SERAGAM") String PotSeragam,
            @Field("POT_CASH_BON") String PotCashBon,
            @Field("TJ_KOM") String TjKom,
            @Field("TJ_TRANSPORT") String TjTrans,
            @Field("TJ_MAKAN") String TjMakan);

    @FormUrlEncoded
    @POST("UpdateTransaction.php")
    Call<DeleteUpdateTransactionResponse> updateTransaction(@Field("TRX_DATE") String trxdate,
                                                            @Field("STORE_CODE") String storeCode,
                                                            @Field("UNIQUEID") String uniqueID,
                                                            @Field("PRICE") String price,
                                                            @Field("DISC_CODE") String discCode,
                                                            @Field("QTY") String qty,
                                                            @Field("ROWID") String rowid,
                                                            @Field("NIK_CODE") String nikCode);

    @FormUrlEncoded
    @POST("UpdateMutasi.php")
    Call<DeleteUpdateMutasiResponse> UpdateMutasi(@Field("TRX_CODE") String trx_code,
                                                  @Field("ARTICLE_CODE") String articleCode,
                                                  @Field("SACK_CODE") String sackcode,
                                                  @Field("TRX_DATE") String trxdate,
                                                  @Field("TRX_QTY") String qty,
                                                  @Field("TRX_TO") String trxto);

    @FormUrlEncoded
    @POST("deleteDateTransaction.php")
    Call<DeleteUpdateTransactionResponse> DeleteDateTransaction(@Field("STORE_CODE") String storeCode, @Field("TRX_DATE") String trxdate);


    @FormUrlEncoded
    @POST("DeleteTransaction.php")
    Call<DeleteUpdateTransactionResponse> DeleteTransaction(@Field("ROWID") String rowId,
                                                            @Field("NIK_CODE") String nikCode);

    @FormUrlEncoded
    @POST("DeleteMutasi.php")
    Call<DeleteUpdateMutasiResponse> DeleteMutasi(@Field("TRX_CODE") String trxCode);


    @FormUrlEncoded
    @POST("DeleteAbsensi.php")
    Call<DeleteUpdateAbsensiResponse> DeleteAbsensi(@Field("TRX_CODE") String trxCode);

    @FormUrlEncoded
    @POST("DeleteAbsensiVersion2.php")
    Call<DeleteUpdateAbsensiVersion2Response> DeleteAbsensiVersion2(@Field("TRX_CODE") String trxCode);




    @FormUrlEncoded
    @POST("DeleteOpname.php")
    Call<DeleteOpnameResponse> DeleteOpname(@Field("TRX_CODE") String trx_code);


    @FormUrlEncoded
    @POST("getDataArticle.php")
    Call<ArticleResponse> getDataArticle(@Field("STORE_CODE") String storeCode);

    @FormUrlEncoded
    @POST("getViewDailyMTDSalesCodeTransaction.php")
    Call<DailyMTDSalesCodeTransactionResponse> getDailyTrxDisc(@Field("STORE_CODE") String storeCode, @Field("TRX_DATE") String trx_date);


}
