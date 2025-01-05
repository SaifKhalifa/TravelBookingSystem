package com.groupnine.travelbookingsystem.model.searchFlights;

import java.util.List;

public interface searchFDAO {
    List<searchF> getFlightsByDestination(String destination);
}
