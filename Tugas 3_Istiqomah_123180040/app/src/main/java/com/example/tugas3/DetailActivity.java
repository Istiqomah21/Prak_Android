package com.example.tugas3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {
    public static String EXTRA_DATA = "EXTRA_DATA";
    private Menu menu;

    ImageView ivImage;
    TextView tvTitle, tvDetail, tvHarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTitle = findViewById(R.id.tv_nama);
        tvDetail = findViewById(R.id.tv_detail);
        tvHarga = findViewById(R.id.tv_harga);
        ivImage = findViewById(R.id.iv_images);

        menu = getIntent().getParcelableExtra(EXTRA_DATA);

        Glide.with(this)
                .load(menu.getsImage())
                .apply(new RequestOptions().override(160,240))
                .into(ivImage);
        tvTitle.setText(menu.getsName());
        tvDetail.setText(menu.getsDetail());
        tvHarga.setText(menu.getsHarga());


    }
}