package com.blz.hotel_reservation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HotelReservation {

	HotelDetails hotelDetails = new HotelDetails();
	Map<Integer, String> listOfHotels = hotelDetails.getHotels();
	Map<Integer, Integer> totalRates = new HashMap<Integer, Integer>();
	Map<Integer, Integer> cheapestRatingHotel = new HashMap<Integer, Integer>();
	List<String> hotelWithCheapRate = new ArrayList<>();
	Map<Integer, Integer> ratings = hotelDetails.getHotelRatings();

	public int getSize() {
		return listOfHotels.size();
	}

	public String getHotelName(int id) {
		return listOfHotels.get(id);
	}

	public int getRate(List<Integer> days, int hotelId) {
		int totalRate = 0;
		for (Integer day : days) {
			if (day != 6 && day != 7)
				totalRate = totalRate + hotelDetails.getHotelWeekdayRatesForRewardCustomers(hotelId);
			else
				totalRate = totalRate + hotelDetails.getHotelWeekendRatesForRewardCustomers(hotelId);
		}
		return totalRate;
	}

	public int getCheapestRate(List<Integer> days) {
		for (int i = 1; i <= getSize(); i++) {
			totalRates.put(i, getRate(days, i));
		}
		int cheapestRate = Collections.min(totalRates.values());
		return cheapestRate;
	}

	public List<String> getCheapestHotel(int rate) {
		int hotelId = 0;
		for (Entry<Integer, Integer> entry : totalRates.entrySet()) {
			if (entry.getValue().equals(rate)) {
				hotelId = entry.getKey();
				hotelWithCheapRate.add(getHotelName(hotelId));

			}
		}
		return hotelWithCheapRate;
	}

	public String getCheapestBestRatedHotel(List<String> cheapestHotel) {
		for (int i = 1; i <= cheapestHotel.size(); i++) {
			for (String cheapHotel : cheapestHotel)
				cheapestRatingHotel.put(i, getHotelRatingBasedOnHotel(cheapHotel));
		}
		int bestRating = Collections.max(cheapestRatingHotel.values());
		return getHotelBasedOnRating(bestRating);
	}

	public String getHotelBasedOnRating(int rating) {
		int hotelNum = 0;
		for (Entry<Integer, Integer> entry : ratings.entrySet()) {
			if (entry.getValue().equals(rating)) {
				hotelNum = entry.getKey();
			}
		}
		return listOfHotels.get(hotelNum);
	}

	public int getHotelRatingBasedOnHotel(String inputHotel) {
		return ratings.get(getHotelIndex(inputHotel));
	}

	public int getHotelIndex(String inputHotel) {
		int hotelNo = 0;
		for (Entry<Integer, String> entry : listOfHotels.entrySet()) {
			if (entry.getValue().equals(inputHotel))
				hotelNo = entry.getKey();
		}
		return hotelNo;
	}

	public String getBestRatedHotel() {
		int bestRating = Collections.max(ratings.values());
		return getHotelBasedOnRating(bestRating);
	}

}
