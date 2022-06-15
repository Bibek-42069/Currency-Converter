package com;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converter {
    //Preset list of currencies
    private Currency[] listArray = new Currency[]{
            new Currency("USD", 1f),
            new Currency("Yen", 0.0075f),
            new Currency("Won", 0.00078f)
    };

    // Convert to list so user can edit this
    private List<Currency> list = new ArrayList<Currency>(Arrays.asList(listArray));

    public Currency StringToCurrency(String input) {
        for (Currency curr : list) {
            if (curr.name.equalsIgnoreCase(input))
                return curr;
        }

        return new Currency(null, 0.0f);
    }

    public void PrintValidCurrency(){
        for(Currency currency: list){
            System.out.println(currency.name);
        }
    }

    public float convert(float input, Currency inputCurrency, Currency outputCurrency) {
        if (inputCurrency.name.equals("USD")) {
            return input * outputCurrency.usdValue;
        }

        float usdEquivalent = input * inputCurrency.usdValue;

        return usdEquivalent * (1f/outputCurrency.usdValue);
    }

    public void AddNewCurrency(String name, float value){
        Currency newCurrency = new Currency(name,value);
        list.add(newCurrency);
    }

    // Checks if this is a valid choice
    public boolean validifyCurrentCurrency(String input) {
        for (Currency currency: list) {
            if (currency.name.equalsIgnoreCase(input))
                return true;
        }
        return false;
    }

    // Checks if this is a valid new currency
    public boolean validifyNewCurrency(String input){
        for(Currency currency: list){
            if(currency.name.equalsIgnoreCase(input))
                return false;
        }

        return true;
    }
}
