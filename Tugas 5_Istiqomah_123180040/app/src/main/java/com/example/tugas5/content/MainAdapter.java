package com.example.tugas5.content;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugas5.R;
import com.example.tugas5.database.DataMusic;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder> {
    Context context;
    List<DataMusic> list;
    MainContact.content mview;

    public MainAdapter(Context context, List<DataMusic> list, MainContact.content mview) {
        this.context = context;
        this.list = list;
        this.mview = mview;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.music_item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.viewHolder holder, int position) {
        final DataMusic item = list.get(position);
        //holder.id.setText(item.getId());
        holder.tvJudul.setText(item.getJudul());
        holder.tvPenyanyi.setText(item.getPenyanyi());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mview.editData(item);
            }
        });
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mview.deleteData(item);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tvJudul, tvPenyanyi, id;
        CardView cardView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            //id = itemView.findViewById(R.id.tv_id);
            tvJudul = itemView.findViewById(R.id.tv_judul);
            tvPenyanyi = itemView.findViewById(R.id.tv_penyanyi);
            cardView = itemView.findViewById(R.id.cv_cardview);
        }
    }
}
