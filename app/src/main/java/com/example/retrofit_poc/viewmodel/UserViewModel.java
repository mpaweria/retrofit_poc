package com.example.retrofit_poc.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofit_poc.model.ResponseModel;
import com.example.retrofit_poc.network.APIService;
import com.example.retrofit_poc.network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserViewModel extends ViewModel {

    private MutableLiveData<List<ResponseModel>> usersList;

    public UserViewModel(){
        usersList = new MutableLiveData<>();
    }

    public MutableLiveData<List<ResponseModel>> getUsersListObserver() {
        return usersList;
    }

    public void makeApiCall() {
        APIService apiService = RetroInstance.getRetrofitClient().create(APIService.class);
        Call<List<ResponseModel>> call = apiService.getUsersList();
        call.enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                usersList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {
                usersList.postValue(null);
            }
        });
    }
}
