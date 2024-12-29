package com.groupnine.travelbookingsystem.model.searchHotels;

import java.util.List;

public interface searchHDAO {

    // Create a new hotel booking
    void addHotelBooking(searchH hotelBooking);

    // Get a hotel booking by ID
    searchH getHotelBookingById(int id);

    // Get all hotel bookings
    List<searchH> getAllHotelBookings();

    // Update an existing hotel booking
    void updateHotelBooking(searchH hotelBooking);

    // Delete a hotel booking by ID
    void deleteHotelBooking(int id);
}
