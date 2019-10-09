package com.github.latestexperiments;

import com.github.latestexperiments.mvvm_kotlin.HolidayModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Kashif on 9/27/2019.
 */
public interface ApiInterface {

    @GET()
    Call<String> getCurrencyList(@Url String URL);

    @GET()
    Call<ArrayList<HolidayModel>> getHolidays(@Url String URL);
}
