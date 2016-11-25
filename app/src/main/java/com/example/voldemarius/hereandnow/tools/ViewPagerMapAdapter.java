package com.example.voldemarius.hereandnow.tools;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Voldemarius on 19.11.2016.
 */

public class ViewPagerMapAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentList=new ArrayList<Fragment>();
    public ViewPagerMapAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment) {
        fragmentList.add(fragment);
        notifyDataSetChanged();
    }


    public Fragment getFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }
    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
