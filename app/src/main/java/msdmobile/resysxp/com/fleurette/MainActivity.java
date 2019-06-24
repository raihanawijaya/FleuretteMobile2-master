package msdmobile.resysxp.com.fleurette;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import msdmobile.resysxp.com.fleurette.adapter.ViewPagerAdapter;
import msdmobile.resysxp.com.fleurette.fragment.BestArticleFragment;
import msdmobile.resysxp.com.fleurette.fragment.BestDiscCodeFragment;
import msdmobile.resysxp.com.fleurette.fragment.BestMotifFragment;
import msdmobile.resysxp.com.fleurette.fragment.BestNikCodeFragment;
import msdmobile.resysxp.com.fleurette.fragment.DailyFragment;
import msdmobile.resysxp.com.fleurette.fragment.DeliveryFragment;
import msdmobile.resysxp.com.fleurette.fragment.GuidanceFragment;
import msdmobile.resysxp.com.fleurette.fragment.ListDiscountFragment;
import msdmobile.resysxp.com.fleurette.fragment.ModelFragment;
import msdmobile.resysxp.com.fleurette.fragment.StockStoreFragment;
import msdmobile.resysxp.com.fleurette.fragment.TransactionFragment;
import msdmobile.resysxp.com.fleurette.model.DeleteUpdateTransactionResponse;
import msdmobile.resysxp.com.fleurette.model.GetViewDailyMTDTransactionStore;
import msdmobile.resysxp.com.fleurette.model.GetViewDailyMTDTransactionStoreResponse;
import msdmobile.resysxp.com.fleurette.model.LoginModel;
import msdmobile.resysxp.com.fleurette.services.RetrofitServices;
import msdmobile.resysxp.com.fleurette.utils.SharedPreference;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView tvNIKCode,tvNIKName, tvStoreCode, tvStoreName, tvMtdLyStatus,tvDate, tvTotalQty, tvTotalNett, tvMtdQty, tvMtdNett,tvMtdNettLy,tvFragmenthdr, tvMtdPlan,tvMtdAch,tvMtdStatus,tvMtdLyAch;
    private ImageButton imgBtnDelDate;
    private Button btnStockStore,btnAbsen,btnMutasi;
    private FloatingActionButton fabAdd, fabNext, fabPrev;
    private SharedPreference sharedPreference;
    private String nikCode,nikName, storeCode, storeName, date, dateView;
    private int y_id;
    private int m_id;
    private Calendar calendar;
    private SimpleDateFormat sdf, sdfView;
    private int dateInc = 0;
    private ProgressDialog addLoading;
    private ViewPagerAdapter viewPagerAdapter;
    private int viewPagerPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = Calendar.getInstance();
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdfView = new SimpleDateFormat("dd MMM yyyy");

        addLoading = new ProgressDialog(this);
        addLoading.setMessage("Log In . . .");
        addLoading.setCancelable(false);

        date = sdf.format(calendar.getTime());
        dateView = sdfView.format(calendar.getTime());

        y_id = calendar.get(Calendar.YEAR);
        m_id = calendar.get(Calendar.MONTH) + 1;

        sharedPreference = new SharedPreference(this);

        if (sharedPreference.checkIfDataExists("dataLogin")) {
            LoginModel loginModel = sharedPreference.getObjectData("dataLogin", LoginModel.class);
            nikCode = loginModel.getNIKCODE();
            nikName = loginModel.getNIKNAME();
            storeCode = loginModel.getSTORECODE();
            storeName = loginModel.getsTORENAME();
        }

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);
        tvNIKCode = findViewById(R.id.tv_nik_code);
        tvNIKName = findViewById(R.id.tv_nik_name);
        tvStoreCode = findViewById(R.id.tv_store_code);
        tvStoreName = findViewById(R.id.tv_store_name);
      //  imgBtnDelDate = findViewById(R.id.img_btn_del_date);
      //  btnStockStore = findViewById(R.id.btn_opname);
      //  btnAbsen = findViewById(R.id.btn_absen);
      //  btnMutasi = findViewById(R.id.btn_mutasi);
        tvFragmenthdr= findViewById(R.id.tv_fragment_hdr_1);
        tvDate = findViewById(R.id.tv_date);
        tvTotalQty = findViewById(R.id.tv_total_qty);
        tvTotalNett = findViewById(R.id.tv_total_nett);
        tvMtdQty = findViewById(R.id.tv_mtd_qty);
        tvMtdNett = findViewById(R.id.tv_mtd_nett);
        tvMtdNettLy = findViewById(R.id.tv_mtd_ly);
        tvMtdPlan = findViewById(R.id.tv_mtd_plan);
        tvMtdAch = findViewById(R.id.tv_mtd_ach);
        tvMtdLyAch = findViewById(R.id.tv_mtd_ly_ach);

        tvMtdStatus =findViewById(R.id.tv_mtd_status);
        tvMtdLyStatus =findViewById(R.id.tv_mtd_ly_status);
        fabAdd = findViewById(R.id.fab_add);
        fabNext = findViewById(R.id.fab_next_date);
        fabPrev = findViewById(R.id.fab_previous_date);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        tvNIKCode.setText(nikCode);
        tvNIKName.setText(nikName);
        tvStoreCode.setText(storeCode);
        tvStoreName.setText(storeName);
        tvDate.setText(dateView);

        setViewPager(viewPager);
        viewPagerPosition = viewPager.getCurrentItem();

        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                viewPagerPosition = position;

                fabAdd.setVisibility(View.INVISIBLE);
                Fragment fragment = viewPagerAdapter.getItem(position);
                if (fragment instanceof TransactionFragment) {
                    TransactionFragment transactionFragment = (TransactionFragment) fragment;
                    transactionFragment.setStoreCode(storeCode);
                    transactionFragment.setDate(date);
                    transactionFragment.setY_id(String.valueOf(y_id));
                    transactionFragment.setM_id(String.valueOf(m_id));
                    transactionFragment.onRefresh();
                    tvFragmenthdr.setText("  Article                   Disc     Qty           Gross          Nett");
                    fabAdd.setVisibility(View.VISIBLE);
                } else if (fragment instanceof BestDiscCodeFragment) {
                    BestDiscCodeFragment BestDiscCodeFragment = (BestDiscCodeFragment) fragment;
                    BestDiscCodeFragment.setStoreCode(storeCode);
                    BestDiscCodeFragment.setDate(date);
                    BestDiscCodeFragment.onRefresh();
                    tvFragmenthdr.setText("  Disc Code                 Qty         Nett             Avg");
                } else if (fragment instanceof BestNikCodeFragment) {
                    BestNikCodeFragment BestNikCodeFragment = (BestNikCodeFragment) fragment;
                    BestNikCodeFragment.setStoreCode(storeCode);
                    BestNikCodeFragment.setDate(date);
                    BestNikCodeFragment.onRefresh();
                    tvFragmenthdr.setText("  Nik Code                                           Qty           Nett");
                } else if (fragment instanceof DailyFragment) {
                    DailyFragment dailyFragment = (DailyFragment) fragment;
                    dailyFragment.setStoreCode(storeCode);
                    dailyFragment.setyCode(String.valueOf(y_id));
                    dailyFragment.setmCode(String.valueOf(m_id));
                    dailyFragment.onRefresh();
                    tvFragmenthdr.setText("  Trx Date             Qty                  Nett                  AvgPrice");
                } else if (fragment instanceof GuidanceFragment) {
                    GuidanceFragment GuidanceFragment = (msdmobile.resysxp.com.fleurette.fragment.GuidanceFragment) fragment;
                    GuidanceFragment.setStoreCode(storeCode);
                    GuidanceFragment.setDate(date);
                    GuidanceFragment.onRefresh();
                    tvFragmenthdr.setText("  User Guide :");
                } else if (fragment instanceof ModelFragment) {
                    ModelFragment ModelFragment = (msdmobile.resysxp.com.fleurette.fragment.ModelFragment) fragment;
                    ModelFragment.setStoreCode(storeCode);
                    ModelFragment.setDate(date);
                    ModelFragment.onRefresh();
                    tvFragmenthdr.setText("  Model                                  Qty                         Nett");
                } else if (fragment instanceof BestArticleFragment) {
                    BestArticleFragment BestArticleFragment = (msdmobile.resysxp.com.fleurette.fragment.BestArticleFragment) fragment;
                    BestArticleFragment.setStoreCode(storeCode);
                    BestArticleFragment.setDate(date);
                    BestArticleFragment.onRefresh();
                    tvFragmenthdr.setText("     Article                     Qty         Nett         Avg");
                } else if (fragment instanceof BestMotifFragment) {
                    BestMotifFragment BestMotifFragment = (BestMotifFragment) fragment;
                    BestMotifFragment.setStoreCode(storeCode);
                    BestMotifFragment.setDate(date);
                    BestMotifFragment.onRefresh();
                    tvFragmenthdr.setText("  Motif                                       Qty         Nett             Avg");
                } else if (fragment instanceof StockStoreFragment) {
                    StockStoreFragment StockStoreFragment = (msdmobile.resysxp.com.fleurette.fragment.StockStoreFragment) fragment;
                    StockStoreFragment.setStoreCode(storeCode);
                    StockStoreFragment.setDate(date);
                    StockStoreFragment.onRefresh();
                   tvFragmenthdr.setText("  Information                                                                 Qty");
                }  else if (fragment instanceof DeliveryFragment) {
                    DeliveryFragment DeliveryFragment = (msdmobile.resysxp.com.fleurette.fragment.DeliveryFragment) fragment;
                    DeliveryFragment.setStoreCode(storeCode);
                    DeliveryFragment.setDate(date);
                    DeliveryFragment.onRefresh();
                    tvFragmenthdr.setText("  TrxNo                   Category                 Date                Qty");
                } else if (fragment instanceof ListDiscountFragment) {
                    ListDiscountFragment ListDiscountFragment = (msdmobile.resysxp.com.fleurette.fragment.ListDiscountFragment) fragment;
                    ListDiscountFragment.setStoreCode(storeCode);
                    ListDiscountFragment.onRefresh();
                    tvFragmenthdr.setText("  Disc Code          Disc Pct              Use Price           Price");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        MainActivity.this,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });

     /*   imgBtnDelDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // deleteDateTransaction(storeCode, date);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Hapus Data ?")
                        .setMessage("Hapus Data Transaksi di Tanggal Tersebut ?")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                deleteDateTransaction(storeCode, date);
                            }
                        })
                        .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .show();;
            }
        });*/



        fabPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DEBUG ", "onClick(-): "+dateInc);
