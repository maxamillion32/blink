package com.example.voldemarius.hereandnow.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.voldemarius.hereandnow.R;

/**
 * Created by Voldemarius on 03.09.2016.
 */
public class FriendsFragment extends Fragment {
    public static FriendsFragment newInstance()
    {
        FriendsFragment friendsFragment=new FriendsFragment();
        return friendsFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.textview,container,false);
        TextView textView=(TextView)view.findViewById(R.id.exampleTextView);
        textView.setText("FriendsFragment");
        return view;
    }
}
