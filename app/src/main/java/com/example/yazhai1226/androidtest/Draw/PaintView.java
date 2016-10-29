package com.example.yazhai1226.androidtest.Draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by MingRen on 2016/9/14.
 */
public class PaintView extends View {
    public PaintView(Context context) {
        super(context);
    }

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        String a = "";
        p.setAntiAlias(true);
        p.setColor(Color.RED);
        p.setStyle(Paint.Style.STROKE);

        Path path = new Path();
        path.moveTo(10, 10);
        path.lineTo(100, 100);
        path.lineTo(300, 400);
        path.close();
        Rect rect = new Rect(0,0,100, 100);
        canvas.drawRect(rect,p);
        canvas.drawText("哈哈",10,100, p);
    }
}
