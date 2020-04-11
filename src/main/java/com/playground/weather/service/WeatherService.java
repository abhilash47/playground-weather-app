package com.playground.weather.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.playground.weather.domain.WeatherResponse;

@Component
public class WeatherService {

	@Autowired
	WeatherGatewatey gateway;
	
	public List<WeatherResponse> getResponse(long lat, long lon, String time) {
		
		List<WeatherResponse> response = new ArrayList<WeatherResponse>();
		
		WeatherResponse today = gateway.getWeather(lat, lon, time);
		WeatherResponse lastYear = gateway.getWeather(lat, lon, time);
		
		return response;
	}
	
}
