package com.example.zalandoapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.zalandoapp.TabbedFragments.TabBasketFragment;
import com.example.zalandoapp.TabbedFragments.TabFavouriteFragment;
import com.example.zalandoapp.TabbedFragments.TabMainPageFragment;
import com.example.zalandoapp.TabbedFragments.TabSearchFragment;

public class PagerAdapter extends FragmentPagerAdapter {
    private int numberOfTabs;

    public PagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);

        this.numberOfTabs = numberOfTabs;
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TabMainPageFragment();
            case 1:
                return new TabSearchFragment();
            case 2:
                return new TabFavouriteFragment();
            case 3:
                return new TabBasketFragment();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
