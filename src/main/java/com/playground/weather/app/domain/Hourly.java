package com.playground.weather.app.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Hourly {

	String summary;
	String icon;
	
	@JsonProperty("data")
	List<HourlyData> data;
}
