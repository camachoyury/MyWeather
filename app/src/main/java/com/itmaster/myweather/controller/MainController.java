package com.itmaster.myweather.controller;

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

        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;


        try {

            String city = URLEncoder.encode(strings[0].toString(),"UTF-8");

            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=0a0d539af11f6d6fb40e37ae5fccafff&units=metric");

            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();

            InputStream inputStream = httpURLConnection.getInputStream();

            if (inputStream == null){
                return null;
            }


            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);


            bufferedReader = new BufferedReader(inputStreamReader);

            StringBuffer json = new StringBuffer();

            String line;

            while ((line = bufferedReader.readLine())!= null){

                json.append(line + "\n");
            }

            if (json.length() == 0){

                return null;
            }

            return json.toString();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        Forecast forecast = Parser.getForecast(s);
        mainActivity.updateWeather(forecast);

        mainActivity.hideProgressbar();
    }
}
