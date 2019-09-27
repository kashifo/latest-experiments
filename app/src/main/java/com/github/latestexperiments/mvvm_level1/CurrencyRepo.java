package com.github.latestexperiments.mvvm_level1;

import android.util.Log;

import com.github.latestexperiments.ApiInterface;
import com.github.latestexperiments.MyApplication;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kashif on 9/27/2019.
 */
public class CurrencyRepo {

    private final String TAG = getClass().getSimpleName();
    private final String URL = "https://api.exchangeratesapi.io/latest?base=USD";
    private CurrencyData currencyData = new CurrencyData();
    private MutableLiveData<CurrencyData> mutableLiveData = new MutableLiveData<>();

    public CurrencyRepo() {

    }

    public MutableLiveData<CurrencyData> getMutableLiveData() {

        ApiInterface apiService =
                MyApplication.getRetrofitClient().create(ApiInterface.class);

        apiService.getCurrencyList(URL).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.e(TAG, "getCurrencyList response="+response );

                if (response.isSuccessful()) {
                    String responseString = response.body();
                    Log.e(TAG, "getCurrencyList responseString="+responseString );

                    currencyData.setData(responseString);
                    mutableLiveData.setValue(currencyData);
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e(TAG, "getProdList onFailure" + call.toString());
            }
        });

        return mutableLiveData;
    }


}
