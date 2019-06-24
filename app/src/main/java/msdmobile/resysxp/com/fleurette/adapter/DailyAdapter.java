package msdmobile.resysxp.com.fleurette.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import msdmobile.resysxp.com.fleurette.R;
import msdmobile.resysxp.com.fleurette.model.GetViewDailyTransactionStore;

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.DailyViewHolder> {
    List<GetViewDailyTransactionStore> list;

    public DailyAdapter(List<GetViewDailyTransactionStore> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public DailyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DailyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DailyViewHolder holder, int position) {

        String DayName ="",Day="";
        Float AvgPrice;
        NumberFormat numberFormatCurrency = new DecimalFormat("#,##0.0");
        NumberFormat numberFormatQty = new DecimalFormat("#,###");

        DayName = list.get(position).TRX_DATE.toString();
        Day = DayName.toString().substring(5,7);

 /*       if (Day.equalsIgnoreCase("SU")){
            holder.tvDailyDate.setTextColor(Color.RED);
            holder.tvDailyQty.setTextColor(Color.RED);
            holder.tvDailyNett.setTextColor(Color.RED);
            holder.tvDailyAvg.setTextColor(Color.RED);
        }*/


        String net;
        if(list.get(position).getNETT().contains(".")){
            int index = list.get(position).getNETT().indexOf(".");
            net = list.get(position).getNETT().substring(0,index);
        }else{
            net = list.get(position).getNETT();
        }
        holder.tvDailyNett.setText(holder.numberFormatCurrency.format(Integer.parseInt(net)));
        holder.tvDailyQty.setText(holder.numberFormatCurrency.format(Integer.parseInt(list.get(position).QTY)));
        holder.tvDailyDate.setText(list.get(position).TRX_DATE);

        AvgPrice = Float.parseFloat(list.get(position).NETT) / Float.parseFloat(list.get(position).QTY);
        holder.tvDailyAvg.setText(numberFormatQty.format(Float.parseFloat(AvgPrice.toString())));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DailyViewHolder extends RecyclerView.ViewHolder {

        TextView tvDailyDate, tvDailyQty, tvDailyNett,tvDailyAvg;
        DecimalFormatSymbols decimalFormatSymbols;
        NumberFormat numberFormatCurrency;

        public DailyViewHolder(View itemView) {
            super(itemView);
            tvDailyDate = itemView.findViewById(R.id.tv_daily_date);
            tvDailyQty = itemView.findViewById(R.id.tv_daily_qty);
            tvDailyNett = itemView.findViewById(R.id.tv_daily_nett);
            tvDailyAvg = itemView.findViewById(R.id.tv_daily_avg);

            Locale localeID = new Locale("in", "ID");

            numberFormatCurrency = NumberFormat.getCurrencyInstance(localeID);
            numberFormatCurrency.setMaximumFractionDigits(0);
            decimalFormatSymbols = ((DecimalFormat) numberFormatCurrency).getDecimalFormatSymbols();
            decimalFormatSymbols.setCurrencySymbol("");
            ((DecimalFormat) numberFormatCurrency).setDecimalFormatSymbols(decimalFormatSymbols);

        }
    }



}
