package com.groupnine.travelbookingsystem.model.hotel;

import java.util.List;

public interface HotelDAO {
    //Creation
    void addHotel(Hotel hotel);

    //Reading
    List<Hotel> getAllHotels();
    Hotel getHotelById(int id);

    //Updating
    void updateHotel(Hotel hotel);

    //Deletion
    void deleteHotelById(int id);
}