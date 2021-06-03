package com.example.tugas5.database;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "music_db")
public class DataMusic implements Parcelable {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "judul")
    private String judul;
    @ColumnInfo(name = "penyanyi")
    private String penyanyi;

    @Ignore
    public DataMusic(int id, String judul, String penyanyi) {
        this.id = id;
        this.judul = judul;
        this.penyanyi = penyanyi;
    }

    public DataMusic(String judul, String penyanyi) {
        this.judul = judul;
        this.penyanyi = penyanyi;
    }

    protected DataMusic(Parcel in) {
        id = in.readInt();
        judul = in.readString();
        penyanyi = in.readString();
    }

    public static final Creator<DataMusic> CREATOR = new Creator<DataMusic>() {
        @Override
        public DataMusic createFromParcel(Parcel in) {
            return new DataMusic(in);
        }

        @Override
        public DataMusic[] newArray(int size) {
            return new DataMusic[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenyanyi() {
        return penyanyi;
    }

    public void setPenyanyi(String penyanyi) {
        this.penyanyi = penyanyi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(judul);
        dest.writeString(penyanyi);
    }
}
