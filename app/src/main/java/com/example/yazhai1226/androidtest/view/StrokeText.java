package com.example.yazhai1226.androidtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;

import com.example.yazhai1226.androidtest.R;

/**
 * Created by MingRen on 2016/5/24.
 */
class StrokeText extends TextView {

    private float mBigFontBottom;
    private float mBigFontHeight;

    private String text;
    private Paint mPaint;
    private int strokeSize = 1;

    public StrokeText(Context context) {
        super(context);
        init();
    }

    public StrokeText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public StrokeText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(getTextSize());
        mPaint.setColor(Color.parseColor("#ff6a01"));
        Paint.FontMetrics fm = mPaint.getFontMetrics();
        mBigFontBottom = fm.bottom;
        mBigFontHeight = fm.bottom - fm.top;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (strokeSize > 0 && strokeSize < 4) {
            float y = getPaddingTop() + mBigFontHeight - mBigFontBottom;
            canvas.drawText(text, 0, y - strokeSize, mPaint);
            canvas.drawText(text, 0, y + strokeSize, mPaint);
            canvas.drawText(text, 0 + strokeSize, y, mPaint);
            canvas.drawText(text, 0 + strokeSize, y + strokeSize, mPaint);
            canvas.drawText(text, 0 + strokeSize, y - strokeSize, mPaint);
            canvas.drawText(text, 0 - strokeSize, y, mPaint);
            canvas.drawText(text, 0 - strokeSize, y + strokeSize, mPaint);
            canvas.drawText(text, 0 - strokeSize, y - strokeSize, mPaint);
        }

        super.onDraw(canvas);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        this.text = text.toString();
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (strokeSize > 0 && strokeSize < 4) {
            setMeasuredDimension(getMeasuredWidth() + strokeSize, getMeasuredHeight());
        }
    }

}