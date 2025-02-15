package com.snehadatta.drizzle.presentation.current_weather;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.snehadatta.drizzle.R;
import com.snehadatta.drizzle.databinding.FragmentCurrentWeatherBinding;
import com.snehadatta.drizzle.presentation.model.HourlyWeather;
import com.snehadatta.drizzle.presentation.current_weather.adapter.CurrentWeatherHourlyUpdateRecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;


public class CurrentWeatherFragment extends Fragment {
    private FragmentCurrentWeatherBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCurrentWeatherBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        List<HourlyWeather> hourlyWeatherList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            hourlyWeatherList.add(new HourlyWeather("12 PM", "19°", R.drawable.ic_day_113));
        }

        binding.hourlyUpdateRecycleView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.hourlyUpdateRecycleView.setAdapter(new CurrentWeatherHourlyUpdateRecycleViewAdapter(hourlyWeatherList));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}