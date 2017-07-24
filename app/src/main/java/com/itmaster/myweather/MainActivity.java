package com.itmaster.myweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.itmaster.myweather.model.Forecast;

import static android.R.attr.button;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        button.setOnClickListener(this);

        Forecast forecast = new Forecast("Buenos Aires", "12:30", "12-12-2017", "30", "3.4", "18", "-3", "45", "90%", "Nublado");
        updateWeather(forecast);

    }

    private void updateWeather(Forecast forecast) {

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


            Intent intent = new Intent(this, ForecastActivity.class);
            startActivity(intent);
        }
    }
}
