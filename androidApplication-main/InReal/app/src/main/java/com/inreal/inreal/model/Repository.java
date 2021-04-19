package com.inreal.inreal.model;

import com.inreal.inreal.Dish;
import com.inreal.inreal.R;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    static List<Dish> listSalads = new ArrayList<>();
    static List<Dish> listSoups = new ArrayList<>();
    static List<Dish> listHotMeals = new ArrayList<>();
    static List<Dish> listDesserts = new ArrayList<>();
    static List<Dish> listDrinks = new ArrayList<>();

    static {
        listSalads.add(new Dish(
                "Салат",
                "Листья, листья в\nсоке листьев",
                "250",
                R.drawable.standart_salad,
                "КБЖУ",
                "Листья салата",
                DishType.SALADS,
                "100 Г",
                R.raw.standart_salad));

        listSalads.add(new Dish(
                "Картофельный салат",
                "Вкусный салат с\nкартофелем, морковкой и ветчиной",
                "350",
                R.drawable.potato_salad,
                "КБЖУ",
                "Картофель, морковь, ветчина, майонез",
                DishType.SALADS,
                "350 Г",
                R.raw.potato_salad));

        listSoups.add(new Dish(
                "Кремовый суп",
                "Потрясающий кремовый\nсуп",
                "150",
                R.drawable.krem_soup,
                "КБЖУ",
                "Крем, сухарики",
                DishType.SOUPS,
                "300 Г",
                R.raw.krem_soup));

        listSoups.add(new Dish(
                "Том Ям",
                "Острый пан-\nазиатский суп",
                "450",
                R.drawable.tom_yam,
                "КБЖУ",
                "Лапша, яйцо, грибы",
                DishType.SOUPS,
                "560 Г",
                R.raw.tom_yam));

        listDrinks.add(new Dish(
                "Каппучино",
                "Нежный сливочный латте",
                "130",
                R.drawable.cappuccino,
                "КБЖУ",
                "Кофеин, сливки, молоко",
                DishType.DRINKS,
                "310 Г",
                R.raw.capuccino));

        listDrinks.add(new Dish(
                "Кофе",
                "Вкуснейшее кофе",
                "100",
                R.drawable.coffee,
                "КБЖУ",
                "Кофеин",
                DishType.DRINKS,
                "300 Г",
                R.raw.coffee));

        listDrinks.add(new Dish(
                "Черный чай",
                "Вкуснейший чай",
                "70",
                R.drawable.tea,
                "КБЖУ",
                "Лапсанх Сушонг",
                DishType.DRINKS,
                "300 Г",
                R.raw.tea));

        listDesserts.add(new Dish(
                "Воздушный торт",
                "Нежное безе и шоколад\nс вишней и черникой",
                "1000",
                R.drawable.bisquit_cake,
                "КБЖУ",
                "Шоколад, крем, черника, вишня, сливки",
                DishType.DESSERTS,
                "1000 Г",
                R.raw.bisquit_cake));

        listDesserts.add(new Dish(
                "Шоколадный торт",
                "Вкусный многослойный\nторт",
                "400",
                R.drawable.piece_of_the_cake,
                "КБЖУ",
                "Шоколад, крем, вишня",
                DishType.DESSERTS,
                "500 Г",
                R.raw.piece_of_the_cake));

        listDesserts.add(new Dish(
                "Шоколадный пудинг",
                "Шоколадный пудинг\nсо сладкими вишенками",
                "300",
                R.drawable.pudding,
                "КБЖУ",
                "Шоколад, вишня",
                DishType.DESSERTS,
                "600 Г",
                R.raw.pudding));

        listHotMeals.add(new Dish(
                "Чизбургер",
                "Американский чизбургер\nс тремя видами сыра",
                "200",
                R.drawable.cheeseburger,
                "КБЖУ",
                "Котлета, сыры, салат, помидор",
                DishType.HOT,
                "700 Г",
                R.raw.cheeseburger));

        listHotMeals.add(new Dish(
                "Пицца",
                "Американская пицца\nс острым чоризо",
                "400",
                R.drawable.pizza,
                "КБЖУ",
                "Колбаса, сыр, кетчуп",
                DishType.HOT,
                "1000 Г",
                R.raw.pizza));

        listHotMeals.add(new Dish(
                "Курица с картошкой",
                "Целая курица\nс вкусной картошкой",
                "800",
                R.drawable.chicken_mit_potato,
                "КБЖУ",
                "Курица, картошка",
                DishType.HOT,
                "1500 Г",
                R.raw.chicken_mit_potato));

        listHotMeals.add(new Dish(
                "Крылышки",
                "Куриные крылышки\nс укропом",
                "400",
                R.drawable.chicken_wings,
                "КБЖУ",
                "Курица, укроп",
                DishType.HOT,
                "500 Г",
                R.raw.chicken_wings));


    }


    static public List<Dish> getDishesList(DishType type) {
        switch (type) {
            case SALADS:
                return listSalads;
            case SOUPS:
                return listSoups;
            case HOT:
                return listHotMeals;
            case DESSERTS:
                return listDesserts;
            default:
                return listDrinks;
        }
    }
}
