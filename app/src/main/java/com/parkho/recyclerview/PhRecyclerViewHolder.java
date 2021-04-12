package com.parkho.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.parkho.recyclerview.PhRecyclerViewAdapter.OnImageItemClickEventListener;
import com.parkho.recyclerview.PhRecyclerViewAdapter.OnItemClickEventListener;
import com.parkho.recyclerview.PhRecyclerViewAdapter.OnItemLongClickEventListener;

public class PhRecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView tvName;
    ImageView ivIcon;

    public PhRecyclerViewHolder(View a_itemView,
                                final OnItemClickEventListener a_itemClickListener,
                                final OnItemLongClickEventListener a_itemLongClickListener,
                                final OnImageItemClickEventListener a_imageItemClickListener) {
        super(a_itemView);

        tvName = a_itemView.findViewById(R.id.tv_name);
        ivIcon = a_itemView.findViewById(R.id.iv_icon);

        // Image click event
        ivIcon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View a_view) {
                final int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    a_imageItemClickListener.onImageItemClick(position);
                }
            }
        });

        // Click event
        a_itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a_view) {
                final int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    a_itemClickListener.onItemClick(a_view, position);
                }
            }
        });

        // long Click event
        a_itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View a_view) {
                final int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    a_itemLongClickListener.onItemLongClick(a_view, position);
                }

                return true;
            }
        });
    }

}