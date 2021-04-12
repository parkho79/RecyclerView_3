package com.parkho.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class PhRecyclerViewAdapter extends RecyclerView.Adapter<PhRecyclerViewHolder> {

    // Item click event 를 위한 listener
    public interface OnItemClickEventListener {
        void onItemClick(View a_view, int a_position);
    }

    // Item long click event 를 위한 listener
    public interface OnItemLongClickEventListener {
        void onItemLongClick(View a_view, int a_position);
    }

    // Item click event 를 위한 listener
    public interface OnImageItemClickEventListener {
        void onImageItemClick(int a_position);
    }

    private List<PhRecyclerItem> mItemList;

    private OnItemClickEventListener mItemClickListener;
    private OnItemLongClickEventListener mItemLongClickListener;
    private OnImageItemClickEventListener mImageItemClickListener;

    public PhRecyclerViewAdapter(List<PhRecyclerItem> a_list) {
        mItemList = a_list;
    }

    @Override
    public PhRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup a_viewGroup, int a_position) {
        View view = LayoutInflater.from(a_viewGroup.getContext()).inflate(R.layout.content_recycler_item, a_viewGroup, false);
        return new PhRecyclerViewHolder(view, mItemClickListener, mItemLongClickListener, mImageItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PhRecyclerViewHolder a_viewHolder, int a_position) {
        final PhRecyclerItem item = mItemList.get(a_position);

        a_viewHolder.ivIcon.setImageResource(item.getImageResId());
        a_viewHolder.tvName.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public void setOnItemClickListener(OnItemClickEventListener a_listener) {
        mItemClickListener = a_listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickEventListener a_listener) {
        mItemLongClickListener = a_listener;
    }

    public void setImageItemClickListener(OnImageItemClickEventListener a_listener) {
        mImageItemClickListener = a_listener;
    }
}