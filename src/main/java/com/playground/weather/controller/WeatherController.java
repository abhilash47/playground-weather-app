package com.playground.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

	@GetMapping("/app/weather")
	public Object getWeather() {
		
	}
}
