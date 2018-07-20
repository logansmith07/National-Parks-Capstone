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

import com.techelevator.npgeek.model.park.JdbcParkDao;
import com.techelevator.npgeek.model.park.Park;
import com.techelevator.npgeek.model.survey.JdbcSurveyDao;
import com.techelevator.npgeek.model.survey.Survey;
import com.techelevator.npgeek.model.weather.Weather;

public class JdbcSurveyDaoIntegrationTest {
	
	private static final String TEST_PARKCODE = "ABCD";
	private static SingleConnectionDataSource dataSource;
	private JdbcSurveyDao surveyDao;
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
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		parkDao = new JdbcParkDao(dataSource);
		surveyDao = new JdbcSurveyDao(dataSource);
		long id = surveyDao.getNextId();
		String sqlInsertSurvey = "INSERT INTO survey_result (surveyid, parkcode, emailaddress, state, activitylevel) "+
				"VALUES (" + id +  ", 'ABCD', 'zach@gmail.com', 'OH', 'Active')";
		jdbcTemplate.update(sqlInsertSurvey);
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void add_survey() throws SQLException {
		List<Park> results = parkDao.getParksWithSurveyCount();
		for (int i=0; i < results.size() -1; i++) {
			if (results.get(i).getParkCode().equals("ABCD")) {
				Assert.assertEquals(results.get(i).getNumberSurveys(), 1);
			}
		}
		
		Survey survey = new Survey();
		survey.setActivityLevel("Inactive");
		survey.setEmail("lookinggood@gmail.com");
		survey.setParkCode("ABCD");
		survey.setResidenceState("OH");
		surveyDao.addSurvey(survey);
		
		for (int i=0; i < results.size() -1; i++) {
			if (results.get(i).getParkCode().equals("ABCD")) {
				Assert.assertEquals(results.get(i).getNumberSurveys(), 2);
			}
		}
		
	}

}
