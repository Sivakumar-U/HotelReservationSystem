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
	Map<Integer, Integer> cheapestRatingHotel = new HashMap<Integer, Integer>();
	List<String> hotelWithCheapRate = new ArrayList<>();
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
			totalRates.put(i, totalRate);

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

	public String getCheapestBestRatedHotel(List<String> cheapestHotel) {
		for (int i = 1; i <= cheapestHotel.size(); i++) {
			for (String cheapHotel : cheapestHotel)
				cheapestRatingHotel.put(i, getRatingBasedOnHotel(cheapHotel));
		}
		int bestRating = Collections.max(cheapestRatingHotel.values());
		int hotelNo = 0;
		for (Entry<Integer, Integer> entry : cheapestRatingHotel.entrySet()) {
			if (entry.getValue().equals(bestRating)) {
				hotelNo = entry.getKey();
			}
		}
		return hotelDetails.getHotelName(hotelNo);
	}

	public int getRatingBasedOnHotel(String inputHotel) {
		int hotelNum = 0;
		for (Entry<Integer, String> entry : listOfHotels.entrySet()) {
			if (entry.getValue().equals(inputHotel)) {
				hotelNum = entry.getKey();
			}
		}
		return hotelDetails.getHotelRatings(hotelNum);
	}

}
