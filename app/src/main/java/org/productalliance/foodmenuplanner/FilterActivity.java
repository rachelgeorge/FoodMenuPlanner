package org.productalliance.foodmenuplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class FilterActivity extends AppCompatActivity {

    private Button shoppingListBtn;
    private Switch vegSwitch;
    private ImageView closeFilterBtn;
    private RecyclerView filterRecyclerView;
    private FilterListAdapter filterAdapter;
    private RecyclerView.LayoutManager filterLayoutManager;
    private Button applyFilterBtn;
    private Button removeFilterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        shoppingListBtn = findViewById(R.id.shoppingListBtn);
        vegSwitch = findViewById(R.id.vegSwitch);
        closeFilterBtn = findViewById(R.id.closeFilterBtn);
        applyFilterBtn = findViewById(R.id.applyFilterBtn);
        removeFilterBtn = findViewById(R.id.removeFilterBtn);

        shoppingListBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shoppingIntent = new Intent(FilterActivity.this, ShoppingListActivity.class);
                startActivity(shoppingIntent);
            }
        });

        vegSwitch.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((Switch) v).isChecked();
                if (on) {
                    //select all non-veg items in filter list
                } else {
                    //select only those items that user clicks on
                }
            }
        });

        //if switch is toggled from home page, it has to be toggled in filter page too
        //code to auto-select all non-veg items in filter if switch is toggled from Main Activity
        //code to detect switch state

        closeFilterBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent closeFilterIntent = new Intent(FilterActivity.this, MainActivity.class);
                startActivity(closeFilterIntent);
            }
        });

        ArrayList<FilterItem> filterList = new ArrayList<>();
        filterList.add(new FilterItem("Chicken"));
        filterList.add(new FilterItem("Beef"));
        filterList.add(new FilterItem("Pork"));
        filterList.add(new FilterItem("Mutton"));
        filterList.add(new FilterItem("Fish"));
        filterList.add(new FilterItem("Prawn"));
        filterList.add(new FilterItem("Egg"));
        filterList.add(new FilterItem("Peanut"));
        filterList.add(new FilterItem("Milk"));
        filterList.add(new FilterItem("Gluten"));

        filterRecyclerView = findViewById(R.id.filterRecyclerView);
        filterLayoutManager = new LinearLayoutManager(this);
        filterAdapter = new FilterListAdapter(filterList);

        filterRecyclerView.setLayoutManager(filterLayoutManager);
        filterRecyclerView.setAdapter(filterAdapter);

        applyFilterBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //code to update menu
                //put extras in intent
            }
        });

        removeFilterBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //code to reset menu to original
            }
        });
    }
}
