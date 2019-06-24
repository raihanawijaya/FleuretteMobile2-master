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
import msdmobile.resysxp.com.fleurette.model.GetViewBestMotif;

public class BestMotifAdapter extends RecyclerView.Adapter<BestMotifAdapter.ViewHolder>{
    private Context context;
    private List<GetViewBestMotif> listData;

    public BestMotifAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<GetViewBestMotif> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.best_motif_items,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final GetViewBestMotif dataModel = listData.get(position);
        Locale localeID = new Locale("in","ID");
        Float AvgPrice;
        NumberFormat numberFormatCurrency = new DecimalFormat("#,###");
        NumberFormat numberFormatQty = new DecimalFormat("#,###");

        holder.tvMotif.setText(dataModel.getMotif());
        holder.tvQty.setText(dataModel.getQty());
        holder.tvNett.setText(numberFormatQty.format(Float.parseFloat(dataModel.getNett())));

        AvgPrice = Float.parseFloat(dataModel.getNett())/Float.parseFloat(dataModel.getQty());
        holder.tvAvgPrice.setText(numberFormatQty.format(AvgPrice));

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
        private TextView tvMotif, tvNett, tvNettPct, tvQty,tvAvgPrice;
        DecimalFormatSymbols decimalFormatSymbols;
        NumberFormat numberFormatCurrency;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvMotif = itemView.findViewById(R.id.tv_motif);
            tvQty = itemView.findViewById(R.id.tv_qty);
            tvNett = itemView.findViewById(R.id.tv_nett);
            tvNettPct= itemView.findViewById(R.id.tv_nett_pct);
            tvAvgPrice= itemView.findViewById(R.id.tv_avg_price);

        }
    }
}
