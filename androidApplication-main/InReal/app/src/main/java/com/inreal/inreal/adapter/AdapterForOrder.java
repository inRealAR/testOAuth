package com.inreal.inreal.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.inreal.inreal.ClickDish;
import com.inreal.inreal.OrderItem;
import com.inreal.inreal.R;

import java.util.List;

public class AdapterForOrder
        extends RecyclerView.Adapter<AdapterForOrder.ViewHolderForOrder> {

    public List<OrderItem> orderItems;
    private final ClickDish clickDish;
    public AdapterForOrder(List<OrderItem> orderItems, ClickDish clickDish) {
        this.orderItems = orderItems;
        this.clickDish = clickDish;
    }

    @NonNull
    @Override
    public ViewHolderForOrder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.order_card, parent, false);
        return new AdapterForOrder.ViewHolderForOrder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderForOrder holder, int position) {
        CardView cardView = holder.cardView;
        TextView nameOfDish = cardView.findViewById(R.id.order_card_name);
        ImageView imageOfDish = cardView.findViewById(R.id.order_card_picture);
        TextView priceOfDish = cardView.findViewById(R.id.order_card_total_cost);

        TextView count = cardView.findViewById(R.id.order_card_count);

        OrderItem currentItem = orderItems.get(position);

        count.setText((Integer.valueOf(currentItem.getCountOfDish())).toString());
        priceOfDish.setText((Integer.valueOf(currentItem.getCountPrice())).toString());

        nameOfDish.setText(currentItem.getDish().getName());
        imageOfDish.setImageResource(currentItem.getDish().getImageId());


        ImageView plus = cardView.findViewById(R.id.order_card_plus);
        ImageView minus = cardView.findViewById(R.id.order_card_minus);

        plus.setOnClickListener(v -> {
            Log.e("AdapterForOrder", "PLUSPLUSPLUSPLUSPLUSPLUSPLUSPLUSPLUSPLUSPLUSPLUSPLUSPLUS");
            clickDish.onPlusClickListener(currentItem);
            count.setText((Integer.valueOf(currentItem.getCountOfDish())).toString());
            priceOfDish.setText((Integer.valueOf(currentItem.getCountPrice())).toString());
            notifyDataSetChanged();
        });

        minus.setOnClickListener(v ->
        {
            clickDish.onMinusClickListener(currentItem);
            if (currentItem != null) {
                count.setText((Integer.valueOf(currentItem.getCountOfDish())).toString());
                priceOfDish.setText((Integer.valueOf(currentItem.getCountPrice())).toString());
            }
            Log.e("AdapterForOrder", orderItems.toString());
            notifyDataSetChanged();
        });

        ImageView delete = cardView.findViewById(R.id.order_card_delete);
        delete.setOnClickListener(v -> {
            clickDish.onDeleteClickListener(currentItem);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return orderItems.size();
    }

    public class ViewHolderForOrder extends RecyclerView.ViewHolder {
        private final CardView cardView;

        public ViewHolderForOrder(CardView cv) {
            super(cv);
            cardView = cv;
        }
    }
}