//                dateInc--;
                Calendar prevDate = calendar;
                //prevDate.setTime(calendar.getTime());
                prevDate.add(Calendar.DAY_OF_YEAR, -1);

                calendar.setTime(prevDate.getTime());
                date = sdf.format(calendar.getTime());
                dateView = sdfView.format(calendar.getTime());

                y_id = calendar.get(Calendar.YEAR);
                m_id = calendar.get(Calendar.MONTH) + 1;

                Log.d("MainDate", "onClick: " + y_id + " " + m_id);

                tvDate.setText(dateView);

                GetViewDailyMTDTransaction(date, storeCode);

                Fragment fragment = viewPagerAdapter.getItem(viewPagerPosition);
                if (fragment instanceof TransactionFragment) {
                    TransactionFragment transactionFragment = (TransactionFragment) fragment;
                    transactionFragment.setStoreCode(storeCode);
                    transactionFragment.setDate(date);
                    transactionFragment.setY_id(String.valueOf(y_id));
                    transactionFragment.setM_id(String.valueOf(m_id));
                    transactionFragment.onRefresh();
                } else if (fragment instanceof BestDiscCodeFragment) {
                    BestDiscCodeFragment BestDiscCodeFragment = (BestDiscCodeFragment) fragment;
                    BestDiscCodeFragment.setStoreCode(storeCode);
                    BestDiscCodeFragment.setDate(date);
                    BestDiscCodeFragment.onRefresh();
                }else if (fragment instanceof BestNikCodeFragment) {
                    BestNikCodeFragment BestNikCodeFragment = (BestNikCodeFragment) fragment;
                    BestNikCodeFragment.setStoreCode(storeCode);
                    BestNikCodeFragment.setDate(date);
                    BestNikCodeFragment.onRefresh();
                 } else if (fragment instanceof DailyFragment) {
                    DailyFragment dailyFragment = (DailyFragment) fragment;
                    dailyFragment.setStoreCode(storeCode);
                    dailyFragment.setyCode(String.valueOf(y_id));
                    dailyFragment.setmCode(String.valueOf(m_id));
                    dailyFragment.onRefresh();
                }else if (fragment instanceof GuidanceFragment) {
                    GuidanceFragment GuidanceFragment = (msdmobile.resysxp.com.fleurette.fragment.GuidanceFragment) fragment;
                    GuidanceFragment.setStoreCode(storeCode);
                    GuidanceFragment.setDate(date);
                    GuidanceFragment.onRefresh();
                }else if (fragment instanceof ModelFragment) {
                    ModelFragment ModelFragment = (msdmobile.resysxp.com.fleurette.fragment.ModelFragment) fragment;
                    ModelFragment.setStoreCode(storeCode);
                    ModelFragment.setDate(date);
                    ModelFragment.onRefresh();
                }else if (fragment instanceof BestArticleFragment) {
                    BestArticleFragment BestArticleFragment = (msdmobile.resysxp.com.fleurette.fragment.BestArticleFragment) fragment;
                    BestArticleFragment.setStoreCode(storeCode);
                    BestArticleFragment.setDate(date);
                    BestArticleFragment.onRefresh();
                } else if (fragment instanceof BestMotifFragment) {
                    BestMotifFragment BestMotifFragment = (BestMotifFragment) fragment;
                    BestMotifFragment.setStoreCode(storeCode);
                    BestMotifFragment.setDate(date);
                    BestMotifFragment.onRefresh();
                } else if (fragment instanceof StockStoreFragment) {
                    StockStoreFragment StockStoreFragment = (msdmobile.resysxp.com.fleurette.fragment.StockStoreFragment) fragment;
                    StockStoreFragment.setStoreCode(storeCode);
                    StockStoreFragment.setDate(date);
                    StockStoreFragment.onRefresh();
                }else if (fragment instanceof DeliveryFragment) {
                    DeliveryFragment DeliveryFragment = (msdmobile.resysxp.com.fleurette.fragment.DeliveryFragment) fragment;
                    DeliveryFragment.setStoreCode(storeCode);
                    DeliveryFragment.setDate(date);
                    DeliveryFragment.onRefresh();
                } else if (fragment instanceof ListDiscountFragment) {
                    ListDiscountFragment ListDiscountFragment = (msdmobile.resysxp.com.fleurette.fragment.ListDiscountFragment) fragment;
                    ListDiscountFragment.setStoreCode(storeCode);
                    ListDiscountFragment.onRefresh();
                }
            }
        });

        //------------------------------------------------------------------------------------
        fabNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DEBUG ", "onClick(+): " + dateInc);
