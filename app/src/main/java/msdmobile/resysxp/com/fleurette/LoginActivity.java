package msdmobile.resysxp.com.fleurette;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import msdmobile.resysxp.com.fleurette.model.LoginModel;
import msdmobile.resysxp.com.fleurette.model.LoginResponses;
import msdmobile.resysxp.com.fleurette.services.RetrofitServices;
import msdmobile.resysxp.com.fleurette.utils.SharedPreference;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText etNIKCode, etPassword,etStoreCode;
    private TextView etVersion;
    private Button btnMasuk;

    private SharedPreference sharedPreference;

    private ProgressDialog loginLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MODE_CHANGED);
       //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
       // input.setRawInputType(Configuration.KEYBOARD_12KEY);
        loginLoading = new ProgressDialog(this);
        loginLoading.setMessage("Log In . . .");
        loginLoading.setCancelable(false);

        sharedPreference = new SharedPreference(this);

        if (sharedPreference.isLoggedIn()) {
            //startActivity(new Intent(this, MainActivity.class));
            //finish();
        }

        etNIKCode = findViewById(R.id.et_nik_code);
        etPassword = findViewById(R.id.et_password);
        etStoreCode = findViewById(R.id.et_store_code);
        etVersion = findViewById(R.id.et_version);



        btnMasuk = findViewById(R.id.btn_masuk);

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String NIKCode = etNIKCode.getText().toString();
                String password = etPassword.getText().toString();
                String storecode = etStoreCode.getText().toString();
                String version = etVersion.getText().toString();

                if (isInputValid(NIKCode, password,storecode)) {
                    GetLoginVersion(NIKCode, password,storecode,version);
                }
            }
        });
    }

    private boolean isInputValid(String NIKCode, String password ,String storecode) {
        if (TextUtils.isEmpty(NIKCode) || TextUtils.isEmpty(password)  || TextUtils.isEmpty(storecode)) {
            if (TextUtils.isEmpty(NIKCode)) {
                etNIKCode.setError("Masukkan nik code!");
            }

            if (TextUtils.isEmpty(password)) {
                etPassword.setError("Masukkan password!");
            }

            if (TextUtils.isEmpty(storecode)) {
                etStoreCode.setError("Masukkan Store Code!");
            }
            return false;
        }

        return true;
    }

    private void GetLoginVersion(final String NIKCode, String password, String storecode,String version) {
        loginLoading.show();
        try {
            Call<LoginResponses> call = RetrofitServices.sendDataRequest().GetLoginVersion(NIKCode, password,storecode, version);
            call.enqueue(new Callback<LoginResponses>() {
                @Override
                public void onResponse(Call<LoginResponses> call, Response<LoginResponses> response) {
                    loginLoading.dismiss();
                    if (response.isSuccessful()) {
                        boolean error = response.body().getError();
                        String msg = response.body().getMsg();

                        if (!error) {
                            LoginModel loginModel = response.body().getDataLogin();
                            sharedPreference.storeData("dataLogin", loginModel);
                            Toast.makeText(getApplicationContext(), "Welcome " + NIKCode + " To Mobile System " , Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        } else {
                            Toast toast = Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 90);
                            toast.show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Login Failed , Try Again !", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponses> call, Throwable t) {
                    loginLoading.dismiss();
                    Log.d("error", "onFailure: " + t.getMessage());
                    Toast toast = Toast.makeText(getApplicationContext(), "Error Occured When Login Process...!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();


                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
