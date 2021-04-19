package com.inreal.inreal.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.inreal.inreal.Category;
import com.inreal.inreal.Listener;
import com.inreal.inreal.R;
import com.inreal.inreal.adapter.AdapterForMenu;

import java.util.ArrayList;

public class TopFragment extends Fragment {
    Listener listener;

    public TopFragment(Listener listener) {this.listener = listener;}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView view = (RecyclerView) inflater.inflate(R.layout.fragment_top, container, false);
        ArrayList<Category> categories = new ArrayList<>();
        for (int i = 0; i < Category.categories.length; ++i) {
            String name = Category.categories[i].getName();
            int imageId = Category.categories[i].getImageId();
            Category c = new Category(name, imageId);
            categories.add(c);
        }

        AdapterForMenu adapter = new AdapterForMenu(categories, listener);
        view.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        view.setLayoutManager(layoutManager);
        return view;
    }
}
