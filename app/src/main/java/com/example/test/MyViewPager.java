package com.example.test;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyViewPager extends FragmentPagerAdapter {

    final List<Fragment> myFragment = new ArrayList<>();
    final List<String> myTitleList = new ArrayList<>();

    public MyViewPager(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return myFragment.get(position);
    }

    @Override
    public int getCount() {
        return myTitleList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return myTitleList.get(position);
    }
    void adFragment(Fragment fragment,String title){
        myFragment.add(fragment);
        myTitleList.add(title);
    }
}
