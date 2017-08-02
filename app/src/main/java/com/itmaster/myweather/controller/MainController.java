package com.itmaster.myweather.controller;

import android.app.DownloadManager;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.itmaster.myweather.Parser;
import com.itmaster.myweather.model.Forecast;
import com.itmaster.myweather.view.MainActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by yury on 7/26/17.
 */

public class MainController extends AsyncTask<String, Void,String>{

    private MainActivity mainActivity;



    public MainController(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mainActivity.showProgressbar();

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
        mainActivity.updateWeather(forecast);

        mainActivity.hideProgressbar();
    }
}
