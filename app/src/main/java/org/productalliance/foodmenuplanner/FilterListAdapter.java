package org.productalliance.foodmenuplanner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class FilterListAdapter extends RecyclerView.Adapter<FilterListAdapter.FilterViewHolder> {

    private ArrayList<FilterItem> mFilterList;

    public FilterListAdapter(ArrayList<FilterItem> filterList) {
        mFilterList = filterList;
    }

    @NonNull
    @Override
    public FilterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_view_layout, parent, false);
        return new FilterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterViewHolder holder, int position) {
        FilterItem currentItem = mFilterList.get(position);
        holder.filterItemTextView.setText(currentItem.getItemName());
    }

    @Override
    public int getItemCount() {
        return mFilterList.size();
    }


    public static class FilterViewHolder extends RecyclerView.ViewHolder {

        public CheckBox filterCheckBox;
        public TextView filterItemTextView;

        public FilterViewHolder(@NonNull View itemView) {
            super(itemView);

            filterCheckBox = itemView.findViewById(R.id.filterCheckBox);
            filterItemTextView = itemView.findViewById(R.id.filterItemTextView);

            filterCheckBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (filterCheckBox.isChecked()) {

                    }
                }
            });
        }
    }
}