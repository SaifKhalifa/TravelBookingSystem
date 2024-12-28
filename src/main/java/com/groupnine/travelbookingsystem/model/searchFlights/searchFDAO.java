package com.groupnine.travelbookingsystem.model.searchFlights;

import java.util.List;

public interface searchFDAO {

    // Create a new flight booking
    void addFlightBooking(searchF flightBooking);

    // Get a flight booking by ID
    searchF getFlightBookingById(int id);

    // Get all flight bookings
    List<searchF> getAllFlightBookings();

    // Update an existing flight booking
    void updateFlightBooking(searchF flightBooking);

    // Delete a flight booking by ID
    void deleteFlightBooking(int id);
}

