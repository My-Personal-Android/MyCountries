package com.mycountries.model;

import com.google.gson.annotations.SerializedName;

public class CountryModel {

    @SerializedName("name")
    String countryName;

    @SerializedName("capital")
    String countryCapital;

    @SerializedName("flagPNG")
    String countryFlag;

    public CountryModel(String countryName, String countryCapital, String countryFlag) {
        this.countryName = countryName;
        this.countryCapital = countryCapital;
        this.countryFlag = countryFlag;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public void setCountryCapital(String countryCapital) {
        this.countryCapital = countryCapital;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(String countryFlag) {
        this.countryFlag = countryFlag;
    }
}
