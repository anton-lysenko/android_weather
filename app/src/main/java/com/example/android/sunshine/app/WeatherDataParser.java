package com.example.android.sunshine.app;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Created by alys on 13/10/2016.
 */

public class WeatherDataParser {
    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */
    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex) throws JSONException {
        JSONObject oWeatherData     = new JSONObject(weatherJsonStr);
        JSONArray  aWeatherForecast = oWeatherData.getJSONArray("list");
        JSONObject oDayForecast     = aWeatherForecast.getJSONObject(dayIndex);
        JSONObject dayTemperature   = oDayForecast.getJSONObject("temp");

        return dayTemperature.getDouble("max");
    }
}
