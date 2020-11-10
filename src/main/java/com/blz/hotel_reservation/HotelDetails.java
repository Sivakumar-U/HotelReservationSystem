package com.blz.hotel_reservation;

import java.util.HashMap;
import java.util.Map;

public class HotelDetails {

	Map<Integer, Integer> rateOfHotel = new HashMap<Integer, Integer>();
	Map<Integer, String> nameOfHotel = new HashMap<Integer, String>();
	Map<Integer, Integer> ratings = new HashMap<Integer, Integer>();

	public Map<Integer, String> getHotels() {
		nameOfHotel.put(1, "Lakewood");
		nameOfHotel.put(2, "Bridgewood");
		nameOfHotel.put(3, "Ridgewood");
		return nameOfHotel;
	}

	public int getHotelWeekdayRates(int id) {
		rateOfHotel.put(1, 110);
		rateOfHotel.put(2, 150);
		rateOfHotel.put(3, 220);
		return rateOfHotel.get(id);
	}

	public int getHotelWeekendRates(int id) {
		rateOfHotel.put(1, 90);
		rateOfHotel.put(2, 50);
		rateOfHotel.put(3, 150);
		return rateOfHotel.get(id);
	}

	public Map<Integer,Integer> getHotelRatings() {
		ratings.put(1, 3);
		ratings.put(2, 4);
		ratings.put(3, 5);
		return ratings;
	}

}
