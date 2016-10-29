package com.example.yazhai1226.androidtest.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MingRen on 2016/9/8.
 */
public class LiveViewPager extends ViewPager {

    private List<View> viewList = new ArrayList<>();

    public LiveViewPager(Context context) {
        this(context, null);
    }

    public LiveViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setAdapter(pagerAdapter);
    }

    public void addChildView(View view) {
        viewList.add(view);
        pagerAdapter.notifyDataSetChanged();
    }


    private PagerAdapter pagerAdapter = new PagerAdapter() {
        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));
        }
    };
}
