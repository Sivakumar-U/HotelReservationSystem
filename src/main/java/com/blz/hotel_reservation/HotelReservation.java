package com.blz.hotel_reservation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HotelReservation {

	Map<Integer, String> listOfHotels = new HashMap<Integer, String>();
	Map<Integer, Integer> totalRates = new HashMap<Integer, Integer>();
	List<String>hotelWithCheapRate=new ArrayList<String>();
	HotelDetails hotelDetails = new HotelDetails();

	public int getSize() {
		listOfHotels = hotelDetails.getHotels();
		return listOfHotels.size();
	}

	public int getCheapestRate(List<Integer> days) {
		for (int i = 1; i <= getSize(); i++) {
			int totalRate = 0;
			for (Integer day : days) {
				if (day != 6 && day != 7)
					totalRate = totalRate + hotelDetails.getHotelWeekdayRates(i);
				else
					totalRate = totalRate + hotelDetails.getHotelWeekendRates(i);
			}
			totalRates.put(i,totalRate);

		}
		int cheapestRate = Collections.min(totalRates.values());
		return cheapestRate;
	}

	public List<String> getCheapestHotel(int rate) {
		int hotelId = 0;
		for (Entry<Integer, Integer> entry : totalRates.entrySet()) {
			if (entry.getValue().equals(rate)) {
				hotelId = entry.getKey();
				hotelWithCheapRate.add(hotelDetails.getHotelName(hotelId));
				
			}
		}
		return hotelWithCheapRate;
	}

}
