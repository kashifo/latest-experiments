package com.github.latestexperiments.mvvm_level1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import android.os.Bundle;

import com.github.latestexperiments.R;
import com.github.latestexperiments.databinding.ActivityCurrencyBinding;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

public class CurrencyActivity extends AppCompatActivity {

    final String TAG = getClass().getSimpleName();
    ActivityCurrencyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_currency);

        CurrencyViewModel currencyViewModel = new CurrencyViewModel();
        currencyViewModel.getCurrencies().observe(this, new Observer<CurrencyData>() {
            @Override
            public void onChanged(CurrencyData currencyData) {
                showPrettyJson(currencyData.getData());
            }
        });

    }

    void showPrettyJson(String text){

        try{
            JSONObject jsonObject = new JSONObject(text);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            text = gson.toJson(jsonObject);
        }catch (Exception e){
            e.printStackTrace();
        }

        binding.tvCurrencyData.setText( text );
    }


}
