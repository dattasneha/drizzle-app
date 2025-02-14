package com.snehadatta.drizzle.presentation.currentWeather.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.snehadatta.drizzle.databinding.ItemHourlyImageBinding;

import java.util.List;

public class HourlyUpdateRecycleViewAdapter extends RecyclerView.Adapter<HourlyUpdateRecycleViewAdapter.ViewHolder>{
    private final List<Integer> hourlyUpdateList;

    public HourlyUpdateRecycleViewAdapter(List<> hourlyUpdateList) {
        this.hourlyUpdateList = hourlyUpdateList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemHourlyImageBinding binding;

        public ViewHolder(ItemHourlyImageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemHourlyImageBinding binding = ItemHourlyImageBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return hourlyUpdateList.size();
    }
}