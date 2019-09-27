package com.github.latestexperiments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.github.latestexperiments.databinding.ActivityMainBinding;
import com.github.latestexperiments.mvvm_level1.CurrencyActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btnMvvmL1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnMvvmL1:
                Intent intent = new Intent(this, CurrencyActivity.class);
                startActivity(intent);
                break;

            default:;
        }

    }
}
