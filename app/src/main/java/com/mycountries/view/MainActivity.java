package com.mycountries.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.mycountries.R;
import com.mycountries.model.CountryModel;
import com.mycountries.viewmodel.ListViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.countriesList)
    RecyclerView countriesList;

    @BindView(R.id.list_error)
    TextView listError;

    @BindView(R.id.loading_view)
    ProgressBar loadingView;

    private ListViewModel viewModel;
    private CountryListAdapter countryListAdapter = new CountryListAdapter(new ArrayList<>());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this).get(ListViewModel.class);
        viewModel.refresh();

        countriesList.setLayoutManager(new LinearLayoutManager(this));
        countriesList.setAdapter(countryListAdapter);

        setUpListeners();

        swipeRefreshLayout.setOnRefreshListener(() -> {
            viewModel.refresh();
            swipeRefreshLayout.setRefreshing(false);
        });
    }

    private void setUpListeners() {
        viewModel.countries.observe(this, countryModels -> {
            if(null != countryModels){
                countriesList.setVisibility(View.VISIBLE);
                countryListAdapter.swapCountries(countryModels);
            }
        });

        viewModel.countryLoadError.observe(this , isError->{
            if(null != isError){
                listError.setVisibility(isError ? View.VISIBLE : View.GONE);
            }
        });

        viewModel.loading.observe(this,isLoading->{
            if(null != isLoading){
                loadingView.setVisibility(isLoading ? View.VISIBLE : View.GONE);
                if(isLoading){
                    listError.setVisibility(View.GONE);
                    countriesList.setVisibility(View.GONE);
                }
            }
        });
    }


}