package com.playground.weather.app.domain;

import lombok.Data;

@Data
public class MinutelyData {
	
	long time;
	float precipIntensity;
	float precipProbability;

}
