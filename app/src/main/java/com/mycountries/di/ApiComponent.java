package com.mycountries.di;

import com.mycountries.model.CountriesService;
import com.mycountries.viewmodel.ListViewModel;

import dagger.Component;

@Component(modules = {ApiModule.class})
public interface ApiComponent {
    void inject(CountriesService service);
    void inject(ListViewModel listViewModel);
}
