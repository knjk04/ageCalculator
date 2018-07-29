package com.example.karan.agecalculator;

/**
 * Created by karan on 26/06/18
 */
class ConvertedVal {
    String strCalculatedValue;
    String strUnit;

    public ConvertedVal(String calculatedValue, String strUnit) {
        this.strCalculatedValue = calculatedValue;
        this.strUnit = strUnit;
    }

    public String getStrCalculatedValue() {
        return strCalculatedValue;
    }

    public void setStrCalculatedValue(String strCalculatedValue) {
        this.strCalculatedValue = strCalculatedValue;
    }

    public String getStrUnit() {
        return strUnit;
    }

    public void setStrUnit(String strUnit) {
        this.strUnit = strUnit;
    }
}
