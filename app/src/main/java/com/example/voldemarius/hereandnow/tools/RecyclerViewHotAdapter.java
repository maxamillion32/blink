package com.example.voldemarius.hereandnow.tools;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.voldemarius.hereandnow.R;

/**
 * Created by Voldemarius on 01.11.2016.
 */

public class RecyclerViewHotAdapter extends RecyclerView.Adapter<RecyclerViewHotAdapter.ViewHolder> {
    public RecyclerViewHotAdapter() {
    }
    static class ViewHolder extends RecyclerView.ViewHolder
    {
        CardView cardView;
        TextView time;
        TextView title;
        TextView location;
        ImageView mainImage;
        Button addBtn;
        View eventView;
        ImageButton moreBtn;

        ViewHolder(View view) {
            super(view);
            eventView=view;
            cardView = (CardView)view.findViewById(R.id.cardView);
            time = (TextView)view.findViewById(R.id.textTime);
            title = (TextView)view.findViewById(R.id.textTitle);
            location = (TextView)view.findViewById(R.id.textLocation);
            mainImage = (ImageView)view.findViewById(R.id.imageEvent);
            addBtn = (Button)view.findViewById(R.id.addEventBtn);
            moreBtn = (ImageButton)view.findViewById(R.id.moreEventBtn);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_hot_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide
                .with(holder.eventView.getContext())
                .load(R.drawable.festival)
                .centerCrop()
                .into(holder.mainImage);


    }



    @Override
    public int getItemCount() {
        return 4;
    }
}
