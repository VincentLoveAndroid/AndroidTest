package com.example.yazhai1226.androidtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by MingRen on 2016/8/9.
 */
public class MoveImageView extends RelativeLayout {

    private int mLeft;
    private int mTop;
    private int mRight;
    private int mBottom;
    private boolean move;
    private int startX;
    private int startY;
    private int moveX;
    private int moveY;

    public MoveImageView(Context context) {
        super(context);
    }

    public MoveImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoveImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setLocation(int x, int y) {
//        mLeft = x - this.getWidth() / 2;
//        mTop = y - this.getHeight() / 2;
//        mRight = mLeft + this.getWidth();
//        mBottom = mTop + this.getHeight();
        //this.layout(mLeft, mTop, mRight, mBottom);
        //this.scrollTo(mLeft,mTop);
        this.setTranslationX(mLeft + x);
        this.setTranslationY(mTop + y);
        System.out.println("移动到的位置是" + mLeft + "" + mTop);
        System.out.println("长" + this.getWidth() + "高" + this.getHeight());
        move = true;
//        setLeft(mLeft);
//        setRight(mRight);
//        setTop(mTop);
//        setBottom(mBottom);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        boolean rb = false;
        if (touchInView(x, y)) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    startX = (int) event.getRawX();
                    startY = (int) event.getRawY();
                    rb = true;
                    break;
                case MotionEvent.ACTION_MOVE:
                    System.out.println("点击的位置是" + (int) event.getRawX() + "," + (int) event.getRawY());
                    moveX = (int) event.getRawX() - startX;
                    moveY = (int) event.getRawY() - startY;
                    this.setLocation(moveX, moveY);
                    rb = true;
                    break;
                case MotionEvent.ACTION_UP:
                    mLeft = mLeft + moveX;
                    mTop = mTop + moveY;
                    rb = super.onTouchEvent(event);
                    break;
            }
        }
        return rb;
    }

    public boolean touchInView(int x, int y) {
        if (x > 0 && x <= this.getWidth() && y > 0 && y <= this.getHeight()) {
            return true;
        }
        return false;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        System.out.println("onLayout");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        System.out.println("onMeasure");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        System.out.println("onDraw");
    }

    @Override
    public void invalidate() {
        super.invalidate();
        System.out.println("invalidate");
    }

    @Override
    public void invalidate(int l, int t, int r, int b) {
        super.invalidate(l, t, r, b);
        System.out.println("invalidate(int l, int t, int r, int b)" + l + "," + t + "," + r + "," + b);
    }


    @Override
    public void invalidate(Rect dirty) {
        super.invalidate(dirty);
        System.out.println("invalidate(Rect dirty)");
    }
}
