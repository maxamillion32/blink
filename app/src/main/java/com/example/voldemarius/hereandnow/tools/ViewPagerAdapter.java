package com.example.voldemarius.hereandnow.tools;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.voldemarius.hereandnow.fragments.FriendsFragment;
import com.example.voldemarius.hereandnow.fragments.TrendsFragment;

/**
 * Created by Voldemarius on 03.09.2016.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter{
    private final int FragmentsCount=2;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0)
        {
            return TrendsFragment.newInstance();
        }
        else
        {
            return FriendsFragment.newInstance();
        }

    }

    @Override
    public int getCount() {
        return FragmentsCount;
    }
}
