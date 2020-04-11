package com.playground.weather.domain;

import lombok.Data;

@Data
public class WeatherResponse {

	String date;
	String time;
	String temperature;
	String sunriseTime;
	String sunsetTime;
	String temperatureHigh;
	String temperatureHighTime;
	String temperatureLow;
	String temperatureLowTime;
	
}
