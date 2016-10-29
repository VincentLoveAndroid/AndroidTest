package com.example.yazhai1226.androidtest.view.zhaibaView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.yazhai1226.androidtest.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mingren on 2016/1/13.
 */
public class LineGridView extends GridView {
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;
    // private int[] points = {R.id.iv_point1, R.id.iv_point2, R.id.iv_point3, R.id.iv_point4};//选择提示点
    //根据后来传来的是一图片还是图片加文字进行适配
    private int[] icon = {R.mipmap.icon_gift_test, R.mipmap.icon_gift_test, R.mipmap.icon_gift_test, R.mipmap.icon_gift_test,
            R.mipmap.icon_gift_test, R.mipmap.icon_gift_test, R.mipmap.icon_gift_test, R.mipmap.icon_gift_test, R.mipmap.
            icon_gift_test, R.mipmap.icon_gift_test};

    //    private String[] iconName = {"50寨币", "300棒棒糖", "50寨币", "300棒棒糖", "100棒棒糖", "300棒棒糖", "50寨币",
    //            "10橙钻", "100橙钻", "200橙钻"};
    public LineGridView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        init();
    }

    public LineGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LineGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        //        //得到每一项
        //        View localView1 = getChildAt(0);
        //        //得到列数
        //        int column = getWidth() / localView1.getWidth();
        //得到item数
        int childCount = getChildCount();
        //设置画笔
        Paint localPaint;
        localPaint = new Paint();
        localPaint.setStyle(Paint.Style.STROKE);
        localPaint.setColor(Color.rgb(237, 237, 237));
        //按照设计要求绘制边框线
        for (int i = 0; i < childCount; i++) {
            View cellView = getChildAt(i);
            if (i == 0 || i == 1 || i == 2 || i == 3) {//绘制每个格子下边一横和右边一竖
                canvas.drawLine(cellView.getLeft(), cellView.getBottom(), cellView.getRight(), cellView.getBottom(), localPaint);
                canvas.drawLine(cellView.getRight(), cellView.getBottom(), cellView.getRight(), cellView.getTop(), localPaint);
            } else if (i == 4) {//该格子下边一横
                canvas.drawLine(cellView.getLeft(), cellView.getBottom(), cellView.getRight(), cellView.getBottom(), localPaint);
            } else if (i == 5 || i == 6 || i == 7 || i == 8) {//绘制每个格子的右边一竖
                canvas.drawLine(cellView.getRight(), cellView.getBottom(), cellView.getRight(), cellView.getTop(), localPaint);
            }
        }

        //绘制选中的框
        localPaint.setColor(Color.rgb(254, 102, 1));
        localPaint.setStrokeWidth(2);
        for (int i = 0; i < childCount; i++) {
            View cellView2 = getChildAt(i);
            if (cellView2.isSelected()) {
                canvas.drawLine(cellView2.getLeft(), cellView2.getTop(), cellView2.getLeft(), cellView2.getBottom(), localPaint);
                canvas.drawLine(cellView2.getLeft(), cellView2.getBottom(), cellView2.getRight(), cellView2.getBottom(), localPaint);
                canvas.drawLine(cellView2.getRight(), cellView2.getBottom(), cellView2.getRight(), cellView2.getTop(), localPaint);
                canvas.drawLine(cellView2.getRight(), cellView2.getTop(), cellView2.getLeft(), cellView2.getTop(), localPaint);
            }
        }
    }

    /**
     * 获取数据
     */
    public List<Map<String, Object>> getData() {
        //cion和iconName的长度是相同的，这里任选其一都可以
        for (int i = 0; i < icon.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            //map.put("text", iconName[i]);
            data_list.add(map);
        }
        return data_list;
    }

    /**
     * author:mingren
     * date:2016/1/14 12:03
     * Description:初始化数据，设置适配器和item点击监听
     */
    public void init() {
        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        //        String[] from = {"image", "text"};
        //        int[] to = {R.id.iv_image, R.id.tv_text};
        String[] from = {"image"};
        int[] to = {R.id.iv_image};
        sim_adapter = new SimpleAdapter(getContext(), data_list, R.layout.layout_chat_recharge_git_item, from, to);
        //配置适配器
        this.setAdapter(sim_adapter);
        this.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), position + "", Toast.LENGTH_SHORT).show();
                Log.d("mingren", " 是否选中" + view.isSelected());
                view.setSelected(true);//手动设置选中状态
                invalidate();
            }
        });
    }
}