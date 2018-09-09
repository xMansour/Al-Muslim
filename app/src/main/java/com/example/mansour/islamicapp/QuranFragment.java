package com.example.mansour.islamicapp;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Mansour on 8/13/2018.
 */

public class QuranFragment extends Fragment {
    View mView;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;
    int [] images;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_quran,container,false);
        loadImages();
        return mView;
    }
//TODO:: put this inside a thread
    private void loadImages(){
        images = new int[605];
        for(int i = 0; i < 604; i++ ){
            int j = i;
            String imageNumber = String.format("%03d",++j);
            images[i] =getResourceID("page"+imageNumber,"drawable",getActivity().getApplicationContext());
        }
        viewPager = (ViewPager) mView.findViewById(R.id.viewPager);
        pagerAdapter = new QuranFragmentPagerAdapter(getActivity(), images);
        viewPager.setAdapter(pagerAdapter);
    }

    protected final static int getResourceID(final  String resourceName, final String resourceType, final Context context){
        final int resourceID = context.getResources().getIdentifier(resourceName, resourceType, context.getApplicationContext().getPackageName());
        if(resourceID == 0){
            throw new IllegalArgumentException("No resource found with name "+ resourceName);
        }
        else{
            return resourceID;
        }
    }
}
