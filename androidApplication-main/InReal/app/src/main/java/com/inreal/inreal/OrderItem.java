package com.inreal.inreal;


import java.util.Objects;

public class OrderItem {
    private Dish dish;
    private int countOfDish;
    private int countPrice;

    public OrderItem(Dish dish, int countOfDish) {
        this.dish = dish;
        this.countOfDish = countOfDish;
        this.countPrice = Integer.parseInt(dish.getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem item = (OrderItem) o;
        return getCountOfDish() == item.getCountOfDish() &&
                countPrice == item.countPrice &&
                getDish().equals(item.getDish());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDish(), getCountOfDish(), countPrice);
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getCountOfDish() {
        return countOfDish;
    }

    public void setCountOfDish(int countOfDish) {
        this.countOfDish = countOfDish;
    }

    public void setCountPrice(int countPrice) {
        this.countPrice = countPrice;
    }

    public int getCountPrice() {
        return countPrice;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "dish=" + dish +
                ", countOfDish=" + countOfDish +
                ", countPrice=" + countPrice +
                '}';
    }
}
