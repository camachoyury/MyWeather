package com.itmaster.myweather.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.itmaster.myweather.R;
import com.itmaster.myweather.Utils;
import com.itmaster.myweather.model.Forecast;


import java.util.List;

/**
 * Created by yury on 7/23/17.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>{


    private List<Forecast> forecastList;
    public OnItemClickListener listener;
    public final static int IMAGE_SOURCE = 1;
    public final static int LAYOUT_SOURCE = 2;

    public ForecastAdapter(List<Forecast> forecasts, OnItemClickListener listener){
        this.forecastList =  forecasts;
        this.listener = listener;
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_item,null);
        return new ForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {

        final Forecast forecast = forecastList.get(position);
        holder.description.setText(forecast.getDescription());
        holder.humidity.setText(forecast.getHumidity());
        holder.weekday.setText(forecast.getDate());
        holder.max.setText(forecast.getMax());
        holder.min.setText(forecast.getMin());
        holder.icon.setImageResource(Utils.getIconResourceForWeatherCondition(forecast.getIconCode()));
        holder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(forecast,IMAGE_SOURCE);
            }
        });
        holder.rightLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                listener.onItemClick(forecast,LAYOUT_SOURCE);
            }
        });


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
        private LinearLayout layoutItem;
        private LinearLayout rightLayout;

        public ForecastViewHolder(View view) {
            super(view);
            icon = (ImageView) view.findViewById(R.id.item_icon);

            description = (TextView) view.findViewById(R.id.item_description);
            humidity = (TextView) view.findViewById(R.id.item_humidity);
            weekday = (TextView) view.findViewById(R.id.weekday);
            max = (TextView) view.findViewById(R.id.item_max);
            min = (TextView) view.findViewById(R.id.item_min);
            layoutItem = (LinearLayout) view.findViewById(R.id.layout_item);
            rightLayout = (LinearLayout) view.findViewById(R.id.right_layout);

        }
    }


    public interface OnItemClickListener{

        void onItemClick(Forecast forecast, int source);

    }
}
