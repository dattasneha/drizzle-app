package com.snehadatta.drizzle.data.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Forecast {

    @SerializedName("forecastday")
    private List<Forecastday> forecastday;

    // Constructor
    public Forecast(List<Forecastday> forecastday) {
        this.forecastday = forecastday;
    }

    // Getter and Setter
    public List<Forecastday> getForecastday() {
        return forecastday;
    }

    public void setForecastday(List<Forecastday> forecastday) {
        this.forecastday = forecastday;
    }
}

