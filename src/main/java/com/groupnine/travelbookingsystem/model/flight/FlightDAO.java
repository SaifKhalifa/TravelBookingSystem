package com.groupnine.travelbookingsystem.model.flight;

import java.util.List;

public interface FlightDAO {
    //Creation
    void addFlight(Flight flight);

    //Reading
    List<Flight> getFlights();
    Flight getFlightById(int flightId);

    //Updating
    void updateFlight(Flight flight);

    //Deletion
    void deleteFlightById(int flightId);

    //Flights Count
    long getFlightsCount();
}
