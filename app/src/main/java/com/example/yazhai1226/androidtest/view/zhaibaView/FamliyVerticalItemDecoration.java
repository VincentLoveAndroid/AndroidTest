package com.example.yazhai1226.androidtest.view.zhaibaView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Created by MingRen on 2016/7/27.
 */
public class FamliyVerticalItemDecoration extends RecyclerView.ItemDecoration {
    private Context context;
    private Xfermode xfermode;

    public FamliyVerticalItemDecoration(Context context) {
        super();
        this.context = context;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.top = 20;
        outRect.left = 0;
        outRect.bottom = 0;
        outRect.right = 0;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        int top = parent.getTop();
        System.out.println("top" + top);
        int left = parent.getLeft();
        int Right = left + parent.getWidth();
        int bottom = top + 20;
        int colorFrom = Color.parseColor("#FFF2DDCE");
        int colorTo = Color.parseColor("#00ffffff");
        Paint p = new Paint();
        int i = Color.parseColor("#4D000000");
        LinearGradient lg = new LinearGradient(0, -5, 0, 10,Color.TRANSPARENT,Color.TRANSPARENT, Shader.TileMode.CLAMP);
        p.setShader(lg);
        xfermode = new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY);
        p.setXfermode(xfermode);
        c.drawRect(0, 0, parent.getWidth(), 10, p);
        System.out.println("onDrawOver");

    }
}
