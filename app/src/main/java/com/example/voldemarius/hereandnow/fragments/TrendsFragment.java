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
 * Created by Voldemarius on 03.09.2016.
 */
public class TrendsFragment extends Fragment {
    private RecyclerView recyclerView;
    public static TrendsFragment newInstance()
    {
        TrendsFragment trendsFragment=new TrendsFragment();
        return trendsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.recycler_fragment,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerView);
        setUpRecyclerView();
        return view;
    }
    private void setUpRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new RecyclerViewHotAdapter());
    }
}
