package com.itmaster.myweather;

import android.util.Log;

import com.itmaster.myweather.model.Forecast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by yury on 7/24/17.
 */

public class Parser {


    public static Forecast getForecast(String data){

        Forecast forecast = new Forecast();
        try {
            JSONObject json =  new JSONObject(data);



            JSONArray weather = getObjectArray("weather",json);

            JSONObject current = (JSONObject) weather.get(0);
            forecast.setDescription(getString("description",current));
            forecast.setIconCode(getInt("id",current));
            forecast.setCity(getString("name",json));

            JSONObject main = getObject("main",json);
            forecast.setWeather(getString("temp",main));
            forecast.setMax(getString("temp_max",main));
            forecast.setMin(getString("temp_min",main));
            forecast.setHumidity(getString("humidity",main));
            forecast.setPressure(getString("pressure",main));

            JSONObject wind = getObject("wind",json);
            forecast.setWind(getString("speed",wind));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return forecast;
    }

    private static JSONObject  getObject(String tagName, JSONObject jsonObject) throws JSONException{
        JSONObject subObj = jsonObject.getJSONObject(tagName);
        return subObj;
    }


    private static JSONArray  getObjectArray(String tagName, JSONObject jsonObject) throws JSONException{
        JSONArray subObj = jsonObject.getJSONArray(tagName);
        return subObj;
    }

    private static String getString(String tagName, JSONObject jsonObject) throws JSONException {

        return jsonObject.getString(tagName);

    }

    private static int  getInt(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getInt(tagName);
    }


    public static List<Forecast> getForecastList(String data){


        List<Forecast> forecastList = new ArrayList<Forecast>();
        try {

            JSONObject json = new JSONObject(data);
            JSONArray list = json.getJSONArray("list");

            for (int i = 0; i < list.length();i++ ){

                Forecast result = new Forecast();

                JSONObject forecastObject = (JSONObject) list.get(i);
                JSONObject main = forecastObject.getJSONObject("main");
                result.setMin(main.getString("temp_min"));
                result.setMax(main.getString("temp_max"));
                result.setHumidity(main.getString("humidity"));

                JSONArray weatherArray = forecastObject.getJSONArray("weather");
                JSONObject weather =  (JSONObject) weatherArray.get(0);
                result.setIconCode(weather.getInt("id"));
                result.setDescription(weather.getString("description"));

                forecastList.add(result);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return forecastList;

    }
}
