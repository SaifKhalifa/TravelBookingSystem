package com.groupnine.travelbookingsystem.model.searchFlights;

import java.util.List;

public interface searchFDAO {
    // Search for flight by destination
    List<searchF> searchFlightsByDestination(String destination);
}
