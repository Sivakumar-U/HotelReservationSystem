package com.blz.hotel_reservation;

import java.util.ArrayList;
import java.util.List;

public class HotelReservation {

	public static void main(String[] args) {
		System.out.println("Welcome to Hotel Reservation System");
	}

	public void addHotelDetails() {
		List<HotelDetails> hotelDetails = new ArrayList<>();

		hotelDetails.add(new HotelDetails("Lakewood", 110));
		hotelDetails.add(new HotelDetails("Bridgewood", 150));
		hotelDetails.add(new HotelDetails("Ridgewood", 220));
		System.out.println(hotelDetails);
	}

}
