package com.example.taskapplication.ui.detailsActivity;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.taskapplication.Pogo.ResponseResult;
import com.example.taskapplication.data.NutritionClient;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ModelViewMain extends ViewModel
{
    MutableLiveData<ResponseResult> mutableLiveData=new MutableLiveData<>();
    CompositeDisposable disposable=new CompositeDisposable();
    public void GetData(String ingr)
    {
       Single<ResponseResult> observable= NutritionClient.getINSTANCE()
               .GetData("1393967d","bd0c6ebea99a87728365ef2b0432de2e",ingr)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread());
       disposable.add(observable.subscribe(O->Log.e("DDDDD",O.getTotalNutrients().getFAT().getLabel())));
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
