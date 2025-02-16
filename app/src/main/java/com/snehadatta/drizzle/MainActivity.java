package com.snehadatta.drizzle;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.preference.PreferenceManager;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationBarView;
import com.snehadatta.drizzle.data.model.ForecastResponse;
import com.snehadatta.drizzle.databinding.ActivityMainBinding;
import com.snehadatta.drizzle.presentation.MainViewModel;
import com.snehadatta.drizzle.presentation.SettingsFragment;
import com.snehadatta.drizzle.presentation.current_weather.CurrentWeatherFragment;
import com.snehadatta.drizzle.presentation.future_weather.FutureWeatherFragment;
import com.snehadatta.drizzle.util.LocationName;
import com.snehadatta.drizzle.util.Resource;

import java.io.Serializable;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private CurrentWeatherFragment homeFragment;
    private FutureWeatherFragment futureWeatherFragment;
    private SettingsFragment settingsFragment;
    private MainViewModel mainViewModel;
    private LocationName locationName;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1001;
    private FusedLocationProviderClient fusedLocationClient;
    private SharedPreferences sharedPreferences;
    private  String  API_KEY = "fba9573acc654d7a995110405240808";
    private int days = 2;
    private String aqi = "yes";
    private String alerts = "yes";
    private String lastLocation = "";
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
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // Initialize location provider
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        // Get last saved location from SharedPreferences
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        lastLocation = sharedPreferences.getString("CUSTOM_LOCATION", "kolkata");
        mainViewModel.getForeCast(API_KEY,lastLocation, days,aqi,alerts);

        checkAndUpdateLocation();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean useDeviceLocation = sharedPreferences.getBoolean("USE_Device_Location", true);
        String newLocation = sharedPreferences.getString("CUSTOM_LOCATION", "kolkata");

        if (useDeviceLocation) {
            requestDeviceLocation();
        } else if (!newLocation.equals(lastLocation)) {
            lastLocation = newLocation;
            mainViewModel.getForeCast(API_KEY,newLocation, days,aqi,alerts);
        }
    }

    private void loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }
    }
    // Check if device location is enabled or use custom location
    private void checkAndUpdateLocation() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean useDeviceLocation = sharedPreferences.getBoolean("USE_Device_Location", true);

        if (useDeviceLocation) {
            requestDeviceLocation();
        } else {
            mainViewModel.getForeCast(API_KEY,lastLocation, days,aqi,alerts);
        }
    }

    private void requestDeviceLocation() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Request location permission
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
            return;
        }

        // Get last known location
        Task<android.location.Location> locationTask = fusedLocationClient.getLastLocation();
        locationTask.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(android.location.Location location) {
                if (location != null) {
                    locationName = new LocationName(location.getLatitude(), location.getLongitude(),MainActivity.this);
                    String cityName = locationName.getCityName();

                    if (cityName != null && !cityName.isEmpty()) {
                        lastLocation = cityName;

                        // Save location in SharedPreferences
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                        sharedPreferences.edit().putString("CUSTOM_LOCATION", cityName).apply();

                        // Trigger API call in ViewModel
                        mainViewModel.getForeCast(API_KEY,cityName, days,aqi,alerts);
                    } else {
                        Toast.makeText(MainActivity.this, "Unable to fetch location", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Location not available", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                requestDeviceLocation(); // Fetch location after permission granted
            } else {
                Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT).show();
            }
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