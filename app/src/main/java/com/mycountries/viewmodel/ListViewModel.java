package com.mycountries.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mycountries.model.CountryModel;

import java.util.ArrayList;
import java.util.List;

public class ListViewModel extends ViewModel {

    public MutableLiveData<List<CountryModel>> countries = new MutableLiveData<>();
    public MutableLiveData<Boolean> countryLoadError = new MutableLiveData<>();
    public MutableLiveData<Boolean> loading = new MutableLiveData<>();

    public void refresh(){

        fetchCountries();

    }

    private void fetchCountries(){

        CountryModel countryModel1 = new CountryModel("Abania","Tirana","");
        CountryModel countryModel2 = new CountryModel("Australia","Toranto","");
        CountryModel countryModel3 = new CountryModel("China","Huawei","");

        List<CountryModel> countryModelList = new ArrayList<>();
        countryModelList.add(countryModel1);
        countryModelList.add(countryModel2);
        countryModelList.add(countryModel3);

        countries.setValue(countryModelList);
        countryLoadError.setValue(false);
        loading.setValue(false);

    }
}
