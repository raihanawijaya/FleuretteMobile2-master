package msdmobile.resysxp.com.fleurette.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import msdmobile.resysxp.com.fleurette.R;
import msdmobile.resysxp.com.fleurette.model.GetViewStockStore;

public class StockStoreAdapter extends RecyclerView.Adapter<StockStoreAdapter.ViewHolder>{
    private Context context;
    private List<GetViewStockStore> listData;

    public StockStoreAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<GetViewStockStore> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.stock_store_items,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final GetViewStockStore dataModel = listData.get(position);
        Locale localeID = new Locale("in","ID");

        NumberFormat numberFormatCurrency = new DecimalFormat("#,###");
        NumberFormat numberFormatQty = new DecimalFormat("#,###");

        holder.tvInfo.setText(dataModel.getInfo());
        holder.tvQty.setText(dataModel.getQty());

        holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           // holder.cvItem.setCardBackgroundColor(Color.RED);
            }
        });
    }

    @Override
    public int getItemCount() {

     return listData.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cvItem;
        private TextView tvInfo,  tvQty;
        DecimalFormatSymbols decimalFormatSymbols;
        NumberFormat numberFormatCurrency;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvInfo = itemView.findViewById(R.id.tv_info);
            tvQty = itemView.findViewById(R.id.tv_qty);

        }
    }
}
