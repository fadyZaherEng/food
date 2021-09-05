package com.example.taskapplication.data;

import com.example.taskapplication.Pogo.ResponseResult;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class NutritionClient
{
  private static NutritionClient INSTANCE;
  private static final String BASE_URL="https://api.edamam.com/";
  private ApiInterface anInterface;

  public  NutritionClient(){
      Retrofit retrofit = new Retrofit.Builder()
              .baseUrl(BASE_URL)
              .addConverterFactory(GsonConverterFactory.create())
              .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
              .build();
      anInterface = retrofit.create(ApiInterface.class);
  }

    public static NutritionClient getINSTANCE()
    {
        if (INSTANCE==null) INSTANCE=new NutritionClient();
        return INSTANCE;
    }
    public Single<ResponseResult> GetData(String app_id, String app_key, String ingr)
    {
        return anInterface.GetNutritionDetails(app_id,app_key,ingr);
    }
}
