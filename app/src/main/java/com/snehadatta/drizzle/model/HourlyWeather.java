package com.snehadatta.drizzle.model;

public class HourlyWeather {
    private String hourTime;
    private String hourlyTemp;
    private int weatherIcon;

    public HourlyWeather(String hourTime, String hourlyTemp, int weatherIcon) {
        this.hourTime = hourTime;
        this.hourlyTemp = hourlyTemp;
        this.weatherIcon = weatherIcon;
    }

    public String getHourTime() {
        return hourTime;
    }

    public String getHourlyTemp() {
        return hourlyTemp;
    }

    public int getWeatherIcon() {
        return weatherIcon;
    }
}

