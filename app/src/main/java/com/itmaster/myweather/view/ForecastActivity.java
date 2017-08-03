package com.itmaster.myweather.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.itmaster.myweather.R;
import com.itmaster.myweather.controller.Constants;
import com.itmaster.myweather.controller.ForecastController;
import com.itmaster.myweather.model.Forecast;

import org.json.JSONException;
import org.json.JSONObject;

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

        adapter = new ForecastAdapter(forecastList, new ForecastAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Forecast forecast , int source) {
                if (source == ForecastAdapter.IMAGE_SOURCE){
                    Toast.makeText(getBaseContext(),"ESTE ES EL CLIMA : "+forecast.getDescription(), Toast.LENGTH_LONG).show();
                }if (source == ForecastAdapter.LAYOUT_SOURCE){

                    Toast.makeText(getBaseContext(),"ESTE ES EL CLIMA MAXIMO: "+forecast.getMax(), Toast.LENGTH_LONG).show();
                }


            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mLinearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLinearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        new ForecastController(this).execute("Buenos Aires", Constants.FORECAST);

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


    public void updateForecast(List<Forecast> forecastList){

//        forecastList.addAll(forecastList);
        adapter = new ForecastAdapter(forecastList, new ForecastAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Forecast forecast , int source) {
                if (source == ForecastAdapter.IMAGE_SOURCE){
                    Toast.makeText(getBaseContext(),"ESTE ES EL CLIMA : "+forecast.getDescription(), Toast.LENGTH_LONG).show();
                }if (source == ForecastAdapter.LAYOUT_SOURCE){

                    Toast.makeText(getBaseContext(),"ESTE ES EL CLIMA MAXIMO: "+forecast.getMax(), Toast.LENGTH_LONG).show();
                }


            }
        });

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();





    }
}
