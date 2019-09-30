package com.github.latestexperiments.mvvm_level2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.latestexperiments.R;
import com.github.latestexperiments.databinding.ItemCurrencyCardBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Kashif on 9/30/2019.
 */
public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.MyViewHolder> implements CurrencyClickListener {

    private List<CurrencyPojo> currencyList;

    public CurrencyAdapter() {
        currencyList = new ArrayList<>();
    }

    public void addCurrencyList(List<CurrencyPojo> currencyList) {
        this.currencyList = currencyList;
    }

    @Override
    public int getItemCount() {
        return currencyList!=null ? currencyList.size() : 0;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemCurrencyCardBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_currency_card, parent, false);

        return new MyViewHolder(binding);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public ItemCurrencyCardBinding binding;

        public MyViewHolder(ItemCurrencyCardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        CurrencyPojo pojo = currencyList.get(listPosition);
        holder.binding.setModel(pojo);
        holder.binding.setItemClickListener(this);

    }

    @Override
    public void onCurrencyClicked(CurrencyPojo pojo) {
        Log.e("CurrencyAdapter", "onCurrencyClicked()-"+pojo.toString() );
    }

}
