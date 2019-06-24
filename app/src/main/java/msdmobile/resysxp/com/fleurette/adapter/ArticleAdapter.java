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
import msdmobile.resysxp.com.fleurette.model.DailyMTDSalesArticleTransaction;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder>{
    private Context context;
    private List<DailyMTDSalesArticleTransaction> listData;

    public ArticleAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<DailyMTDSalesArticleTransaction> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_items,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final DailyMTDSalesArticleTransaction dataModel = listData.get(position);
        Locale localeID = new Locale("in","ID");
        Float PctAch;

        NumberFormat numberFormatCurrency = new DecimalFormat("#,##0.0");
        NumberFormat numberFormatQty = new DecimalFormat("#,###");;

        holder.tvArticle.setText(dataModel.getArticle());
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
        private TextView tvArticle,  tvMtdModelQty, tvMtdModelNett, tvMtdModelPct;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvArticle = itemView.findViewById(R.id.tv_model_code);
            tvMtdModelQty = itemView.findViewById(R.id.tv_mtd_model_qty);
            tvMtdModelNett = itemView.findViewById(R.id.tv_mtd_model_nett);
            tvMtdModelPct= itemView.findViewById(R.id.tv_mtd_model_pct);
        }
    }
}
