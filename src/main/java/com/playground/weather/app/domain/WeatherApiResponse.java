package com.playground.weather.app.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class WeatherApiResponse {

	String latitude;
	String longitude;
	String timeZone;
	Currently currently;
	
	@JsonProperty("minutely")
	Minutely minutely;
	
	@JsonProperty("hourly")
	Hourly hourly;
	@JsonProperty("daily")
	Daily daily;
	@JsonProperty("flags")
	Flags flags;
	String offset;
}
