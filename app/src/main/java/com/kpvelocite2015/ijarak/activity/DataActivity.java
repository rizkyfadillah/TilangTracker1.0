package com.kpvelocite2015.ijarak.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.kpvelocite2015.ijarak.R;
import com.kpvelocite2015.ijarak.model.Pasal;

import java.util.ArrayList;

public class DataActivity extends AppCompatActivity {
    private EditText inputName, inputNIK, inputPlat;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        final ArrayList<Pasal> pasalList = i.getParcelableArrayListExtra("pasalList");

        inputName = (EditText)findViewById(R.id.name2);
        inputNIK = (EditText)findViewById(R.id.nik2);
        inputPlat = (EditText)findViewById(R.id.plat2);

        submit = (Button)findViewById(R.id.submit2);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DataActivity.this, DataPelanggarActivity.class);
                i.putExtra("nama", inputName.getText().toString());
                i.putExtra("nik", inputNIK.getText().toString());
                i.putExtra("plat", inputPlat.getText().toString());
                i.putParcelableArrayListExtra("pasalList", pasalList);
                startActivity(i);
            }
        });
    }
}
