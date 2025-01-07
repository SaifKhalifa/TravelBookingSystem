package com.groupnine.travelbookingsystem.model.searchHotels;
import java.util.List;


public interface searchHDAO {
     List<searchH> getHotelsByDestination(String destination);
}

