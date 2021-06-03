package com.example.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText numb1, numb2;
    Button btn_Tambah, btn_Kurang, btn_Kali, btn_Bagi;
    TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numb1 = findViewById(R.id.number1);
        numb2 = findViewById(R.id.number2);
        btn_Tambah = findViewById(R.id.button1);
        btn_Kurang = findViewById(R.id.button2);
        btn_Kali = findViewById(R.id.button3);
        btn_Bagi = findViewById(R.id.button4);
        Result = findViewById(R.id.hasil);

        btn_Tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sNumber1 = numb1.getText().toString();
                String sNumber2 = numb2.getText().toString();

                double number1 = Double.parseDouble(sNumber1);
                double number2 = Double.parseDouble(sNumber2);

                double result = 0;
                result = number1 + number2;

                String sResult = String.valueOf(result);
                Result.setText(sResult);
            }
        });
        btn_Kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sNumber1 = numb1.getText().toString();
                String sNumber2 = numb2.getText().toString();

                double number1 = Double.parseDouble(sNumber1);
                double number2 = Double.parseDouble(sNumber2);

                double result = 0;
                result = number1 - number2;

                String sResult = String.valueOf(result);
                Result.setText(sResult);
            }
        });

        btn_Kali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sNumber1 = numb1.getText().toString();
                String sNumber2 = numb2.getText().toString();

                double number1 = Double.parseDouble(sNumber1);
                double number2 = Double.parseDouble(sNumber2);

                double result = 0;
                result = number1 * number2;

                String sResult = String.valueOf(result);
                Result.setText(sResult);
            }
        });

        btn_Bagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sNumber1 = numb1.getText().toString();
                String sNumber2 = numb2.getText().toString();

                double number1 = Double.parseDouble(sNumber1);
                double number2 = Double.parseDouble(sNumber2);

                double result = 0;
                result = number1 / number2;

                String sResult = String.valueOf(result);
                Result.setText(sResult);
            }
        });
    }
}