package com.snehadatta.drizzle.data.model;

import com.google.gson.annotations.SerializedName;

public class Hour {

    @SerializedName("chance_of_rain")
    private int chanceOfRain;

    @SerializedName("chance_of_snow")
    private int chanceOfSnow;

    @SerializedName("cloud")
    private int cloud;

    @SerializedName("condition")
    private Condition condition;

    @SerializedName("dewpoint_c")
    private double dewpointC;

    @SerializedName("dewpoint_f")
    private double dewpointF;

    @SerializedName("feelslike_c")
    private double feelslikeC;

    @SerializedName("feelslike_f")
    private double feelslikeF;

    @SerializedName("gust_kph")
    private double gustKph;

    @SerializedName("gust_mph")
    private double gustMph;

    @SerializedName("heatindex_c")
    private double heatindexC;

    @SerializedName("heatindex_f")
    private double heatindexF;

    @SerializedName("humidity")
    private int humidity;

    @SerializedName("is_day")
    private int isDay;

    @SerializedName("precip_in")
    private double precipIn;

    @SerializedName("precip_mm")
    private double precipMm;

    @SerializedName("pressure_in")
    private double pressureIn;

    @SerializedName("pressure_mb")
    private double pressureMb;

    @SerializedName("snow_cm")
    private double snowCm;

    @SerializedName("temp_c")
    private double tempC;

    @SerializedName("temp_f")
    private double tempF;

    @SerializedName("time")
    private String time;

    @SerializedName("time_epoch")
    private int timeEpoch;

    @SerializedName("uv")
    private double uv;

    @SerializedName("vis_km")
    private double visKm;

    @SerializedName("vis_miles")
    private double visMiles;

    @SerializedName("will_it_rain")
    private int willItRain;

    @SerializedName("will_it_snow")
    private int willItSnow;

    @SerializedName("wind_degree")
    private int windDegree;

    @SerializedName("wind_dir")
    private String windDir;

    @SerializedName("wind_kph")
    private double windKph;

    @SerializedName("wind_mph")
    private double windMph;

    @SerializedName("windchill_c")
    private double windchillC;

    @SerializedName("windchill_f")
    private double windchillF;

    // Constructor
    public Hour(int chanceOfRain, int chanceOfSnow, int cloud, Condition condition, double dewpointC, double dewpointF,
                double feelslikeC, double feelslikeF, double gustKph, double gustMph, double heatindexC, double heatindexF,
                int humidity, int isDay, double precipIn, double precipMm, double pressureIn, double pressureMb, double snowCm,
                double tempC, double tempF, String time, int timeEpoch, double uv, double visKm, double visMiles, int willItRain,
                int willItSnow, int windDegree, String windDir, double windKph, double windMph, double windchillC, double windchillF) {
        this.chanceOfRain = chanceOfRain;
        this.chanceOfSnow = chanceOfSnow;
        this.cloud = cloud;
        this.condition = condition;
        this.dewpointC = dewpointC;
        this.dewpointF = dewpointF;
        this.feelslikeC = feelslikeC;
        this.feelslikeF = feelslikeF;
        this.gustKph = gustKph;
        this.gustMph = gustMph;
        this.heatindexC = heatindexC;
        this.heatindexF = heatindexF;
        this.humidity = humidity;
        this.isDay = isDay;
        this.precipIn = precipIn;
        this.precipMm = precipMm;
        this.pressureIn = pressureIn;
        this.pressureMb = pressureMb;
        this.snowCm = snowCm;
        this.tempC = tempC;
        this.tempF = tempF;
        this.time = time;
        this.timeEpoch = timeEpoch;
        this.uv = uv;
        this.visKm = visKm;
        this.visMiles = visMiles;
        this.willItRain = willItRain;
        this.willItSnow = willItSnow;
        this.windDegree = windDegree;
        this.windDir = windDir;
        this.windKph = windKph;
        this.windMph = windMph;
        this.windchillC = windchillC;
        this.windchillF = windchillF;
    }

    // Getters and Setters
    public int getChanceOfRain() {
        return chanceOfRain;
    }

    public void setChanceOfRain(int chanceOfRain) {
        this.chanceOfRain = chanceOfRain;
    }

