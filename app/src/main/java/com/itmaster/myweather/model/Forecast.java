package com.itmaster.myweather.model;

/**
 * Created by yury on 7/23/17.
 */

public class Forecast {

    private  String city;
    private String time;
    private String  date;
    private  String weather;
    private String description;
    private String  wind;
    private String  max;
    private String  min;
    private String  pressure;
    private String humidity;

    public Forecast() {
    }

    public Forecast(String city, String time, String date, String weather, String wind, String max, String min, String pressure, String humidity, String description) {
        this.city = city;
        this.time = time;
        this.date = date;
        this.weather = weather;
        this.wind = wind;
        this.max = max;
        this.min = min;
        this.pressure = pressure;
        this.humidity = humidity;
        this.description = description;
    }

    public Forecast(String date, String weather, String wind, String max, String min, String pressure, String humidity, String description) {

        this.date = date;
        this.weather = weather;
        this.wind = wind;
        this.max = max;
        this.min = min;
        this.pressure = pressure;
        this.humidity = humidity;
        this.description = description;

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

