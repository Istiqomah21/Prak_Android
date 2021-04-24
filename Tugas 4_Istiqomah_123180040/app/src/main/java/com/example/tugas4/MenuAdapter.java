package com.example.tugas4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tugas4.DetailActivity;
import com.example.tugas4.Menu;
import com.example.tugas4.R;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder>{

    private ArrayList<Menu> menu;
    private Context context;

    public MenuAdapter(ArrayList<Menu> menu, Context context) {
        this.menu = menu;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.menu_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(menu.get(position));
    }

    @Override
    public int getItemCount() {
        return menu.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView ivPhoto;
        CardView cvCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_name);
            ivPhoto = itemView.findViewById(R.id.iv_photo);
            cvCardView = itemView.findViewById(R.id.cv_cardview);
        }

        public void bind(Menu menu){
            tvTitle.setText(menu.getsName());
            Glide.with(itemView.getContext())
                    .load(menu.getsImage())
                    .apply(new RequestOptions().override(40,60))
                    .into(ivPhoto);
            cvCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_DATA, menu);
                    context.startActivity(intent);
                }
            });
        }
    }
}

