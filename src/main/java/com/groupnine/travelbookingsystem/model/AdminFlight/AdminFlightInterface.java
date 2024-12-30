package com.groupnine.travelbookingsystem.model.AdminFlight;

import java.util.List;

public interface AdminFlightInterface {
    // Method to add flight, throws Exception
    void addFlight(AdminFlightModel flight) throws Exception;
    List<AdminFlightModel> getAllFlights() throws Exception;
    void deleteFlight(int flightId) throws Exception;
    // Method to update flight, throws Exception
    void updateFlight(AdminFlightModel flight) throws Exception;

    // Method to get flight by id
    AdminFlightModel getFlightById(int flightId) throws Exception;
}
