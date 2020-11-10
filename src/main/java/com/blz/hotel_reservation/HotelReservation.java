package com.blz.hotel_reservation;

import java.util.ArrayList;
import java.util.Comparator;
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

	public int getRate(List<Integer> days, int hotelId, String customerType) {
		int totalRate = 0;
		if (customerType.equalsIgnoreCase("Regular")) {
			for (Integer day : days) {
				if (day != 6 && day != 7)
					totalRate = totalRate + hotelDetails.getHotelWeekdayRatesForRegularCustomers(hotelId);
				else
					totalRate = totalRate + hotelDetails.getHotelWeekendRatesForRegularCustomers(hotelId);
			}
		} else if (customerType.equalsIgnoreCase("Reward")) {
			for (Integer day : days) {
				if (day != 6 && day != 7)
					totalRate = totalRate + hotelDetails.getHotelWeekdayRatesForRewardCustomers(hotelId);
				else
					totalRate = totalRate + hotelDetails.getHotelWeekendRatesForRewardCustomers(hotelId);
			}
		}
		return totalRate;
	}

	public int getCheapestRate(List<Integer> days, String customerType) {
		for (int i = 1; i <= getSize(); i++) {
			totalRates.put(i, getRate(days, i, customerType));
		}
		int cheapestRate = totalRates.entrySet().stream().min(Comparator.comparing(Map.Entry::getValue)).get().getValue();
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
		int bestRating = cheapestRatingHotel.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getValue();
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
		int bestRating = ratings.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getValue();
		return getHotelBasedOnRating(bestRating);
	}

}
