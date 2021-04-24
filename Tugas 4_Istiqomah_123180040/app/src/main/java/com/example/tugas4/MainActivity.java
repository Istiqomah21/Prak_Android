package com.example.tugas4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUsername, etPassword;
    Button btnLogin;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "pref";
    private static final String KEY_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.et_uname);
        etPassword = findViewById(R.id.et_pass);
        btnLogin = findViewById(R.id.bt_login);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String sUsername = sharedPreferences.getString(KEY_USERNAME, null);

        if (sUsername != null){
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
            finish();
        }
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login:
                if (TextUtils.isEmpty(etUsername.getText())){
                    etUsername.setError("Input Username!");
                }

                if (TextUtils.isEmpty(etPassword.getText())){
                    etPassword.setError("Input Password!");
                }

                if (!TextUtils.isEmpty(etUsername.getText()) && !TextUtils.isEmpty(etPassword.getText())){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_USERNAME, etUsername.getText().toString());
                    editor.apply();

                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivity(intent);
                    finish();
                }
        }
    }
}