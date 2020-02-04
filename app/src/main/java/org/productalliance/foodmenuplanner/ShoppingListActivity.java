package org.productalliance.foodmenuplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.util.ArrayList;

public class ShoppingListActivity extends AppCompatActivity {

    private ImageView NavBtn;
    private TextView MenuNav;
    private Button shoppingIncreaseBtn;
    private TextView shoppingCounterTextView;
    private Button shoppingDecreaseBtn;
    private int mInteger = 0;
    private RecyclerView shoppingListRecyclerView;
    private ShoppingListAdapter shoppingAdapter;
    private RecyclerView.LayoutManager shoppingLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        NavBtn = findViewById(R.id.NavBtn);
        MenuNav = findViewById(R.id.MenuNav);
        shoppingIncreaseBtn = findViewById(R.id.shoppingIncreaseBtn);
        shoppingCounterTextView = findViewById(R.id.shoppingCounterTextView);
        shoppingDecreaseBtn = findViewById(R.id.shoppingDecreaseBtn);

        NavBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        MenuNav.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //counter behaviour
        shoppingIncreaseBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mInteger = mInteger + 1;
                shoppingCounterTextView.setText("" + mInteger);
            }
        });

        shoppingDecreaseBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInteger > 0) {
                    mInteger = mInteger - 1;
                    shoppingCounterTextView.setText("" + mInteger);
                } else {
                    shoppingCounterTextView.setText(getResources().getString(R.string.integer_text_view));
                }
            }
        });

        //recycler view for shopping list information
        ArrayList<ShoppingListItem> shoppingList = new ArrayList<>();
        shoppingList.add(new ShoppingListItem("500", "gms", "Potatoes"));
        shoppingList.add(new ShoppingListItem("1", "kg", "Aata"));
        shoppingList.add(new ShoppingListItem("1", "bunch", "Mint Leaves"));
        shoppingList.add(new ShoppingListItem("1", "null", "Coconut"));
        shoppingList.add(new ShoppingListItem("100", "gms", "Green Chillies"));
        shoppingList.add(new ShoppingListItem("100", "gms", "Turmeric Powder"));
        shoppingList.add(new ShoppingListItem("75", "gms", "Curd"));
        shoppingList.add(new ShoppingListItem("500", "gms", "Oranges"));


        shoppingListRecyclerView = findViewById(R.id.shoppingListRecyclerView);
        shoppingLayoutManager = new LinearLayoutManager(this);
        shoppingAdapter = new ShoppingListAdapter(shoppingList);

        shoppingListRecyclerView.setLayoutManager(shoppingLayoutManager);
        shoppingListRecyclerView.setAdapter(shoppingAdapter);
    }
}
