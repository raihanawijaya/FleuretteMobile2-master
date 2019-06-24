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
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import msdmobile.resysxp.com.fleurette.R;
import msdmobile.resysxp.com.fleurette.adapter.StockStoreAdapter;
import msdmobile.resysxp.com.fleurette.model.GetViewStockStore;
import msdmobile.resysxp.com.fleurette.model.GetViewStockStoreResponse;
import msdmobile.resysxp.com.fleurette.services.RetrofitServices;
import msdmobile.resysxp.com.fleurette.utils.SharedPreference;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class StockStoreFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView rvList;
    private StockStoreAdapter adapter;
    private List<GetViewStockStore> listData = new ArrayList<>();
    private SharedPreference sharedPreference;
    private String storeCode, date;

    public StockStoreFragment() {
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_stock_store, container, false);
        swipeRefreshLayout = v.findViewById(R.id.swipe);
        rvList = v.findViewById(R.id.rv_list);

        adapter = new StockStoreAdapter(getContext());
        rvList.setHasFixedSize(true);
        rvList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvList.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(this);

        getDataTransaction(getStoreCode(), getDate());
        return  v;
    }

    private void getDataTransaction(String storeCode, String date) {
        swipeRefreshLayout.setRefreshing(true);
        listData.clear();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Call<GetViewStockStoreResponse> call = RetrofitServices.sendDataRequest().GetViewStockStore(storeCode, date);
            if (call != null) {
                call.enqueue(new Callback<GetViewStockStoreResponse>() {
                    @Override
                    public void onResponse(Call<GetViewStockStoreResponse> call, Response<GetViewStockStoreResponse> response) {
                        swipeRefreshLayout.setRefreshing(false);
                        Locale localeID = new Locale("in", "ID");
                        /*
                        NumberFormat numberFormatCurrency = NumberFormat.getCurrencyInstance(localeID);
                        numberFormatCurrency.setMaximumFractionDigits(0);
                        DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) numberFormatCurrency).getDecimalFormatSymbols();
                        decimalFormatSymbols.setCurrencySymbol("");
                        ((DecimalFormat) numberFormatCurrency).setDecimalFormatSymbols(decimalFormatSymbols);
                        */
                        if (response.isSuccessful()) {
                            boolean error = response.body().getError();
                            String msg = response.body().getMsg();
                            GetViewStockStore dataMtdTransactionModel = null;
                            if (!error) {
                                listData = response.body().GetViewStockStore();
                            } else {
                               Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
                            }
                            adapter.setData(listData);
                        } else {
                               Toast.makeText(getContext(), "Connection error", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<GetViewStockStoreResponse> call, Throwable t) {
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
}

