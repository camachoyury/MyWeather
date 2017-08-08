package com.itmaster.myweather.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class WeatherFragment extends Fragment implements View.OnClickListener{


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
    public static String MESSAGE = "message";
    MainController controller;


    public static WeatherFragment newInstance(String message){

        WeatherFragment fragment =  new WeatherFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString(MESSAGE, message);
        fragment.setArguments(bundle);

       return  fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_main,container, false);

        String message = getArguments().getString(MESSAGE);


        inputCity = (EditText) view.findViewById(R.id.inputCity);
        city = (TextView) view.findViewById(R.id.city);
        time = (TextView) view.findViewById(R.id.time);
        date = (TextView) view.findViewById(R.id.date);
        current = (TextView) view.findViewById(R.id.current);
        wind = (TextView) view.findViewById(R.id.wind);
        max = (TextView) view.findViewById(R.id.max);
        min = (TextView) view.findViewById(R.id.min);
        pressure = (TextView) view.findViewById(R.id.pressure);
        humidity = (TextView) view.findViewById(R.id.humidity);
        button = (Button) view.findViewById(R.id.pronosticos);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        icon = (ImageView) view.findViewById(R.id.icon);
        button.setOnClickListener(this);


        controller = new MainController(this);
        controller.execute("Buenos%20Aires");
        button.setVisibility(View.INVISIBLE);

        return view;
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

        button.setVisibility(View.VISIBLE);

    }

    @Override
    public void onClick(View view) {

        if (controller.getStatus() == AsyncTask.Status.FINISHED){

            if(view == button){

                String value = inputCity.getText().toString();
                controller = new MainController(this);
                controller.execute(value);
            }
        }
    }

    public void showProgressbar(){
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgressbar(){
        progressBar.setVisibility(View.INVISIBLE);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (!controller.isCancelled()){
            controller.cancel(true);
        }
    }
}
