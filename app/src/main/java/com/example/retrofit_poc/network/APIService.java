package com.example.retrofit_poc.network;

import com.example.retrofit_poc.model.ResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("/2.3/users?order=desc&sort=reputation&site=stackoverflow")
    Call<List<ResponseModel>> getUsersList();
}
