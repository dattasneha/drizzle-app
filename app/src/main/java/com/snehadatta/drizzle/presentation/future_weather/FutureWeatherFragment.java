package com.snehadatta.drizzle.presentation.future_weather;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.snehadatta.drizzle.R;
import com.snehadatta.drizzle.data.model.ForecastResponse;
import com.snehadatta.drizzle.data.model.Hour;
import com.snehadatta.drizzle.databinding.FragmentFutureWeatherBinding;
import com.snehadatta.drizzle.presentation.MainViewModel;
import com.snehadatta.drizzle.presentation.current_weather.adapter.CurrentWeatherHourlyUpdateRecycleViewAdapter;
import com.snehadatta.drizzle.presentation.model.DateFormat;
import com.snehadatta.drizzle.presentation.model.HourlyWeather;
import com.snehadatta.drizzle.util.Resource;
import com.snehadatta.drizzle.util.WeatherIconMapper;

import java.util.ArrayList;
import java.util.List;

public class FutureWeatherFragment extends Fragment {
    private FragmentFutureWeatherBinding binding;
    private MainViewModel mainViewModel;

    public FutureWeatherFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentFutureWeatherBinding.inflate(inflater,container,false);
       View view = binding.getRoot();

        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        mainViewModel.getForecastLiveData().observe(getViewLifecycleOwner(),resource -> {
            if (resource instanceof Resource.Loading) {
                binding.progressBar.setVisibility(View.VISIBLE);
            }else if (resource instanceof Resource.Success) {
                binding.progressBar.setVisibility(View.GONE);
                ForecastResponse data = resource.getData();
                binding.location1.setText(data.getLocation().getName());
                binding.location2.setText(data.getLocation().getName());
                binding.location3.setText(data.getLocation().getName());



                binding.date1.setText(new DateFormat(data.getForecast().getForecastday().get(0).getDate()).getFormattedDate());

                binding.date2.setText(new DateFormat(data.getForecast().getForecastday().get(1).getDate()).getFormattedDate());

                binding.date3.setText(new DateFormat(data.getForecast().getForecastday().get(2).getDate()).getFormattedDate());

                List<HourlyWeather> hourlyWeatherList1 = new ArrayList<>();
                int noOfHours = data.getForecast().getForecastday().get(0).getHour().size();
                for (int i = 0; i < noOfHours; i++) {
                    Hour hour = data.getForecast().getForecastday().get(0).getHour().get(i);
                    String temp = String.valueOf(hour.getTempC());
                    String time = hour.getTime();

                    int icon = WeatherIconMapper.getWeatherIcon(this.getResources(), hour.getCondition().getIcon(), hour.getIsDay());

                    hourlyWeatherList1.add(new HourlyWeather(time, temp+"°", icon));
                }

                binding.hourlyUpdateRecycleView1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                binding.hourlyUpdateRecycleView1.setAdapter(new CurrentWeatherHourlyUpdateRecycleViewAdapter(hourlyWeatherList1));

                List<HourlyWeather> hourlyWeatherList2 = new ArrayList<>();
                for (int i = 0; i < noOfHours; i++) {
                    Hour hour = data.getForecast().getForecastday().get(1).getHour().get(i);
                    String temp = String.valueOf(hour.getTempC());
                    String time = hour.getTime();

                    int icon = WeatherIconMapper.getWeatherIcon(this.getResources(), hour.getCondition().getIcon(), hour.getIsDay());

                    hourlyWeatherList2.add(new HourlyWeather(time, temp+"°", icon));
                }

                binding.hourlyUpdateRecycleView2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                binding.hourlyUpdateRecycleView2.setAdapter(new CurrentWeatherHourlyUpdateRecycleViewAdapter(hourlyWeatherList1));

                List<HourlyWeather> hourlyWeatherList3 = new ArrayList<>();
                for (int i = 0; i < noOfHours; i++) {
                    Hour hour = data.getForecast().getForecastday().get(0).getHour().get(i);
                    String temp = String.valueOf(hour.getTempC());
                    String time = hour.getTime();

                    int icon = WeatherIconMapper.getWeatherIcon(this.getResources(), hour.getCondition().getIcon(), hour.getIsDay());

                    hourlyWeatherList3.add(new HourlyWeather(time, temp+"°", icon));
                }

                binding.hourlyUpdateRecycleView3.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                binding.hourlyUpdateRecycleView3.setAdapter(new CurrentWeatherHourlyUpdateRecycleViewAdapter(hourlyWeatherList1));
            }
        });

       return view;
    }
}