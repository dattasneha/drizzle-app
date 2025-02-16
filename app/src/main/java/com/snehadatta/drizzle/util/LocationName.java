package com.snehadatta.drizzle.util;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationName {
    double latitude;
    double longitude;
    Context context;
    public LocationName(double latitude,double longitude,Context context) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.context = context;
    }
    public String getCityName() {
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses != null && !addresses.isEmpty()) {
                return addresses.get(0).getLocality();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
