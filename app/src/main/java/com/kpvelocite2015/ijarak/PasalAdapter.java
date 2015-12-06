package com.kpvelocite2015.ijarak;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.kpvelocite2015.ijarak.model.Pasal;

import java.util.ArrayList;

/**
 * Created by hallidafykzir on 10/24/2015.
 */
public class PasalAdapter extends RecyclerView.Adapter<PasalAdapter.PasalViewHolder> {

    ArrayList<Pasal> pasalList;
    Context context;

    public PasalAdapter(ArrayList<Pasal> pasalList, Context context) {
        this.pasalList = pasalList;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return pasalList.size();
    }

    public static class PasalViewHolder extends RecyclerView.ViewHolder {
        TextView vNomor, vIsi, vObyek,vDenda;
        public CheckBox chkSelected;

        Pasal pasal;

        public PasalViewHolder(View v) {
            super(v);
            vNomor =  (TextView) v.findViewById(R.id.nomorTV);
            vIsi = (TextView) v.findViewById(R.id.isiTV);
            vObyek = (TextView) v.findViewById(R.id.obyekTV);
            vDenda = (TextView) v.findViewById(R.id.dendaTV);
            chkSelected = (CheckBox) v.findViewById(R.id.checkbox);
        }
    }

    @Override
    public PasalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.recyclerview_pasal_layout, parent, false);

        return new PasalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PasalViewHolder holder, final int position) {

        Typeface typefaceBold = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Bold.ttf");
        Typeface typefaceLight = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Light.ttf");
        Typeface typefaceMedium = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Medium.ttf");

        holder.vNomor.setTypeface(typefaceBold);
        holder.vIsi.setTypeface(typefaceLight);

        holder.vNomor.setText(pasalList.get(position).getNomor());
        holder.vIsi.setText(pasalList.get(position).getIsi());
        holder.vObyek.setText("Obyek Hukum : " + pasalList.get(position).getObyekHukum());
        holder.vDenda.setText("Denda : Rp." + pasalList.get(position).getDenda());

        holder.chkSelected.setChecked(pasalList.get(position).isSelected());

        holder.chkSelected.setTag(pasalList.get(position));

        holder.chkSelected.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                Pasal contact = (Pasal) cb.getTag();

                contact.setSelected(cb.isChecked());
                pasalList.get(position).setSelected(cb.isChecked());
            }
        });

    }

    public ArrayList<Pasal> getPasalList() {
        return pasalList;
    }

}
