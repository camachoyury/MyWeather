package com.itmaster.myweather.controller;

import android.os.AsyncTask;

import com.itmaster.myweather.Parser;
import com.itmaster.myweather.model.Forecast;
import com.itmaster.myweather.view.ForecastFragment;

import java.util.List;

/**
 * Created by yury.camacho on 7/31/17.
 */

public class ForecastController  extends AsyncTask<String, Void, String>{

    private ForecastFragment fragment;

    public ForecastController(ForecastFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {

        ConnectionController connectionController = new ConnectionController();
        return connectionController.getHTTPData(strings[0],Constants.FORECAST);

    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        List<Forecast> forecasts = Parser.getForecastList(s);

        fragment.updateForecast(forecasts);

    }

}
