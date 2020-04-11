package com.playground.weather.app.gateway;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.playground.weather.app.domain.WeatherApiResponse;


@Component
public class WeatherGateway {

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${weather.api.url}")
	private String weatherApiUrl;
	
	@Value("${weather.authHeader}")
	private String authHeader;
	
	public JSONObject getWeather(String lat, String lon, String time) throws Exception {
		
		String coords = lat+","+lon+","+time;
		String url = weatherApiUrl + authHeader + "/" + coords;
		
		try {
			
			ResponseEntity<JSONObject> response = restTemplate.getForEntity(url, JSONObject.class);
			
			if(response.getStatusCode().equals(HttpStatus.OK)) {				
				JSONObject body = response.getBody();
				return body;
				
			} else {
				throw new Exception("Service response not 200");
			}
			
		} catch (Exception ex) {
			throw new Exception("Exception while calling service");
		}
		
	}
	
	public WeatherApiResponse getWeather(String coords) throws Exception {
	
		if (StringUtils.isBlank(coords)) {
			throw new Exception("empty coordinates");
			
		} else {
			
			String url = weatherApiUrl + authHeader + "/" + coords;
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json");
			headers.add("Accept", "application/json");

			HttpEntity<String> entity = new HttpEntity<>("body", headers);

			
			try {
				
				ResponseEntity<WeatherApiResponse> response = restTemplate.getForEntity(url, WeatherApiResponse.class);
				
				if(response.getStatusCode().equals(HttpStatus.OK)) {				
					WeatherApiResponse body = response.getBody();
					return body;
					
				} else {
					throw new Exception("Service response not 200");
				}
				
			} catch (Exception ex) {
				throw new Exception("Exception while calling service");
			}
		}
		
		
	}
	
	
}
