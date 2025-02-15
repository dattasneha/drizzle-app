package com.snehadatta.drizzle.data.model;

import com.google.gson.annotations.SerializedName;

public class Condition {

    @SerializedName("code")
    private int code;

    @SerializedName("icon")
    private String icon;

    @SerializedName("text")
    private String text;

    // Constructor
    public Condition(int code, String icon, String text) {
        this.code = code;
        this.icon = icon;
        this.text = text;
    }

    // Getters and Setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

