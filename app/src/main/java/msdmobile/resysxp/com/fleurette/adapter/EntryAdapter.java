package msdmobile.resysxp.com.fleurette.adapter;

import android.content.Context;
import android.content.Intent;
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

import msdmobile.resysxp.com.fleurette.AddDataActivity;
import msdmobile.resysxp.com.fleurette.R;
import msdmobile.resysxp.com.fleurette.model.DataEntryModel;

public class EntryAdapter extends RecyclerView.Adapter<EntryAdapter.ViewHolder> {
    private Context context;
    private List<DataEntryModel> listData;

    public EntryAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<DataEntryModel> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_items, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DataEntryModel dataModel = listData.get(position);

        Locale localeID = new Locale("in", "ID");

        NumberFormat numberFormatCurrency = NumberFormat.getCurrencyInstance(localeID);
        numberFormatCurrency.setMaximumFractionDigits(0);
        DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) numberFormatCurrency).getDecimalFormatSymbols();
        decimalFormatSymbols.setCurrencySymbol("");
        ((DecimalFormat) numberFormatCurrency).setDecimalFormatSymbols(decimalFormatSymbols);

        holder.tvNett.setText(numberFormatCurrency.format(Integer.parseInt(dataModel.getNett())));
        holder.tvPrice.setText(numberFormatCurrency.format(dataModel.getArticlePrice()));
        holder.tvArticle.setText(dataModel.getArticleCode());
        holder.tvSlsCode.setText(dataModel.getSalesCode());
        holder.tvQty.setText(String.valueOf(dataModel.getTrxQty()));


        holder.cvItem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, AddDataActivity.class);
                i.putExtra("status", "edit");
                i.putExtra("trxcode", dataModel.getTrxCode());
                i.putExtra("storecode", dataModel.getStoreCode());
                i.putExtra("trxdate", dataModel.getTrxDate());
                i.putExtra("article", dataModel.getArticleCode());
                i.putExtra("slscode", dataModel.getSalesCode());
                i.putExtra("qty", dataModel.getTrxQty());
                context.startActivity(i);
            }
        }
        );
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cvItem;
        private TextView tvArticle, tvSlsCode, tvQty,tvPrice,tvNett;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvArticle = itemView.findViewById(R.id.tv_article);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvQty = itemView.findViewById(R.id.tv_qty);
            tvSlsCode = itemView.findViewById(R.id.tv_sls_code);
            tvQty = itemView.findViewById(R.id.tv_qty);
            tvNett = itemView.findViewById(R.id.tv_nett);

        }
    }
}
