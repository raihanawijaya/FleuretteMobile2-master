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

import java.util.ArrayList;
import java.util.List;

import msdmobile.resysxp.com.fleurette.R;
import msdmobile.resysxp.com.fleurette.adapter.DailyAdapter;
import msdmobile.resysxp.com.fleurette.model.GetViewDailyTransactionStore;
import msdmobile.resysxp.com.fleurette.model.GetViewDailyTransactionStoreResponse;
import msdmobile.resysxp.com.fleurette.services.RetrofitServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView rvList;
    private DailyAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<GetViewDailyTransactionStore> listData = new ArrayList<>();
    private String storeCode, yCode, mCode;

    public String getStoreCode() {
        return storeCode;
    }
    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }
    public String getyCode() {
        return yCode;
    }
    public void setyCode(String yCode) {
        this.yCode = yCode;
    }
    public String getmCode() {
        return mCode;
    }
    public void setmCode(String mCode) {
        this.mCode = mCode;
    }

    public DailyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_daily, container, false);
        swipeRefreshLayout = v.findViewById(R.id.swipe);
        rvList = v.findViewById(R.id.rv_list);
        adapter = new DailyAdapter(listData);
        layoutManager = new LinearLayoutManager(getContext());

        rvList.setLayoutManager(layoutManager);
        rvList.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(this);

        onRefresh();

        return v;

    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        Call<GetViewDailyTransactionStoreResponse> callDaily = RetrofitServices
                .sendDataRequest()
                .getViewDailyTransactionStore(getStoreCode(),getyCode(),getmCode());
        callDaily.enqueue(new Callback<GetViewDailyTransactionStoreResponse>() {
            @Override
            public void onResponse(Call<GetViewDailyTransactionStoreResponse> call, Response<GetViewDailyTransactionStoreResponse> response) {
                listData.clear();
                swipeRefreshLayout.setRefreshing(false);
                if (response.isSuccessful() && response.body().getDataTransaction() != null){
                    for (GetViewDailyTransactionStore item: response.body().getDataTransaction()) {
                        Log.d("data", "onResponse: " + item.getNETT());
                        listData.add(item);
                    }
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<GetViewDailyTransactionStoreResponse> call, Throwable t) {

            }
        });
    }
}
