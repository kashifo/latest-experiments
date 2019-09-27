package com.github.latestexperiments.mvvm_level1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Kashif on 9/27/2019.
 */
public class CurrencyViewModel extends ViewModel {

    private CurrencyRepo currencyRepo;

    public CurrencyViewModel(){
        currencyRepo = new CurrencyRepo();
    }

    public LiveData<CurrencyData> getCurrencies() {
        return currencyRepo.getMutableLiveData();
    }

}
