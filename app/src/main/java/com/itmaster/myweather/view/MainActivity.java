package com.itmaster.myweather.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.itmaster.myweather.R;
import com.itmaster.myweather.Utils;
import com.itmaster.myweather.controller.MainController;
import com.itmaster.myweather.model.Forecast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    TextView city;
    TextView time;
    TextView date;
    TextView current;
    TextView wind;
    TextView max;
    TextView min;
    TextView pressure;
    TextView humidity;
    Button button;
    ProgressBar progressBar;
    ImageView icon;
    EditText inputCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputCity = (EditText) findViewById(R.id.inputCity);
        city = (TextView) findViewById(R.id.city);
        time = (TextView) findViewById(R.id.time);
        date = (TextView) findViewById(R.id.date);
        current = (TextView) findViewById(R.id.current);
        wind = (TextView) findViewById(R.id.wind);
        max = (TextView) findViewById(R.id.max);
        min = (TextView) findViewById(R.id.min);
        pressure = (TextView) findViewById(R.id.pressure);
        humidity = (TextView) findViewById(R.id.humidity);
        button = (Button) findViewById(R.id.pronosticos);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        icon = (ImageView) findViewById(R.id.icon);
        button.setOnClickListener(this);

        new MainController(this).execute("Buenos%20Aires");








//        Forecast forecast = new Forecast("Buenos Aires", "12:30", "12-12-2017", "30", "3.4", "18", "-3", "45", "90%", "Nublado");
//        updateWeather(forecast);

    }

    public void updateWeather(Forecast forecast) {

        icon.setImageResource(Utils.getIconResourceForWeatherCondition(forecast.getIconCode()));
        city.setText(forecast.getCity());
        time.setText(forecast.getTime());
        date.setText(forecast.getDate());
        current.setText(forecast.getWeather());
        wind.setText(forecast.getWind());
        max.setText(forecast.getMax());
        min.setText(forecast.getMin());
        pressure.setText(forecast.getPressure());
        humidity.setText(forecast.getHumidity());

    }

    @Override
    public void onClick(View view) {

        if(view == button){

            String value = inputCity.getText().toString();

            new MainController(this).execute(value);
        }
    }


    public void showProgressbar(){
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgressbar(){
        progressBar.setVisibility(View.INVISIBLE);
    }

}
