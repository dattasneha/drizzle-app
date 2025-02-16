package com.snehadatta.drizzle.presentation.current_weather;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.snehadatta.drizzle.R;
import com.snehadatta.drizzle.data.model.ForecastResponse;
import com.snehadatta.drizzle.data.model.Hour;
import com.snehadatta.drizzle.databinding.FragmentCurrentWeatherBinding;
import com.snehadatta.drizzle.presentation.MainViewModel;
import com.snehadatta.drizzle.presentation.current_weather.adapter.CurrentWeatherHourlyUpdateRecycleViewAdapter;
import com.snehadatta.drizzle.presentation.model.HourlyWeather;
import com.snehadatta.drizzle.util.Resource;
import com.snehadatta.drizzle.util.WeatherIconMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CurrentWeatherFragment extends Fragment {
    private FragmentCurrentWeatherBinding binding;
    private  String  API_KEY = "fba9573acc654d7a995110405240808";
    private int days = 2;
    private String aqi = "yes";
    private String alerts = "yes";
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCurrentWeatherBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        if (getActivity() instanceof AppCompatActivity) {
            Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).hide();
        }

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.getForeCast(API_KEY,"Kolkata", days,aqi,alerts);

        viewModel.getForecastLiveData().observe(getViewLifecycleOwner(), resource -> {
            if (resource instanceof Resource.Loading) {
                binding.progressBar.setVisibility(View.VISIBLE);
            } else if (resource instanceof Resource.Success) {
                binding.progressBar.setVisibility(View.GONE);
                ForecastResponse data = resource.getData();

                binding.locationTextView.setText(data.getLocation().getName());
                binding.tempTextView.setText(String.format(Locale.US, "%.1f° C", data.getCurrent().getTempC()));
                binding.weatherTextView.setText(data.getCurrent().getCondition().getText());
                binding.feelsLikeTextView.setText(
                        String.format(Locale.US, "Feels Like: %.1f° C", data.getCurrent().getFeelslikeC())
                );
                binding.weatherImageView.setImageResource(
                        WeatherIconMapper.getWeatherIcon(
                                getResources(),
                                data.getCurrent().getCondition().getIcon(),
                                data.getCurrent().getIsDay()
                        )
                );

                List<HourlyWeather> hourlyWeatherList = new ArrayList<>();
                int noOfHours = data.getForecast().getForecastday().get(0).getHour().size();
                for (int i = 0; i < noOfHours; i++) {
                    Hour hour = data.getForecast().getForecastday().get(0).getHour().get(i);
                    String temp = String.valueOf(hour.getTempC());
                    String time = hour.getTime();

                    int icon = WeatherIconMapper.getWeatherIcon(this.getResources(), hour.getCondition().getIcon(), hour.getIsDay());

                    hourlyWeatherList.add(new HourlyWeather(time, temp+"°", icon));
                }
                binding.hourlyUpdateRecycleView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                binding.hourlyUpdateRecycleView.setAdapter(new CurrentWeatherHourlyUpdateRecycleViewAdapter(hourlyWeatherList));


            } else if (resource instanceof Resource.Error) {
                binding.progressBar.setVisibility(View.GONE);
                String errorMessage = resource.getMessage();

                Toast.makeText(getContext(), errorMessage, Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        if (getActivity() instanceof AppCompatActivity) {
            Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).show();
        }
    }
}