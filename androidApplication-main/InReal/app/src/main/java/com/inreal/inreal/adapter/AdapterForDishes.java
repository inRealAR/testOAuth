package com.inreal.inreal.adapter;


import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.inreal.inreal.Dish;
import com.inreal.inreal.Listener;
import com.inreal.inreal.R;
import com.inreal.inreal.model.DishType;

import java.util.List;

public class AdapterForDishes extends RecyclerView.Adapter<AdapterForDishes.ViewHolderDishes> {

    public static List<Dish> dishes;
    public static DishType type;
    private final Listener listener;
    public AdapterForDishes(Listener listener) {
        this.listener = listener;
    }

    public static List<Dish> getDishes() {
        return dishes;
    }

    @NonNull
    @Override
    public AdapterForDishes.ViewHolderDishes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_for_dish, parent, false);
        return new AdapterForDishes.ViewHolderDishes(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterForDishes.ViewHolderDishes holder, int position) {
        Dish currentDish = dishes.get(position);
        CardView cardView = holder.cardView;
        cardView.setOnClickListener(v -> listener.onClickDish(currentDish.getName()));
        LinearLayout layout = cardView.findViewById(R.id.card_for_dish_layout);
        ImageView image = layout.findViewById(R.id.card_for_dish_picture);
        CardView innerCardView = layout.findViewById(R.id.card_for_dish_card_for_description);
        TextView title = innerCardView.findViewById(R.id.card_for_dish_name_text_view);
        TextView description = innerCardView.findViewById(R.id.card_for_dish_description_text_view);
        TextView price = innerCardView.findViewById(R.id.card_for_dish_price_text_view);

        Button chooseForOrder = innerCardView.findViewById(R.id.card_for_dish_button_for_choice);
        chooseForOrder.setOnClickListener(v -> listener.onClickButtonChooseToOrder(currentDish));

        image.setImageResource(currentDish.getImageId());
        title.setText(currentDish.getName());
        description.setText(currentDish.getDescription());
        price.setText(currentDish.getPrice());
    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }

    public static class ViewHolderDishes extends RecyclerView.ViewHolder {
        private final CardView cardView;

        public ViewHolderDishes(@NonNull CardView itemView) {
            super(itemView);
            cardView = itemView;
        }
    }
}
