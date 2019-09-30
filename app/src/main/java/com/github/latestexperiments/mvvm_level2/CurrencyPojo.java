package com.github.latestexperiments.mvvm_level2;

/**
 * Created by Kashif on 9/27/2019.
 */
public class CurrencyPojo {

    private String name;
    private String value;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getValue() {

        return value;
    }

    public void setValue(String value) {

        this.value = value;
    }

    @Override
    public String toString() {
        return "CurrencyData{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
