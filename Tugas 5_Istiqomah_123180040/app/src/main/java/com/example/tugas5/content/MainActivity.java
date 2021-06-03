package com.example.tugas5.content;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tugas5.R;
import com.example.tugas5.database.AppDatabase;
import com.example.tugas5.database.DataMusic;
import com.example.tugas5.database.MusicDao;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContact.content{
    private AppDatabase appDatabase;
    private List<DataMusic> list;
    private MainPresenter mainPresenter;
    private MainAdapter mainAdapter;
    private MusicDao musicDao;

    private Button btnSubmit;
    private RecyclerView recyclerView;
    private EditText etJudul, etPenyanyi;

    private int id = 0;
    boolean edit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = findViewById(R.id.bt_add);
        etJudul = findViewById(R.id.et_judul);
        etPenyanyi = findViewById(R.id.et_penyanyi);
        recyclerView = findViewById(R.id.rv_recycler_view);

        appDatabase = AppDatabase.inidb(getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mainPresenter = new MainPresenter(this);

        mainPresenter.readData(appDatabase);

        btnSubmit.setOnClickListener(this::onClick);

    }

    @Override
    public void successAdd() {
        Toast.makeText(this, "Berhasil Menambahkan Data", Toast.LENGTH_SHORT).show();
        mainPresenter.readData(appDatabase);
    }

    @Override
    public void successDelete() {
        Toast.makeText(this, "Berhasil Menghapus Data", Toast.LENGTH_SHORT).show();
        mainPresenter.readData(appDatabase);
    }

    @Override
    public void resetForm(){
        etJudul.setText("");
        etPenyanyi.setText("");
        btnSubmit.setText("");
    }

    @Override
    public void getData(List<DataMusic> list) {
        mainAdapter = new MainAdapter(this,list,this);
        recyclerView.setAdapter(mainAdapter);

    }
    @Override
    public void editData(DataMusic item) {
        etJudul.setText(item.getJudul());
        etPenyanyi.setText(item.getPenyanyi());
        id = item.getId();
        edit = true;
        btnSubmit.setText("Edit Data");
    }

    @Override
    public void deleteData(DataMusic item) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("Menghapus Data").setMessage("Anda yakin ingin menghapus data ini?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        resetForm();
                        mainPresenter.deleteData(item, appDatabase);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setIcon(R.drawable.warning)
                .show();
    }

    @Override
    public void onClick(View v) {
        if (v == btnSubmit) {
            if (etJudul.getText().toString().equals("") || etPenyanyi.getText().toString().equals("")) {
                Toast.makeText(this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
            } else {
                if (!edit) {
                    mainPresenter.insertData(etJudul.getText().toString(), etPenyanyi.getText().toString(), appDatabase);
                } else {
                    mainPresenter.editData(etJudul.getText().toString(), etPenyanyi.getText().toString(), id, appDatabase);
                    edit = false;
                }
                resetForm();
            }
            Log.d("test", "click btn submit masuk");
        }
    }
}