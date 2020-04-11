package com.playground.weather.app.domain;

import lombok.Data;

@Data
public class Currently {

	long time;
	String summary;
	String icon;
	float nearestStormDistance;
	float nearestStormBearing;
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
