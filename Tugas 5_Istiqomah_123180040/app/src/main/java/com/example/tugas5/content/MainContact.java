package com.example.tugas5.content;

import android.view.View;

import com.example.tugas5.database.AppDatabase;
import com.example.tugas5.database.DataMusic;

import java.util.List;

public interface MainContact {
    //untuk codingan activity
    interface content extends View.OnClickListener{
        void successAdd();
        void resetForm();
        void successDelete();
        void getData(List<DataMusic> list);
        void editData(DataMusic item);
        void deleteData(DataMusic item);
    }

    //untuk kodingan database
    interface presenter{
        void insertData(String judul, String penyanyi, AppDatabase database);
        void readData(AppDatabase database);
        void editData(String judul, String penyanyi, int id, AppDatabase database);
        void deleteData(DataMusic dataMusic, AppDatabase database);
    }
}
