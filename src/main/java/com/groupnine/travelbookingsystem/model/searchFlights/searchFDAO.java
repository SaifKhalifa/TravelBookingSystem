package com.groupnine.travelbookingsystem.model.searchFlights;

import com.groupnine.travelbookingsystem.model.searchHotels.searchH;
import java.util.List;

public interface searchFDAO {
    List<searchF> getFlightsByDestination(String destination);
}
