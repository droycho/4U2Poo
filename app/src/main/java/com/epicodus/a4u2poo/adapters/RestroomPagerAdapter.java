package com.epicodus.a4u2poo.adapters;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.epicodus.a4u2poo.Models.Restroom;
import com.epicodus.a4u2poo.RestroomDetailFragment;

import java.util.ArrayList;

public class RestroomPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Restroom> mRestrooms;

    public RestroomPagerAdapter(FragmentManager fm, ArrayList<Restroom> restrooms) {
        super(fm);
        mRestrooms = restrooms;
    }

    @Override
    public Fragment getItem(int position) {
        return RestroomDetailFragment.newInstance(mRestrooms.get(position));
    }

    @Override
    public int getCount() {
        return mRestrooms.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mRestrooms.get(position).getName();
    }
}
