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
import msdmobile.resysxp.com.fleurette.model.GetViewListDiscount;

public class ListDiscountAdapter extends RecyclerView.Adapter<ListDiscountAdapter.ViewHolder>{
    private Context context;
    private List<GetViewListDiscount> listData;

    public ListDiscountAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<GetViewListDiscount> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_disc_items,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final GetViewListDiscount dataModel = listData.get(position);
        Locale localeID = new Locale("in","ID");


        NumberFormat numberFormatQty = new DecimalFormat("#,###");

        NumberFormat numberFormatCurrency = NumberFormat.getCurrencyInstance(localeID);
        numberFormatCurrency.setMaximumFractionDigits(0);
        DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) numberFormatCurrency).getDecimalFormatSymbols();
        decimalFormatSymbols.setCurrencySymbol("");
        ((DecimalFormat) numberFormatCurrency).setDecimalFormatSymbols(decimalFormatSymbols);

        holder.tvDiscCode.setText(dataModel.getDiscCode());
        holder.tvDiscPct.setText(dataModel.getDiscPct());
        holder.tvUseThisPrice.setText(dataModel.getUseThisPrice());
        holder.tvThisPrice.setText(dataModel.getThisPrice());

         holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });


    }


    @Override
    public int getItemCount() {

     return listData.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cvItem;
        private TextView tvDiscCode, tvDiscPct, tvUseThisPrice, tvThisPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvDiscCode = itemView.findViewById(R.id.tv_disc_code);
            tvDiscPct = itemView.findViewById(R.id.tv_disc_pct);
            tvUseThisPrice = itemView.findViewById(R.id.tv_use_this_price);
            tvThisPrice = itemView.findViewById(R.id.tv_this_price);

        }
    }
}
