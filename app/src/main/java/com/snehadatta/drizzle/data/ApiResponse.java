package com.snehadatta.drizzle.data;

public class ApiResponse<T> {

    private int statusCode;
    private T data;
    private String message;
    private boolean success;

    // Constructor
    public ApiResponse(int statusCode, T data, String message, boolean success) {
        this.statusCode = statusCode;
        this.data = data;
        this.message = message;
        this.success = success;
    }

    // Getters and Setters
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

