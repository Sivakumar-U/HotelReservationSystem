package com.blz.hotel_reservation;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class HotelReservationTest {

	private static HotelReservation obj;

	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dMMMyyyy", Locale.ENGLISH);
	LocalDate date;

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
	public void givenDateRange_FindCheapestRate_ShouldReturnHotel() {
		String date1 = "10Sep2020";
		String date2 = "11Sep2020";
		List<Integer> dates = new ArrayList<>();
		dates.add(LocalDate.parse(date1, formatter).getDayOfWeek().getValue());
		dates.add(LocalDate.parse(date2, formatter).getDayOfWeek().getValue());
		int cheapestRate = obj.getCheapestRate(dates);
		List<String> cheapestHotel = obj.getCheapestHotel(cheapestRate);
		assertTrue(cheapestHotel.contains("Lakewood"));
		System.out.println("Cheapest Hotel : " + cheapestHotel + ", Total charges: $" + cheapestRate);
	}

	@Test
	public void givenWeekdayAndWeekendDay_FindCheapestRate_ShouldReturnHotels() {
		String date1 = "11Sep2020";
		String date2 = "12Sep2020";
		List<Integer> dates = new ArrayList<>();
		dates.add((LocalDate.parse(date1, formatter)).getDayOfWeek().getValue());
		dates.add((LocalDate.parse(date2, formatter)).getDayOfWeek().getValue());
		int cheapestRate = obj.getCheapestRate(dates);
		List<String> cheapestHotel = obj.getCheapestHotel(cheapestRate);
		assertTrue(cheapestHotel.contains("Lakewood"));
		System.out.println(cheapestHotel + " with Total charges : $" + cheapestRate);
	}

}
