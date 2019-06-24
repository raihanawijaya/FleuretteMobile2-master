package msdmobile.resysxp.com.fleurette;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.WindowManager;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import msdmobile.resysxp.com.fleurette.adapter.DataAdapter;
import msdmobile.resysxp.com.fleurette.adapter.EntryAdapter;
import msdmobile.resysxp.com.fleurette.model.DataEntryModel;
import msdmobile.resysxp.com.fleurette.model.DeleteUpdateTransactionResponse;
import msdmobile.resysxp.com.fleurette.model.GetViewEntryTransactionModel;
import msdmobile.resysxp.com.fleurette.model.GetViewEntryTransactionResponse;
import msdmobile.resysxp.com.fleurette.model.InputTransactionResponse;
import msdmobile.resysxp.com.fleurette.model.LoginModel;
import msdmobile.resysxp.com.fleurette.services.RetrofitServices;
import msdmobile.resysxp.com.fleurette.utils.SharedPreference;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddDataActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private Toolbar toolbar;
    private TextView tvStoreCode, tvStoreName,tvNikCode, tvNikName;
    private EditText etTrxDate, etDiscCode, etUniqueID,etPrice, etQty;
    private List<GetViewEntryTransactionModel> listData = new ArrayList<>();
    private DataAdapter adapter;
    private MaterialSpinner spinnerArticle;
    private ImageButton btnClear;
    private SharedPreference sharedPreference;
    private String status,dateString,rowId;
    private SimpleDateFormat sdf, sdfView;
    private ProgressDialog addLoading;
    private RecyclerView rvList;
    private SwipeRefreshLayout swipeRefreshLayout;
    private String date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        swipeRefreshLayout = findViewById(R.id.swipe);
        rvList = findViewById(R.id.rv_list);

        addLoading = new ProgressDialog(this);
        addLoading.setMessage("Log In . . .");
        addLoading.setCancelable(false);

        toolbar = findViewById(R.id.toolbar);
        tvStoreCode = findViewById(R.id.tv_store_code);
        tvStoreName = findViewById(R.id.tv_store_name);

        tvNikCode = findViewById(R.id.tv_nik_code);
        tvNikName = findViewById(R.id.tv_nik_name);
        etTrxDate = findViewById(R.id.et_trx_date);
        etDiscCode = findViewById(R.id.et_disc_code);
        etUniqueID= findViewById(R.id.et_uniqueid);
        etPrice =findViewById(R.id.et_price);
        etQty = findViewById(R.id.et_qty);


        btnClear = findViewById(R.id.btn_clear);

        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        sharedPreference = new SharedPreference(this);
        LoginModel loginModel = sharedPreference.getObjectData("dataLogin", LoginModel.class);

        //Adapter
        adapter = new DataAdapter(this);
        rvList.setHasFixedSize(true);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(adapter);

        final String nikCode = loginModel.getNIKCODE();
        final String storeCode = loginModel.getSTORECODE();

        Intent dataIntent = getIntent();

        tvStoreCode.setText(loginModel.getSTORECODE());
        tvStoreName.setText(loginModel.getsTORENAME());
        tvNikCode.setText(loginModel.getNIKCODE());
        tvNikName.setText(loginModel.getNIKNAME());

       // tvStoreName.setText("");
       // tvNikName.setText("");

        etQty.setSelection(etQty.getText().toString().length());

        sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdfView = new SimpleDateFormat("dd MMMM yyyy");

        /*
        try {
            Date date = sdf.parse(dateString);
            dateString = date.toString();
            } catch (Exception e) {
            e.printStackTrace();
        }  */

        status = dataIntent.getStringExtra("status"); //Coba run
        dateString = dataIntent.getStringExtra("date");
        etTrxDate.setText(dateString);

        try {
            getDataTransaction(storeCode,sdf.format(sdfView.parse(dateString)));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /*
        etTrxDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                       AddDataActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });*/


        /*
        if (status.equals("edit")) {
           // String storecode = dataIntent.getStringExtra("storecode");
          //  String nikcode = dataIntent.getStringExtra("nikcode");
            String uniqueID = dataIntent.getStringExtra("uniqueid");
            String discCode = dataIntent.getStringExtra("disccode");
            String price = String.valueOf(dataIntent.getIntExtra("price", 0));
            String qty = String.valueOf(dataIntent.getIntExtra("qty", 0));
            rowId = String.valueOf(dataIntent.getIntExtra("rowid", 0));

            dateString = dataIntent.getStringExtra("trxdate");
            Log.d("DATE", "onCreate: " + dateString);

            etUniqueID.setText(uniqueID);
            etUniqueID.requestFocus();
            etDiscCode.setText(discCode);
            etPrice.setText(price);
            etQty.setText(qty);
            etTrxDate.setText(dateString);
        } else {
            dateString = dataIntent.getStringExtra("date");
            etTrxDate.setText(dateString);
        }*/

        etUniqueID.requestFocus();
        //Log.d("Oncreate", "OnOpenActivity: " + "Store_code " + storeCode + " Tanggal=" +sdf.format(dateString));

        //getDataTransaction(storeCode,sdf.format(dateString));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    getDataTransaction(storeCode,sdf.format(sdfView.parse(dateString)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void getDataTransaction(String storeCode, String date) {

        listData.clear();

        try {
            Call<GetViewEntryTransactionResponse> call = RetrofitServices.sendDataRequest().getDataTransaction(storeCode, date);
            if (call != null) {
                call.enqueue(new Callback<GetViewEntryTransactionResponse>() {
                    @Override
                    public void onResponse(Call<GetViewEntryTransactionResponse> call, Response<GetViewEntryTransactionResponse> response) {
                        swipeRefreshLayout.setRefreshing(false);
                       // Locale localeID = new Locale("in", "ID");

                        if (response.isSuccessful()) {
                            boolean error = response.body().getError();
                            String msg = response.body().getMsg();
                            if (!error) {
                                listData = response.body().getDataTransaction();
                            } else {
                                // Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
                            }
                        } /*else {
                            Toast.makeText(getContext(), "Connection error", Toast.LENGTH_SHORT).show();
                        }*/

                        adapter.setData(listData);
                    }

                    @Override
                    public void onFailure(Call<GetViewEntryTransactionResponse> call, Throwable t) {
                        swipeRefreshLayout.setRefreshing(false);
                        Log.e("error", t.getMessage());
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isInputValid() {

        if (TextUtils.isEmpty(etTrxDate.getText().toString())
                || TextUtils.isEmpty(etUniqueID.getText().toString())
                || TextUtils.isEmpty(etDiscCode     .getText().toString())
                || TextUtils.isEmpty(etPrice.getText().toString())
                ||TextUtils.isEmpty(etQty.getText().toString())) {

            if (TextUtils.isEmpty(etTrxDate.getText().toString())) {
                etTrxDate.setError("TRX_DATE harus diisi!");
            }

            if (TextUtils.isEmpty(etUniqueID.getText().toString())) {
                etUniqueID.setError("Uniqueid harus diisi!");
            }

            if (TextUtils.isEmpty(etDiscCode.getText().toString())) {
                etDiscCode.setError("Disc Code harus diisi");
            }

            if (TextUtils.isEmpty(etQty.getText().toString())) {
                etQty.setError("Qty Code harus diisi");
            }

            return false;
        }

        return true;
    }
    /***************************************************************************************************************************************/
    private void clearLayout() {
        etUniqueID.requestFocus();
        etUniqueID.setText("");
        etQty.setText("1");
    }
    /***************************************************************************************************************************************/
    private void InputTransaction(final String trxDate,final String storeCode, String nikCode, String uniqueID, String price, String discCode, String qty) {
        Log.d("DATA", "InputTransaction: " + trxDate + " " + storeCode + " " + nikCode + " " + uniqueID + " " + price + " " + discCode + " " + qty);
        Toast toast;
        addLoading.show();
        try {
            Call<InputTransactionResponse> call = RetrofitServices.sendDataRequest().InputTransaction(trxDate,storeCode,nikCode,uniqueID,price,discCode,qty);
            call.enqueue(new Callback<InputTransactionResponse>() {
                @Override
                public void onResponse(Call<InputTransactionResponse> call, Response<InputTransactionResponse> response) {
                    addLoading.dismiss();
                    if (response.isSuccessful()) {
                        String msg = response.body().getMsg();
                        boolean error = response.body().getError();
                        if (!error) {
                            String substr=msg.substring(0,1);
                            Toast toast = Toast.makeText(AddDataActivity.this, msg, Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, -45);
                            toast.show();
                            etUniqueID.setText("");

                            Log.d("DATA", "Data store in input Transaction: " + trxDate + " " + storeCode );

                            getDataTransaction(storeCode,trxDate);
                        } else {
                            Toast toast = Toast.makeText(AddDataActivity.this, msg, Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, -45);
                            toast.show();

                        }
                        etUniqueID.requestFocus();
                        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);

                    }
                }

                @Override
                public void onFailure(Call<InputTransactionResponse> call, Throwable t) {
                    addLoading.dismiss();
                    Log.e("error", "onFailure: " + t.getMessage());

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void UpdateTransaction(final String trxDate, final String storeCode, String uniqueID, String price, String discCode, String qty, String rowID,String nikCode) {
        Toast toast;
        Log.d("UPDATE", "updateTransaction: " + " " + trxDate + " " + storeCode + " " + uniqueID + " " + price + " " + discCode + " " + qty + " " + rowID);
        addLoading.show();
        try {
            Call<DeleteUpdateTransactionResponse> call = RetrofitServices.sendDataRequest().updateTransaction(trxDate,storeCode,uniqueID,price,discCode,qty,rowID,nikCode);
            call.enqueue(new Callback<DeleteUpdateTransactionResponse>() {
                @Override
                public void onResponse(Call<DeleteUpdateTransactionResponse> call, Response<DeleteUpdateTransactionResponse> response) {
                    addLoading.dismiss();
                    if (response.isSuccessful()) {
                        String msg = response.body().getMsg();
                        boolean error = response.body().getError();
                        String substr=msg.substring(0,1);
                        Toast toast = Toast.makeText(AddDataActivity.this, msg, Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, -45);
                        toast.show();

                        Log.d("DATA", "Data store in input Transaction: " + trxDate + " " + storeCode );

                        getDataTransaction(storeCode,trxDate);

                    }
                }

                @Override
                public void onFailure(Call<DeleteUpdateTransactionResponse> call, Throwable t) {
                    addLoading.dismiss();
                    Log.e("error", "onFailure: " + t.getMessage());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void DeleteTransaction(String rowId,String nikCode) {
        Log.d("DELETE", "DeleteTransaction: " + " " + rowId + " " + nikCode );
         try {
            Call<DeleteUpdateTransactionResponse> call = RetrofitServices.sendDataRequest().DeleteTransaction(rowId,nikCode);
            call.enqueue(new Callback<DeleteUpdateTransactionResponse>() {
                @Override
                public void onResponse(Call<DeleteUpdateTransactionResponse> call, Response<DeleteUpdateTransactionResponse> response) {
                    if (response.isSuccessful()) {
                        String msg = response.body().getMsg();
                        Toast.makeText(AddDataActivity.this, msg, Toast.LENGTH_SHORT).show();

                        String trxdate = etTrxDate.getText().toString();
                        String storeCode = tvStoreCode.getText().toString();

                        try {
                            Date date = sdfView.parse(trxdate);
                            trxdate = sdf.format(date);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Log.d("DATA", "Data store in delete Transaction: " + trxdate + " " + storeCode );
                        getDataTransaction(storeCode,trxdate);
//                        finish();
                    }
                }

                @Override
                public void onFailure(Call<DeleteUpdateTransactionResponse> call, Throwable t) {
                    Log.d("error", "onFailure: " + t.getMessage());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_data_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem Delete = menu.findItem(R.id.delete);

        if (status.equals("add")) {
            Delete.setVisible(true);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.delete:
                new AlertDialog.Builder(this)
                        .setTitle("Confirm ?")
                        .setMessage("Apakah anda yakin akan menghapus data ini?")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String nikCode = tvNikCode.getText().toString();
                                String trxdate = etTrxDate.getText().toString();
                                String storeCode = tvStoreCode.getText().toString();

                                try {
                                    Date date = sdfView.parse(trxdate);
                                    trxdate = sdf.format(date);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                DeleteTransaction(rowId,nikCode);

                                Log.d("DELETE", "DeleteTransaction: " + " " + storeCode + " " + trxdate );

                              //  getDataTransaction(storeCode,trxdate);
                            }
                        })
                        .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .show();
                break;
            case R.id.save:
                        String nikCode = tvNikCode.getText().toString();
                        String trxdate = etTrxDate.getText().toString();
                        String uniqueID = etUniqueID.getText().toString();
                        String discCode = etDiscCode.getText().toString();
                        String price = etPrice.getText().toString();
                        String qty = etQty.getText().toString();
                        String storeCode = tvStoreCode.getText().toString();

                        try {
                            Date date = sdfView.parse(trxdate);
                            trxdate = sdf.format(date);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                            InputTransaction(trxdate,storeCode,nikCode,uniqueID,price,discCode,qty);
                            Log.d("INSERT", "InsertTransaction: " + " " + storeCode + " " + trxdate );


                break;
            case R.id.update:
                new AlertDialog.Builder(this)
                        .setTitle("Confirm ?")
                        .setMessage("Apakah anda yakin akan merubah data ini?")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String nikCode = tvNikCode.getText().toString();
                                String trxdate = etTrxDate.getText().toString();
                                String uniqueID = etUniqueID.getText().toString();
                                String discCode = etDiscCode.getText().toString();
                                String price = etPrice.getText().toString();
                                String qty = etQty.getText().toString();
                                String storeCode = tvStoreCode.getText().toString();

                                try {
                                    Date date = sdfView.parse(trxdate);
                                    trxdate = sdf.format(date);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                UpdateTransaction(trxdate, storeCode, uniqueID,price, discCode, qty, rowId,nikCode);

                            }
                        })
                        .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String month;
        if ((monthOfYear+1) < 10) {
            month = "0" + (monthOfYear+1);
        } else {
            month = String.valueOf(monthOfYear+1);
        }
        dateString = year + "-" + month + "-" + dayOfMonth;
        try {
            Date date = sdf.parse(dateString);
            dateString = sdfView.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        etTrxDate.setText(dateString);
    }

    public void setData(GetViewEntryTransactionModel model){
        etUniqueID.setText(model.getUNIQUEID());
        etDiscCode.setText(model.getDISCCODE());
        etPrice.setText(model.getPRICE().toString());
        etQty.setText(model.getQTY().toString());
       // etTrxDate.setText(model.gettRX_DATE());
        rowId=model.getROWID().toString();
       // status = "edit";

        supportInvalidateOptionsMenu();
    }

}
