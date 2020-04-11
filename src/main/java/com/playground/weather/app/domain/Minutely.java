package com.playground.weather.app.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Minutely {
	
	String summary;
	String icon;
	@JsonProperty("data")
	List<MinutelyData> data;
}
