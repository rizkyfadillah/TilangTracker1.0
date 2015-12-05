package com.kpvelocite2015.ijarak.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.kpvelocite2015.ijarak.R;
import com.kpvelocite2015.ijarak.SessionManager;


public class SplashActivity extends Activity {

    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sessionManager = new SessionManager(SplashActivity.this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sessionManager.checkLogin();
                finish();
            }
        }, 3000);
    }

}