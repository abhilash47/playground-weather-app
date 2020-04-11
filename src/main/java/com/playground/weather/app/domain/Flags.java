package com.playground.weather.app.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Flags {
	
	List<String> sources;
	@JsonProperty("nearest-station")
	float nearestStation;
	String units;
}
