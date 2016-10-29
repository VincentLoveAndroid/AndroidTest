package com.example.yazhai1226.androidtest.view.zhaibaView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by MingRen on 2016/8/16.
 */
public class RecycleViewAdpater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;

    public RecycleViewAdpater(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView textView = new TextView(context);
        textView.setText("哈哈");
        return new MyViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 30;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

}
