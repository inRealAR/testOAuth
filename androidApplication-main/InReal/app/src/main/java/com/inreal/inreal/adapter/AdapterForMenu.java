package com.inreal.inreal.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.inreal.inreal.Category;
import com.inreal.inreal.Listener;
import com.inreal.inreal.R;

import java.util.ArrayList;

public class AdapterForMenu extends RecyclerView.Adapter<AdapterForMenu.ViewHolderCategories> {
    ArrayList<Category> categories;
    Listener listener;

    public AdapterForMenu(ArrayList<Category> categories, Listener listener) {
        this.categories = categories;
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    @Override
    public ViewHolderCategories onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_for_fragment_categories, parent, false);
        return new ViewHolderCategories(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolderCategories holder, int position) {
        CardView cardView = holder.cardView;
        cardView.setOnClickListener(v -> listener.onClickCategory(categories.get(position).getName()));
        ConstraintLayout layout = (ConstraintLayout) cardView.findViewById(R.id.card_category_layout);
        ImageView imageView = (ImageView) layout.findViewById(R.id.card_category_picture);
        TextView textView = (TextView) layout.findViewById(R.id.card_category_name_text_view);

        imageView.setImageResource(categories.get(position).getImageId());
        textView.setText(categories.get(position).getName());
    }

    public static class ViewHolderCategories extends RecyclerView.ViewHolder {
        private final CardView cardView;

        public ViewHolderCategories(CardView v) {
            super(v);
            cardView = v;
        }
    }
}
