package com.snehadatta.drizzle.data;

import com.snehadatta.drizzle.data.model.ForecastResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MainApi {
    @GET("forecast.json")
    Call<ForecastResponse> getForeCast(
            @Query("key")String apiKey,
            @Query("q") String location,
            @Query("days") int days,
            @Query("aqi") String aqi,
            @Query("alerts") String alerts
    );
}
