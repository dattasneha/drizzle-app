package com.snehadatta.drizzle.presentation.currentWeather.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.snehadatta.drizzle.databinding.ItemHourlyImageBinding;
import com.snehadatta.drizzle.model.HourlyWeather;

import java.util.List;

public class CurrentWeatherHourlyUpdateRecycleViewAdapter extends RecyclerView.Adapter<CurrentWeatherHourlyUpdateRecycleViewAdapter.ViewHolder> {

    private List<HourlyWeather> hourlyWeatherList;

    public CurrentWeatherHourlyUpdateRecycleViewAdapter(List<HourlyWeather> hourlyWeatherList) {
        this.hourlyWeatherList = hourlyWeatherList;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemHourlyImageBinding binding;
        public ViewHolder(ItemHourlyImageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(HourlyWeather item) {
            binding.hourTime.setText(item.getHourTime());
            binding.hourlyTemp.setText(item.getHourlyTemp());
            binding.hourlyWeather.setImageResource(item.getWeatherIcon());
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemHourlyImageBinding binding = ItemHourlyImageBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(hourlyWeatherList.get(position));
    }

    @Override
    public int getItemCount() {
        return hourlyWeatherList.size();
    }


}
