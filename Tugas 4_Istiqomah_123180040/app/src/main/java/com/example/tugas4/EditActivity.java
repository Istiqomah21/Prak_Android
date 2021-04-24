package com.example.tugas4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etEmail, etPhone;
    Button btnSave, btnCancel;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "pref";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PHONE = "phone";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etEmail = findViewById(R.id.et_email);
        etPhone = findViewById(R.id.et_phone);
        btnSave = findViewById(R.id.bt_save);
        btnCancel = findViewById(R.id.bt_cancel);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String sEmail = sharedPreferences.getString(KEY_EMAIL, null);
        String sPhone = sharedPreferences.getString(KEY_PHONE, null);

        System.out.println("Email : " + sEmail);
        System.out.println("Phone : " + sPhone);

        if (sEmail != null || sPhone != null) {
            etEmail.setText(sEmail);
            etPhone.setText(sPhone);

        }
        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.bt_save:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_EMAIL, etEmail.getText().toString());
                editor.putString(KEY_PHONE, etPhone.getText().toString());
                editor.apply();
                finish();
                break;

            case  R.id.bt_cancel:
                finish();
                break;
        }
    }
}
