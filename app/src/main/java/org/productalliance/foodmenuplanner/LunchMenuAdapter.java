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

public class LunchMenuAdapter extends RecyclerView.Adapter<LunchMenuAdapter.LunchViewHolder> {

    //variables
    private ArrayList<LunchMenu> mLunchList;
    private OnItemClickListener lunchListener;
    private final int limit = 2;

    //get the info from the array list (in Main Activity) to put into the adapter
    //pass it into the constructor for the adapter

    public interface OnItemClickListener {  /* OnItemClickListener is not part of RecyclerView. Has to be created */
        void OnItemClick(int position);
    }

    public void setOnItemClickListener (OnItemClickListener listener) {
        lunchListener = listener;
    }


    public static class LunchViewHolder extends RecyclerView.ViewHolder {

        //variables referencing the card components
        public TextView lunchMenu;
        public ImageView lunchArrow;
        public TextView lunchQuestion;
        public CheckBox lunchCheckBox;
        public Button lunchIncreaseBtn;
        public TextView lunchCounterTextView;
        public Button lunchDecreaseBtn;
        public int mInteger = 0;

        public LunchViewHolder(@NonNull final View itemView, final OnItemClickListener listener) {
            super(itemView);

            lunchMenu = itemView.findViewById(R.id.lunchMenu);
            lunchArrow = itemView.findViewById(R.id.lunchArrow);
            lunchQuestion = itemView.findViewById(R.id.lunchQuestion);
            lunchCheckBox = itemView.findViewById(R.id.lunchCheckBox);
            lunchIncreaseBtn = itemView.findViewById(R.id.lunchIncreaseBtn);
            lunchCounterTextView = itemView.findViewById(R.id.lunchCounterTextView);
            lunchDecreaseBtn = itemView.findViewById(R.id.lunchDecreaseBtn);


            lunchQuestion.setVisibility(View.INVISIBLE);
            lunchIncreaseBtn.setVisibility(View.INVISIBLE);
            lunchCounterTextView.setVisibility(View.INVISIBLE);
            lunchDecreaseBtn.setVisibility(View.INVISIBLE);

            lunchMenu.setOnClickListener(new View.OnClickListener() {
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

            lunchArrow.setOnClickListener(new View.OnClickListener() {
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

            lunchCheckBox.setOnClickListener(new View.OnClickListener() {
                //better to set OnClickListener than onCheckedChangeListener when writing code to react to a user

                @Override
                public void onClick(View v) {
                    if (lunchCheckBox.isChecked()) {
                        lunchQuestion.setVisibility(View.VISIBLE);
                        lunchIncreaseBtn.setVisibility(View.VISIBLE);
                        lunchCounterTextView.setVisibility(View.VISIBLE);
                        lunchDecreaseBtn.setVisibility(View.VISIBLE);
                        lunchCheckBox.setText("Remove from List");
                    } else {
                        lunchQuestion.setVisibility(View.INVISIBLE);
                        lunchIncreaseBtn.setVisibility(View.INVISIBLE);
                        lunchCounterTextView.setVisibility(View.INVISIBLE);
                        lunchDecreaseBtn.setVisibility(View.INVISIBLE);
                        lunchCheckBox.setText("Add to List");
                    }
                }
            });

            lunchIncreaseBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mInteger = mInteger + 1;
                    lunchCounterTextView.setText("" + mInteger);
                }
            });

            lunchDecreaseBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mInteger > 0) {
                        mInteger = mInteger - 1;
                        lunchCounterTextView.setText("" + mInteger);
                    } else {
                        lunchCounterTextView.setText("" + 0);
                    }
                }
            });

        }

    }

    //SetOnClickListener methods for counters

    public LunchMenuAdapter(ArrayList<LunchMenu> lunchList) {
        mLunchList = lunchList;
    }

    @NonNull
    @Override
    public LunchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lunch_layout, parent, false);
         return new LunchViewHolder(view, lunchListener);
    }

    @Override
    public void onBindViewHolder(@NonNull LunchViewHolder holder, int position) {
         LunchMenu currentItem = mLunchList.get(position); /* binds menu at current position */
         holder.lunchMenu.setText(currentItem.getLunchMenu()); /* change the text to the current position's text */
    }

    @Override
    public int getItemCount() {
        if (mLunchList.size() > limit) {
            return limit;
        } else {
            return mLunchList.size(); /* number of items in the array list */
        }
    }

}
