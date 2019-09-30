package com.github.latestexperiments.mvvm_level2;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Kashif on 9/27/2019.
 */
public class CurrencyViewModel2 extends ViewModel {

    private CurrencyRepo2 currencyRepo;

    public CurrencyViewModel2(){
        currencyRepo = new CurrencyRepo2();
    }

    public LiveData<List<CurrencyPojo>> getCurrencies() {
        return currencyRepo.getMldCurrencyList();
    }

}
