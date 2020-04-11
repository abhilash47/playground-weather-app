package com.playground.weather.app.domain;

import lombok.Data;

@Data
public class DailyData {

	long time;
    String summary;
    String icon;
    long sunriseTime;
    long sunsetTime;
    float moonPhase;
    float precipIntensity;
    float precipIntensityMax;
    long precipIntensityMaxTime;
    float precipProbability;
    String precipType;
    float temperatureHigh;
    long temperatureHighTime;
    float temperatureLow;
    long temperatureLowTime;
    float apparentTemperatureHigh;
    long apparentTemperatureHighTime;
    float apparentTemperatureLow;
    long apparentTemperatureLowTime;
    float dewPoint;
    float humidity;
    float pressure;
    float windSpeed;
    float windGust;
    long windGustTime;
    float windBearing;
    float cloudCover;
    float uvIndex;
    long uvIndexTime;
    float visibility;
    float ozone;
    float temperatureMin;
    long temperatureMinTime;
    float temperatureMax;
    long temperatureMaxTime;
    float apparentTemperatureMin;
    long apparentTemperatureMinTime;
    float apparentTemperatureMax;
    long apparentTemperatureMaxTime;
}
