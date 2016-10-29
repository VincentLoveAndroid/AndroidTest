package com.example.yazhai1226.androidtest.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yazhai1226.androidtest.R;

/**
 * Created by mingren on 2016/1/8.
 */
public class MyTextView extends TextView {
    public MyTextView(Context context) {
        this(context, null);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        System.out.println("1onlayout");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        System.out.println("1onMeasure");
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        System.out.println("1onDraw");
    }

    @Override
    public boolean canResolveTextDirection() {
        return super.canResolveTextDirection();
    }
}
