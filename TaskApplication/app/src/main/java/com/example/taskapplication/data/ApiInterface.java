package com.example.taskapplication.data;

import com.example.taskapplication.Pogo.ResponseResult;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface
{
    @GET("api/nutrition-data")
    Single<ResponseResult> GetNutritionDetails(@Query("app_id") String app_Id, @Query("app_key") String app_key, @Query("ingr") String ingr);

}
