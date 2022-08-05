package com.example.frontintermedias;

import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.HashMap;
import java.util.List;

public interface Api {

    String BASE_URL = "http://34.82.130.245:3000/";
    @GET("getUsers")
    Call<Results> getUsers();

    @Headers("Content-Type: application/json")
    @POST("postRegistroUsuario")
    Call<User> postUser(@Body HashMap<String, Object> user);

    @Headers("Content-Type: application/json")
    @POST("postAssignCourse")
    Call<Assign> postAssignment(@Body HashMap<String, Object> assignment);
}