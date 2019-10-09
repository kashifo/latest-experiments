package com.github.latestexperiments.mvvm_kotlin

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.latestexperiments.R
import kotlinx.android.synthetic.main.item_holiday.view.*

/**
 * Created by Kashif on 10/9/2019.
 */
class HolidayAdapter() : RecyclerView.Adapter<HolidayAdapter.ViewHolder>() {

    val TAG = javaClass.simpleName
    var arrList: ArrayList<HolidayModel>

    init {
        arrList = ArrayList()
    }

    fun addData(arrList: ArrayList<HolidayModel>){
        this.arrList = arrList
    }

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int):  ViewHolder {
        return  ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_holiday, parent, false))
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var tvTitle = view.tvTitle
        var tvText = view.tvText
    }

    override fun getItemCount(): Int {
        return if (arrList != null) arrList.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {

        Log.e(TAG, "onBindViewHolder-"+arrList.get(pos).toString() )

        holder.tvTitle.text = arrList.get(pos).date
        holder.tvText.text = arrList.get(pos).name

    }//onBind


}