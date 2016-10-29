package com.example.yazhai1226.androidtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by MingRen on 2016/2/2.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
    private Context context;

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void OnItemClick(View v, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public GalleryAdapter(Context context) {
        this.context = context;
    }

    /**
     * 创建ViewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_recycler_view, null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.mImg = (ImageView) view.findViewById(R.id.id_index_gallery_item_image);
        viewHolder.mTxt = (TextView) view.findViewById(R.id.id_index_gallery_item_text);
        return viewHolder;
    }

    /**
     * 设置值
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTxt.setText("哈哈" + position);
        holder.mImg.setBackgroundResource(R.mipmap.ic_launcher);
        //如果设置了点击事件
        if (onItemClickListener != null) {
            holder.mImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.OnItemClick(v, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        ImageView mImg;
        TextView mTxt;
    }
}