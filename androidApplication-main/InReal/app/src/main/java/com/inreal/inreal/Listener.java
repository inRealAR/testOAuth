package com.inreal.inreal;

import android.view.View;

public interface Listener {
    void onClickForScan();
    void onClickCategory(String nameOfCategory);
    void onClickDish(String nameOfDish);
    void onClickButtonSeeInARListener();
    void onClickButtonChooseToOrder(Dish dish);
}
