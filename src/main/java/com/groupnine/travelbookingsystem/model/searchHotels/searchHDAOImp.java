package com.groupnine.travelbookingsystem.model.searchHotels;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class searchHDAOImp implements searchHDAO {

    // List to store hotel bookings
    private List<searchH> hotelBookings = new ArrayList<>();

    // Add a hotel booking
    @Override
    public void addHotelBooking(searchH hotelBooking) {
        hotelBookings.add(hotelBooking);
    }

    // Get a hotel booking by ID
    @Override
    public searchH getHotelBookingById(int id) {
        Optional<searchH> hotelBooking = hotelBookings.stream()
                .filter(hb -> hb.getHotelId() == id)
                .findFirst();
        return hotelBooking.orElse(null); // Returns null if not found
    }

    // Get all hotel bookings
    @Override
    public List<searchH> getAllHotelBookings() {
        return new ArrayList<>(hotelBookings); // Return a copy of the list to avoid external modifications
    }

    // Update an existing hotel booking
    @Override
    public void updateHotelBooking(searchH hotelBooking) {
        for (int i = 0; i < hotelBookings.size(); i++) {
            if (hotelBookings.get(i).getHotelId() == hotelBooking.getHotelId()) {
                hotelBookings.set(i, hotelBooking);
                return;
            }
        }
    }

    // Delete a hotel booking by ID
    @Override
    public void deleteHotelBooking(int id) {
        hotelBookings.removeIf(hb -> hb.getHotelId() == id);
    }
}
