package com.playground.weather.app.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class WeatherResponse {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	Date date;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss.SSSZ")
	long time;
	float temperature;
	long sunriseTime;
	long sunsetTime;
	float temperatureHigh;
	long temperatureHighTime;
	float temperatureLow;
	long temperatureLowTime;
	
}
