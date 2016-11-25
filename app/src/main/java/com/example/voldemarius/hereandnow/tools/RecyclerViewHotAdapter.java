package com.example.voldemarius.hereandnow.tools;

import android.graphics.Typeface;
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
        ImageButton viewBtn;
        View eventView;
        ImageButton shareBtn;
        TextView interestNumber;
        TextView category;
        TextView author;

        ViewHolder(View view) {
            super(view);
            Typeface ptSansBold=Typeface.createFromAsset(view.getContext().getAssets(),"fonts/PT_SansBold.ttf");
            Typeface ptSansRegular=Typeface.createFromAsset(view.getContext().getAssets(),"fonts/PT_SansRegular.ttf");
            Typeface latoBold=Typeface.createFromAsset(view.getContext().getAssets(),"fonts/Lato-Bold.ttf");
            Typeface latoRegular=Typeface.createFromAsset(view.getContext().getAssets(),"fonts/Lato-Regular.ttf");
            eventView=view;
            cardView = (CardView)view.findViewById(R.id.cardView);
            time = (TextView)view.findViewById(R.id.textTime);
            time.setTypeface(ptSansBold);
            title = (TextView)view.findViewById(R.id.textTitle);
            title.setTypeface(ptSansBold);
            location = (TextView)view.findViewById(R.id.textLocation);
            location.setTypeface(ptSansRegular);
            interestNumber = (TextView)view.findViewById(R.id.interestedNumber);
            interestNumber.setTypeface(ptSansRegular);
            mainImage = (ImageView)view.findViewById(R.id.imageEvent);
            category = (TextView)view.findViewById(R.id.eventCategory);
            category.setTypeface(latoBold);
            author = (TextView)view.findViewById(R.id.eventAuthor);
            author.setTypeface(latoBold);
            viewBtn = (ImageButton)view.findViewById(R.id.addEventBtn);
            shareBtn = (ImageButton)view.findViewById(R.id.shareEventBtn);
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
