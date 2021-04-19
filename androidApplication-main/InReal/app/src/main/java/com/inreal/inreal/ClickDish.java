package com.inreal.inreal;

public interface ClickDish {
    void increment(OrderItem item);

    void decrement(OrderItem item);

    void onPlusClickListener(OrderItem orderItem);

    void onMinusClickListener(OrderItem orderItem);

    void onDeleteClickListener(OrderItem orderItem);
}
