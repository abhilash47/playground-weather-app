package com.playground.weather.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherGateway {

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${weather.api.url}")
	private String weatherApiUrl;
	
	@Value("${weather.authHeader}")
	private String authHeader;
	
}
