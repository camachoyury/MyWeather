package com.itmaster.myweather;

import android.util.Log;

import com.itmaster.myweather.model.Forecast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by yury on 7/24/17.
 */

public class Parser {


    public static Forecast getForecast(String data){

        Forecast forecast = new Forecast();

        try {

            JSONObject jsonArray =  new JSONObject(data);
            JSONArray weather = getObjectArray("weather",jsonArray);
            JSONObject current = (JSONObject) weather.get(0);
            forecast.setDescription(getString("description",current));
            forecast.setIconCode(getInt("id",current));
            forecast.setCity(getString("name",jsonArray));
            JSONObject main = getObject("main",jsonArray);
            forecast.setWeather(getString("temp",main));
            forecast.setMax(getString("temp_max",main));
            forecast.setMin(getString("temp_min",main));
            forecast.setHumidity(getString("humidity",main));
            forecast.setPressure(getString("pressure",main));
            JSONObject wind = getObject("wind",jsonArray);
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
}
