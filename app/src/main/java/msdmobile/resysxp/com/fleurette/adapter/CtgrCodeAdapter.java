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
import msdmobile.resysxp.com.fleurette.model.DailyMTDSalesCtgrCodeTransaction;

public class CtgrCodeAdapter extends RecyclerView.Adapter<CtgrCodeAdapter.ViewHolder>{
    private Context context;
    private List<DailyMTDSalesCtgrCodeTransaction> listData;

    public CtgrCodeAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<DailyMTDSalesCtgrCodeTransaction> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ctgr_items,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final DailyMTDSalesCtgrCodeTransaction dataModel = listData.get(position);
        Locale localeID = new Locale("in","ID");
        Float PctAch;

        NumberFormat numberFormatCurrency = new DecimalFormat("#,##0.0");
        NumberFormat numberFormatQty = new DecimalFormat("#,###");;

        holder.tvCtgrCode.setText(dataModel.getCtgrCode());
        holder.tvMtdCtgrNett.setText(numberFormatQty.format(Integer.parseInt(dataModel.getMtdNett())));
        holder.tvMtdCtgrQty.setText(dataModel.getMtdQty());

        PctAch = Float.parseFloat(dataModel.getMtdNett())*100/Float.parseFloat(dataModel.getMtdNettTotal());
        holder.tvMtdCtgrPct.setText(numberFormatCurrency.format(Float.parseFloat(PctAch.toString())));


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
        private TextView tvCtgrCode,  tvMtdCtgrQty, tvMtdCtgrNett, tvMtdCtgrPct;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvCtgrCode = itemView.findViewById(R.id.tv_ctgr_code);
            tvMtdCtgrQty = itemView.findViewById(R.id.tv_mtd_ctgr_qty);
            tvMtdCtgrNett = itemView.findViewById(R.id.tv_mtd_ctgr_nett);
            tvMtdCtgrPct= itemView.findViewById(R.id.tv_mtd_ctgr_pct);

        }
    }
}
