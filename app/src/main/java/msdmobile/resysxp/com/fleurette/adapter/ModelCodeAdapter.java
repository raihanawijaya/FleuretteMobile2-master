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
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import msdmobile.resysxp.com.fleurette.R;
import msdmobile.resysxp.com.fleurette.model.DailyMTDSalesModelCodeTransaction;

public class ModelCodeAdapter extends RecyclerView.Adapter<ModelCodeAdapter.ViewHolder>{
    private Context context;
    private List<DailyMTDSalesModelCodeTransaction> listData;

    public ModelCodeAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<DailyMTDSalesModelCodeTransaction> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_items,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final DailyMTDSalesModelCodeTransaction dataModel = listData.get(position);
        Locale localeID = new Locale("in","ID");
        Float PctAch;

        NumberFormat numberFormatCurrency = new DecimalFormat("#,##0.0");
        NumberFormat numberFormatQty = new DecimalFormat("#,###");;

        holder.tvModelCode.setText(dataModel.getModelCode());
        holder.tvMtdModelNett.setText(numberFormatQty.format(Integer.parseInt(dataModel.getMtdNett())));
        holder.tvMtdModelQty.setText(dataModel.getMtdQty());

        PctAch = Float.parseFloat(dataModel.getMtdNett())*100/Float.parseFloat(dataModel.getMtdNettTotal());
        holder.tvMtdModelPct.setText(numberFormatCurrency.format(Float.parseFloat(PctAch.toString())));


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
        private TextView tvModelCode,  tvMtdModelQty, tvMtdModelNett, tvMtdModelPct;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvModelCode = itemView.findViewById(R.id.tv_model_code);
            tvMtdModelQty = itemView.findViewById(R.id.tv_mtd_model_qty);
            tvMtdModelNett = itemView.findViewById(R.id.tv_mtd_model_nett);
            tvMtdModelPct= itemView.findViewById(R.id.tv_mtd_model_pct);
        }
    }
}
