package com.snehadatta.drizzle.data.model;

import com.google.gson.annotations.SerializedName;

public class Day {

    @SerializedName("avghumidity")
    private int avghumidity;

    @SerializedName("avgtemp_c")
    private double avgtempC;

    @SerializedName("avgtemp_f")
    private double avgtempF;

    @SerializedName("avgvis_km")
    private double avgvisKm;

    @SerializedName("avgvis_miles")
    private double avgvisMiles;

    @SerializedName("condition")
    private Condition condition;

    @SerializedName("daily_chance_of_rain")
    private int dailyChanceOfRain;

    @SerializedName("daily_chance_of_snow")
    private int dailyChanceOfSnow;

    @SerializedName("daily_will_it_rain")
    private int dailyWillItRain;

    @SerializedName("daily_will_it_snow")
    private int dailyWillItSnow;

    @SerializedName("maxtemp_c")
    private double maxtempC;

    @SerializedName("maxtemp_f")
    private double maxtempF;

    @SerializedName("maxwind_kph")
    private double maxwindKph;

    @SerializedName("maxwind_mph")
    private double maxwindMph;

    @SerializedName("mintemp_c")
    private double mintempC;

    @SerializedName("mintemp_f")
    private double mintempF;

    @SerializedName("totalprecip_in")
    private double totalprecipIn;

    @SerializedName("totalprecip_mm")
    private double totalprecipMm;

    @SerializedName("totalsnow_cm")
    private double totalsnowCm;

    @SerializedName("uv")
    private double uv;

    // Constructor
    public Day(int avghumidity, double avgtempC, double avgtempF, double avgvisKm, double avgvisMiles,
               Condition condition, int dailyChanceOfRain, int dailyChanceOfSnow, int dailyWillItRain,
               int dailyWillItSnow, double maxtempC, double maxtempF, double maxwindKph, double maxwindMph,
               double mintempC, double mintempF, double totalprecipIn, double totalprecipMm, double totalsnowCm,
               double uv) {
        this.avghumidity = avghumidity;
        this.avgtempC = avgtempC;
        this.avgtempF = avgtempF;
        this.avgvisKm = avgvisKm;
        this.avgvisMiles = avgvisMiles;
        this.condition = condition;
        this.dailyChanceOfRain = dailyChanceOfRain;
        this.dailyChanceOfSnow = dailyChanceOfSnow;
        this.dailyWillItRain = dailyWillItRain;
        this.dailyWillItSnow = dailyWillItSnow;
        this.maxtempC = maxtempC;
        this.maxtempF = maxtempF;
        this.maxwindKph = maxwindKph;
        this.maxwindMph = maxwindMph;
        this.mintempC = mintempC;
        this.mintempF = mintempF;
        this.totalprecipIn = totalprecipIn;
        this.totalprecipMm = totalprecipMm;
        this.totalsnowCm = totalsnowCm;
        this.uv = uv;
    }

    // Getters and Setters
    public int getAvghumidity() {
        return avghumidity;
    }

    public void setAvghumidity(int avghumidity) {
        this.avghumidity = avghumidity;
    }

    public double getAvgtempC() {
        return avgtempC;
    }

    public void setAvgtempC(double avgtempC) {
        this.avgtempC = avgtempC;
    }

    public double getAvgtempF() {
        return avgtempF;
    }

    public void setAvgtempF(double avgtempF) {
        this.avgtempF = avgtempF;
    }

    public double getAvgvisKm() {
        return avgvisKm;
    }

    public void setAvgvisKm(double avgvisKm) {
        this.avgvisKm = avgvisKm;
    }

    public double getAvgvisMiles() {
        return avgvisMiles;
    }

    public void setAvgvisMiles(double avgvisMiles) {
        this.avgvisMiles = avgvisMiles;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public int getDailyChanceOfRain() {
        return dailyChanceOfRain;
    }

    public void setDailyChanceOfRain(int dailyChanceOfRain) {
        this.dailyChanceOfRain = dailyChanceOfRain;
    }

    public int getDailyChanceOfSnow() {
        return dailyChanceOfSnow;
    }

    public void setDailyChanceOfSnow(int dailyChanceOfSnow) {
        this.dailyChanceOfSnow = dailyChanceOfSnow;
    }

    public int getDailyWillItRain() {
        return dailyWillItRain;
    }

    public void setDailyWillItRain(int dailyWillItRain) {
        this.dailyWillItRain = dailyWillItRain;
    }

    public int getDailyWillItSnow() {
        return dailyWillItSnow;
    }

    public void setDailyWillItSnow(int dailyWillItSnow) {
        this.dailyWillItSnow = dailyWillItSnow;
    }

    public double getMaxtempC() {
        return maxtempC;
    }

    public void setMaxtempC(double maxtempC) {
        this.maxtempC = maxtempC;
    }

    public double getMaxtempF() {
        return maxtempF;
    }

    public void setMaxtempF(double maxtempF) {
        this.maxtempF = maxtempF;
    }

    public double getMaxwindKph() {
        return maxwindKph;
    }

    public void setMaxwindKph(double maxwindKph) {
        this.maxwindKph = maxwindKph;
    }

    public double getMaxwindMph() {
        return maxwindMph;
    }

    public void setMaxwindMph(double maxwindMph) {
        this.maxwindMph = maxwindMph;
    }

    public double getMintempC() {
        return mintempC;
    }

    public void setMintempC(double mintempC) {
        this.mintempC = mintempC;
    }

    public double getMintempF() {
        return mintempF;
    }

    public void setMintempF(double mintempF) {
        this.mintempF = mintempF;
    }

    public double getTotalprecipIn() {
        return totalprecipIn;
    }

    public void setTotalprecipIn(double totalprecipIn) {
        this.totalprecipIn = totalprecipIn;
    }

    public double getTotalprecipMm() {
        return totalprecipMm;
    }

    public void setTotalprecipMm(double totalprecipMm) {
        this.totalprecipMm = totalprecipMm;
    }

    public double getTotalsnowCm() {
        return totalsnowCm;
    }

    public void setTotalsnowCm(double totalsnowCm) {
        this.totalsnowCm = totalsnowCm;
    }

    public double getUv() {
        return uv;
    }

    public void setUv(double uv) {
        this.uv = uv;
    }
}

