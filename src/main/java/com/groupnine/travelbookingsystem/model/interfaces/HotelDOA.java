package com.groupnine.travelbookingsystem.model.interfaces;

import com.groupnine.travelbookingsystem.model.Hotel;

import java.util.List;

public interface HotelDOA {
    public void insert(Hotel hotel);
    public List<Hotel> getAllHotels();
    public void update(Hotel hotel);
    public void delete(int id);
    public Hotel getById(int id);

}
