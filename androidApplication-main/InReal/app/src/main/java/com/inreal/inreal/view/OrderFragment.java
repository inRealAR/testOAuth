package com.inreal.inreal.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.inreal.inreal.ClickDish;
import com.inreal.inreal.OrderItem;
import com.inreal.inreal.R;
import com.inreal.inreal.adapter.AdapterForOrder;
import com.inreal.inreal.adapter.DiffUtils;

import java.util.List;

public class OrderFragment extends Fragment {

    public ClickDish clickDish;
    public List<OrderItem> orderItems;
    public AdapterForOrder adapterForOrder = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        RecyclerView view = (RecyclerView) inflater.inflate(R.layout.fragment_for_order, container, false);

        if (adapterForOrder == null) {
            adapterForOrder = new AdapterForOrder(orderItems, clickDish);
        }

        view.setAdapter(adapterForOrder);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        view.setLayoutManager(layoutManager);
        return view;
    }

    public void update(List<OrderItem> orderItems) {
        if (adapterForOrder == null) {
            adapterForOrder = new AdapterForOrder(orderItems, clickDish);
        }
        DiffUtil.DiffResult diff = DiffUtil.calculateDiff(new DiffUtils(adapterForOrder.orderItems, orderItems));
        adapterForOrder.orderItems = orderItems;
        diff.dispatchUpdatesTo(adapterForOrder);
    }
}