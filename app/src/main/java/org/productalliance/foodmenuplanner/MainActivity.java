package org.productalliance.foodmenuplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class MainActivity extends AppCompatActivity {

    private Button shoppingListBtn;
    private Switch vegSwitch;
    private ImageButton filterBtn;
    private RecyclerView bkfRecyclerView;
    private BreakfastMenuAdapter bkfAdapter;
    private RecyclerView.LayoutManager bkfLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar appToolbar = findViewById(R.id.appToolbar);
        setSupportActionBar(appToolbar);
        getSupportActionBar().setTitle(null); //hide application name

        shoppingListBtn = findViewById(R.id.shoppingListBtn);
        vegSwitch = findViewById(R.id.vegSwitch);
        filterBtn = findViewById(R.id.filterBtn);

        shoppingListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShoppingListActivity.class);
                startActivity(intent);
            }
        });

        //horizontal calendar section
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.DATE, 0); /* starts 2 days before now */

        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1); /* ends after 1 month from now */

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                //method to call matching menus
            }
        });

        //create an array list of custom breakfast menu objects
        //each card is a custom breakfast menu object
        ArrayList<BreakfastMenu> breakfastList = new ArrayList<>();

        //dummy code until menu database is set up
        breakfastList.add(new BreakfastMenu("Scrambled Eggs, Toast, Chicken Sausages, Apples"));
        breakfastList.add(new BreakfastMenu("Aloo Paratha, Mint Chutney, Dahi, Oranges"));

        bkfRecyclerView = findViewById(R.id.bkfRecyclerView);
        bkfLayoutManager = new LinearLayoutManager(this);
        bkfAdapter = new BreakfastMenuAdapter(breakfastList); /* pass the adapter an array list of breakfast menu objects */

        bkfRecyclerView.setLayoutManager(bkfLayoutManager);
        bkfRecyclerView.setAdapter(bkfAdapter);

        bkfAdapter.setOnItemClickListener(new BreakfastMenuAdapter.OnItemClickListener() { /* set the OnItemClickListener to the adapter */
            @Override
            public void OnItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, IngredientsActivity.class);
                startActivity(intent);
                //modify method to take intent info and populate ingredients page
            }
        });

        bkfRecyclerView.setVisibility(View.VISIBLE);
        final TextView hideBkfTextView = findViewById(R.id.hideBkfTextView);
        hideBkfTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bkfRecyclerView.getVisibility() == View.VISIBLE) {
                    bkfRecyclerView.setVisibility(View.INVISIBLE);
                    hideBkfTextView.setText("Show Breakfast");
                } else {
                    bkfRecyclerView.setVisibility(View.VISIBLE);
                    hideBkfTextView.setText("Hide Breakfast");
                }

            }
        });
                //filter method for veg switch
                //show only veg menu items

                //method for filter button
                //show only items not containing filter choices

    }
}