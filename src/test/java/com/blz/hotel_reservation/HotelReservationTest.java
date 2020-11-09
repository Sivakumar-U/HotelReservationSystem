package com.blz.hotel_reservation;

import org.junit.BeforeClass;
import org.junit.Test;

public class HotelReservationTest {

	private static HotelReservation obj;

	@BeforeClass
	public static void createHotelReservationSystemObj() {
		obj = new HotelReservation();

	}

	@Test
	public void givenHotelDetails_WhenAdded_ShouldReturnTrue() {
		obj.addHotelDetails();
	}
}
