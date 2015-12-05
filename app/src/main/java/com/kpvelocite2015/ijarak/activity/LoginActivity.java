package com.kpvelocite2015.ijarak.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kpvelocite2015.ijarak.R;
import com.kpvelocite2015.ijarak.SessionManager;
import com.kpvelocite2015.ijarak.api.WebServiceHelper;
import com.kpvelocite2015.ijarak.model.Login;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginActivity extends Activity {

    private EditText emailET;
    private EditText passwordET;
    private TextView forgotTV;
    private TextView createTV;
    private Button loginButton;

    private String emailInputan, passwordInputan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailET = (EditText) findViewById(R.id.emailLoginET);
        passwordET = (EditText) findViewById(R.id.passwordLoginET);
        forgotTV = (TextView) findViewById(R.id.forgotTV);
        createTV = (TextView) findViewById(R.id.createTV);
        loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailInputan = emailET.getText().toString();
                passwordInputan = passwordET.getText().toString();
                //new ProsesLogin(email, password).execute();
                /*
                ProgressDialog pDialog = new ProgressDialog(LoginActivity.this);
                pDialog.setMessage("Loading..");
                pDialog.setIndeterminate(false);
                pDialog.setCancelable(true);
                pDialog.show();
                */
                SessionManager sessionManager = new SessionManager(LoginActivity.this);
                sessionManager.createLoginSession(emailInputan, "10", "Rizky Fadillah");
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                //login(emailInputan, passwordInputan, pDialog);
            }
        });

        forgotTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

        createTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    private void login(final String emailInputan, final String passwordInputan, final ProgressDialog pDialog) {
        System.out.println(emailInputan);
        System.out.println(passwordInputan);
        WebServiceHelper.getInstance().getServices().login(emailInputan, passwordInputan, new Callback<Login>() {

            @Override
            public void success(Login login, Response response) {
                if (login.getSuccess() == 1) {
                    Toast.makeText(LoginActivity.this, "Login berhasil", Toast.LENGTH_SHORT).show();
                    SessionManager sessionManager = new SessionManager(LoginActivity.this);
                    sessionManager.createLoginSession(emailInputan, String.valueOf(login.getId()), login.getName());
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Email atau password yang anda masukkan salah", Toast.LENGTH_SHORT).show();
                }
                pDialog.dismiss();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(LoginActivity.this, "Login gagal. Silahkan coba beberapa saat lagi.", Toast.LENGTH_SHORT).show();
                pDialog.dismiss();
            }
        });
    }
}
