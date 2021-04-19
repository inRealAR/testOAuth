package com.inreal.inreal.adapter;

import androidx.recyclerview.widget.DiffUtil;

import com.inreal.inreal.OrderItem;

import java.util.List;

public class DiffUtils extends DiffUtil.Callback {

    private final List<OrderItem> oldList;
    private final List<OrderItem> newList;
    public DiffUtils(List<OrderItem> oldList, List<OrderItem> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition)) &&
                (oldItemPosition == newItemPosition);
    }
}
