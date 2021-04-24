package com.example.tugas4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;


public class ProfileFragment extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    TextView txEmail, txPhone;
    Button btnLogout, btnEdit;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "pref";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PHONE = "phone";

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txEmail = view.findViewById(R.id.tx_email);
        txPhone = view.findViewById(R.id.tx_phone);

        btnEdit = view.findViewById(R.id.bt_edit);
        btnLogout = view.findViewById(R.id.bt_logout);

        sharedPreferences = getActivity().getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        retrieveData();

        btnEdit.setOnClickListener(this);
        btnLogout.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        retrieveData();
    }

    @SuppressLint("SetTextI18n")
    private void retrieveData(){
        String sEmail = sharedPreferences.getString(KEY_EMAIL, null);
        System.out.println("Email : " + sEmail);

        String sPhone = sharedPreferences.getString(KEY_PHONE, null);
        System.out.println("Phone : " + sPhone);

        txEmail.setText("Email : " + sEmail);
        txPhone.setText("Phone : " + sPhone);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.bt_edit:
                intent = new Intent(getContext(), EditActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_logout:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                intent = new Intent(getContext(), MainActivity.class);
                Objects.requireNonNull(getActivity()).finish();
                Objects.requireNonNull(getContext()).startActivity(intent);
                break;
        }
    }
}