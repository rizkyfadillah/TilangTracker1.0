package com.kpvelocite2015.ijarak.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hallidafykzir on 12/6/2015.
 */
public class Pasal implements Parcelable {

    String nomor, isi, obyekHukum;
    double denda;
    private boolean isSelected;

    private Pasal(Parcel in) {
        nomor = in.readString();
        isi = in.readString();
        obyekHukum = in.readString();
        denda = in.readDouble();
    }

    public Pasal(){

    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getObyekHukum() {
        return obyekHukum;
    }

    public void setObyekHukum(String obyekHukum) {
        this.obyekHukum = obyekHukum;
    }

    public double getDenda() {
        return denda;
    }

    public void setDenda(double denda) {
        this.denda = denda;
    }

    public static final Parcelable.Creator<Pasal> CREATOR =
            new Parcelable.Creator<Pasal>() {

                @Override
                public Pasal createFromParcel(Parcel source) {
                    return new Pasal(source);
                }

                @Override
                public Pasal[] newArray(int size) {
                    return new Pasal[size];
                }

            };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nomor);
        parcel.writeString(isi);
        parcel.writeString(obyekHukum);
        parcel.writeDouble(denda);
    }
}
