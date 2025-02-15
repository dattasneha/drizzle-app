package com.snehadatta.drizzle.data.model;
import com.google.gson.annotations.SerializedName;

public class AirQuality {

    @SerializedName("co")
    private double co;

    @SerializedName("gb-defra-index")
    private int gbDefraIndex;

    @SerializedName("no2")
    private double no2;

    @SerializedName("o3")
    private double o3;

    @SerializedName("pm10")
    private double pm10;

    @SerializedName("pm2_5")
    private double pm25;

    @SerializedName("so2")
    private double so2;

    @SerializedName("us-epa-index")
    private int usEpaIndex;

    // Constructor
    public AirQuality(double co, int gbDefraIndex, double no2, double o3, double pm10, double pm25, double so2, int usEpaIndex) {
        this.co = co;
        this.gbDefraIndex = gbDefraIndex;
        this.no2 = no2;
        this.o3 = o3;
        this.pm10 = pm10;
        this.pm25 = pm25;
        this.so2 = so2;
        this.usEpaIndex = usEpaIndex;
    }

    // Getters and Setters
    public double getCo() {
        return co;
    }

    public void setCo(double co) {
        this.co = co;
    }

    public int getGbDefraIndex() {
        return gbDefraIndex;
    }

    public void setGbDefraIndex(int gbDefraIndex) {
        this.gbDefraIndex = gbDefraIndex;
    }

    public double getNo2() {
        return no2;
    }

    public void setNo2(double no2) {
        this.no2 = no2;
    }

    public double getO3() {
        return o3;
    }

    public void setO3(double o3) {
        this.o3 = o3;
    }

    public double getPm10() {
        return pm10;
    }

    public void setPm10(double pm10) {
        this.pm10 = pm10;
    }

    public double getPm25() {
        return pm25;
    }

    public void setPm25(double pm25) {
        this.pm25 = pm25;
    }

    public double getSo2() {
        return so2;
    }

    public void setSo2(double so2) {
        this.so2 = so2;
    }

    public int getUsEpaIndex() {
        return usEpaIndex;
    }

    public void setUsEpaIndex(int usEpaIndex) {
        this.usEpaIndex = usEpaIndex;
    }
}

