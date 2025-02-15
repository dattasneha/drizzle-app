package com.snehadatta.drizzle.util;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class ErrorResponseParserUtil {
    private static final String TAG = "ErrorResponseParserUtil";
    public static <T> String getErrorMessage(Response<T> errorResponse) {
        try {
            ResponseBody errorBody = errorResponse.errorBody();
            if (errorBody != null) {
                String errorString = errorBody.string();
                return new JSONObject(errorString).getString("message");
            } else {
                Log.e(TAG, "Error body is null.");
                return "An unexpected error occurred.";
            }
        } catch (JSONException e) {
            Log.e(TAG, "Failed to parse error message: " + e.getMessage());
            return "An error occurred. Please try again.";
        } catch (IOException e) {
            Log.e(TAG, "Failed to read error body: " + e.getMessage());
            return "An error occurred. Please try again.";
        }
    }
}