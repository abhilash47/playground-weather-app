package com.playground.weather.app.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class WeatherResponse {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	Date date;
	String time;
	float temperature;
	String sunriseTime;
	String sunsetTime;
	float temperatureHigh;
	String temperatureHighTime;
	float temperatureLow;
	String temperatureLowTime;
	
}
