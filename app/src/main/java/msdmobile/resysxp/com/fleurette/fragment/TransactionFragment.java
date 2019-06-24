package msdmobile.resysxp.com.fleurette.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import msdmobile.resysxp.com.fleurette.R;
import msdmobile.resysxp.com.fleurette.adapter.DataAdapter;
import msdmobile.resysxp.com.fleurette.model.GetViewEntryTransactionModel;
import msdmobile.resysxp.com.fleurette.model.GetViewEntryTransactionResponse;
import msdmobile.resysxp.com.fleurette.model.LoginModel;
import msdmobile.resysxp.com.fleurette.services.RetrofitServices;
import msdmobile.resysxp.com.fleurette.utils.SharedPreference;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransactionFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView rvList;
    private DataAdapter adapter;
    private List<GetViewEntryTransactionModel> listData = new ArrayList<>();
    private String storeCode, date, y_id, m_id,mtdQty, mtdNett, totalQty, totalNett;
    private String uniqueID, discCode, qty, harga, nett, article, warna, size, NIKCode;
    public TransactionFragment() {
        // Required empty public constructor
    }
    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getY_id() {
        return y_id;
    }

    public void setY_id(String y_id) {
        this.y_id = y_id;
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public String getMtdQty() {
        return mtdQty;
    }

    public void setMtdQty(String mtdQty) {
        this.mtdQty = mtdQty;
    }

    public String getMtdNett() {
        return mtdNett;
    }

    public void setMtdNett(String mtdNett) {
        this.mtdNett = mtdNett;
    }

    public String getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(String totalQty) {
        this.totalQty = totalQty;
    }

    public String getTotalNett() {
        return totalNett;
    }

    public void setTotalNett(String totalNett) {
        this.totalNett = totalNett;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_transaction, container, false);
        swipeRefreshLayout = v.findViewById(R.id.swipe);
        rvList = v.findViewById(R.id.rv_list);

        SharedPreference sharedPreference = new SharedPreference(getContext());
        if (sharedPreference.checkIfDataExists("dataLogin")) {
            LoginModel loginModel = sharedPreference.getObjectData("dataLogin", LoginModel.class);
            storeCode = loginModel.getSTORECODE();
        }

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // sdfView = new SimpleDateFormat("EEEE,dd MMM yyyy");

        date = sdf.format(calendar.getTime());

        adapter = new DataAdapter(getContext());
        rvList.setHasFixedSize(true);
        rvList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvList.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(this);

        Log.d("STORE_CODE", "onCreateView: " + storeCode + " " + date);
        getDataTransaction(storeCode, getDate());

        return v;
    }

    private void getDataTransaction(String storeCode, String date) {
        swipeRefreshLayout.setRefreshing(true);
        listData.clear();

        try {
            Call<GetViewEntryTransactionResponse> call = RetrofitServices.sendDataRequest().getDataTransaction(storeCode, date);
            if (call != null) {
                call.enqueue(new Callback<GetViewEntryTransactionResponse>() {
                    @Override
                    public void onResponse(Call<GetViewEntryTransactionResponse> call, Response<GetViewEntryTransactionResponse> response) {
                        swipeRefreshLayout.setRefreshing(false);
                        Locale localeID = new Locale("in", "ID");

                        if (response.isSuccessful()) {
                            boolean error = response.body().getError();
                            String msg = response.body().getMsg();
                            if (!error) {
                                listData = response.body().getDataTransaction();
                            } else {
                               // Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
                            }
                        } /*else {
                            Toast.makeText(getContext(), "Connection error", Toast.LENGTH_SHORT).show();
                        }*/

                        adapter.setData(listData);
                    }

                    @Override
                    public void onFailure(Call<GetViewEntryTransactionResponse> call, Throwable t) {
                        swipeRefreshLayout.setRefreshing(false);
                        Log.e("error", t.getMessage());
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRefresh() {
        getDataTransaction(getStoreCode(), getDate());
    }

    public void onResume() {
        super.onResume();
        getDataTransaction(getStoreCode(), getDate());
    }
}

