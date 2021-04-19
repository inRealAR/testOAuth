package com.inreal.inreal;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.inreal.inreal.adapter.AdapterForDishes;
import com.inreal.inreal.model.DishType;
import com.inreal.inreal.view.CategoryFragment;
import com.inreal.inreal.view.DetailedDishFragment;
import com.inreal.inreal.view.OrderFragment;
import com.inreal.inreal.view.QrFragment;
import com.inreal.inreal.view.TopFragment;
import com.inreal.inreal.viewmodel.CategoryViewModel;
import com.inreal.inreal.viewmodel.OrderViewModel;

public class MainActivity extends AppCompatActivity implements Listener{
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    TopFragment fragmentTop;
    CategoryFragment fragmentCategory;
    DetailedDishFragment fragmentDetailedDish;
    OrderFragment fragmentOrder;
    Fragment fragmentQr;
    CategoryViewModel categoryViewModel;
    OrderViewModel orderViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTop = new TopFragment(this);
        fragmentCategory = new CategoryFragment(this);
        fragmentDetailedDish = new DetailedDishFragment(this);

        fragmentOrder = new OrderFragment();
        fragmentQr = new QrFragment(this);
        fragmentTransaction.add(R.id.activity_main_container, fragmentQr);
        fragmentTransaction.commit();
    }

    @Override
    protected void onResume() {
        initOrderFragmentView();
        initObservers();
        super.onResume();
    }

    private void initObservers() {
        orderViewModel.getListDishes().observe(this, v ->
                fragmentOrder.update(orderViewModel.getListDishes().getValue()));
    }

    private void initOrderFragmentView() {
        fragmentOrder.clickDish = new ClickDish() {
            @Override
            public void increment(OrderItem item) {
                orderViewModel.increment(item);
            }

            @Override
            public void decrement(OrderItem item) {
                orderViewModel.decrement(item);
            }

            @Override
            public void onPlusClickListener(OrderItem orderItem) {
                increment(orderItem);
            }

            @Override
            public void onMinusClickListener(OrderItem orderItem) {
                decrement(orderItem);
            }

            @Override
            public void onDeleteClickListener(OrderItem orderItem) { orderViewModel.delete(orderItem); }
        };
    }

    public void onClickForScan() {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_main_container, fragmentTop);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void onClickCategory(String nameOfCategory) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (nameOfCategory) {
            case "Салаты и холодные закуски":
                AdapterForDishes.type = DishType.SALADS;
                AdapterForDishes.dishes = categoryViewModel.getSalads();
                break;
            case "Супы":
                AdapterForDishes.type = DishType.SOUPS;
                AdapterForDishes.dishes = categoryViewModel.getSoups();
                break;
            case "Горячие блюда":
                AdapterForDishes.type = DishType.HOT;
                AdapterForDishes.dishes = categoryViewModel.getHotMeals();
                break;
            case "Десерты":
                AdapterForDishes.type = DishType.DESSERTS;
                AdapterForDishes.dishes = categoryViewModel.getDesserts();
                break;
            case "Напитки":
                AdapterForDishes.type = DishType.DRINKS;
                AdapterForDishes.dishes = categoryViewModel.getDrinks();
                break;
        }
        fragmentTransaction.replace(R.id.activity_main_container, fragmentCategory);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void onClickDish(String nameOfDish) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();

        for (Dish i : AdapterForDishes.getDishes()) {
            if (i.getName().equals(nameOfDish)) {
                DetailedDishFragment.dish = i;
                break;
            }
        }
        fragmentTransaction.replace(R.id.activity_main_container, fragmentDetailedDish);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onClickButtonSeeInARListener() {
        Intent intent = new Intent(MainActivity.this, ARFoundation.class);
        int rawForObject = DetailedDishFragment.dish.getRawForObject();
        intent.putExtra("rawForObject", rawForObject);
        startActivity(intent);
    }

    @Override
    public void onClickButtonChooseToOrder(Dish dish) {
        orderViewModel.increment(new OrderItem(dish, 1));

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_main_container, fragmentOrder);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}