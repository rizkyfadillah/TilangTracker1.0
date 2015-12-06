package com.kpvelocite2015.ijarak.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.kpvelocite2015.ijarak.DividerItemDecoration;
import com.kpvelocite2015.ijarak.PasalAdapter;
import com.kpvelocite2015.ijarak.R;
import com.kpvelocite2015.ijarak.RecyclerItemClickListener;
import com.kpvelocite2015.ijarak.VerticalSpaceItemDecoration;
import com.kpvelocite2015.ijarak.model.Pasal;

import java.util.ArrayList;

public class TilangActivity extends AppCompatActivity {

    ListView listView;
    String[] kota = {"Pasal 1", "Pasal 2", "Pasal 3", "Pasal 4", "Pasal 5", "Pasal 6", "Pasal 7", "Pasal 8", "Pasal 9", "Pasal 10"};
    //ArrayAdapter<String> adapter;

    RecyclerView recyclerView;

    ArrayList<Pasal> pasalList;

    private RecyclerView.Adapter mAdapter;

    private static final int VERTICAL_ITEM_SPACE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tilang);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pasalList = new ArrayList<Pasal>();

        Pasal pasal = new Pasal();
        pasal.setNomor("Pasal 278");
        pasal.setIsi("Tidak  dilengkapi dengan    perlengkapan   berupa  ban  cadangan,      segitiga pengaman,  dongkrak,  pembuka    roda,  dan   peralatan pertolongan pertama pada kecelakaan.");
        pasal.setObyekHukum("Pengendara roda dua atau lebih");
        pasal.setDenda(250000);
        pasalList.add(pasal);

        Pasal pasal2 = new Pasal();
        pasal2.setNomor("Pasal 279");
        pasal2.setIsi("Memasang perlengkapan yang dapat mengganggu keselamatan.");
        pasal2.setObyekHukum("Pengendara roda dua atau lebih");
        pasal2.setDenda(500000);
        pasalList.add(pasal2);

        Pasal pasal3 = new Pasal();
        pasal3.setNomor("Pasal 280");
        pasal3.setIsi("Tidak memasang Tanda Nomor Kendaraan Bermotor.");
        pasal3.setObyekHukum("Pengendara roda dua atau lebih");
        pasal3.setDenda(500000);
        pasalList.add(pasal3);

        Pasal pasal4 = new Pasal();
        pasal4.setNomor("Pasal 282");
        pasal4.setIsi("Tidak  mematuhi perintah yang diberikan oleh petugas Kepolisian.");
        pasal4.setObyekHukum("Pengendara roda dua atau lebih");
        pasal4.setDenda(250000);
        pasalList.add(pasal4);

        Pasal pasal5 = new Pasal();
        pasal5.setNomor("Pasal 281");
        pasal5.setIsi("Tidak  memiliki  Surat  Izin  Mengemudi.");
        pasal5.setObyekHukum("Pengendara roda dua atau lebih");
        pasal5.setDenda(1000000);
        pasalList.add(pasal5);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewPasal);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);

        mAdapter = new PasalAdapter(pasalList, this);

        //add ItemDecoration
        recyclerView.addItemDecoration(new VerticalSpaceItemDecoration(VERTICAL_ITEM_SPACE));
        //or
        recyclerView.addItemDecoration(new DividerItemDecoration(this));
        //or
        recyclerView.addItemDecoration(new DividerItemDecoration(this, R.drawable.divider));


        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent i = new Intent(TilangActivity.this, BeritaActivity.class);
                        //i.putExtra("judul", pasalList.get(position).getJudul());
                        //i.putExtra("konten", pasalList.get(position).getKonten());
                        //i.putExtra("tanggal", pasalList.get(position).getTanggal());
                        //i.putExtra("gambar", pasalList.get(position).getGambar());
                        //startActivity(i);
                    }
                })
        );

        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TilangActivity.this, DataActivity.class);
                startActivity(i);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String data = "";
                ArrayList<Pasal> pasalList = ((PasalAdapter) mAdapter)
                        .getPasalList();

                ArrayList<Pasal> pasalListSend = new ArrayList<Pasal>();

                for (int i = 0; i < pasalList.size(); i++) {
                    Pasal pasal = pasalList.get(i);
                    if (pasal.isSelected() == true) {
                        data = data + "\n" + pasal.getNomor().toString();
                        pasalListSend.add(pasal);
                    }

                }

                Intent intent = new Intent(TilangActivity.this, DataActivity.class);
                intent.putParcelableArrayListExtra("pasalList", pasalListSend);
                startActivity(intent);

            }
        });
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
