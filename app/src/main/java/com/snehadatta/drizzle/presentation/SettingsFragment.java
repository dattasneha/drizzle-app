package com.snehadatta.drizzle.presentation;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.EditTextPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreference;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.snehadatta.drizzle.R;

import java.util.Objects;

public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {

    private static final String KEY_USE_DEVICE_LOCATION = "USE_Device_Location";
    private static final String KEY_CUSTOM_LOCATION = "CUSTOM_LOCATION";
    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_future_weather, container, false);
    }


    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
        updateSummary();
    }


    @Override
    public void onResume() {
        super.onResume();
        Objects.requireNonNull(getPreferenceScreen().getSharedPreferences()).registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        Objects.requireNonNull(getPreferenceScreen().getSharedPreferences()).unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, @Nullable String key) {
        assert key != null;
        if (key.equals(KEY_USE_DEVICE_LOCATION) || key.equals(KEY_CUSTOM_LOCATION)) {
            updateSummary();
        }
    }
    private void updateSummary() {
        SharedPreferences sharedPreferences = getPreferenceManager().getSharedPreferences();

        SwitchPreference useDeviceLocationPref = findPreference(KEY_USE_DEVICE_LOCATION);
        EditTextPreference customLocationPref = findPreference(KEY_CUSTOM_LOCATION);

        assert sharedPreferences != null;
        boolean useDeviceLocation = sharedPreferences.getBoolean(KEY_USE_DEVICE_LOCATION, true);
        String customLocation = sharedPreferences.getString(KEY_CUSTOM_LOCATION, "Kolkata");

        if (useDeviceLocation) {
            if (customLocationPref != null) {
                customLocationPref.setEnabled(false);
                customLocationPref.setSummary("Using Device Location");
            }
        } else {
            if (customLocationPref != null) {
                customLocationPref.setEnabled(true);
                customLocationPref.setSummary("Current: " + customLocation);
            }
        }
    }
}