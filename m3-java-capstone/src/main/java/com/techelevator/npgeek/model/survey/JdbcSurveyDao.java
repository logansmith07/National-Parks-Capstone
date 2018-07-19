package com.techelevator.npgeek.model.survey;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcSurveyDao implements SurveyDao {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcSurveyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void addSurvey(Survey survey) {
		String sqlInsertSurvey = "INSERT INTO survey_result (surveyid, parkcode, emailaddress, state, activitylevel) VALUES(?, ?, ?, ?, ?)";
		Long id = getNextId();
		jdbcTemplate.update(sqlInsertSurvey, id, survey.getParkCode(), survey.getEmail(), survey.getResidenceState(), survey.getActivityLevel());
		survey.setSurveyId(id);
		
	}

	@Override
	public Survey getNumberOfSurveysByParkCode() {
		Survey survey = null;
		//CHANGE LINE 31 SQL STATEMENT!!!
		String sqlSelectSurveyByParkCode = "SELECT * FROM survey_result WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectSurveyByParkCode);
		if(results.next()) {
			survey = mapRowToSurvey(results);
		}
		return survey;
	}
	
	private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_surveyid')";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		if(result.next()) {
			return result.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting the next survey id");
		}
	}
	
	private Survey mapRowToSurvey(SqlRowSet row) {
		Survey survey = new Survey();
		survey.setSurveyId(row.getLong("surveyid"));
		survey.setParkCode(row.getString("parkcode"));
		survey.setEmail(row.getString("emailaddress"));
		survey.setResidenceState(row.getString("state"));
		survey.setActivityLevel(row.getString("surveyid"));
		
		return survey;
	}	

}
