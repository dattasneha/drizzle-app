package com.snehadatta.drizzle.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.snehadatta.drizzle.data.ApiResponse;
import com.snehadatta.drizzle.data.model.ForecastResponse;
import com.snehadatta.drizzle.domain.MainRepository;
import com.snehadatta.drizzle.util.ErrorResponseParserUtil;
import com.snehadatta.drizzle.util.Resource;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private final MainRepository mainRepository;
    private final MutableLiveData<Resource<ForecastResponse>> forecastLiveData = new MutableLiveData<>();

    @Inject
    public MainViewModel(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    public LiveData<Resource<ForecastResponse>> getForecastLiveData() {
        return forecastLiveData;
    }

    public void getForeCast(String apiKey, String location, int days, String aqi, String alerts) {
        forecastLiveData.setValue(new Resource.Loading<>());

        mainRepository.getForeCast(apiKey, location, days, aqi, alerts).enqueue(new Callback<ApiResponse<ForecastResponse>>() {
            @Override
            public void onResponse(Call<ApiResponse<ForecastResponse>> call, Response<ApiResponse<ForecastResponse>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    forecastLiveData.setValue(new Resource.Success<>(response.body().getData()));
                } else {
                    String errorMessage = ErrorResponseParserUtil.getErrorMessage(response);
                    forecastLiveData.setValue(new Resource.Error<>(errorMessage));
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<ForecastResponse>> call, Throwable t) {
                forecastLiveData.setValue(new Resource.Error<>(t.getMessage() != null ? t.getMessage() : "Network error occurred"));
            }
        });
    }
}

