package com.kpvelocite2015.ijarak.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.kpvelocite2015.ijarak.R;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ImageButton tilangButton = (ImageButton)findViewById(R.id.tilangButton);
        ImageButton beritaButton = (ImageButton)findViewById(R.id.beritaButton);
        ImageButton peraturanButton = (ImageButton)findViewById(R.id.peraturanButton);
        ImageButton informasiButton = (ImageButton)findViewById(R.id.informasiButton);

        TextView tilangTV = (TextView) findViewById(R.id.tilangTV);
        TextView beritaTV = (TextView) findViewById(R.id.beritaTV);
        TextView peraturanTV = (TextView) findViewById(R.id.peraturanTV);
        TextView informasiTV = (TextView) findViewById(R.id.informasiTV);

        Typeface typefaceBold = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Bold.ttf");
        Typeface typefaceLight = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        Typeface typefaceMedium = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");

        tilangTV.setTypeface(typefaceLight);
        beritaTV.setTypeface(typefaceLight);
        peraturanTV.setTypeface(typefaceLight);
        informasiTV.setTypeface(typefaceLight);

        tilangButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, TilangActivity.class);
                startActivity(i);
            }
        });

        beritaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, ListBeritaActivity.class);
                startActivity(i);
            }
        });

        peraturanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent i = new Intent(HomeActivity.this, Tilang.class);
                //startActivity(i);
            }
        });

        informasiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, InformasiActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {

        } else if (id == R.id.tilang) {
            Intent i = new Intent(HomeActivity.this, TilangActivity.class);
            startActivity(i);

        } else if (id == R.id.berita) {
            Intent i = new Intent(HomeActivity.this, ListBeritaActivity.class);
            startActivity(i);

        } else if (id == R.id.peraturan) {

        } else if (id == R.id.informasi) {
            Intent i = new Intent(HomeActivity.this, InformasiActivity.class);
            startActivity(i);

        } else if (id == R.id.logout) {
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}