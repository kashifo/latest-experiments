package com.github.latestexperiments.mvvm_kotlin

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.github.latestexperiments.ApiInterface
import com.github.latestexperiments.Constants
import com.github.latestexperiments.MyApplication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Kashif on 10/9/2019.
 */
class HolidayRepo {

    val TAG = javaClass.simpleName
    var list: ArrayList<HolidayModel> = ArrayList()
    var mutableList: MutableLiveData<ArrayList<HolidayModel>> = MutableLiveData()

    fun fetchHolidays(): MutableLiveData<ArrayList<HolidayModel>>{
        val apiInterface = MyApplication.getRetrofitClient().create(ApiInterface::class.java)

        apiInterface.getHolidays(Constants.URL_HOLIDAYS).enqueue(object: Callback<ArrayList<HolidayModel>>{

            override fun onFailure(call: Call<ArrayList<HolidayModel>>, t: Throwable) {
                Log.e(TAG, "onFailure call="+call.toString() )
            }

            override fun onResponse(call: Call<ArrayList<HolidayModel>>, response: Response<ArrayList<HolidayModel>>) {
                Log.e(TAG, "onResponse response="+response.toString() )

                if(response.isSuccessful){
                    Log.e(TAG, "onResponse response.size="+response.body()?.size )

                    if(response.body()!=null && response.body()?.size!!>0 ) {
                        list.addAll(response.body()!!)
                        mutableList.value = list
                    }
                }

            }

        })

        return mutableList
    }

}