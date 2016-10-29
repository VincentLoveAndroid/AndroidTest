package com.example.yazhai1226.androidtest.view.zhaibaView;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.yazhai1226.androidtest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mingren on 2016/1/14.
 */
public class ChatGiftRechargePopupWindow extends PopupWindow {
    private int[] points = {R.id.iv_point1, R.id.iv_point2, R.id.iv_point3, R.id.iv_point4};//选择提示点
    private List<View> gridViewList;
    private View conentView;
    private int giftPagerCount;//礼物的页数
    private View giftView;//每一页礼物
    /**
     * author:mingren
     * date:2016/1/14 12:24
     * Description:添加PopWindow，传入所在Activity
     */
    public void addPopWindow(final Activity context) {
        conentView = View.inflate(context, R.layout.layout_chat_gift_recharge, null);
        //int h = context.getWindowManager().getDefaultDisplay().getHeight();
        int w = context.getWindowManager().getDefaultDisplay().getWidth();
        // 设置View
        this.setContentView(conentView);
        this.setWidth(w);
        this.setHeight(ActionBar.LayoutParams.WRAP_CONTENT);
        // 设置弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        //        // 实例化一个ColorDrawable颜色为半透明
        //        ColorDrawable dw = new ColorDrawable(0000000000);
        //        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        //        this.setBackgroundDrawable(dw);
        final ViewPager vpChat = (ViewPager) conentView.findViewById(R.id.vp_chat);

        vpChat.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((TextView) conentView.findViewById(R.id.tv_chat_next)).setText("" + (position + 1));
                for (int point : points) {
                    conentView.findViewById(point).setBackgroundResource(R.mipmap.icon_normal_point);
                }
                conentView.findViewById(points[position]).setBackgroundResource(R.mipmap.icon_select_point);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //点击充值按钮
        conentView.findViewById(R.id.tv_chat_recharge).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //点击赠送按钮
        conentView.findViewById(R.id.tv_chat_give).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //点击选择赠送的礼物数量
        conentView.findViewById(R.id.ll_giftNum).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //添加gridView
        gridViewList = new ArrayList<>();
        giftPagerCount = 4;//得到分页数
        for (int i = 0; i < giftPagerCount; i++) {
            giftView = View.inflate(context, R.layout.layout_grid_view, null);
            gridViewList.add(giftView);
        }

        vpChat.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return gridViewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View v = gridViewList.get(position);
                ViewGroup parent = (ViewGroup) v.getParent();
                if (parent != null) {
                    parent.removeAllViews();
                }
                container.addView(v);
                return gridViewList.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(gridViewList.get(position));
            }
        });
        // 刷新状态
        this.update();
    }
}


