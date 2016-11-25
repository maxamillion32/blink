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
import com.example.voldemarius.hereandnow.tools.RecyclerViewProfileAdapter;

/**
 * Created by Voldemarius on 04.09.2016.
 */
public class ProfileFragment extends Fragment {
    private RecyclerView recyclerView;
    private TextView name;
    private TextView about;
    private TextView location;
    private TextView friends;
    private TextView events;

    public static ProfileFragment newInstance()
    {
        ProfileFragment profileFragment=new ProfileFragment();
        return profileFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.profile_fragment,container,false);
        implementViews(view);
        RecyclerViewProfileAdapter profileAdapter=new RecyclerViewProfileAdapter();
        LinearLayoutManager layoutManager=new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setAdapter(profileAdapter);
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    private void implementViews(View view) {
        recyclerView = (RecyclerView)view.findViewById(R.id.profile_recyclerview);
        name=(TextView)view.findViewById(R.id.name);
        about=(TextView)view.findViewById(R.id.about_me);
        location=(TextView)view.findViewById(R.id.profile_location);
        friends=(TextView)view.findViewById(R.id.profile_friends_number);
        events=(TextView)view.findViewById(R.id.profile_events_number);
    }
}
