package com.example.tugas3;

import android.os.Parcel;
import android.os.Parcelable;

public class Menu implements Parcelable {
    private String sName, sDetail, sImage, sHarga;

    public Menu(String sName, String sDetail, String sImage, String sHarga) {
        this.sName = sName;
        this.sDetail = sDetail;
        this.sImage = sImage;
        this.sHarga = sHarga;
    }

    public Menu() {
    }

    protected Menu(Parcel in) {
        sName = in.readString();
        sDetail = in.readString();
        sImage = in.readString();
        sHarga = in.readString();
    }

    public static final Creator<Menu> CREATOR = new Creator<Menu>() {
        @Override
        public Menu createFromParcel(Parcel in) {
            return new Menu(in);
        }

        @Override
        public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsDetail() {
        return sDetail;
    }

    public void setsDetail(String sDetail) {
        this.sDetail = sDetail;
    }

    public String getsImage() {
        return sImage;
    }

    public void setsImage(String sImage) {
        this.sImage = sImage;
    }

    public String getsHarga() {
        return sHarga;
    }

    public void setsHarga(String sHarga) {
        this.sHarga = sHarga;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sName);
        dest.writeString(sDetail);
        dest.writeString(sImage);
        dest.writeString(sHarga);
    }
}
