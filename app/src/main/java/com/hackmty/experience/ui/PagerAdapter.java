package com.hackmty.experience.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    String[] TABS = {"Pendientes","Historial"};

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new PendingFragment();
        return new HistoryFragment();
    }

    @Override
    public int getCount() {
        return TABS.length;
    }
}
