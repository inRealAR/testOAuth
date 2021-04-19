package com.inreal.inreal.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.inreal.inreal.Dish;
import com.inreal.inreal.Listener;
import com.inreal.inreal.R;

public class DetailedDishFragment extends Fragment {

    public static Dish dish;
    private final Listener listener;

    public DetailedDishFragment(Listener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detailed_dish_fagment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView nameOfDish = getView().findViewById(R.id.detailed_card_for_dish_name_text_view);
        TextView kbguOfDish = getView().findViewById(R.id.detailed_card_for_dish_kbgu_text_view);
        ImageView pictureOfDish = getView().findViewById(R.id.detailed_card_for_dish_picture);
        TextView ingredientsOfDish = getView().findViewById(R.id.detailed_card_for_dish_ingridients_text_view);
        TextView priceOfDish = getView().findViewById(R.id.detailed_card_for_dish_price_text_view);

        nameOfDish.setText(dish.getName());
        kbguOfDish.setText(dish.getCalories());
        pictureOfDish.setImageResource(dish.getImageId());
        ingredientsOfDish.setText(dish.getIngredients());
        priceOfDish.setText(String.format("%s/%s", dish.getWeight(), dish.getPrice()));

        Button seeInAR = getView().findViewById(R.id.detailed_card_for_dish_button_see_in_ar);
        seeInAR.setOnClickListener(v -> listener.onClickButtonSeeInARListener());

        Button chooseToOrder = getView().findViewById(R.id.detailed_card_for_dish_button_for_choice);
        chooseToOrder.setOnClickListener(v -> listener.onClickButtonChooseToOrder(dish));
    }
}