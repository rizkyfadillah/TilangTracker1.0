package com.kpvelocite2015.ijarak;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kpvelocite2015.ijarak.model.Berita;

import java.util.List;

/**
 * Created by hallidafykzir on 10/24/2015.
 */
public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder> {

    List<Berita> beritaList;
    Context context;

    public BeritaAdapter(List<Berita> beritaList, Context context) {
        this.beritaList = beritaList;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return beritaList.size();
    }

    public static class BeritaViewHolder extends RecyclerView.ViewHolder {
        TextView vJudul;
        TextView vTanggal;
        ImageView vFoto;

        public BeritaViewHolder(View v) {
            super(v);
            vJudul =  (TextView) v.findViewById(R.id.judul);
            vTanggal = (TextView) v.findViewById(R.id.tanggal);
            vFoto = (ImageView) v.findViewById(R.id.gambar);
        }
    }

    @Override
    public BeritaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.recyclerview_berita_layout, parent, false);

        return new BeritaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BeritaViewHolder holder, int position) {
        Berita berita = beritaList.get(position);

        Typeface typefaceBold = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Bold.ttf");
        Typeface typefaceLight = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Light.ttf");
        Typeface typefaceMedium = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Medium.ttf");

        holder.vJudul.setTypeface(typefaceBold);
        holder.vTanggal.setTypeface(typefaceLight);

        holder.vJudul.setText(berita.getJudul());
        holder.vTanggal.setText(berita.getTanggal());
        holder.vFoto.setImageResource(berita.getGambar());
        //Picasso.with(context).load("http://36.86.177.169/kemis/public/" + berita.getFotoKeluarga()).into(holder.vCheckbox);
    }

}
