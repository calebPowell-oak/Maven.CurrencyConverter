package io.zipcoder.currencyconverterapplication;

import java.util.ArrayList;
import java.util.Arrays;

public enum CurrencyType {
    AUSTRALIAN_DOLLAR(2.70),
    CANADIAN_DOLLAR(2.64),
    CHINESE_YR(13.84),
    EURO(1.88),
    FRANC(2.02),
    POUND(1.64),
    RINGGIT(8.94),
    RUPEE(136.64),
    SINGAPORE_DOLLAR(1.86),
    US_DOLLAR(2.0),
    UNIVERSAL_CURRENCY(1.0),
    YEN(231.68);

    private final double rate;

    CurrencyType(double rate) {
        this.rate = rate;
    }

    public Double getRate() {
        return rate;
    }

    public static CurrencyType getTypeOfCurrency(ConvertableCurrency currency) {
        String[] name = currency.getClass().getSimpleName().split("");
        int capCount = 0;
        int i = 0;
        boolean spaceAdded = false;
        for(String letter : name){
            if(letter.matches("[A-Z]")){
                if(capCount != 0 && !spaceAdded && i > 1){
                    name[i] = "_" + name[i];
                    spaceAdded = true;
                }
                capCount++;
            }
            i++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(String letter : name){
            stringBuilder.append(letter);
        }
        if(capCount > 1){
            return valueOf(stringBuilder.toString().toUpperCase());
        } else {
            return valueOf(currency.getClass().getSimpleName().toUpperCase());
        }
    }
}
