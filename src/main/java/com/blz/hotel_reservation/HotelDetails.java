package com.blz.hotel_reservation;

import java.util.HashMap;
import java.util.Map;

public class HotelDetails {

	Map<Integer, Integer> rateOfHotel = new HashMap<Integer, Integer>();
	Map<Integer, String> hotels;
	Map<Integer, String> nameOfHotel = new HashMap<Integer, String>();

	public Map<Integer, String> getHotels() {
		nameOfHotel.put(1, "Lakewood");
		nameOfHotel.put(2, "Bridgewood");
		nameOfHotel.put(3, "Ridgewood");
		return nameOfHotel;
	}

	public int getHotelRates(int id) {
		rateOfHotel.put(1, 110);
		rateOfHotel.put(2, 160);
		rateOfHotel.put(3, 220);
		return rateOfHotel.get(id);
	}

	public String getHotelName(int id) {
		hotels = getHotels();
		return nameOfHotel.get(id);
	}
}
