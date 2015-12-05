package com.kpvelocite2015.ijarak.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.kpvelocite2015.ijarak.R;

public class BeritaActivity extends AppCompatActivity {

    private String judul, konten, tanggal;
    private int gambar;
    private TextView judulTV, kontenTV, tanggalTV;
    private ImageView gambarTV;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        judul = intent.getStringExtra("judul");
        konten = intent.getStringExtra("konten");
        tanggal = intent.getStringExtra("tanggal");
        gambar = intent.getIntExtra("gambar", 0);

        judulTV = (TextView) findViewById(R.id.judul);
        kontenTV = (TextView) findViewById(R.id.konten);
        tanggalTV = (TextView) findViewById(R.id.tanggal);
        gambarTV = (ImageView) findViewById(R.id.gambar);

        Typeface typefaceBold = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Bold.ttf");
        Typeface typefaceLight = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        Typeface typefaceMedium = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");

        judulTV.setTypeface(typefaceBold);
        tanggalTV.setTypeface(typefaceLight);

        judulTV.setText(judul);
        kontenTV.setText(konten);
        tanggalTV.setText(tanggal);
        gambarTV.setImageResource(gambar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_berita, menu);
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