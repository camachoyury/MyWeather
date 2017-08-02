package com.itmaster.myweather.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by yury.camacho on 7/31/17.
 */

public class ConnectionController {



    public String getHTTPData(String city, String queryType){

        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        String cityEncode;
        String result = "";
        try {
            cityEncode = URLEncoder.encode(city,"UTF-8");
            URL url = new URL(Constants.BASE_URL+ queryType +Constants.QUERY+  cityEncode + Constants.APP_ID+Constants.UNITS);
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
            result = json.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}
