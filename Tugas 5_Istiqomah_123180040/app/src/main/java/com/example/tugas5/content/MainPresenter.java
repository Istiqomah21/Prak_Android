package com.example.tugas5.content;

import android.os.AsyncTask;
import android.util.Log;

import androidx.room.Delete;

import com.example.tugas5.database.AppDatabase;
import com.example.tugas5.database.DataMusic;

import java.util.List;

public class MainPresenter implements MainContact.presenter{

    private MainContact.content view;

    public MainPresenter(MainContact.content view) {
        this.view = view;
    }

    class InsertData extends AsyncTask<Void,Void,Long>{
        private AppDatabase appDatabase;
        private DataMusic dataMusic;

        public InsertData(AppDatabase appDatabase, DataMusic dataMusic){
            this.appDatabase = appDatabase;
            this.dataMusic = dataMusic;
        }

        @Override
        protected Long doInBackground(Void... voids) {
            return appDatabase.dao().insertData(dataMusic);
        }

        protected void onPostExecute(Long along){
            super.onPostExecute(along);
            view.successAdd();
        }
    }

    @Override
    public void insertData(String judul, String penyanyi, AppDatabase database) {
        final DataMusic dataMusic = new DataMusic(judul, penyanyi);
        dataMusic.setJudul(judul);
        dataMusic.setPenyanyi(penyanyi);
        new InsertData(database, dataMusic).execute();
    }

    @Override
    public void readData(AppDatabase database) {
        List<DataMusic> list;
        list = database.dao().getData();
        view.getData(list);
    }

    class EditData extends AsyncTask<Void, Void, Integer> {
        private AppDatabase appDatabase;
        private DataMusic dataMusic;

        public EditData(AppDatabase appDatabase, DataMusic dataMusic) {
            this.appDatabase = appDatabase;
            this.dataMusic = dataMusic;
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            return appDatabase.dao().updateData(dataMusic);
        }

        protected void onPostExecute(Integer integer){
            super.onPostExecute(integer);
            Log.d("integer db", "onPostExecute : "+integer);
            view.successAdd();
        }
    }

    @Override
    public void editData(String judul, String penyanyi, int id, AppDatabase database) {
        final DataMusic dataMusic = new DataMusic(judul, penyanyi);
        dataMusic.setJudul(judul);
        dataMusic.setPenyanyi(penyanyi);
        dataMusic.setId(id);
        new EditData(database, dataMusic).execute();
    }

    class DeleteData extends AsyncTask<Void,Void,Long>{
        private AppDatabase appDatabase;
        private DataMusic dataMusic;

        public DeleteData(AppDatabase appDatabase, DataMusic dataMusic){
            this.appDatabase = appDatabase;
            this.dataMusic = dataMusic;
        }

        @Override
        protected Long doInBackground(Void... voids) {
            appDatabase.dao().deleteData(dataMusic);
            return null;
        }
    }

    @Override
    public void deleteData(DataMusic dataMusic, AppDatabase database) {
        new DeleteData(database,dataMusic).execute();
    }
}
