package com.techelevator.npgeek.model.weather;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Weather {
	
	private String parkCode;
	private int low;
	private int high;
	private String forecast;
	private int fiveDayForecast;
	
	
	public List<String> getWarnings(){
		List<String> warnings = new ArrayList<String>();
		if (forecast.equals("snow")) {
			warnings.add("Pack snowshoes");
		} else if (forecast.equals("rain")) {
			warnings.add("Pack rain gear and wear waterproof shoes");
		} else if (forecast.equals("thunderstorms")) {
			warnings.add("You should seek shelter and avoid hiking on exposed ridges");
		} else if (forecast.equals("sunny")) {
			warnings.add("Make sure to pack sunblock");
		}
		
		if (high > 75) {
			warnings.add("Bring an extra gallon of water");
		} else if (high - low > 20) {
			warnings.add("Wear breathable layers");
		} else if (low < 20) {
			warnings.add("Beware of frostbite and hypothermia");
		}
		return warnings;
	}
	
	public int getFiveDayForecast() {
		return fiveDayForecast;
	}
	
	public void setFiveDayForecast(int fiveDayForecast) {
		this.fiveDayForecast = fiveDayForecast;
	}
	public String getParkCode() {
		return parkCode;
	}
	
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	
	
	public int getLow(String celsius) {
		if (celsius.equals("true")) {
			BigDecimal lowCel = new BigDecimal(low);
			lowCel = lowCel.subtract(new BigDecimal(32));
			BigDecimal five = new BigDecimal(5);
			BigDecimal nine = new BigDecimal(9);
			MathContext mc = new MathContext(3, RoundingMode.HALF_UP);
			BigDecimal fiveOverNine = five.divide(nine, mc);
			lowCel = lowCel.multiply(fiveOverNine);
			lowCel = lowCel.setScale(0, RoundingMode.HALF_UP);
			int lowCelInt = lowCel.intValue();
			return lowCelInt;
		}
		return low;
	}
	
	public int getHigh(String celsius) {
		if (celsius.equals("true")) {
			BigDecimal highCel = new BigDecimal(high);
			highCel = highCel.subtract(new BigDecimal(32));
			BigDecimal five = new BigDecimal(5);
			BigDecimal nine = new BigDecimal(9);
			MathContext mc = new MathContext(3, RoundingMode.HALF_UP);
			BigDecimal fiveOverNine = five.divide(nine, mc);
			highCel = highCel.multiply(fiveOverNine);
			highCel = highCel.setScale(0, RoundingMode.HALF_UP);
			int highCelInt = highCel.intValue();
			return highCelInt;
		}
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public String getForecast() {
		if (forecast.equals("partly cloudy")) {
			return "partlyCloudy";
		}
		return forecast;
	}
	
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

}
