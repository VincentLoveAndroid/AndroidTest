package com.example.yazhai1226.androidtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;

import com.example.yazhai1226.androidtest.R;

/**
 * Created by MingRen on 2016/6/30.
 */
public class MyView extends TextView {

    private Scroller mScroller;
    private int downX;
    private int downY;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mScroller = new Scroller(getContext());
    }

    @Override
    public void computeScroll() {
        super.computeScroll();

        if (mScroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        System.out.println("measure");
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                downX = (int) event.getRawX();
//                downY = (int) event.getRawY();
//                return true;
//            case MotionEvent.ACTION_MOVE:
//                break;
//            case MotionEvent.ACTION_UP:
//                int dx = (int) (event.getRawX() - downX);
//                int dy = (int) (event.getRawY() - downY);
//                if (Math.abs(dx) > 8 || Math.abs(dy) > 8) {
//                    View view = (View) getParent();
//                    mScroller.startScroll(view.getScrollX(), view.getScrollY(), -dx, -dy);
//                    invalidate();
//                }
//                break;
//        }
//        return super.onTouchEvent(event);
//
//    }
}
