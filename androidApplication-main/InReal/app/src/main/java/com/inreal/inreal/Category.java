package com.inreal.inreal;


public class Category {
    public static final Category[] categories = {
            new Category("Салаты и холодные закуски", R.drawable.salad),
            new Category("Супы", R.drawable.soup),
            new Category("Горячие блюда", R.drawable.main_dish),
            new Category("Десерты", R.drawable.dessert),
            new Category("Напитки", R.drawable.drinks)
    };
    private String name;
    private int imageId;

    public Category(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
