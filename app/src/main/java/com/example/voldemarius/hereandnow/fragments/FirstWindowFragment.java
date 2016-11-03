package com.example.voldemarius.hereandnow.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.voldemarius.hereandnow.R;
import com.example.voldemarius.hereandnow.tools.ViewPagerAdapter;

/**
 * Created by Voldemarius on 03.09.2016.
 */
public class FirstWindowFragment extends Fragment {
    public ViewPager viewPager;
    public static FirstWindowFragment newInstance()
    {
        return new FirstWindowFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View window = inflater.inflate(R.layout.firstwindow_fragment, container, false);
        viewPager = (ViewPager) window.findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager()));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return window;
    }
    public void changePage(int pos)
    {
        viewPager.setCurrentItem(pos);
    }
}
