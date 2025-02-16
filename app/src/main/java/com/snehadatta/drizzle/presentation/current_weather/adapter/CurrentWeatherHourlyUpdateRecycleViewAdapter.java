package com.snehadatta.drizzle.presentation.current_weather.adapter;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.snehadatta.drizzle.databinding.ItemHourlyImageBinding;
import com.snehadatta.drizzle.presentation.model.HourlyWeather;

import java.util.List;

public class CurrentWeatherHourlyUpdateRecycleViewAdapter extends RecyclerView.Adapter<CurrentWeatherHourlyUpdateRecycleViewAdapter.ViewHolder> {

    private List<HourlyWeather> hourlyWeatherList;

    public CurrentWeatherHourlyUpdateRecycleViewAdapter(List<HourlyWeather> hourlyWeatherList) {
        this.hourlyWeatherList = hourlyWeatherList;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemHourlyImageBinding binding;
        Resources resources;
        public ViewHolder(ItemHourlyImageBinding binding, Resources resources) {
            super(binding.getRoot());
            this.binding = binding;
            this.resources = resources;
        }

        public void bind(HourlyWeather item) {
            binding.hourTime.setText(item.getHourTime());
            binding.hourlyTemp.setText(item.getHourlyTemp() + " C");
            binding.hourlyWeather.setImageResource(item.getWeatherIcon());
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemHourlyImageBinding binding = ItemHourlyImageBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding, parent.getResources());
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