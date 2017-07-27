package com.itmaster.myweather.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.itmaster.myweather.R;
import com.itmaster.myweather.model.Forecast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yury on 7/23/17.
 */

public class ForecastActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private ForecastAdapter adapter;
    private List<Forecast> forecastList = new ArrayList<Forecast>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        adapter = new ForecastAdapter(forecastList);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mLinearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLinearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        loadData();
    }


    private void loadData() {

        Forecast forecast = new Forecast( "12-12-2017", "30 C", "3.4", "18", "-3", "45", "90%", "Nublado");
        forecastList.add(forecast);
        Forecast forecast1 = new Forecast( "12-12-2017", "30 C", "3.4", "18", "-3", "45", "90%", "Nublado");
        forecastList.add(forecast1);
        Forecast forecast2 = new Forecast( "12-12-2017", "30 C", "3.4", "18", "-3", "45", "90%", "Nublado");
        forecastList.add(forecast2);
        Forecast forecast3 = new Forecast( "12-12-2017", "30 C", "3.4", "18", "-3", "45", "90%", "Nublado");
        forecastList.add(forecast3);
        Forecast forecast4 = new Forecast( "12-12-2017", "30 C", "3.4", "18", "-3", "45", "90%", "Nublado");
        forecastList.add(forecast4);
        Forecast forecast5 = new Forecast( "12-12-2017", "30 C", "3.4", "18", "-3", "45", "90%", "Nublado");
        forecastList.add(forecast5);


        adapter.notifyDataSetChanged();


    }
}
