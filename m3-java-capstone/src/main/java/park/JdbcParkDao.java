package park;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcParkDao implements ParkDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcParkDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while(results.next()) {
			allParks.add(mapRowToPark(results));
		}
		return allParks;
	}

	@Override
	public Park getParkByParkCode(String parkCode) {
		Park park = null;
		String sqlSelectParkByParkCode = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectParkByParkCode, parkCode);
		if(results.next()) {
			park = mapRowToPark(results);
		}
		return park;
	}
	
	private Park mapRowToPark(SqlRowSet row) {
		Park park = new Park();
		park.setParkCode(row.getString("parkCode"));
		park.setParkName(row.getString("parkName"));
		park.setState(row.getString("state"));
		park.setAcreage(row.getInt("acreage"));
		park.setElevation(row.getInt("elevation"));
		park.setMilesOfTrail(row.getFloat("milesOfTrail"));
		park.setNumberOfCampsites(row.getInt("numberOfCampsites"));
		park.setClimate(row.getString("climate"));
		park.setYearFounded(row.getInt("yearFounded"));
		park.setAnnualVisitorCount(row.getInt("annualVisitorCount"));
		park.setInspirationalQuote(row.getString("inspirationalQuote"));
		park.setQuoteSource(row.getString("quoteSource"));
		park.setDescription(row.getString("description"));
		park.setEntryFee(row.getInt("entryFee"));
		park.setNumberAnimalSpecies(row.getInt("numberAnimalSpecies"));

		return park;
	}

}
