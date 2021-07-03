package com.example.covid.adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid.R;
import com.example.covid.model.rs.DataItem;

import java.util.List;

public class RSAdapter extends RecyclerView.Adapter<RSAdapter.ViewHolder> {

    List<DataItem> items;

    public RSAdapter(List<DataItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rs_item, parent, false);
        return new RSAdapter.ViewHolder(view);
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
        TextView tvRS, tvAlamat;
        Button btnMaps;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvRS = itemView.findViewById(R.id.tv_rs);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            btnMaps = itemView.findViewById(R.id.btn_map);
        }

        public void bind(DataItem dataItem) {
            tvRS.setText(dataItem.getNama());
            tvAlamat.setText(dataItem.getAlamat());
            btnMaps.setOnClickListener(v->{
                String locatin = "geo:" + dataItem.getLatitude() + "," + dataItem.getLongitude() + "?q=";
                Uri gmmIntentUri = Uri.parse(locatin + Uri.encode(dataItem.getNama()));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                itemView.getContext().startActivity(mapIntent);
            });
        }
    }
}
