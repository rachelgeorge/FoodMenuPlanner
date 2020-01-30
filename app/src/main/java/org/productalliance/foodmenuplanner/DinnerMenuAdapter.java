package org.productalliance.foodmenuplanner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DinnerMenuAdapter extends RecyclerView.Adapter<DinnerMenuAdapter.DinnerViewHolder> {

    //variables
    private ArrayList<DinnerMenu> mDinnerList;
    private OnItemClickListener dinnerListener;
    private final int limit = 2;

    //get the info from the array list (in Main Activity) to put into the adapter
    //pass it into the constructor for the adapter

    public interface OnItemClickListener {  /* OnItemClickListener is not part of RecyclerView. Has to be created */
        void OnItemClick(int position);
    }

    public void setOnItemClickListener (OnItemClickListener listener) {
        dinnerListener = listener;
    }


    public static class DinnerViewHolder extends RecyclerView.ViewHolder {

        //variables referencing the card components
        public TextView dinnerMenu;
        public ImageView dinnerArrow;
        public TextView dinnerQuestion;
        public CheckBox dinnerCheckBox;
        public Button dinnerIncreaseBtn;
        public TextView dinnerCounterTextView;
        public Button dinnerDecreaseBtn;
        public int mInteger = 0;

        public DinnerViewHolder(@NonNull final View itemView, final OnItemClickListener listener) {
            super(itemView);

            dinnerMenu = itemView.findViewById(R.id.dinnerMenu);
            dinnerArrow = itemView.findViewById(R.id.dinnerArrow);
            dinnerQuestion = itemView.findViewById(R.id.dinnerQuestion);
            dinnerCheckBox = itemView.findViewById(R.id.dinnerCheckBox);
            dinnerIncreaseBtn = itemView.findViewById(R.id.dinnerIncreaseBtn);
            dinnerCounterTextView = itemView.findViewById(R.id.dinnerCounterTextView);
            dinnerDecreaseBtn = itemView.findViewById(R.id.dinnerDecreaseBtn);


            dinnerQuestion.setVisibility(View.INVISIBLE);
            dinnerIncreaseBtn.setVisibility(View.INVISIBLE);
            dinnerCounterTextView.setVisibility(View.INVISIBLE);
            dinnerDecreaseBtn.setVisibility(View.INVISIBLE);

            dinnerMenu.setOnClickListener(new View.OnClickListener() {
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

            dinnerArrow.setOnClickListener(new View.OnClickListener() {
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

            dinnerCheckBox.setOnClickListener(new View.OnClickListener() {
                //better to set OnClickListener than onCheckedChangeListener when writing code to react to a user

                @Override
                public void onClick(View v) {
                    if (dinnerCheckBox.isChecked()) {
                        dinnerQuestion.setVisibility(View.VISIBLE);
                        dinnerIncreaseBtn.setVisibility(View.VISIBLE);
                        dinnerCounterTextView.setVisibility(View.VISIBLE);
                        dinnerDecreaseBtn.setVisibility(View.VISIBLE);
                        dinnerCheckBox.setText("Remove from List");
                    } else {
                        dinnerQuestion.setVisibility(View.INVISIBLE);
                        dinnerIncreaseBtn.setVisibility(View.INVISIBLE);
                        dinnerCounterTextView.setVisibility(View.INVISIBLE);
                        dinnerDecreaseBtn.setVisibility(View.INVISIBLE);
                        dinnerCheckBox.setText("Add to List");
                    }
                }
            });

            dinnerIncreaseBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mInteger = mInteger + 1;
                    dinnerCounterTextView.setText("" + mInteger);
                }
            });

            dinnerDecreaseBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mInteger > 0) {
                        mInteger = mInteger - 1;
                        dinnerCounterTextView.setText("" + mInteger);
                    } else {
                        dinnerCounterTextView.setText("" + 0);
                    }
                }
            });

        }

    }

    //SetOnClickListener methods for counters

    public DinnerMenuAdapter(ArrayList<DinnerMenu> dinnerList) {
        mDinnerList = dinnerList;
    }

    @NonNull
    @Override
    public DinnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dinner_layout, parent, false);
         return new DinnerViewHolder(view, dinnerListener);
    }

    @Override
    public void onBindViewHolder(@NonNull DinnerViewHolder holder, int position) {
         DinnerMenu currentItem = mDinnerList.get(position); /* binds menu at current position */
         holder.dinnerMenu.setText(currentItem.getDinnerMenu()); /* change the text to the current position's text */
    }

    @Override
    public int getItemCount() {
        if (mDinnerList.size() > limit) {
            return limit;
        } else {
            return mDinnerList.size(); /* number of items in the array list */
        }
    }
}
