package com.example.voldemarius.hereandnow.tools;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.voldemarius.hereandnow.R;

/**
 * Created by Voldemarius on 15.11.2016.
 */

public class RecyclerViewProfileAdapter extends RecyclerView.Adapter<RecyclerViewProfileAdapter.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name;
        TextView time;
        View view1;
        ViewHolder(View view) {
            super(view);
            imageView=(ImageView)view.findViewById(R.id.recycler_image);
            name=(TextView)view.findViewById(R.id.item_name);
            time=(TextView)view.findViewById(R.id.item_time);
            view1=view;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_profile_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide
                .with(holder.view1.getContext())
                .load(R.drawable.festival)
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
