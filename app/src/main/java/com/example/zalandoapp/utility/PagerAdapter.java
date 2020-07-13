package com.example.zalandoapp.utility;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.zalandoapp.ui.TabbedFragments.TabBasket.TabBasketFragment;
import com.example.zalandoapp.ui.TabbedFragments.TabFavourites.TabFavouriteFragment;
import com.example.zalandoapp.ui.TabbedFragments.TabMainPageFragment;
import com.example.zalandoapp.ui.TabbedFragments.TabSearchFragment;

public class PagerAdapter extends FragmentPagerAdapter {
    private int numberOfTabs;

    public PagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);

        this.numberOfTabs = numberOfTabs;
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
            Fragment fragment = new Fragment();
            if (position == 0) {
                fragment = new TabMainPageFragment();
            } else if(position == 1) {
                fragment = new TabSearchFragment();
            }
            else if(position==2) {
                fragment = new TabFavouriteFragment();
            }
            else if(position==3){
                fragment = new TabBasketFragment();
            }
            return fragment;

        }


    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
