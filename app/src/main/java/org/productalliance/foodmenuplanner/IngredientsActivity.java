package org.productalliance.foodmenuplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class IngredientsActivity extends AppCompatActivity {

    private Button shoppingListBtn;
    private ImageView NavBtn;
    private TextView MenuNav;
    private TextView menuItemTextView;
    private TextView ingListTextView;
    private TextView ingQuestion;
    private CheckBox ingCheckBox;
    private Button ingIncreaseBtn;
    private TextView ingCounterTextView;
    private Button ingDecreaseBtn;
    private int mInteger = 0;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

        shoppingListBtn = findViewById(R.id.shoppingListBtn);
        NavBtn = findViewById(R.id.NavBtn);
        MenuNav = findViewById(R.id.MenuNav);
        menuItemTextView = findViewById(R.id.menuItemTextView);
        ingListTextView = findViewById(R.id.ingListTextView);
        ingQuestion = findViewById(R.id.ingQuestion);
        ingCheckBox = findViewById(R.id.ingCheckBox);
        ingIncreaseBtn = findViewById(R.id.ingIncreaseBtn);
        ingCounterTextView = findViewById(R.id.ingCounterTextView);
        ingDecreaseBtn = findViewById(R.id.ingDecreaseBtn);

        ingQuestion.setVisibility(View.INVISIBLE);
        ingIncreaseBtn.setVisibility(View.INVISIBLE);
        ingCounterTextView.setVisibility(View.INVISIBLE);
        ingDecreaseBtn.setVisibility(View.INVISIBLE);

        shoppingListBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shoppingIntent = new Intent(IngredientsActivity.this, ShoppingListActivity.class);
                startActivity(shoppingIntent);
            }
        });

        NavBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IngredientsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        MenuNav.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IngredientsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //code to pull item name from selected card
        //code to pull ingredients list (with quantities) for selected card from database

        ingCheckBox.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ingCheckBox.isChecked()) {
                    ingQuestion.setVisibility(View.VISIBLE);
                    ingIncreaseBtn.setVisibility(View.VISIBLE);
                    ingCounterTextView.setVisibility(View.VISIBLE);
                    ingDecreaseBtn.setVisibility(View.VISIBLE);
                    ingCheckBox.setText("Remove from List");
                } else {
                    ingQuestion.setVisibility(View.INVISIBLE);
                    ingIncreaseBtn.setVisibility(View.INVISIBLE);
                    ingCounterTextView.setVisibility(View.INVISIBLE);
                    ingDecreaseBtn.setVisibility(View.INVISIBLE);
                    ingCheckBox.setText("Add to List");
                }
            }
        });

        ingIncreaseBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ingCounterTextView.setText(String.valueOf(++mInteger));
            }
        });

        ingDecreaseBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInteger > 0) {
                    ingCounterTextView.setText(String.valueOf(--mInteger));
                } else {
                    ingCounterTextView.setText(String.valueOf(mInteger));
                }
            }
        });
    }
}
