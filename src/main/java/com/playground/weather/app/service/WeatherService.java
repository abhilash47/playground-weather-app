package com.playground.weather.app.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.playground.weather.app.domain.DailyData;
import com.playground.weather.app.domain.WeatherApiResponse;
import com.playground.weather.app.domain.WeatherResponse;
import com.playground.weather.app.gateway.WeatherGateway;

@Component
public class WeatherService {

	@Autowired
	WeatherGateway gateway;
	
	public List<WeatherResponse> getResponse(String coords) throws Exception {
		
		long epc = Instant.now().getEpochSecond();
		long lastYear_epc = Instant.now().minus(365, ChronoUnit.DAYS).getEpochSecond();
		
		String today_coords = coords +","+epc;
		String lastYear_coords = coords+ ","+lastYear_epc;
		
		List<WeatherResponse> response = new ArrayList<WeatherResponse>();
		
		WeatherApiResponse todayResponse = gateway.getWeather(today_coords);
		WeatherApiResponse lastYearResponse = gateway.getWeather(lastYear_coords);
		
		WeatherResponse today_Weather = convertWeatherApiResponseToWeatherResponse(todayResponse, epc);
		WeatherResponse lastYear_Weather = convertWeatherApiResponseToWeatherResponse(lastYearResponse, lastYear_epc);
		
		response.add(today_Weather);
		response.add(lastYear_Weather);
		
		return response;
	}

	
	private static WeatherResponse convertWeatherApiResponseToWeatherResponse(WeatherApiResponse input, long epc) {
		
		WeatherResponse response = new WeatherResponse();
		
		response.setDate(new Date(input.getCurrently().getTime()*1000));
		response.setTime(convertDate(input.getCurrently().getTime()));
		response.setTemperature(input.getCurrently().getTemperature());
		
		DailyData dailyData = input.getDaily().getData().get(0);
		
		response.setSunriseTime(convertDate(dailyData.getSunriseTime()));
		response.setSunsetTime(convertDate(dailyData.getSunsetTime()));
		response.setTemperatureHigh(dailyData.getTemperatureHigh());
		response.setTemperatureLow(dailyData.getTemperatureLow());
		response.setTemperatureLowTime(convertDate(dailyData.getTemperatureLowTime()));
		response.setTemperatureHighTime(convertDate(dailyData.getTemperatureHighTime()));		
		
		return response;
		
	}
	
	private static String convertDate(long val) {
		
		Date date = new Date(val);
		DateFormat formattype = new SimpleDateFormat("HH:mm:ss");
		String formated = formattype.format(date);
		
		return formated;
		
	}
}
