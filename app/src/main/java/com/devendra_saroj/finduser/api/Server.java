package com.devendra_saroj.finduser.api;

import com.devendra_saroj.finduser.model.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Server {

    @GET("/search/users?q=language:java+location:India")
    Call<ItemResponse> getItems();
}
