package com.example.covid.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid.R;
import com.example.covid.model.kasus.ContentItem;

import java.util.ArrayList;
import java.util.List;

public class KasusAdapter extends RecyclerView.Adapter<KasusAdapter.ViewHolder> {
    List<ContentItem> items;
    public KasusAdapter(List<ContentItem> items){
        this.items = items;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kasus_item,parent,false);
        return new KasusAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTanggal, tvSembuh, tvKonfirmasi, tvMeninggal;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTanggal = itemView.findViewById(R.id.tv_tanggal);
            tvKonfirmasi = itemView.findViewById(R.id.tv_terkonfirmasi);
            tvMeninggal = itemView.findViewById(R.id.tv_meninggal);
            tvSembuh = itemView.findViewById(R.id.tv_sembuh);

        }
        @SuppressLint("SetTextI18n")
        void bind(ContentItem contentItem) {
            tvTanggal.setText(contentItem.getTanggal());
            tvSembuh.setText("Sembuh " + contentItem.getConfirmationSelesai() + " Kasus");
            tvMeninggal.setText("Meninggal " + contentItem.getConfirmationMeninggal() + " Kasus");
            tvKonfirmasi.setText("Terkonfirmasi " + contentItem.getConfirmationDiisolasi() + " Kasus");
        }
    }
}
