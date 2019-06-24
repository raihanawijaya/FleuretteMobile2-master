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
import msdmobile.resysxp.com.fleurette.model.DailyMTDDeliveryTransaction;

public class DeliveryAdapter extends RecyclerView.Adapter<DeliveryAdapter.ViewHolder>{
    private Context context;
    private List<DailyMTDDeliveryTransaction> listData;

    public DeliveryAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<DailyMTDDeliveryTransaction> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.delivery_items,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final DailyMTDDeliveryTransaction dataModel = listData.get(position);
        Locale localeID = new Locale("in","ID");
        Float PctAch;

        NumberFormat numberFormatCurrency = new DecimalFormat("#,##0.0");
        NumberFormat numberFormatQty = new DecimalFormat("#,###");

        holder.tvArticle.setText(dataModel.getArticle());
        holder.tvColour.setText(dataModel.getColour());
        holder.tvSize.setText(dataModel.getSize());

        holder.tvTrxNo.setText(dataModel.getTrxNo());
        holder.tvDlvDate.setText(dataModel.getTrxDlvDate());
        holder.tvQty.setText(numberFormatQty.format(Integer.parseInt(dataModel.getQty())));

        if (Integer.parseInt(dataModel.getCode())==2){
            holder.tvArticle.setTextColor(Color.BLUE);
            holder.tvTrxNo.setTextColor(Color.BLUE);
            holder.tvDlvDate.setTextColor(Color.BLUE);
            holder.tvQty.setTextColor(Color.BLUE);
        };

        if (Integer.parseInt(dataModel.getCode())==3){
            holder.tvArticle.setTextColor(Color.RED);
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
        private TextView tvArticle,  tvTrxNo, tvDlvDate, tvQty,tvColour,tvSize;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvArticle = itemView.findViewById(R.id.tv_article);
            tvTrxNo = itemView.findViewById(R.id.tv_trx_no);
            tvDlvDate = itemView.findViewById(R.id.tv_dlv_date);
            tvQty= itemView.findViewById(R.id.tv_qty);
            tvColour= itemView.findViewById(R.id.tv_colour);
            tvSize= itemView.findViewById(R.id.tv_size);



        }
    }
}
