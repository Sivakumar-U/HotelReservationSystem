package com.blz.hotel_reservation;

public class HotelDetails {

	private String name;
	private int regularRate;

	public HotelDetails(String name, int regularRate) {
		super();
		this.name = name;
		this.regularRate = regularRate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRegularRate() {
		return regularRate;
	}

	public void setRegularRate(int regularRate) {
		this.regularRate = regularRate;
	}

	@Override
	public String toString() {
		return "Hotel [name=" + name + ", regularRate=" + regularRate + "]";
	}

}
