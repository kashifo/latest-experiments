package com.github.latestexperiments.mvvm_kotlin

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.latestexperiments.R
import kotlinx.android.synthetic.main.activity_currency2.*

class HolidaysActivity : AppCompatActivity() {

    val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency2)

        textView2.text = "U.S Public Holidays"
        rvCurrencyList.setHasFixedSize(true);
        val layoutManager = LinearLayoutManager(this)
        rvCurrencyList.setLayoutManager(layoutManager)
        rvCurrencyList.setItemAnimator(DefaultItemAnimator())

        val holidayAdapter = HolidayAdapter()
        rvCurrencyList.adapter = holidayAdapter

        val holidayViewModel = HolidayViewModel()
        holidayViewModel.getHolidays().observe(this, object: Observer<ArrayList<HolidayModel>>{
            override fun onChanged(t: ArrayList<HolidayModel>?) {
                Log.e(TAG, "observe onChanged()="+t?.size )
                progressBar.setVisibility(View.GONE)
                holidayAdapter.addData(t!!)
                holidayAdapter.notifyDataSetChanged()
            }
        })

    }
}
