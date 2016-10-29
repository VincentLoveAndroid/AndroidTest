package com.example.yazhai1226.androidtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by MingRen on 2016/10/13.
 */

public class ClockSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private Canvas mCanvas;
    private Paint mPaint;
    private boolean isDrawing;
    private SurfaceHolder mHolder;


    public ClockSurfaceView(Context context) {
        super(context);
        init();
    }

    public ClockSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mHolder = getHolder();
        mHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setKeepScreenOn(true);

        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    private void draw() {
        try {
            mCanvas = mHolder.lockCanvas();
            //draw sth
        } catch (Exception e) {

        } finally {
            if (mCanvas != null) mHolder.unlockCanvasAndPost(mCanvas);
        }
    }

    @Override
    public void run() {
        if (isDrawing) {
            draw();
        }
    }
}
