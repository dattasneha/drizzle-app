package com.snehadatta.drizzle.util;

import android.content.res.Resources;
import android.util.Log;

import com.snehadatta.drizzle.R;

public class WeatherIconMapper {

    public static int getWeatherIcon(Resources resources, String iconUrl, int isDay) {
        try {
            // Extract the number from the URL: "//cdn.weatherapi.com/weather/64x64/night/143.png"
            String[] parts = iconUrl.split("/");
            String fileName = parts[parts.length - 1]; // "143.png"
            String iconCode = fileName.replace(".png", ""); // "143"
            int code = Integer.parseInt(iconCode);

            // Map API icon code to local drawable resource
            if (isDay == 1) {
                return resources.getIdentifier("ic_day_" + code, "drawable", "com.snehadatta.drizzle");
            } else {
                return resources.getIdentifier("ic_night_" + code, "drawable", "com.snehadatta.drizzle");
            }
        } catch (Exception e) {
            Log.e("WeatherIcon", "Error parsing icon URL: " + iconUrl, e);
            return R.drawable.ic_day_113; // Default icon in case of error
        }
    }
}
