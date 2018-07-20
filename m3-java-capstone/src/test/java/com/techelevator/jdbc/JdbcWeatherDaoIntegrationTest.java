package com.techelevator.jdbc;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.npgeek.model.weather.JdbcWeatherDao;
import com.techelevator.npgeek.model.weather.Weather;

public class JdbcWeatherDaoIntegrationTest {
	
	private static final String TEST_PARKCODE = "ABCD";
	private static SingleConnectionDataSource dataSource;
	private JdbcWeatherDao weatherDao;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
		dataSource.setUsername("postgres");
		dataSource.setPassword("");
		dataSource.setAutoCommit(false);
	}
	
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	
	@Before
	public void setup() {
		String sqlInsertWeather = "INSERT INTO weather (parkcode, fivedayforecastvalue, low, high, forecast) "+
				"VALUES ('ABCD', 1, 50, 65, 'sunny')";
		
		String sqlInsertPark = "INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) "+
				"VALUES ('ABCD', 'Test Park', 'OH', 100000, 10000, 100.0, 50, 'Forest', 2018, 2000000, 'This is a test quote', 'Logan Smith', 'This is a test description', 10, 300)";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertPark);
		jdbcTemplate.update(sqlInsertWeather);
		weatherDao = new JdbcWeatherDao(dataSource);
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void get_weather_by_parkcode() throws SQLException {
		List<Weather> results = weatherDao.getWeatherByParkCode(TEST_PARKCODE);
		
		Assert.assertNotNull(results);
		Assert.assertEquals(1, results.size());
		
	}
	
	private Weather getWeather(String parkcode, int fivedayforecastvalue, int low, int high, String forecast) {
		Weather theWeather = new Weather();
		theWeather.setParkCode(parkcode);
		theWeather.setFiveDayForecast(fivedayforecastvalue);
		theWeather.setLow(low);
		theWeather.setHigh(high);
		theWeather.setForecast(forecast);
		
		return theWeather;
	}
}
