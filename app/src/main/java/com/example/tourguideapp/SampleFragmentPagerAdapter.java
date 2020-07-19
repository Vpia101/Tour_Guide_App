package com.example.tourguideapp;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import android.content.Context;


public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;

    private Context mContext;
    public SampleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    public SampleFragmentPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return HomeFragment.newInstance(0, "Home");
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return DiningFragment.newInstance(1, "Dining");
            case 2: // Fragment # 1 - This will show SecondFragment
                return ShoppingFragment.newInstance(2, "Shopping");
            case 3: // Fragment # 1 - This will show SecondFragment
                return ActivityFragment.newInstance(3, "Page # 4");
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    //@Override
   // public CharSequence getPageTitle(int position) {return "Page " + position;}

}

