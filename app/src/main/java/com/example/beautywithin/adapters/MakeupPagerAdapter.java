package com.example.beautywithin.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.beautywithin.models.Makeup;

import java.util.ArrayList;

public class MakeupPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Makeup> mMakeups;

    public MakeupPagerAdapter(FragmentManager fm, ArrayList<Makeup> makeups) {
        super(fm);
        mMakeups = makeups;
    }

    @Override
    public Fragment getItem(int position) {
        return MakeupDetailFragment.newInstance(mMakeups.get(position));
    }

    @Override
    public int getCount() {
        return mMakeups.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mMakeups.get(position).getmName();
    }
}
