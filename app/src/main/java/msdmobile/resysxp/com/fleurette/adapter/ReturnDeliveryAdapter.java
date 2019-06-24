package msdmobile.resysxp.com.fleurette.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import msdmobile.resysxp.com.fleurette.R;
import msdmobile.resysxp.com.fleurette.model.DailyMTDReturnDeliveryTransaction;

public class ReturnDeliveryAdapter extends RecyclerView.Adapter<ReturnDeliveryAdapter.ViewHolder>{
    private Context context;
    private List<DailyMTDReturnDeliveryTransaction> listData;

    public ReturnDeliveryAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<DailyMTDReturnDeliveryTransaction> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.return_delivery_items,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final DailyMTDReturnDeliveryTransaction dataModel = listData.get(position);
        Locale localeID = new Locale("in","ID");
        Float PctAch;

        NumberFormat numberFormatCurrency = new DecimalFormat("#,##0.0");
        NumberFormat numberFormatQty = new DecimalFormat("#,###");;

        holder.tvCtgrCode.setText(dataModel.getCtgrCode());
        holder.tvTrxNo.setText(dataModel.getTrxNo());
        holder.tvDlvDate.setText(dataModel.getTrxDate());
        holder.tvQty.setText(numberFormatQty.format(Integer.parseInt(dataModel.getQty())));

        if (Integer.parseInt(dataModel.getCode())==2){
            holder.tvCtgrCode.setTextColor(Color.BLUE);
            holder.tvTrxNo.setTextColor(Color.BLUE);
            holder.tvDlvDate.setTextColor(Color.BLUE);
            holder.tvQty.setTextColor(Color.BLUE);
        };

        if (Integer.parseInt(dataModel.getCode())==3){
            holder.tvCtgrCode.setTextColor(Color.RED);
            holder.tvTrxNo.setTextColor(Color.RED);
            holder.tvDlvDate.setTextColor(Color.RED);
            holder.tvQty.setTextColor(Color.RED);
        };

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
        private TextView tvCtgrCode,  tvTrxNo, tvDlvDate, tvQty;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvCtgrCode = itemView.findViewById(R.id.tv_ctgr_code);
            tvTrxNo = itemView.findViewById(R.id.tv_trx_no);
            tvDlvDate = itemView.findViewById(R.id.tv_dlv_date);
            tvQty= itemView.findViewById(R.id.tv_qty);

        }
    }
}
