package com.groupnine.travelbookingsystem.model.toRemove.BookingFlight;
import java.util.List;

public interface FlightDAO {

    //get all data
    List<FlightBookingModel> getAllFlights();

    // update the flight status
    void updateFlightStatus(int flightId, String status);
}