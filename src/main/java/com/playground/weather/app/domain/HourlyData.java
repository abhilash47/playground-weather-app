package com.playground.weather.app.domain;

import lombok.Data;

@Data
public class HourlyData {

	long time;
	String summary;
	String icon;
	float precipIntensity;
	float precipProbability;
	float temperature;
	float apparentTemperature;
	float dewPoint;
	float humidity;
	float pressure;
	float windSpeed;
	float windGust;
	float windBearing;
	float cloudCover;
	float uvIndex;
	float visibility;
	float ozone;
}

