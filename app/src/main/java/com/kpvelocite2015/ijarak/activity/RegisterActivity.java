package com.kpvelocite2015.ijarak.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.kpvelocite2015.ijarak.R;
import com.kpvelocite2015.ijarak.api.WebServiceHelper;
import com.kpvelocite2015.ijarak.model.Register;
import com.rey.material.widget.Button;
import com.rey.material.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by fadhilurrizki on 15/06/2015.
 */
public class RegisterActivity extends ActionBarActivity {

    private Button registerButton;

    private EditText enama, elokasi, enohp, epass, epass2;

    private String nama, lokasi, nohp, password, password2;

    private ProgressDialog pDialog;

    private static final String url = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        enama = (EditText) findViewById(R.id.nameET);
        elokasi = (EditText) findViewById(R.id.lokasiET);
        enohp = (EditText) findViewById(R.id.noHpET);
        epass = (EditText) findViewById(R.id.passwordET);
        epass2 = (EditText) findViewById(R.id.retypeET);

        registerButton = (Button) findViewById(R.id.registerButton);

        registerButton.setEnabled(false);
        registerButton.setClickable(false);

        epass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                enableButonIfReady();
            }
        });

        epass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    epass.setError(null);
                } else if (!hasFocus) {
                    if (!isValidPassword(epass.getText().toString())) {
                        epass.setError("Password is incorrect.");
                    } else if (isValidPassword(epass.getText().toString())) {
                        epass.setError(null);
                    }
                }
            }
        });

        elokasi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                enableButonIfReady();
            }
        });

        elokasi.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    elokasi.setError(null);
                } else if (!hasFocus) {
                    if (!isValidLokasi(elokasi.getText().toString())) {
                        elokasi.setError("Lokasi tidak boleh kosong.");
                    } else if (isValidEmail(elokasi.getText().toString())) {
                        elokasi.setError(null);
                    }
                }
            }
        });

        enama.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                enableButonIfReady();
            }
        });

        enama.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    enama.setError(null);
                } else if (!hasFocus) {
                    if (!isValidNama(enama.getText().toString())) {
                        enama.setError("Nama tidak boleh kosong.");
                    } else if (isValidEmail(enama.getText().toString())) {
                        enama.setError(null);
                    }
                }
            }
        });

        enohp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                enableButonIfReady();
            }
        });

        enohp.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    enohp.setError(null);
                } else if (!hasFocus) {
                    if (!isValidNoHp(enohp.getText().toString())) {
                        enohp.setError("Nomor Hp tidak boleh kosong.");
                    } else if (isValidNoHp(enohp.getText().toString())) {
                        enohp.setError(null);
                    }
                }
            }
        });

        epass2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                enableButonIfReady();
            }
        });

        epass2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    epass2.setError(null);
                } else if (!hasFocus) {
                    if (!isMatchPassword(epass.getText().toString(), epass2.getText().toString())) {
                        epass2.setError("");
                    } else if (isMatchPassword(epass.getText().toString(), epass2.getText().toString())) {
                        epass2.setError(null);
                    }
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(RegisterActivity.this);
                progressDialog.setTitle("Loading");
                progressDialog.setIndeterminate(false);
                progressDialog.setCancelable(true);
                progressDialog.show();
                if (isRegistrationDataValid()){
                    prosesRegistrasi(progressDialog);
                }
            }
        });
    }

    private void prosesRegistrasi(final ProgressDialog progressDialog) {
        WebServiceHelper.getInstance().getServices().createUser(nama, lokasi, nohp, password, password2, new retrofit.Callback<Register>() {

            @Override
            public void success(Register register, Response response) {
                if(register.getSuccess() == 1){
                    Toast.makeText(RegisterActivity.this, "Register berhasil. Silahkan lakukan login.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterActivity.this, "Email sudah terdaftar", Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(RegisterActivity.this, "Register gagal", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }

    private void enableButonIfReady() {

        nama = enama.getText().toString();
        lokasi = elokasi.getText().toString();
        nohp = enohp.getText().toString();
        password = epass.getText().toString();
        password2 = epass2.getText().toString();

        if (isValidNama(nama) && isValidPassword(password) && isValidLokasi(lokasi) && isValidNoHp(nohp) && isMatchPassword(password, password2)) {
            registerButton.setEnabled(true);
        } else {
            registerButton.setEnabled(false);
        }
    }

    private boolean isRegistrationDataValid() {
        nama = enama.getText().toString();
        lokasi = elokasi.getText().toString();
        password = epass.getText().toString();
        password2 = epass2.getText().toString();

        if (isValidPassword(password) && isValidLokasi(lokasi) && isMatchPassword(password, password2) && !nama.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // validating password with retype password
    private boolean isValidPassword(String pass) {
        return !pass.equals("") && pass.length() >= 6;
    }

    private boolean isValidNama(String nama) {
        return !nama.equals("");
    }

    private boolean isValidNoHp(String nohp) {
        return !nohp.equals("");
    }

    private boolean isValidLokasi(String lokasi) {
        return !lokasi.equals("");
    }

    private boolean isMatchPassword(String pass1, String pass2) {
        return pass1.equals(pass2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button_background, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button_background
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;

        }

        return super.onOptionsItemSelected(item);

    }

}
