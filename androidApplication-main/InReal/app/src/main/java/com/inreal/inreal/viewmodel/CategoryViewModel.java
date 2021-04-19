package com.inreal.inreal.viewmodel;

import android.annotation.SuppressLint;

import androidx.lifecycle.ViewModel;

import com.inreal.inreal.Dish;
import com.inreal.inreal.model.DishType;
import com.inreal.inreal.model.Repository;

import java.util.List;

public class CategoryViewModel extends ViewModel {

    private List<Dish> salads;
    private List<Dish> soups;
    private List<Dish> hotMeals;
    private List<Dish> desserts;
    private List<Dish> drinks;

    private boolean isInitSalads = false;
    private boolean isInitSoups = false;
    private boolean isInitHotMeals = false;
    private boolean isInitDesserts = false;
    private boolean isInitDrinks = false;

    //    private Observable<Dish> asyncLoad(DishType type) {
//        return Observable.create(subscriber -> {
//            List<Dish> list = Repository.getDishesList(type);
//            for(Dish i : list) {
//                subscriber.onNext(i);
//            }
//        });
//
//    }
    private List<Dish> asyncLoad(DishType type) {
        return Repository.getDishesList(type);
    }


    //TODO : 3) write adapter with async load
    //TODO : 4) write repository to fetch from firebase or Room
    @SuppressLint("CheckResult")
    private void init(DishType type) {
        switch (type) {
            case SALADS:
                salads = (asyncLoad(type));
                break;
            case SOUPS:
                soups = (asyncLoad(type));
                break;
            case HOT:
                hotMeals = (asyncLoad(type));
                break;
            case DESSERTS:
                desserts = (asyncLoad(type));
                break;
            default:
                drinks = (asyncLoad(type));
                break;
        }
    }

    public List<Dish> getSalads() {
        if (!isInitSalads) {
            init(DishType.SALADS);
            isInitSalads = true;
        }
        return salads;
    }

    public List<Dish> getSoups() {
        if (!isInitSoups) {
            init(DishType.SOUPS);
            isInitSoups = true;
        }
        return soups;
    }

    public List<Dish> getHotMeals() {
        if (!isInitHotMeals) {
            init(DishType.HOT);
            isInitHotMeals = true;
        }
        return hotMeals;
    }

    public List<Dish> getDesserts() {
        if (!isInitDesserts) {
            init(DishType.DESSERTS);
            isInitDesserts = true;
        }
        return desserts;
    }

    public List<Dish> getDrinks() {
        if (!isInitDrinks) {
            init(DishType.DRINKS);
            isInitDrinks = true;
        }
        return drinks;
    }
}
