package com.example.voldemarius.hereandnow.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.voldemarius.hereandnow.R;
import com.example.voldemarius.hereandnow.tools.RecyclerViewHotAdapter;

/**
 * Created by Voldemarius on 18.09.2016.
 */
public class InterestingFragment extends Fragment {
    private RecyclerView recyclerView;
    public static InterestingFragment newInstance()
    {
        InterestingFragment interestingFragment = new InterestingFragment();
        return interestingFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.textview,container,false);//не забудь подключть тут RecyclerView
        TextView textView=(TextView)view.findViewById(R.id.exampleTextView);
        textView.setText("interestingFragment");
        return view;
    }


}
