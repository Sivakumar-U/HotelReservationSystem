package com.blz.hotel_reservation;

import java.util.HashMap;
import java.util.Map;

public class HotelDetails {

	Map<String, Integer> regularRates = new HashMap<String, Integer>();

	public Map<String, Integer> getHotels() {
		regularRates.put("Lakewood", 110);
		regularRates.put("Bridgewood", 160);
		regularRates.put("Ridgewood", 220);
		return regularRates;
	}
}
