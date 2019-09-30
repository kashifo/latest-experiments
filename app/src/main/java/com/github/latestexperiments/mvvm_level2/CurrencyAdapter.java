package com.github.latestexperiments.mvvm_level2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.latestexperiments.R;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Kashif on 9/30/2019.
 */
public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.MyViewHolder> {

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
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_currency_card, parent, false);
        return new MyViewHolder(view);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvValue;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.tvTitle = (TextView) itemView.findViewById(R.id.tvCurrencyTitle);
            this.tvValue = (TextView) itemView.findViewById(R.id.tvCurrencyValue);
        }
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        holder.tvTitle.setText(currencyList.get(listPosition).getName());
        holder.tvValue.setText(currencyList.get(listPosition).getValue());

    }

}
