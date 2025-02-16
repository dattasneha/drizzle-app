package com.snehadatta.drizzle.presentation;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.snehadatta.drizzle.data.model.ForecastResponse;
import com.snehadatta.drizzle.domain.MainRepository;
import com.snehadatta.drizzle.util.ErrorResponseParserUtil;
import com.snehadatta.drizzle.util.Resource;
import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class MainViewModel extends ViewModel {
    private final MainRepository mainRepository;
    private final MutableLiveData<Resource<ForecastResponse>> forecastLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> locationLiveData = new MutableLiveData<>();

    public void setLocation(String location) {
        locationLiveData.setValue(location);
    }

    public LiveData<String> getLocation() {
        return locationLiveData;
    }
    @Inject
    public MainViewModel(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    public LiveData<Resource<ForecastResponse>> getForecastLiveData() {
        return forecastLiveData;
    }

    public void getForeCast(String apiKey, String location, int days, String aqi, String alerts) {
        forecastLiveData.setValue(new Resource.Loading<>());

        mainRepository.getForeCast(apiKey, location, days, aqi, alerts).enqueue(new Callback<ForecastResponse>() {
            @Override
            public void onResponse(@NonNull Call<ForecastResponse> call, @NonNull Response<ForecastResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    forecastLiveData.setValue(new Resource.Success<>(response.body()));
                } else {
                    String errorMessage = ErrorResponseParserUtil.getErrorMessage(response);
                    forecastLiveData.setValue(new Resource.Error<>(errorMessage));
                }
            }

            @Override
            public void onFailure(@NonNull Call<ForecastResponse> call, @NonNull Throwable t) {
                forecastLiveData.setValue(new Resource.Error<>(t.getMessage() != null ? t.getMessage() : "Network error occurred"));
            }
        });
    }
}