package com.snehadatta.drizzle.data.model;

import com.google.gson.annotations.SerializedName;

public class ForecastResponse {

    @SerializedName("current")
    private Current current;

    @SerializedName("forecast")
    private Forecast forecast;

    @SerializedName("location")
    private Location location;

    // Constructor
    public ForecastResponse(Current current, Forecast forecast, Location location) {
        this.current = current;
        this.forecast = forecast;
    }

    // Getters and Setters
    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

