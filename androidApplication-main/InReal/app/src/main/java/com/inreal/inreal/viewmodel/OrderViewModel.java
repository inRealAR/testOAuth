package com.inreal.inreal.viewmodel;

import android.app.Notification;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.inreal.inreal.Dish;
import com.inreal.inreal.OrderItem;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OrderViewModel extends ViewModel {

    private final MutableLiveData<List<OrderItem>> _listDishes = new MutableLiveData<>();
    public final LiveData<List<OrderItem>> listDishes = _listDishes;

    {
        _listDishes.setValue(new ArrayList<>());
    }


    private void addToOrderList(OrderItem item) {
        item.setCountOfDish(1);
        _listDishes.getValue().add(item);
    }

    public void increment(OrderItem item) {
        if(_listDishes.getValue().isEmpty()) {
            addToOrderList(item);
        }
        else {
            boolean isFind = false;
            for(OrderItem itemToFind : _listDishes.getValue()) {
                if(itemToFind.getDish().equals(item.getDish())) {
                    isFind = true;
                    int defaultPrice = itemToFind.getCountPrice() / itemToFind.getCountOfDish();
                    int currentCount = itemToFind.getCountOfDish() + 1;
                    itemToFind.setCountOfDish(currentCount);
                    itemToFind.setCountPrice(defaultPrice * currentCount);
                    break;
                }
            }
            if(!isFind) {
                addToOrderList(item);
            }
        }
    }

    public void delete(OrderItem item) {
        Log.e("OrderViewModel_DELETE", item.getDish().getName());
        _listDishes.getValue().remove(item);
    }

    public void decrement(OrderItem item) {
        Log.e("OrderViewModel", item.getDish().getName());
        if(item.getCountOfDish() == 1) {
            delete(item);
        } else {
            int defaultPrice = item.getCountPrice() / item.getCountOfDish();
            int currentCount = item.getCountOfDish() - 1;
            item.setCountOfDish(currentCount);
            item.setCountPrice(defaultPrice * currentCount);
        }
    }

    public LiveData<List<OrderItem>> getListDishes() {
        return listDishes;
    }
}
