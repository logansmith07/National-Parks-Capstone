package com.techelevator.npgeek.model.weather;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcWeatherDao implements WeatherDao {
	
private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcWeatherDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Weather> getWeatherByParkCode(String parkCode) {
		Weather weather = null;
		List<Weather> weathers = new ArrayList<Weather>();
		String sqlSelectWeatherByParkCode = "SELECT * FROM weather WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectWeatherByParkCode, parkCode);
		while (results.next()) {
			weather = mapRowToWeather(results);
			weathers.add(weather);
		}
		
		return weathers;
	}
	
	private Weather mapRowToWeather(SqlRowSet row) {
		Weather weather = new Weather();
		weather.setParkCode(row.getString("parkcode"));
		weather.setLow(row.getInt("low"));
		weather.setHigh(row.getInt("high"));
		weather.setForecast(row.getString("forecast"));
		weather.setFiveDayForecast(row.getInt("fivedayforecastvalue"));
		
		return weather;		
	}
	
}
