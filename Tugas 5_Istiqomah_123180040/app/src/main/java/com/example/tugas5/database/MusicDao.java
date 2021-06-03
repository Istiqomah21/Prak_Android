package com.example.tugas5.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MusicDao {
    @Insert
    Long insertData(DataMusic dataMusic);

    @Query("Select * from music_db")
    List<DataMusic> getData();

    @Update
    int updateData(DataMusic item);

    @Delete
    void deleteData(DataMusic item);

}
