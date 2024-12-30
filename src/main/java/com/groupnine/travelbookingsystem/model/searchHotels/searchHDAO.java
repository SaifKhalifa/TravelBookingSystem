package com.groupnine.travelbookingsystem.model.searchHotels;

import java.util.List;

public interface searchHDAO {
    // Search for hotels by destination
    List<searchH> searchHotelsByDestination(String destination);
}
