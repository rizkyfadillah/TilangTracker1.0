package com.kpvelocite2015.ijarak.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.kpvelocite2015.ijarak.BeritaAdapter;
import com.kpvelocite2015.ijarak.R;
import com.kpvelocite2015.ijarak.RecyclerItemClickListener;
import com.kpvelocite2015.ijarak.model.Berita;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListBeritaActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    List<Berita> beritaList;

    private FloatingActionButton mFAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Berita berita = new Berita();
        berita.setJudul("Mahkamah Agung menyarankan untuk menggunakan sistem tilang online");
        berita.setTanggal("5 Desember 2015");
        berita.setGambar(R.drawable.lt4fbd1073518ed);
        berita.setKonten("Ketua Mahkamah Agung (MA) M. Hatta Ali mengakui permasalahan pengelolaan atau perkara sidang tilang oleh pengadikan masih belum memiliki sistem yang baik. Hal ini disebabkan tidak sebandingnya jumlah hakim dan jumlah perkara tilang yang masuk ke setiap pengadilan negeri (PN). \n" +
                " \n" +
                "Karena itu, Hatta Ali mengusulkan proses pelanggaran perkara tilang sekaligus pembayaran denda tilang ditangani dan ditentukan pihak kepolisian secara online melalui bank. Hanya saja, kalau ada keberatan menyangkut jenis dan bentuk pelanggarannya, pelaku tilang dapat mengajukan permohonan ke PN setempat.     \n" +
                " \n" +
                "“Denda tilang bukan hakim yang menentukan, tetapi langsung pihak kepolisian yang menentukan jumlah dendanya. Kecuali, kalau ada keberatan karena pelaku tilang merasa tidak melanggar persyaratan mengemudi atau rambu-rambu lalu lintas bisa mengajukan ke PN,” ujar Hatta Ali di Jakarta, Kamis (28/11) kemarin. \n" +
                "       \n" +
                "Dia merasa meski sidang tilang selama ini di pengadilan sifatnya perkara sederhana dan cepat dengan hakim tunggal, tetapi sangat mengganggu proses persidangan perkara lain. Belum lagi, selama ini menjamurnya calo-calo perkara tilang yang bukan pegawai pengadilan.        \n" +
                " \n" +
                "“Sistem ini yang berlaku dan diterapkan di Belanda. Kalau sistem tilang di Indonesia menuju ke arah itu, enak betul, karena tidak mungkin ada ‘transaksi’ dan calo-calo tilang karena semua pembayaran tilang melalui bank,” kata dia.\n" +
                " \n" +
                "Dalam sebuah diskusi Rabu (25/11) kemarin, mantan Ketua MA Harifin A Tumpa juga mengatakan persoalan pengelolaan sidang tilang di PN masih bermasalah. Soalnya, perkara tilang yang diperiksa hakim tunggal tidak proporsional antara jumlah perkara tilang dengan jumlah hakim. \n" +
                " \n" +
                "Untuk itu, salah satunya dia mengusulkan agar pengelolaan perkara tilang dengan sistem online dengan mengubah Surat Ketetapan Bersama (SKB) Ketua MA, Menteri Kehakiman, Jaksa Agung, dan Kapolri tentang Tata Cara Penyelesaian Perkara Pelanggaran Lalu Lintas Jalan Tertentu tertanggal 19 Juni 1993. Sehingga perlu koordinasi antar institusi terkait perubahan sistem dan tata cara pengelolaan tilang.  \n" +
                "    \n" +
                "Sebelumnya, dalam penelitian di 13 PN, PSHK bersama Balitbang Diklat Kumdil MA menghasilkan solusi jangka panjang, jangka menengah, dan jangka pendek. Untuk solusi jangka panjang, Sholikin menyarankan agar perkara tilang ini dikeluarkan dari domain PN, sehingga, tidak semua perkara pelanggaran tilang diputus pengadilan. Untuk solusi jangka menengah perlu merevisi SKB.\n" +
                " \n" +
                "Sedangkan solusi jangka pendek, PSHK menyarankan agar MA mulai melakukan identifikasi praktik-praktik terbaik yang telah dilakukan di sejumlah PN untuk dijadikan model sebagai standar nasional. Sebab, dari 13 PN yang diteliti, terdapat inovasi-inovasi yang baik yang telah dilakukan oleh masing-masing PN. Sayangnya inovasi tersebut masih dilakukan secara parsial. \n" +
                " \n" +
                "Untuk diketahui, berdasarkan Laporan Tahunan MA Tahun 2014, perkara terbesar di pengadilan tingkat pertama berasal dari perkara pidana pelanggaran lalu lintas alias tilang yang berjumlah sebanyak 3.226.102 perkara (95,42%) dari total 3.334.226 perkara pidana. Sebagian besar masyarakat masih mengeluhkan pengelolaan sidang tilang, seperti keberadaan calo, suasana antrian yang kacau, dan fasilitas pendukung yang tidak memadai. ");

        beritaList = new ArrayList<Berita>();

        beritaList.add(berita);

        berita.setJudul("Mahkamah Agung menyarankan untuk menggunakan sistem tilang online");
        berita.setTanggal("5 Desember 2015");
        berita.setGambar(R.drawable.lt4fbd1073518ed);
        berita.setKonten("Ketua Mahkamah Agung (MA) M. Hatta Ali mengakui permasalahan pengelolaan atau perkara sidang tilang oleh pengadikan masih belum memiliki sistem yang baik. Hal ini disebabkan tidak sebandingnya jumlah hakim dan jumlah perkara tilang yang masuk ke setiap pengadilan negeri (PN). \n" +
                " \n" +
                "Karena itu, Hatta Ali mengusulkan proses pelanggaran perkara tilang sekaligus pembayaran denda tilang ditangani dan ditentukan pihak kepolisian secara online melalui bank. Hanya saja, kalau ada keberatan menyangkut jenis dan bentuk pelanggarannya, pelaku tilang dapat mengajukan permohonan ke PN setempat.     \n" +
                " \n" +
                "“Denda tilang bukan hakim yang menentukan, tetapi langsung pihak kepolisian yang menentukan jumlah dendanya. Kecuali, kalau ada keberatan karena pelaku tilang merasa tidak melanggar persyaratan mengemudi atau rambu-rambu lalu lintas bisa mengajukan ke PN,” ujar Hatta Ali di Jakarta, Kamis (28/11) kemarin. \n" +
                "       \n" +
                "Dia merasa meski sidang tilang selama ini di pengadilan sifatnya perkara sederhana dan cepat dengan hakim tunggal, tetapi sangat mengganggu proses persidangan perkara lain. Belum lagi, selama ini menjamurnya calo-calo perkara tilang yang bukan pegawai pengadilan.        \n" +
                " \n" +
                "“Sistem ini yang berlaku dan diterapkan di Belanda. Kalau sistem tilang di Indonesia menuju ke arah itu, enak betul, karena tidak mungkin ada ‘transaksi’ dan calo-calo tilang karena semua pembayaran tilang melalui bank,” kata dia.\n" +
                " \n" +
                "Dalam sebuah diskusi Rabu (25/11) kemarin, mantan Ketua MA Harifin A Tumpa juga mengatakan persoalan pengelolaan sidang tilang di PN masih bermasalah. Soalnya, perkara tilang yang diperiksa hakim tunggal tidak proporsional antara jumlah perkara tilang dengan jumlah hakim. \n" +
                " \n" +
                "Untuk itu, salah satunya dia mengusulkan agar pengelolaan perkara tilang dengan sistem online dengan mengubah Surat Ketetapan Bersama (SKB) Ketua MA, Menteri Kehakiman, Jaksa Agung, dan Kapolri tentang Tata Cara Penyelesaian Perkara Pelanggaran Lalu Lintas Jalan Tertentu tertanggal 19 Juni 1993. Sehingga perlu koordinasi antar institusi terkait perubahan sistem dan tata cara pengelolaan tilang.  \n" +
                "    \n" +
                "Sebelumnya, dalam penelitian di 13 PN, PSHK bersama Balitbang Diklat Kumdil MA menghasilkan solusi jangka panjang, jangka menengah, dan jangka pendek. Untuk solusi jangka panjang, Sholikin menyarankan agar perkara tilang ini dikeluarkan dari domain PN, sehingga, tidak semua perkara pelanggaran tilang diputus pengadilan. Untuk solusi jangka menengah perlu merevisi SKB.\n" +
                " \n" +
                "Sedangkan solusi jangka pendek, PSHK menyarankan agar MA mulai melakukan identifikasi praktik-praktik terbaik yang telah dilakukan di sejumlah PN untuk dijadikan model sebagai standar nasional. Sebab, dari 13 PN yang diteliti, terdapat inovasi-inovasi yang baik yang telah dilakukan oleh masing-masing PN. Sayangnya inovasi tersebut masih dilakukan secara parsial. \n" +
                " \n" +
                "Untuk diketahui, berdasarkan Laporan Tahunan MA Tahun 2014, perkara terbesar di pengadilan tingkat pertama berasal dari perkara pidana pelanggaran lalu lintas alias tilang yang berjumlah sebanyak 3.226.102 perkara (95,42%) dari total 3.334.226 perkara pidana. Sebagian besar masyarakat masih mengeluhkan pengelolaan sidang tilang, seperti keberadaan calo, suasana antrian yang kacau, dan fasilitas pendukung yang tidak memadai. ");

        beritaList.add(berita);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewBerita);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new BeritaAdapter(beritaList, this));
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent i = new Intent(ListBeritaActivity.this, BeritaActivity.class);
                        i.putExtra("judul", beritaList.get(position).getJudul());
                        i.putExtra("konten", beritaList.get(position).getKonten());
                        i.putExtra("tanggal", beritaList.get(position).getTanggal());
                        i.putExtra("gambar", beritaList.get(position).getGambar());
                        startActivity(i);
                    }
                })
        );

        setupFAB();

    }

    private void setupFAB() {

        //define the icon for the main floating action button_background
        ImageView iconFAB = new ImageView(this);
        iconFAB.setImageResource(R.drawable.ic_action_new);

        //set the appropriate background for the main floating action button_background along with its icon
        mFAB = new FloatingActionButton.Builder(this)
                .setContentView(iconFAB)
                .setBackgroundDrawable(R.drawable.selector_button_red)
                .build();

        mFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(HomeActivity.this, AddLaporanActivity.class);
                //startActivity(intent);
            }
        });

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
