package com.blz.hotel_reservation;

import java.util.HashMap;
import java.util.Map;

public class HotelReservation {

	Map<String, Integer> listOfHotels = new HashMap<String, Integer>();
	HotelDetails hotelDetails = new HotelDetails();

	public int getSize() {
		listOfHotels = hotelDetails.getHotels();
		return listOfHotels.size();
	}
}
