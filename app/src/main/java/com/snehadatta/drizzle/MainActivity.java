package com.snehadatta.drizzle;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationBarView;
import com.snehadatta.drizzle.databinding.ActivityMainBinding;
import com.snehadatta.drizzle.presentation.SettingsFragment;
import com.snehadatta.drizzle.presentation.current_weather.CurrentWeatherFragment;
import com.snehadatta.drizzle.presentation.future_weather.FutureWeatherFragment;

import java.util.Objects;

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
        Objects.requireNonNull(getSupportActionBar()).hide();

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

    }
    private void loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }
    }
}