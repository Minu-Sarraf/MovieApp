package com.example.minu.movieapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.minu.movieapp.fragment.NowPlaying;
import com.example.minu.movieapp.fragment.Popular;
import com.example.minu.movieapp.fragment.TopratedFragment;
import com.example.minu.movieapp.fragment.Upcoming;
import com.example.minu.movieapp.model.TopRated;

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
                Popular tab1 = new Popular();
                return tab1;
            case 1:
                Upcoming tab2 = new Upcoming();
                return tab2;
            case 2:
                TopratedFragment tab3 = new TopratedFragment();

                return tab3;
            case 3:
                NowPlaying tab4 = new NowPlaying();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}