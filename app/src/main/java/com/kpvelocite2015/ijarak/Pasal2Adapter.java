package com.kpvelocite2015.ijarak;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kpvelocite2015.ijarak.model.Pasal;

import java.util.ArrayList;

/**
 * Created by hallidafykzir on 10/24/2015.
 */
public class Pasal2Adapter extends RecyclerView.Adapter<Pasal2Adapter.Pasal2ViewHolder> {

    ArrayList<Pasal> pasalList;
    Context context;

    public Pasal2Adapter(ArrayList<Pasal> pasalList, Context context) {
        this.pasalList = pasalList;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return pasalList.size();
    }

    public static class Pasal2ViewHolder extends RecyclerView.ViewHolder {
        TextView vNomor, vIsi, vObyek,vDenda;

        Pasal pasal;

        public Pasal2ViewHolder(View v) {
            super(v);
            vNomor =  (TextView) v.findViewById(R.id.nomorTV);
            vIsi = (TextView) v.findViewById(R.id.isiTV);
            vObyek = (TextView) v.findViewById(R.id.obyekTV);
            vDenda = (TextView) v.findViewById(R.id.dendaTV);
        }
    }

    @Override
    public Pasal2ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.recyclerview_pasal_layout, parent, false);

        return new Pasal2ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(Pasal2ViewHolder holder, final int position) {

        Typeface typefaceBold = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Bold.ttf");
        Typeface typefaceLight = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Light.ttf");
        Typeface typefaceMedium = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Medium.ttf");

        holder.vNomor.setTypeface(typefaceBold);
        holder.vIsi.setTypeface(typefaceLight);

        holder.vNomor.setText(pasalList.get(position).getNomor());
        holder.vIsi.setText(pasalList.get(position).getIsi());
        holder.vObyek.setText("Obyek Hukum : " + pasalList.get(position).getObyekHukum());
        holder.vDenda.setText("Denda : Rp." + pasalList.get(position).getDenda());

    }

    public ArrayList<Pasal> getPasalList() {
        return pasalList;
    }

}
