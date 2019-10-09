package com.github.latestexperiments.mvvm_level2;

import android.util.Log;

import com.github.latestexperiments.ApiInterface;
import com.github.latestexperiments.Constants;
import com.github.latestexperiments.MyApplication;

import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kashif on 9/27/2019.
 */
public class CurrencyRepo2 {

    private final String TAG = getClass().getSimpleName();
    private ArrayList<CurrencyPojo> currencyList = new ArrayList<>();
    private MutableLiveData<List<CurrencyPojo>> mldCurrencyList = new MutableLiveData<>();

    public CurrencyRepo2() {

    }

    public MutableLiveData<List<CurrencyPojo>> getMldCurrencyList() {

        ApiInterface apiService =
                MyApplication.getRetrofitClient().create(ApiInterface.class);

        apiService.getCurrencyList(Constants.URL_EXCHANGE_RATES).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.e(TAG, "getCurrencyList response="+response );

                if (response.isSuccessful()) {
                    String responseString = response.body();
                    Log.e(TAG, "getCurrencyList responseString="+responseString );

                    try {
                        JSONObject jsonObject = new JSONObject(responseString);
                        JSONObject rateObj = jsonObject.getJSONObject("rates");

                        Iterator<String> keys = rateObj.keys();

                        while (keys.hasNext()) {
                            String name = keys.next();
                            String value = rateObj.getString(name);

                            CurrencyPojo pojo = new CurrencyPojo();
                            pojo.setName(name);

                            try {
                                Double d = Double.parseDouble(value);
                                DecimalFormat df = new DecimalFormat("0.00");
                                pojo.setValue( df.format(d) );
                            } catch (Exception e) {
                                e.printStackTrace();
                                pojo.setValue( value );
                            }

                            currencyList.add(pojo);
                        }

                        mldCurrencyList.setValue(currencyList);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e(TAG, "getProdList onFailure" + call.toString());
            }
        });

        return mldCurrencyList;
    }


}
