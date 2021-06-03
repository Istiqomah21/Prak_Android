package com.example.tugas5.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DataMusic.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MusicDao dao();
    private static AppDatabase appDatabase;

    public static AppDatabase inidb(Context context) {
        if (appDatabase==null)
            appDatabase = Room.databaseBuilder(context,AppDatabase.class, "dbMusic").allowMainThreadQueries().build();
        return appDatabase;
    }
}
