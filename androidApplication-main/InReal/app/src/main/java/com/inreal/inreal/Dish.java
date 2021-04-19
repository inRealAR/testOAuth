package com.inreal.inreal;


import com.inreal.inreal.model.DishType;

import java.util.Objects;

public class Dish {
    private String name;
    private String description;
    private String price;
    private int imageId;

    private String calories;
    private String ingredients;
    private DishType type;
    private String weight;
    private int rawForObject;

    public Dish() {
    }

    public Dish(
            String name,
            String description,
            String price,
            int imageId,
            String calories,
            String ingredients,
            DishType type,
            String weight,
            int rawForObject
    ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageId = imageId;
        this.calories = calories;
        this.ingredients = ingredients;
        this.type = type;
        this.weight = weight;
        this.rawForObject = rawForObject;
    }

    public int getRawForObject() {
        return rawForObject;
    }

    public void setRawForObject(int rawForObject) {
        this.rawForObject = rawForObject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public DishType getType() {
        return type;
    }

    public void setType(DishType type) {
        this.type = type;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;
        Dish dish = (Dish) o;
        return getImageId() == dish.getImageId() &&
                getRawForObject() == dish.getRawForObject() &&
                getName().equals(dish.getName()) &&
                getDescription().equals(dish.getDescription()) &&
                getPrice().equals(dish.getPrice()) &&
                getCalories().equals(dish.getCalories()) &&
                getIngredients().equals(dish.getIngredients()) &&
                getType() == dish.getType() &&
                getWeight().equals(dish.getWeight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getPrice(), getImageId(), getCalories(), getIngredients(), getType(), getWeight(), getRawForObject());
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", imageId=" + imageId +
                ", calories='" + calories + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", type=" + type +
                ", weight='" + weight + '\'' +
                ", rawForObject=" + rawForObject +
                '}';
    }
}
