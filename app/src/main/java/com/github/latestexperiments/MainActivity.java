package com.github.latestexperiments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.github.latestexperiments.databinding.ActivityMainBinding;
import com.github.latestexperiments.mvvm_level1.CurrencyActivity;
import com.github.latestexperiments.mvvm_level2.CurrencyActivity2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btnMvvmL1.setOnClickListener(this);
        binding.btnMvvmL2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnMvvmL1: {
                Intent intent = new Intent(this, CurrencyActivity.class);
                startActivity(intent);
            }
            break;

            case R.id.btnMvvmL2: {
                Intent intent = new Intent(this, CurrencyActivity2.class);
                startActivity(intent);
            }
            break;

            default:;
        }

    }
}
