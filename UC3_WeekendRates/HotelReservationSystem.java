package com.bridgelabz.UC3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class HotelReservationSystem {

	ArrayList<Hotel> myHotelList = new ArrayList<Hotel>(); // Array
	// Add Method

	public void addHotel() {

		Hotel Lakewood = new Hotel("Lakewood", 110, 80, 90, 80, 3);

		Hotel Bridgewood = new Hotel("Bridgewood", 150, 110, 50, 50, 4);

		Hotel Ridgewood = new Hotel("Ridgewood", 220, 100, 150, 40, 5);

		myHotelList.add(Lakewood);
		myHotelList.add(Bridgewood);
		myHotelList.add(Ridgewood);
	}

	// Show Method
	public void showHotelInfo() {

		for (int i = 0; i < myHotelList.size(); i++) {
			System.out.println(myHotelList.get(i));
		}
	}

	// Find CheapestHotel based on weekdayRegularRate
	public void findCheapestHotelOne(String startDateRange, String endDateRange) {

		LocalDate startDate = LocalDate.parse(startDateRange, DateTimeFormatter.ofPattern("d-MMM-yyyy"));
		LocalDate endDate = LocalDate.parse(endDateRange, DateTimeFormatter.ofPattern("d-MMM-yyyy"));

		int numberOfDays = endDate.getDayOfMonth() - startDate.getDayOfMonth() + 1;
		Optional<Hotel> cheapestHotel = this.myHotelList.stream()
				.sorted(Comparator.comparing(Hotel::getWeekdayRegularRate)).findFirst();
		Hotel hotel = new Hotel();
		hotel.setHotelName(cheapestHotel.get().getHotelName());
		hotel.setTotal(cheapestHotel.get().getWeekdayRegularRate() * numberOfDays);

		System.out.println("HotelName :" + hotel.getHotelName());

		System.out.println("NumberOfDaysStayed * WeekdayRegularRate :" + hotel.getTotal() + "$");

	}
}


