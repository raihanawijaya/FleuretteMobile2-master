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
import msdmobile.resysxp.com.fleurette.model.GetViewEntryTransactionModel;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private Context context;
    private List<GetViewEntryTransactionModel> listData;

    public DataAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setData(List<GetViewEntryTransactionModel> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.transcation_items, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final GetViewEntryTransactionModel dataModel = listData.get(position);


        Locale localeID = new Locale("in", "ID");

        NumberFormat numberFormatCurrency = NumberFormat.getCurrencyInstance(localeID);
        numberFormatCurrency.setMaximumFractionDigits(0);
        DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) numberFormatCurrency).getDecimalFormatSymbols();
        decimalFormatSymbols.setCurrencySymbol("");
        ((DecimalFormat) numberFormatCurrency).setDecimalFormatSymbols(decimalFormatSymbols);

        holder.tvUniqueID.setText(dataModel.getUNIQUEID());
        String net;
        if (dataModel.getNETT().contains(".")) {
            int index = dataModel.getNETT().indexOf(".");
            net = dataModel.getNETT().substring(0, index);
        } else {
            net = dataModel.getNETT();
        }
        holder.tvNett.setText(numberFormatCurrency.format(Integer.parseInt(net)));
        holder.tvPrice.setText(numberFormatCurrency.format(dataModel.getPRICE()));
        holder.tvArticle.setText(dataModel.getARTICLE());
        holder.tvSlsCode.setText(dataModel.getDISCCODE());
        holder.tvQty.setText(String.valueOf(dataModel.getQTY()));
        holder.tvWarna.setText(dataModel.getWARNA());
        holder.tvSize.setText(dataModel.getSIZE());
        holder.tvNIKCode.setText(dataModel.getNIKCODE());


        holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 * Perlu diketahui intent bisa mengirimkan data ke activity lain yang dituju
                 * Pada kasus ini intent yang dituju yaitu AddDataActivity
                 * Pada baris 55 - 59 merupakan cara untuk mengirimkan data dari suatu activity ke activity lainnya
                 * */
                if (context instanceof AddDataActivity)
                    ((AddDataActivity) context).setData(dataModel);
//                else {
//                    Intent i = new Intent(context, AddDataActivity.class);
//                    i.putExtra("status", "edit");
//                    i.putExtra("trxdate", dataModel.gettRX_DATE());
//                    i.putExtra("uniqueid", dataModel.getUNIQUEID());
//                    i.putExtra("disccode", dataModel.getDISCCODE());
//                    i.putExtra("price", dataModel.getPRICE());
//                    i.putExtra("qty", dataModel.getQTY());
//                    i.putExtra("rowid", dataModel.getROWID());
//                    context.startActivity(i);
//                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cvItem;
        private TextView tvUniqueID, tvArticle, tvSlsCode, tvQty, tvPrice, tvNett, tvWarna, tvSize, tvNIKCode;

        public ViewHolder(View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvUniqueID = itemView.findViewById(R.id.tv_uniqueid);
            tvArticle = itemView.findViewById(R.id.tv_article);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvQty = itemView.findViewById(R.id.tv_qty);
            tvSlsCode = itemView.findViewById(R.id.tv_sls_code);
            tvQty = itemView.findViewById(R.id.tv_qty);
            tvNett = itemView.findViewById(R.id.tv_nett);
            tvWarna = itemView.findViewById(R.id.tv_warna);
            tvSize = itemView.findViewById(R.id.tv_size);
            tvNIKCode = itemView.findViewById(R.id.tv_nik_code);
        }
    }
}
