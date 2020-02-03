package org.productalliance.foodmenuplanner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BreakfastMenuAdapter extends RecyclerView.Adapter<BreakfastMenuAdapter.BreakfastViewHolder> {

    //variables
    private ArrayList<BreakfastMenu> mBreakfastList;
    private OnItemClickListener bkfListener;
    private final int limit = 2;

    //get the info from the array list (in Main Activity) to put into the adapter
    //pass it into the constructor for the adapter

    public interface OnItemClickListener {  /* OnItemClickListener is not part of RecyclerView. Has to be created */
        void OnItemClick(int position);
    }

    public void setOnItemClickListener (OnItemClickListener listener) {
        bkfListener = listener;
    }


    public static class BreakfastViewHolder extends RecyclerView.ViewHolder {

        //variables referencing the card components
        public TextView bkfMenu;
        public ImageView bkfArrow;
        public TextView bkfQuestion;
        public CheckBox bkfCheckBox;
        public Button bkfIncreaseBtn;
        public TextView bkfCounterTextView;
        public Button bkfDecreaseBtn;
        public int mInteger = 0;

        public BreakfastViewHolder(@NonNull final View itemView, final OnItemClickListener listener) {
            super(itemView);

            bkfMenu = itemView.findViewById(R.id.bkfMenu);
            bkfArrow = itemView.findViewById(R.id.bkfArrow);
            bkfQuestion = itemView.findViewById(R.id.bkfQuestion);
            bkfCheckBox = itemView.findViewById(R.id.bkfCheckBox);
            bkfIncreaseBtn = itemView.findViewById(R.id.bkfIncreaseBtn);
            bkfCounterTextView = itemView.findViewById(R.id.bkfCounterTextView);
            bkfDecreaseBtn = itemView.findViewById(R.id.bkfDecreaseBtn);


            bkfQuestion.setVisibility(View.INVISIBLE);
            bkfIncreaseBtn.setVisibility(View.INVISIBLE);
            bkfCounterTextView.setVisibility(View.INVISIBLE);
            bkfDecreaseBtn.setVisibility(View.INVISIBLE);

            bkfMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.OnItemClick(position);
                        }
                    }
                }
            });

            bkfArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.OnItemClick(position);
                        }
                    }
                }
            });

            bkfCheckBox.setOnClickListener(new View.OnClickListener() {
                //better to set OnClickListener than onCheckedChangeListener when writing code to react to a user

                @Override
                public void onClick(View v) {
                    if (bkfCheckBox.isChecked()) {
                        bkfQuestion.setVisibility(View.VISIBLE);
                        bkfIncreaseBtn.setVisibility(View.VISIBLE);
                        bkfCounterTextView.setVisibility(View.VISIBLE);
                        bkfDecreaseBtn.setVisibility(View.VISIBLE);
                        bkfCheckBox.setText("Remove from List");
                    } else {
                        bkfQuestion.setVisibility(View.INVISIBLE);
                        bkfIncreaseBtn.setVisibility(View.INVISIBLE);
                        bkfCounterTextView.setVisibility(View.INVISIBLE);
                        bkfDecreaseBtn.setVisibility(View.INVISIBLE);
                        bkfCheckBox.setText("Add to List");
                    }
                }
            });

            bkfIncreaseBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mInteger = mInteger + 1;
                    bkfCounterTextView.setText("" + mInteger);
                }
            });

            bkfDecreaseBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mInteger > 0) {
                        mInteger = mInteger - 1;
                        bkfCounterTextView.setText("" + mInteger);
                    } else {
                        bkfCounterTextView.setText("" + 0);
                    }
                }
            });

        }

    }

    public BreakfastMenuAdapter(ArrayList<BreakfastMenu> breakfastList) {
        mBreakfastList = breakfastList;
    }

    @NonNull
    @Override
    public BreakfastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.breakfast_layout, parent, false);
         return new BreakfastViewHolder(view, bkfListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BreakfastViewHolder holder, int position) {
         BreakfastMenu currentItem = mBreakfastList.get(position); /* binds menu at current position */
         holder.bkfMenu.setText(currentItem.getBkfMenu()); /* change the text to the current position's text */
    }

    @Override
    public int getItemCount() {
        if (mBreakfastList.size() > limit) {
            return limit; /* so only 2 options show per card */
        } else {
            return mBreakfastList.size(); /* number of items in the array list */
        }

    }

}
