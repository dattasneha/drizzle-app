package com.snehadatta.drizzle;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import com.google.android.material.navigation.NavigationBarView;
import com.snehadatta.drizzle.databinding.ActivityMainBinding;
import com.snehadatta.drizzle.presentation.SettingsFragment;
import com.snehadatta.drizzle.presentation.current_weather.CurrentWeatherFragment;
import com.snehadatta.drizzle.presentation.future_weather.FutureWeatherFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private CurrentWeatherFragment homeFragment;
    private FutureWeatherFragment futureWeatherFragment;
    private SettingsFragment settingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        homeFragment = new CurrentWeatherFragment();
        futureWeatherFragment = new FutureWeatherFragment();
        settingsFragment = new SettingsFragment();
        loadFragment(homeFragment);

        binding.btmNavBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull android.view.MenuItem item) {
                int menuItemId = item.getItemId();
                if(menuItemId == R.id.home) {
                    loadFragment(homeFragment);
                    return true;
                }
                else if(menuItemId == R.id.future_weather) {
                    loadFragment(futureWeatherFragment);
                    return true;
                }
                else if (menuItemId == R.id.settings) {
                    loadFragment(settingsFragment);
                    return true;
                }
                return false;
            }
        });

        applyTheme();
        applyFontSize();
    }

    private void loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }
    }

    private void applyTheme() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = prefs.getString("THEME_PREFERENCE", "system");

        switch (theme) {
            case "light":
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            case "dark":
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            default:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                break;
        }
    }

    private void applyFontSize() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String fontSize = prefs.getString("FONT_SIZE_PREFERENCE", "medium");

        float scale;
        switch (fontSize) {
            case "small":
                scale = 0.85f;
                break;
            case "large":
                scale = 1.15f;
                break;
            case "xlarge":
                scale = 1.3f;
                break;
            default:
                scale = 1.0f;
                break;
        }

        Configuration config = new Configuration();
        config.fontScale = scale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

    }
}