package com.kpvelocite2015.ijarak.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.kpvelocite2015.ijarak.R;

public class DataPelanggarActivity extends AppCompatActivity {

    private TextInputLayout layoutName, layoutNIK, layoutPlat;
    private EditText inputName, inputNIK, inputPlat;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_pelanggar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        layoutName = (TextInputLayout)findViewById(R.id.layout_name);
        layoutNIK = (TextInputLayout)findViewById(R.id.layout_nik);
        layoutPlat = (TextInputLayout)findViewById(R.id.layout_plat);

        inputName = (EditText)findViewById(R.id.name);
        inputNIK = (EditText)findViewById(R.id.nik);
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