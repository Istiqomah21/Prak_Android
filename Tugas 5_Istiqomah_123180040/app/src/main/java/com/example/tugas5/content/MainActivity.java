package com.example.tugas5.content;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tugas5.R;
import com.example.tugas5.database.AppDatabase;
import com.example.tugas5.database.DataMusic;
import com.example.tugas5.database.MusicDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AppDatabase appDatabase;
    private List<DataMusic> list;
    private MainPresenter mainPresenter;
    private MainAdapter mainAdapter;
    private MusicDao musicDao;

    private Button btnOK;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOK = findViewById(R.id.bt_add);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(intent);
            }
        });

        appDatabase = AppDatabase.inidb(getApplicationContext());

        recyclerView = findViewById(R.id.rv_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainPresenter.readData(appDatabase);
    }
}