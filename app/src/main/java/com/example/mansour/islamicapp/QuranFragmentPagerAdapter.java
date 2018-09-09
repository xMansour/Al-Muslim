package com.example.mansour.islamicapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by Mansour on 8/13/2018.
 */

public class QuranFragmentPagerAdapter extends PagerAdapter {

    Context context;
    int [] images;
    LayoutInflater layoutInflater;

    public QuranFragmentPagerAdapter(Context context, int [] images){
        this.context = context;
        this.images = images;
    }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view ==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView imageView;
        layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.fragment_quran_pager_item, container, false);

        imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);
        Toast.makeText(context, "Page"+position, Toast.LENGTH_SHORT).show();

        ((ViewPager) container).addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);
    }
}
