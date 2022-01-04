package com.mycountries.model;

import com.mycountries.di.DaggerApiComponent;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class CountriesService {

    @Inject
    public CountriesApi api ;

    private static CountriesService instance;

    private CountriesService(){
        DaggerApiComponent.create().inject(this);
    }

    public static CountriesService getInstance(){
        if( null == instance){
            instance = new CountriesService();
        }
        return instance;
    }

    public Single<List<CountryModel>> getCountries(){
        return api.getCountries();
    }
}
