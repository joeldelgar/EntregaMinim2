package com.example.minim2exemple;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {

    @GET("users/{id}")
    Call<User> getInfoUser(@Path("id") String userid);

    @GET("users/{id}/followers")
    Call<List<User>> getFollowers(@Path("id") String userid);
}
