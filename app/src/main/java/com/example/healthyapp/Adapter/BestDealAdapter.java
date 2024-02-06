package com.example.healthyapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.healthyapp.Activity.DetailsActivity;
import com.example.healthyapp.Domain.BestDealDomain;
import com.example.healthyapp.R;

import java.util.ArrayList;

public class BestDealAdapter extends RecyclerView.Adapter<BestDealAdapter.viewholder> {
    ArrayList<BestDealDomain> item;
    Context context;

    public BestDealAdapter(ArrayList<BestDealDomain> item) {
        this.item = item;
    }

    @NonNull
    @Override
    public BestDealAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context= parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_best_deal,parent,false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull BestDealAdapter.viewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.titleTxt.setText(item.get(position).getTitle());
        holder.priceTxt.setText(item.get(position).getPrice()+"4/Kg");
        int drawableResourseId = holder.itemView.getResources().getIdentifier(item.get(position).getImgpath(),"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableResourseId)
                .into(holder.pic);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("object",item.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView titleTxt, priceTxt;
        ImageView pic;
        public viewholder(@NonNull View itemView) {
            super(itemView);
         titleTxt = itemView.findViewById(R.id.bestDealTitleTxt);
         priceTxt = itemView.findViewById(R.id.bestDealPriceTxt);
         pic = itemView.findViewById(R.id.img);
        }
    }
}
