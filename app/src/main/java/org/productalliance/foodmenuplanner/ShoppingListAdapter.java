package org.productalliance.foodmenuplanner;

import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ShoppingListViewHolder> {

    private ArrayList<ShoppingListItem> mShoppingList;

    public ShoppingListAdapter(ArrayList<ShoppingListItem> shoppingList) {
        mShoppingList = shoppingList;
    }

    @NonNull
    @Override
    public ShoppingListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_list_view_layout, parent, false);
        return new ShoppingListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingListViewHolder holder, int position) {
        ShoppingListItem currentItem = mShoppingList.get(position);
        holder.itemQtyTextView.setText(currentItem.getItemQty());
        holder.qtyMeasureTextView.setText(currentItem.getQtyMeasure());
        holder.shoppingListItemTextView.setText(currentItem.getItemName());
    }

    @Override
    public int getItemCount() {
        return mShoppingList.size();
    }


    public static class ShoppingListViewHolder extends RecyclerView.ViewHolder {

        public CheckBox shoppingListCheckBox;
        public TextView itemQtyTextView;
        public TextView qtyMeasureTextView;
        public TextView shoppingListItemTextView;

        public ShoppingListViewHolder(@NonNull View itemView) {
            super(itemView);

            shoppingListCheckBox = itemView.findViewById(R.id.shoppingListCheckBox);
            itemQtyTextView = itemView.findViewById(R.id.itemQtyTextView);
            qtyMeasureTextView = itemView.findViewById(R.id.qtyMeasureTextView);
            shoppingListItemTextView = itemView.findViewById(R.id.shoppingListItemTextView);

            shoppingListCheckBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (shoppingListCheckBox.isChecked()) {
                        itemQtyTextView.setTextColor(Color.GRAY);
                        itemQtyTextView.setPaintFlags(itemQtyTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                        qtyMeasureTextView.setTextColor(Color.GRAY);
                        qtyMeasureTextView.setPaintFlags(qtyMeasureTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                        shoppingListItemTextView.setTextColor(Color.GRAY);
                        shoppingListItemTextView.setPaintFlags(shoppingListItemTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    } else {
                        itemQtyTextView.setTextColor(Color.BLACK);
                        itemQtyTextView.setPaintFlags(itemQtyTextView.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
                        qtyMeasureTextView.setTextColor(Color.BLACK);
                        qtyMeasureTextView.setPaintFlags(qtyMeasureTextView.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
                        shoppingListItemTextView.setTextColor(Color.BLACK);
                        shoppingListItemTextView.setPaintFlags(shoppingListItemTextView.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
                    }
                }
            });
        }
    }
}