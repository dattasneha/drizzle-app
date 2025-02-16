package com.snehadatta.drizzle.presentation.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US);
        SimpleDateFormat outputFormat = new SimpleDateFormat("hh:mm a", Locale.US); // 12-hour format with AM/PM

        try {
            Date date = inputFormat.parse(hourTime);
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return hourTime;
        }
    }

    public String getHourlyTemp() {
        return hourlyTemp;
    }

    public int getWeatherIcon() {
        return weatherIcon;
    }
}