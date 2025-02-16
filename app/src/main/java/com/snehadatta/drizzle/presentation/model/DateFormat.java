package com.snehadatta.drizzle.presentation.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormat {
    private String hourTime;

    public DateFormat(String hourTime) { this.hourTime = hourTime; }

    public  String getFormattedDate() {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US);
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        try {
            Date date = inputFormat.parse(hourTime);
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return hourTime;
        }
    }


}
