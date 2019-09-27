package com.github.latestexperiments;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Kashif on 9/27/2019.
 */
public interface ApiInterface {

    @GET()
    Call<String> getCurrencyList(@Url String URL);

}
