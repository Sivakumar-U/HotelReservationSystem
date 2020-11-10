package com.blz.hotel_reservation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
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
		String customerType = "regular";
		List<String> dateRange = Arrays.asList("10Sep2020", "11Sep2020");
		List<Integer> days = new ArrayList<>();
		for (String eachDate : dateRange)
			days.add(LocalDate.parse(eachDate, formatter).getDayOfWeek().getValue());
		int cheapestRate = obj.getCheapestRate(days, customerType);
		List<String> cheapestHotel = obj.getCheapestHotel(cheapestRate);
		assertTrue(cheapestHotel.contains("Lakewood"));
		System.out.println("Cheapest Hotel : " + cheapestHotel + ", Total charges: $" + cheapestRate);
		System.out.println("Customer-Type : " + customerType + ", Given dates : " + dateRange);
	}

	@Test
	public void givenDatesRange_FindCheapestRate_ShouldReturnHotels() {
		String customerType = "regular";
		List<String> dateRange = Arrays.asList("11Sep2020", "12Sep2020");
		List<Integer> days = new ArrayList<>();
		for (String eachDate : dateRange)
			days.add(LocalDate.parse(eachDate, formatter).getDayOfWeek().getValue());
		int cheapestRate = obj.getCheapestRate(days, customerType);
		List<String> cheapestHotel = obj.getCheapestHotel(cheapestRate);
		assertTrue(cheapestHotel.contains("Lakewood"));
		System.out.println(cheapestHotel + " with Total charges : $" + cheapestRate);
	}

	@Test
	public void givenDateRange_WhenCheapestRate_ShouldReturnHighestRatingHotel() {
		String customerType = "regular";
		List<String> dateRange = Arrays.asList("11Sep2020", "12Sep2020");
		List<Integer> days = new ArrayList<>();
		for (String eachDate : dateRange)
			days.add(LocalDate.parse(eachDate, formatter).getDayOfWeek().getValue());
		int cheapestRate = obj.getCheapestRate(days, customerType);
		List<String> cheapestHotel = obj.getCheapestHotel(cheapestRate);
		String bestRatedCheapestHotel = obj.getCheapestBestRatedHotel(cheapestHotel);
		int rating = obj.getHotelRatingBasedOnHotel(bestRatedCheapestHotel);
		assertEquals("Bridgewood", bestRatedCheapestHotel);
		System.out.println(bestRatedCheapestHotel + ", Rating : " + rating + " and Total Charge : $" + cheapestRate);
	}

	@Test
	public void givenDateRange_withBestRating_ShouldReturnHotelName() {
		String customerType = "regular";
		List<String> dateRange = Arrays.asList("11Sep2020", "12Sep2020");
		List<Integer> days = new ArrayList<>();
		for (String eachDate : dateRange)
			days.add(LocalDate.parse(eachDate, formatter).getDayOfWeek().getValue());
		String bestRatedHotel = obj.getBestRatedHotel();
		assertEquals("Ridgewood", bestRatedHotel);
		int id = obj.getHotelIndex(bestRatedHotel);
		System.out.println(
				"Best Rated Hotel : " + bestRatedHotel + ", Total charges :" + obj.getRate(days, id, customerType));
	}

	@Test
	public void givenDateRange_ForRewardCustomer_WhenCheapestRate_ShouldReturnHotel() {
		String customerType = "reward";
		List<String> dateRange = Arrays.asList("11Sep2020", "12Sep2020");
		List<Integer> days = new ArrayList<>();
		for (String eachDate : dateRange)
			days.add(LocalDate.parse(eachDate, formatter).getDayOfWeek().getValue());
		int cheapestRate = obj.getCheapestRate(days, customerType);
		List<String> cheapestHotel = obj.getCheapestHotel(cheapestRate);
		String bestRatedCheapestHotel = obj.getCheapestBestRatedHotel(cheapestHotel);
		int rating = obj.getHotelRatingBasedOnHotel(bestRatedCheapestHotel);
		assertEquals("Ridgewood", bestRatedCheapestHotel);
		System.out.println(bestRatedCheapestHotel + ", Rating : " + rating + " and Total Charge : $" + cheapestRate);
	}

}
