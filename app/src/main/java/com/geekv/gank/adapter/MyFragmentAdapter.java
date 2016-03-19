package com.geekv.gank.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hfl12 on 2016/3/9.
 */
public class MyFragmentAdapter extends FragmentPagerAdapter {
    List<Fragment>fragmentsList;
    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public MyFragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragmentsList = fragments;
    }
    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }
}
