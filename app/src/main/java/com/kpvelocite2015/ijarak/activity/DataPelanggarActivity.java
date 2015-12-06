package com.kpvelocite2015.ijarak.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.kpvelocite2015.ijarak.DividerItemDecoration;
import com.kpvelocite2015.ijarak.Pasal2Adapter;
import com.kpvelocite2015.ijarak.R;
import com.kpvelocite2015.ijarak.VerticalSpaceItemDecoration;
import com.kpvelocite2015.ijarak.model.Pasal;

import java.util.ArrayList;

public class DataPelanggarActivity extends AppCompatActivity {

    private TextInputLayout layoutName, layoutNIK, layoutPlat;
    private EditText inputName, inputNIK, inputPlat;
    private Button submit;

    RecyclerView recyclerView;

    private RecyclerView.Adapter mAdapter;

    private static final int VERTICAL_ITEM_SPACE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_pelanggar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        ArrayList<Pasal> pasalList = intent.getParcelableArrayListExtra("pasalList");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewPasal2);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        mAdapter = new Pasal2Adapter(pasalList, this);

        //add ItemDecoration
        recyclerView.addItemDecoration(new VerticalSpaceItemDecoration(VERTICAL_ITEM_SPACE));
        //or
        recyclerView.addItemDecoration(
                new DividerItemDecoration(this));
        //or
        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, R.drawable.divider));

        recyclerView.setAdapter(mAdapter);

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