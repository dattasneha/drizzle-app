package com.snehadatta.drizzle.domain;

import com.snehadatta.drizzle.data.MainApi;
import com.snehadatta.drizzle.data.model.ForecastResponse;

import javax.inject.Inject;

import retrofit2.Call;

public class MainRepositoryImpl implements MainRepository {
    private final MainApi apiService;

    @Inject
    public MainRepositoryImpl(MainApi apiService) {
        this.apiService = apiService;
    }

    @Override
    public Call<ForecastResponse> getForeCast(String apiKey, String location, int days, String aqi, String alerts) {
        return apiService.getForeCast(apiKey, location, days, aqi, alerts);
    }
}
