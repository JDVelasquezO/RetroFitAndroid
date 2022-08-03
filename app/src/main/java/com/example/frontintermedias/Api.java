package com.example.frontintermedias;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface Api {

    String BASE_URL = "http://34.82.130.245:3000/";
    @GET("getUsers")
    Call<Results> getUsers();
}