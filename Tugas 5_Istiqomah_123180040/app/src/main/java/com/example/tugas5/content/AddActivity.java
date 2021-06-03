package com.example.tugas5.content;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tugas5.R;
import com.example.tugas5.database.MusicDao;

public class AddActivity extends AppCompatActivity {
    private EditText etJudul, etPenyanyi;
    private Button btTambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etJudul = findViewById(R.id.et_judul);
        etPenyanyi = findViewById(R.id.et_penyanyi);
        btTambah = findViewById(R.id.bt_tambah);
    }
}


