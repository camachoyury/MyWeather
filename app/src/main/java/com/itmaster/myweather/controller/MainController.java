package com.itmaster.myweather.controller;

import android.os.AsyncTask;

import com.itmaster.myweather.Parser;
import com.itmaster.myweather.model.Forecast;
import com.itmaster.myweather.view.WeatherFragment;

/**
 * Created by yury on 7/26/17.
 */

public class MainController extends AsyncTask<String, Void,String>{

    private WeatherFragment weatherFragment;



    public MainController(WeatherFragment weatherFragment) {
        this.weatherFragment = weatherFragment;
    }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        weatherFragment.showProgressbar();

    }

    @Override
    protected String doInBackground(String... strings) {

        ConnectionController connectionController = new ConnectionController();
        return  connectionController.getHTTPData(strings[0].toString(),Constants.WEATHER);

    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        Forecast forecast = Parser.getForecast(s);
        weatherFragment.updateWeather(forecast);

        weatherFragment.hideProgressbar();
    }
}
