package com.example.voldemarius.hereandnow.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.voldemarius.hereandnow.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Voldemarius on 19.11.2016.
 */

public class ViewPagerMapFragment extends Fragment {
    private ImageView imageView;
    private TextView title;
    private TextView location;
    private TextView time;
    public static ViewPagerMapFragment newInstance(Bitmap image,String title,String time,String location)
    {
        ViewPagerMapFragment pagerMapFragment=new ViewPagerMapFragment();
        //Переделываем картинку в код для передачи через бандл
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        Bundle args = new Bundle();
        args.putByteArray("image",byteArray);
        args.putString("title",title);
        args.putString("time",time);
        args.putString("loc",location);
        pagerMapFragment.setArguments(args);
        return pagerMapFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.viewpager_map_fragment,container,false);
        imageView=(ImageView)view.findViewById(R.id.viewpager_map_image);
        title=(TextView)view.findViewById(R.id.viewpager_map_title);
        location=(TextView)view.findViewById(R.id.viewpager_map_location);
        time=(TextView)view.findViewById(R.id.viewpager_map_time);
        title.setText(getArguments().getString("title"));
        time.setText(getArguments().getString("time"));
        location.setText(getArguments().getString("loc"));

        Glide
                .with(view.getContext())
                .load(getArguments().getByteArray("image"))//вытаскиваем картинку через ByteArray
                .centerCrop()
                .into(imageView);

        return view;
    }
}
