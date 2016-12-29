package com.example.ravi.customlistviewwithcheckbox;

import com.google.gson.JsonArray;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Ravi on 29-12-2016.
 */
public interface DetailsAPI
{



    @GET("/json/movies.json")
    public void mymeth(Callback<JsonArray> jsonArrayCallback);
}
