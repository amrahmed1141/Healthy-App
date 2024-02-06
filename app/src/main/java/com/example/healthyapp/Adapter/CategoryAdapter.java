package com.example.healthyapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.healthyapp.Domain.CategoryDomain;
import com.example.healthyapp.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewholder> {
    ArrayList<CategoryDomain> item;
    Context context;

    public CategoryAdapter(ArrayList<CategoryDomain> item) {

        this.item = item;
    }

    @NonNull
    @Override
    public CategoryAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
        return new  viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.viewholder holder, int position) {
     holder.titleTxt.setText(item.get(position).getTitle());
     int drawableResourseId = holder.itemView.getResources().getIdentifier(item.get(position).getImgpath(),"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableResourseId)
                .into(holder.pic);

    }

    @Override
    public int getItemCount() {

        return item.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        private TextView titleTxt;
        private ImageView pic;
        public viewholder(@NonNull View itemView) {
            super(itemView);

            titleTxt = itemView.findViewById(R.id.titleTxt);
            pic = itemView.findViewById(R.id.img);
        }
    }
}
