package com.groupnine.travelbookingsystem.model.flightBooking;

import java.util.List;

public interface FlightBookingDAO {
    //Creation
    void addFlightBooking(FlightBooking flightBooking);

    //Reading
    List<FlightBooking> getAllFlightBookings();
    void getFlightBookingById(int flightBookingID);

    //Updating
    void updateFlightBookingStatus(int flightId, String status);
    void updateFlightBooking(FlightBooking flightBooking);

    //Deletion
    void deleteFlightBookingById(int flightId);
}
