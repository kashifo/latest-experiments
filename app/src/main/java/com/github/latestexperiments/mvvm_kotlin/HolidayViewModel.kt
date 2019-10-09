package com.github.latestexperiments.mvvm_kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Kashif on 10/9/2019.
 */
class HolidayViewModel() : ViewModel() {

    var holidayRepo: HolidayRepo? = null

    init {
        holidayRepo = HolidayRepo()
    }

    fun getHolidays(): LiveData<ArrayList<HolidayModel>> {
        return holidayRepo!!.fetchHolidays()
    }

}