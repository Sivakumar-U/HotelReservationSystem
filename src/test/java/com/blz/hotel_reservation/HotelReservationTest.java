package com.blz.hotel_reservation;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class HotelReservationTest {

	private static HotelReservation obj;

	@BeforeClass
	public static void createHotelReservationSystemObj() {
		obj = new HotelReservation();

	}

	@Test
	public void givenHotelDetails_WhenAdded_ShouldReturnSize() {
		int numOfHotels = obj.getSize();
		Assert.assertEquals(3, numOfHotels);
	}

	@Test
	public void givenDateRange_FindCheapestRate_AndReturnHotel() {
		List<String> dateList = new ArrayList<>();
		dateList.add("10sep2020");
		dateList.add("11sep2020");
		int totaldays = dateList.size();
		int cheapestRate = obj.getCheapestRate(totaldays);
		String cheapestHotel = obj.getCheapestHotel(cheapestRate);
		assertEquals("Lakewood", cheapestHotel);
		System.out.println(cheapestHotel + ", Total Charges: $" + cheapestRate);
	}
}