    public int getChanceOfSnow() {
        return chanceOfSnow;
    }

    public void setChanceOfSnow(int chanceOfSnow) {
        this.chanceOfSnow = chanceOfSnow;
    }

    public int getCloud() {
        return cloud;
    }

    public void setCloud(int cloud) {
        this.cloud = cloud;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public double getDewpointC() {
        return dewpointC;
    }

    public void setDewpointC(double dewpointC) {
        this.dewpointC = dewpointC;
    }

    public double getDewpointF() {
        return dewpointF;
    }

    public void setDewpointF(double dewpointF) {
        this.dewpointF = dewpointF;
    }

    public double getFeelslikeC() {
        return feelslikeC;
    }

    public void setFeelslikeC(double feelslikeC) {
        this.feelslikeC = feelslikeC;
    }

    public double getFeelslikeF() {
        return feelslikeF;
    }

    public void setFeelslikeF(double feelslikeF) {
        this.feelslikeF = feelslikeF;
    }

    public double getGustKph() {
        return gustKph;
    }

    public void setGustKph(double gustKph) {
        this.gustKph = gustKph;
    }

    public double getGustMph() {
        return gustMph;
    }

    public void setGustMph(double gustMph) {
        this.gustMph = gustMph;
    }

    public double getHeatindexC() {
        return heatindexC;
    }

    public void setHeatindexC(double heatindexC) {
        this.heatindexC = heatindexC;
    }

    public double getHeatindexF() {
        return heatindexF;
    }

    public void setHeatindexF(double heatindexF) {
        this.heatindexF = heatindexF;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getIsDay() {
        return isDay;
    }

    public void setIsDay(int isDay) {
        this.isDay = isDay;
    }

    public double getPrecipIn() {
        return precipIn;
    }

    public void setPrecipIn(double precipIn) {
        this.precipIn = precipIn;
    }

    public double getPrecipMm() {
        return precipMm;
    }

    public void setPrecipMm(double precipMm) {
        this.precipMm = precipMm;
    }

    public double getPressureIn() {
        return pressureIn;
    }

    public void setPressureIn(double pressureIn) {
        this.pressureIn = pressureIn;
    }

    public double getPressureMb() {
        return pressureMb;
    }

    public void setPressureMb(double pressureMb) {
        this.pressureMb = pressureMb;
    }

    public double getSnowCm() {
        return snowCm;
    }

    public void setSnowCm(double snowCm) {
        this.snowCm = snowCm;
    }

    public double getTempC() {
        return tempC;
    }

    public void setTempC(double tempC) {
        this.tempC = tempC;
    }

    public double getTempF() {
        return tempF;
    }

    public void setTempF(double tempF) {
        this.tempF = tempF;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTimeEpoch() {
        return timeEpoch;
    }

    public void setTimeEpoch(int timeEpoch) {
        this.timeEpoch = timeEpoch;
    }

    public double getUv() {
        return uv;
    }

    public void setUv(double uv) {
        this.uv = uv;
    }

    public double getVisKm() {
        return visKm;
    }

    public void setVisKm(double visKm) {
        this.visKm = visKm;
    }

    public double getVisMiles() {
        return visMiles;
    }

    public void setVisMiles(double visMiles) {
        this.visMiles = visMiles;
    }

    public int getWillItRain() {
        return willItRain;
    }

    public void setWillItRain(int willItRain) {
        this.willItRain = willItRain;
    }

    public int getWillItSnow() {
        return willItSnow;
    }

    public void setWillItSnow(int willItSnow) {
        this.willItSnow = willItSnow;
    }

    public int getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(int windDegree) {
        this.windDegree = windDegree;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public double getWindKph() {
        return windKph;
    }

    public void setWindKph(double windKph) {
        this.windKph = windKph;
    }

    public double getWindMph() {
        return windMph;
    }

    public void setWindMph(double windMph) {
        this.windMph = windMph;
    }

    public double getWindchillC() {
        return windchillC;
    }

    public void setWindchillC(double windchillC) {
        this.windchillC = windchillC;
    }

    public double getWindchillF() {
        return windchillF;
    }

    public void setWindchillF(double windchillF) {
        this.windchillF = windchillF;
    }
}
