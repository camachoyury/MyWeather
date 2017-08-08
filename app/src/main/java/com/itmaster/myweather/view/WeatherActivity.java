package com.itmaster.myweather.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.itmaster.myweather.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yury on 8/7/17.
 */

public class WeatherActivity extends FragmentActivity {

    private ViewPager pager;
    WeatherPageAdapter pagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        pager = (ViewPager) findViewById(R.id.pager);

        pagerAdapter = new WeatherPageAdapter(getSupportFragmentManager(), createFragments());

        pager.setAdapter(pagerAdapter);

    }


    public List<Fragment> createFragments(){
        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(WeatherFragment.newInstance("Weather"));
        fragments.add(ForecastFragment.newInstance("Forecast"));
        return fragments;



    }
}
