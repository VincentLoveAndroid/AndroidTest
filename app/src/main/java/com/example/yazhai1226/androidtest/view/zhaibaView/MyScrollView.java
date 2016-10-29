package com.example.yazhai1226.androidtest.view.zhaibaView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by MingRen on 2016/5/28.
 */
public class MyScrollView extends ScrollView {
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChange(l, t, oldl, oldt);
        }
    }

    private OnScrollChangedListener onScrollChangedListener;

    public interface OnScrollChangedListener {
        void onScrollChange(int l, int t, int oldl, int oldt);
    }

    public void setOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        this.onScrollChangedListener = onScrollChangedListener;
    }
}
