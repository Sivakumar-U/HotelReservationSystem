package com.blz.hotel_reservation;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HotelReservation {

	Map<Integer, String> listOfHotels = new HashMap<Integer, String>();
	Map<Integer, Integer> totalRates = new HashMap<Integer, Integer>();
	HotelDetails hotelDetails = new HotelDetails();

	public int getSize() {
		listOfHotels = hotelDetails.getHotels();
		return listOfHotels.size();
	}

	public int getCheapestRate(int numOfDays) {
		for (int i = 1; i <= getSize(); i++) {
			totalRates.put(i, numOfDays * hotelDetails.getHotelWeekdayRates(i));
		}
		int cheapestRate = Collections.min(totalRates.values());
		return cheapestRate;
	}

	public String getCheapestHotel(int rate) {
		int hotelId = 0;
		for (Entry<Integer, Integer> entry : totalRates.entrySet()) {
			if (entry.getValue().equals(rate)) {
				hotelId = entry.getKey();
			}
		}
		return hotelDetails.getHotelName(hotelId);
	}

}
