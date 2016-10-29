package com.example.yazhai1226.androidtest.view.zhaibaView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by MingRen on 2016/8/19.
 */
public class MyTextView2 extends TextView {
    public MyTextView2(Context context) {
        super(context);
    }

    public MyTextView2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        System.out.println("2onlayout");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        System.out.println("2onMeasure");
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        System.out.println("2onDraw");
    }
}
