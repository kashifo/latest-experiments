package com.github.latestexperiments.mvvm_level2;

import android.os.Bundle;
import android.view.View;

import com.github.latestexperiments.R;
import com.github.latestexperiments.databinding.ActivityCurrency2Binding;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

public class CurrencyActivity2 extends AppCompatActivity {

    final String TAG = getClass().getSimpleName();
    ActivityCurrency2Binding binding;
    CurrencyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_currency2);

        binding.rvCurrencyList.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.rvCurrencyList.setLayoutManager(layoutManager);
        binding.rvCurrencyList.setItemAnimator(new DefaultItemAnimator());
        adapter = new CurrencyAdapter();
        binding.rvCurrencyList.setAdapter(adapter);

        CurrencyViewModel2 currencyViewModel = new CurrencyViewModel2();
        currencyViewModel.getCurrencies().observe(this, new Observer<List<CurrencyPojo>>() {
            @Override
            public void onChanged(List<CurrencyPojo> currencyPojos) {
                binding.progressBar.setVisibility(View.GONE);
                adapter.addCurrencyList(currencyPojos);
                adapter.notifyDataSetChanged();
            }
        });

    }

}
