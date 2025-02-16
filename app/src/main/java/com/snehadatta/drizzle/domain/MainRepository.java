package com.snehadatta.drizzle.domain;

import com.snehadatta.drizzle.data.model.ForecastResponse;

import retrofit2.Call;

public interface MainRepository {
    Call<ForecastResponse> getForeCast(
            String apiKey,
            String location,
            int days,
            String aqi,
            String alerts
    );
}
