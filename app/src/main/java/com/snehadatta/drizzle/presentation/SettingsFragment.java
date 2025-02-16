package com.snehadatta.drizzle.presentation;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.SwitchPreference;

import android.view.View;

import com.snehadatta.drizzle.R;

import java.util.Objects;

public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {

    private static final String KEY_USE_DEVICE_LOCATION = "USE_Device_Location";
    private static final String KEY_CUSTOM_LOCATION = "CUSTOM_LOCATION";
    private static final String KEY_THEME_PREFERENCE = "THEME_PREFERENCE";
    private static final String KEY_FONT_SIZE_PREFERENCE = "FONT_SIZE_PREFERENCE";
    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
        updateSummary();

        ListPreference themePreference = findPreference(KEY_THEME_PREFERENCE);
        ListPreference fontSizePreference = findPreference(KEY_FONT_SIZE_PREFERENCE);

        if (themePreference != null) {
            themePreference.setOnPreferenceChangeListener((preference, newValue) -> {
                showRestartDialog(() -> applyTheme((String) newValue));
                return false; // Prevent automatic change before confirmation
            });
        }

        if (fontSizePreference != null) {
            fontSizePreference.setOnPreferenceChangeListener((preference, newValue) -> {
                showRestartDialog(() -> applyFontSize((String) newValue));
                return false;
            });
        }
    }

    private void showRestartDialog(Runnable onConfirm) {
        new AlertDialog.Builder(requireContext())
                .setTitle("Restart Required")
                .setMessage("Changing this setting will restart the app. Do you want to continue?")
                .setPositiveButton("Yes", (dialog, which) -> onConfirm.run())
                .setNegativeButton("Cancel", null)
                .show();
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

    private void applyTheme(String themeValue) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(requireContext()).edit();
        editor.putString(KEY_THEME_PREFERENCE, themeValue);
        editor.apply();

        requireActivity().recreate(); // Restart activity to apply theme
    }

    private void applyFontSize(String fontSize) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(requireContext()).edit();
        editor.putString(KEY_FONT_SIZE_PREFERENCE, fontSize);
        editor.apply();

        requireActivity().recreate(); // Restart activity to apply font size
    }
}