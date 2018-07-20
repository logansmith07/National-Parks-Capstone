package com.techelevator.jdbc;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.npgeek.model.park.JdbcParkDao;
import com.techelevator.npgeek.model.park.Park;

public class JdbcparkDAOIntegrationTest {
	
	private static final String TEST_PARKCODE = "ABCD";
	private static SingleConnectionDataSource dataSource;
	private JdbcParkDao parkDao;
	
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
		String sqlInsertPark = "INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) "+
				"VALUES ('ABCD', 'Test Park', 'OH', 100000, 10000, 100.0, 50, 'Forest', 2018, 2000000, 'This is a test quote', 'Logan Smith', 'This is a test description', 10, 300)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertPark);
		parkDao = new JdbcParkDao(dataSource);
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void get_all_parks() throws SQLException {
		
		List<Park> results = parkDao.getAllParks();
		
		Assert.assertNotNull(results);
		Assert.assertEquals(11, results.size());
	}
	
	@Test
	public void get_parks_parkcode() throws SQLException {
		Park results = parkDao.getParkByParkCode(TEST_PARKCODE);
		
		Assert.assertNotNull(results);
		Assert.assertEquals(10, results.getEntryFee());
		Assert.assertEquals(10000, results.getElevation());
	}
	
	@Test
	public void get_parks_with_survey_count() throws SQLException {
		List<Park> results = parkDao.getParksWithSurveyCount();
		
		Assert.assertNotNull(results);
		Assert.assertTrue((results.get(0).getNumberSurveys()) == (int) results.get(0).getNumberSurveys());
		
	}
	
	@SuppressWarnings("deprecation")
	private void assertParksAreEqual(Park expected, Park actual) {
		assertEquals(expected.getParkCode(), actual.getParkCode());
		assertEquals(expected.getParkName(), actual.getParkName());
		assertEquals(expected.getState(), actual.getState());
		assertEquals(expected.getAcreage(), actual.getAcreage());
		assertEquals(expected.getElevation(), actual.getElevation());
		assertEquals(expected.getMilesOfTrail(), actual.getMilesOfTrail());
		assertEquals(expected.getNumberOfCampsites(), actual.getNumberOfCampsites());
		assertEquals(expected.getClimate(), actual.getClimate());
		assertEquals(expected.getYearFounded(), actual.getYearFounded());
		assertEquals(expected.getAnnualVisitorCount(), actual.getAnnualVisitorCount());
		assertEquals(expected.getInspirationalQuote(), actual.getInspirationalQuote());
		assertEquals(expected.getQuoteSource(), actual.getQuoteSource());
		assertEquals(expected.getDescription(), actual.getDescription());
		assertEquals(expected.getEntryFee(), actual.getEntryFee());
		assertEquals(expected.getNumberAnimalSpecies(), actual.getNumberAnimalSpecies());
}

}
