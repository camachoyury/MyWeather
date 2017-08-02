package com.itmaster.myweather.controller;

import android.os.AsyncTask;
import android.speech.tts.Voice;

import com.itmaster.myweather.Parser;
import com.itmaster.myweather.model.Forecast;
import com.itmaster.myweather.view.ForecastActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by yury.camacho on 7/31/17.
 */

public class ForecastController  extends AsyncTask<String, Void, String>{


    private ForecastActivity activity;

    public ForecastController(ForecastActivity activity) {
        this.activity = activity;
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

        activity.updateForecast(forecasts);



    }

}
