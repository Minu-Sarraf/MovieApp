package com.example.minu.movieapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.minu.movieapp.fragment.NowPlaying;
import com.example.minu.movieapp.fragment.Popular;
import com.example.minu.movieapp.fragment.TopratedFragment;
import com.example.minu.movieapp.fragment.Upcoming;

/**
 * Created by minu on 10/22/2017.
 */

public class TabPagerAdapter extends FragmentPagerAdapter {

    int tabCount;

    public TabPagerAdapter(FragmentManager fragmentManager, int tabCount) {
        super(fragmentManager);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Popular tab1 = new Popular("popular");

                return tab1;
            case 1:
                Popular tab2 = new Popular("upcoming");
                return tab2;
            case 2:
                Popular tab4 = new Popular("top_rated");
                return tab4;
            case 3:
                Popular tab3 = new Popular("Now playing");
                return tab3;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}