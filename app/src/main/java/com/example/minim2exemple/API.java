package com.example.minim2exemple;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {

    @GET("users/{username}")
    Call<User> getInfoUser(@Path("id") String username);

    @GET("users/{username}/followers")
    Call<List<User>> getFollowers(@Path("id") String username);
}