//                dateInc++;
                Calendar nextDate = calendar;
                //nextDate.setTime(calendar.getTime());
                nextDate.add(Calendar.DAY_OF_YEAR, 1);

                calendar.setTime(nextDate.getTime());

                date = sdf.format(calendar.getTime());
                dateView = sdfView.format(calendar.getTime());

                y_id = calendar.get(Calendar.YEAR);
                m_id = calendar.get(Calendar.MONTH) + 1;

                Log.d("MainDate", "onClick: " + y_id + " " + m_id);

                tvDate.setText(dateView);

                GetViewDailyMTDTransaction(date, storeCode);

                Fragment fragment = viewPagerAdapter.getItem(viewPagerPosition);
                if (fragment instanceof TransactionFragment) {
                    TransactionFragment transactionFragment = (TransactionFragment) fragment;
                    transactionFragment.setStoreCode(storeCode);
                    transactionFragment.setDate(date);
                    transactionFragment.setY_id(String.valueOf(y_id));
                    transactionFragment.setM_id(String.valueOf(m_id));
                    transactionFragment.onRefresh();
                } else if (fragment instanceof BestDiscCodeFragment) {
                    BestDiscCodeFragment BestDiscCodeFragment = (BestDiscCodeFragment) fragment;
                    BestDiscCodeFragment.setStoreCode(storeCode);
                    BestDiscCodeFragment.setDate(date);
                    BestDiscCodeFragment.onRefresh();
                }else if (fragment instanceof BestNikCodeFragment) {
                    BestNikCodeFragment BestNikCodeFragment = (BestNikCodeFragment) fragment;
                    BestNikCodeFragment.setStoreCode(storeCode);
                    BestNikCodeFragment.setDate(date);
                    BestNikCodeFragment.onRefresh();
                 } else if (fragment instanceof DailyFragment) {
                    DailyFragment dailyFragment = (DailyFragment) fragment;
                    dailyFragment.setStoreCode(storeCode);
                    dailyFragment.setyCode(String.valueOf(y_id));
                    dailyFragment.setmCode(String.valueOf(m_id));
                    dailyFragment.onRefresh();
                } else if (fragment instanceof GuidanceFragment) {
                    GuidanceFragment GuidanceFragment = (msdmobile.resysxp.com.fleurette.fragment.GuidanceFragment) fragment;
                    GuidanceFragment.setStoreCode(storeCode);
                    GuidanceFragment.setDate(date);
                    GuidanceFragment.onRefresh();
                } else if (fragment instanceof ModelFragment) {
                    ModelFragment ModelFragment = (msdmobile.resysxp.com.fleurette.fragment.ModelFragment) fragment;
                    ModelFragment.setStoreCode(storeCode);
                    ModelFragment.setDate(date);
                    ModelFragment.onRefresh();
                }else if (fragment instanceof BestArticleFragment) {
                    BestArticleFragment BestArticleFragment = (msdmobile.resysxp.com.fleurette.fragment.BestArticleFragment) fragment;
                    BestArticleFragment.setStoreCode(storeCode);
                    BestArticleFragment.setDate(date);
                    BestArticleFragment.onRefresh();
                } else if (fragment instanceof BestMotifFragment) {
                    BestMotifFragment BestMotifFragment = (BestMotifFragment) fragment;
                    BestMotifFragment.setStoreCode(storeCode);
                    BestMotifFragment.setDate(date);
                    BestMotifFragment.onRefresh();
                } else if (fragment instanceof StockStoreFragment) {
                    StockStoreFragment StockStoreFragment = (msdmobile.resysxp.com.fleurette.fragment.StockStoreFragment) fragment;
                    StockStoreFragment.setStoreCode(storeCode);
                    StockStoreFragment.setDate(date);
                    StockStoreFragment.onRefresh();
                }else if (fragment instanceof DeliveryFragment) {
                    DeliveryFragment DeliveryFragment = (msdmobile.resysxp.com.fleurette.fragment.DeliveryFragment) fragment;
                    DeliveryFragment.setStoreCode(storeCode);
                    DeliveryFragment.setDate(date);
                    DeliveryFragment.onRefresh();
                } else if (fragment instanceof ListDiscountFragment) {
                    ListDiscountFragment ListDiscountFragment = (msdmobile.resysxp.com.fleurette.fragment.ListDiscountFragment) fragment;
                    ListDiscountFragment.setStoreCode(storeCode);
                    ListDiscountFragment.onRefresh();
                }

            }
        });

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddDataActivity.class);
                i.putExtra("status", "add");
                i.putExtra("date", dateView);
                startActivity(i);
            }
        });

    }

    private void setViewPager(ViewPager viewPager) {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        DailyFragment DailyFragment = new DailyFragment();
        DailyFragment.setStoreCode(storeCode);
        DailyFragment.setyCode(String.valueOf(y_id));
        DailyFragment.setmCode(String.valueOf(m_id));
        tvFragmenthdr.setText("  Trx Date             Qty                Nett                  AvgPrice");
        viewPagerAdapter.addFragment(DailyFragment, "Daily");
        viewPagerAdapter.addFragment(new TransactionFragment(), "Transaction");
        viewPagerAdapter.addFragment(new BestNikCodeFragment(),"Best Nik");
        viewPagerAdapter.addFragment(new BestDiscCodeFragment(), "Best Disc");
        viewPagerAdapter.addFragment(new BestArticleFragment(),"Best Art");
        viewPagerAdapter.addFragment(new BestMotifFragment(),"Best Motif");
        viewPagerAdapter.addFragment(new DeliveryFragment(),"Rec Trf");
        viewPagerAdapter.addFragment(new DeliveryFragment(),"Rec Ret");
        viewPagerAdapter.addFragment(new DeliveryFragment(),"Ret Trf");
        viewPagerAdapter.addFragment(new StockStoreFragment(),"Stock Qty");
        viewPagerAdapter.addFragment(new GuidanceFragment(),"Help ?");
        viewPagerAdapter.addFragment(new ListDiscountFragment(),"List Disc");

        viewPager.setAdapter(viewPagerAdapter);
    }
    @Override
    protected void onResume() {
        super.onResume();
        GetViewDailyMTDTransaction(date, storeCode);

/*     Fragment fragment = viewPagerAdapter.getItem(viewPagerPosition);
        if (fragment instanceof TransactionFragment) {
            TransactionFragment transactionFragment = (TransactionFragment) fragment;
            transactionFragment.setStoreCode(storeCode);
            transactionFragment.setDate(date);
            transactionFragment.setY_id(String.valueOf(y_id));
            transactionFragment.setM_id(String.valueOf(m_id));
            transactionFragment.onRefresh();
        }else if (fragment instanceof DailyFragment) {
            DailyFragment dailyFragment = (DailyFragment) fragment;
            dailyFragment.setStoreCode(storeCode);
            dailyFragment.setyCode(String.valueOf(y_id));
            dailyFragment.setmCode(String.valueOf(m_id));
            dailyFragment.onRefresh();
        }*/
  }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_logout:
                logout();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        dateInc = 0;
        String month;
        if ((monthOfYear + 1) < 10) {
            month = "0" + (monthOfYear + 1);
        } else {
            month = String.valueOf(monthOfYear + 1);
        }

        date = year + "-" + month + "-" + dayOfMonth;
        try {
            Date dt = sdf.parse(date);
            calendar.setTime(dt);
            dateView = sdfView.format(dt);
        } catch (Exception e) {
            e.printStackTrace();
        }

        y_id = year;
        m_id = monthOfYear + 1;

        tvDate.setText(dateView);

        // line code dibawah ini untuk merefresh data mtd
        GetViewDailyMTDTransaction(date, storeCode);

        Fragment fragment = viewPagerAdapter.getItem(viewPagerPosition);
        if (fragment instanceof TransactionFragment) {
            TransactionFragment transactionFragment = (TransactionFragment) fragment;
            transactionFragment.setStoreCode(storeCode);
            transactionFragment.setDate(date);
            transactionFragment.setY_id(String.valueOf(y_id));
            transactionFragment.setM_id(String.valueOf(m_id));
            transactionFragment.onRefresh();
        } else if (fragment instanceof BestDiscCodeFragment) {
            BestDiscCodeFragment BestDiscCodeFragment = (BestDiscCodeFragment) fragment;
            BestDiscCodeFragment.setStoreCode(storeCode);
            BestDiscCodeFragment.setDate(date);
            BestDiscCodeFragment.onRefresh();
        } else if (fragment instanceof BestNikCodeFragment) {
            BestNikCodeFragment BestNikCodeFragment = (BestNikCodeFragment) fragment;
            BestNikCodeFragment.setStoreCode(storeCode);
            BestNikCodeFragment.setDate(date);
            BestNikCodeFragment.onRefresh();
         }else if (fragment instanceof DailyFragment) {
            DailyFragment dailyFragment = (DailyFragment) fragment;
            dailyFragment.setStoreCode(storeCode);
            dailyFragment.setyCode(String.valueOf(y_id));
            dailyFragment.setmCode(String.valueOf(m_id));
            dailyFragment.onRefresh();
        } else if (fragment instanceof GuidanceFragment) {
            GuidanceFragment GuidanceFragment = (GuidanceFragment) fragment;
            GuidanceFragment.setStoreCode(storeCode);
            GuidanceFragment.setDate(date);
            GuidanceFragment.onRefresh();
        } else if (fragment instanceof ModelFragment) {
            ModelFragment ModelFragment = (ModelFragment) fragment;
            ModelFragment.setStoreCode(storeCode);
            ModelFragment.setDate(date);
            ModelFragment.onRefresh();
        } else if (fragment instanceof BestArticleFragment) {
            BestArticleFragment BestArticleFragment = (BestArticleFragment) fragment;
            BestArticleFragment.setStoreCode(storeCode);
            BestArticleFragment.setDate(date);
            BestArticleFragment.onRefresh();
        } else if (fragment instanceof BestMotifFragment) {
            BestMotifFragment BestMotifFragment = (BestMotifFragment) fragment;
            BestMotifFragment.setStoreCode(storeCode);
            BestMotifFragment.setDate(date);
            BestMotifFragment.onRefresh();
        } else if (fragment instanceof StockStoreFragment) {
            StockStoreFragment StockStoreFragment = (StockStoreFragment) fragment;
            StockStoreFragment.setStoreCode(storeCode);
            StockStoreFragment.setDate(date);
            StockStoreFragment.onRefresh();
        }else if (fragment instanceof DeliveryFragment) {
            DeliveryFragment DeliveryFragment = (DeliveryFragment) fragment;
            DeliveryFragment.setStoreCode(storeCode);
            DeliveryFragment.setDate(date);
            DeliveryFragment.onRefresh();
        }else if (fragment instanceof ListDiscountFragment) {
            ListDiscountFragment ListDiscountFragment = (ListDiscountFragment) fragment;
            ListDiscountFragment.setStoreCode(storeCode);
            ListDiscountFragment.onRefresh();
        }
    }

    private void logout() {
        sharedPreference.clearAllData();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    private void GetViewDailyMTDTransaction (String trxdate, String storeCode){
        Call<GetViewDailyMTDTransactionStoreResponse> call = RetrofitServices.sendDataRequest().getViewDailyMTDTransactionStore(trxdate, storeCode);
        if (call != null) call.enqueue(new Callback<GetViewDailyMTDTransactionStoreResponse>() {
            @Override
            public void onResponse(Call<GetViewDailyMTDTransactionStoreResponse> call, Response<GetViewDailyMTDTransactionStoreResponse> response) {
                if (response.isSuccessful()) {
                    Locale localeID = new Locale("in", "ID");
                    NumberFormat numberFormatCurrency = NumberFormat.getCurrencyInstance(localeID);
                    numberFormatCurrency.setMaximumFractionDigits(0);
                    DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) numberFormatCurrency).getDecimalFormatSymbols();
                    decimalFormatSymbols.setCurrencySymbol("");
                    ((DecimalFormat) numberFormatCurrency).setDecimalFormatSymbols(decimalFormatSymbols);
                    Float mtdAchPct,mtdLyAchPct;
                    //oast.makeText(getApplicationContext(), "Lanjut ok", Toast.LENGTH_SHORT).show();

                    GetViewDailyMTDTransactionStore data = response.body().getDataTransaction();

                    if (data != null) {
                        tvTotalQty.setText(numberFormatCurrency.format(Integer.parseInt(data.getQTY())));
                        tvTotalNett.setText(numberFormatCurrency.format(Integer.parseInt(data.getNETT())));
                        tvMtdQty.setText(numberFormatCurrency.format(Integer.parseInt(data.getMTDQTY())));
                        tvMtdNett.setText(numberFormatCurrency.format(Integer.parseInt(data.getMTDNETT())));
                        tvMtdPlan.setText(numberFormatCurrency.format(Integer.parseInt(data.getMTDPLAN())));
                        tvMtdNettLy.setText(numberFormatCurrency.format(Integer.parseInt(data.getMTDNETTLY())));

                        mtdAchPct = Float.parseFloat(data.getMTDNETT())*100/Float.parseFloat(data.getMTDPLAN());
                        mtdLyAchPct = Float.parseFloat(data.getMTDNETT())*100/Float.parseFloat(data.getMTDNETTLY());

                        tvMtdAch.setText(numberFormatCurrency.format(Float.parseFloat(mtdAchPct.toString()))+" %");
                        tvMtdLyAch.setText(numberFormatCurrency.format(Float.parseFloat(mtdLyAchPct.toString()))+" %");

                        if (mtdAchPct < 100) {
                            tvMtdStatus.setText("(Under)");
                            tvMtdAch.setTextColor(Color.RED);
                            tvMtdStatus.setTextColor(Color.RED);
                        }
                        else    {
                            tvMtdStatus.setText("Over");
                            tvMtdAch.setTextColor(Color.WHITE);
                            tvMtdStatus.setTextColor(Color.WHITE);
                        }

                        if (mtdLyAchPct < 100) {
                            tvMtdLyStatus.setText("(Under)");
                            tvMtdLyAch.setTextColor(Color.RED);
                            tvMtdLyStatus.setTextColor(Color.RED);
                        }
                        else    {
                            tvMtdLyStatus.setText("Over");
                            tvMtdLyAch.setTextColor(Color.WHITE);
                            tvMtdLyStatus.setTextColor(Color.WHITE);
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "DATA NOT FOUND !", Toast.LENGTH_SHORT).show();
                        tvTotalQty.setText("0");
                        tvTotalNett.setText("0");
                        tvMtdQty.setText("0");
                        tvMtdNett.setText("0");
                        tvMtdPlan.setText("0");
                        tvMtdNettLy.setText("0");
                    }

                }
            }

            @Override
            public void onFailure(Call<GetViewDailyMTDTransactionStoreResponse> call, Throwable t) {

            }
        });
        else {
            tvTotalQty.setText("XXX");
            tvTotalNett.setText("XXX");
            }
    }


    private void deleteDateTransaction(final String storeCode, String trx_date) {
        try {
            Call<DeleteUpdateTransactionResponse> call = RetrofitServices.sendDataRequest().DeleteDateTransaction(storeCode, trx_date);
            call.enqueue(new Callback<DeleteUpdateTransactionResponse>() {
                @Override
                public void onResponse(Call<DeleteUpdateTransactionResponse> call, Response<DeleteUpdateTransactionResponse> response) {
                    if (response.isSuccessful()) {
                        boolean error = response.body().getError();
                        String msg = response.body().getMsg();
                        if (!error) {
                            //getDataMtdTransaction(storeCode, date, String.valueOf(y_id), String.valueOf(m_id));
                            Fragment fragment = viewPagerAdapter.getItem(viewPagerPosition);
                            if (fragment instanceof TransactionFragment) {
                                TransactionFragment transactionFragment = (TransactionFragment) fragment;
                                transactionFragment.setStoreCode(storeCode);
                                transactionFragment.setDate(date);
                                transactionFragment.setY_id(String.valueOf(y_id));
                                transactionFragment.setM_id(String.valueOf(m_id));
                                transactionFragment.onRefresh();
                            }
                        }

                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<DeleteUpdateTransactionResponse> call, Throwable t) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

