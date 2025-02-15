package com.snehadatta.drizzle.data.model;

import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("country")
    private String country;

    @SerializedName("lat")
    private double lat;

    @SerializedName("localtime")
    private String localtime;

    @SerializedName("localtime_epoch")
    private int localtimeEpoch;

    @SerializedName("lon")
    private double lon;

    @SerializedName("name")
    private String name;

    @SerializedName("region")
    private String region;

    @SerializedName("tz_id")
    private String tzId;

    // Constructor
    public Location(String country, double lat, String localtime, int localtimeEpoch, double lon, String name, String region, String tzId) {
        this.country = country;
        this.lat = lat;
        this.localtime = localtime;
        this.localtimeEpoch = localtimeEpoch;
        this.lon = lon;
        this.name = name;
        this.region = region;
        this.tzId = tzId;
    }

    // Getters and Setters
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    public int getLocaltimeEpoch() {
        return localtimeEpoch;
    }

    public void setLocaltimeEpoch(int localtimeEpoch) {
        this.localtimeEpoch = localtimeEpoch;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTzId() {
        return tzId;
    }

    public void setTzId(String tzId) {
        this.tzId = tzId;
    }
}

