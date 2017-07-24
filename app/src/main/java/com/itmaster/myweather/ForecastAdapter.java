package com.itmaster.myweather;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itmaster.myweather.model.Forecast;


import java.util.List;

/**
 * Created by yury on 7/23/17.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>{


    private List<Forecast> forecastList;


    public ForecastAdapter(List<Forecast> forecasts){
        forecastList =  forecasts;
    }


    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_item,null);
        return new ForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {

        Forecast forecast = forecastList.get(position);
        holder.description.setText(forecast.getDescription());
        holder.humidity.setText(forecast.getHumidity());
        holder.weekday.setText(forecast.getDate());
        holder.max.setText(forecast.getMax());
        holder.min.setText(forecast.getMin());
    }

    @Override
    public int getItemCount() {
        return forecastList.size();
    }

    public static class ForecastViewHolder extends RecyclerView.ViewHolder {

        private ImageView icon;
        private TextView humidity;
        private TextView weekday;
        private TextView description;
        private TextView max;
        private TextView min;

        public ForecastViewHolder(View view) {
            super(view);
            icon = (ImageView) view.findViewById(R.id.item_icon);

            description = (TextView) view.findViewById(R.id.item_description);
            humidity = (TextView) view.findViewById(R.id.item_humidity);
            weekday = (TextView) view.findViewById(R.id.weekday);
            max = (TextView) view.findViewById(R.id.item_max);
            min = (TextView) view.findViewById(R.id.item_min);
        }
    }
}
