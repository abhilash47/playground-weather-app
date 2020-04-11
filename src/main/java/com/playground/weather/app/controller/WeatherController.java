package com.playground.weather.app.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playground.weather.app.domain.WeatherResponse;
import com.playground.weather.app.service.WeatherService;


@RestController
@RequestMapping("/app")
public class WeatherController {

	@Autowired
	WeatherService weatherService;
	
	@GetMapping("/weather/{coords}")
	public ResponseEntity getWeather(@PathVariable(value = "coords") String coords) {
		
		if (StringUtils.isNotBlank(coords)) {
			
			try {
				List<WeatherResponse> response = weatherService.getResponse(coords);
				
				ResponseEntity result = new ResponseEntity<>(response, HttpStatus.CREATED);
				
				return result;
				
			} catch (Exception e) {
				
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
			
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
