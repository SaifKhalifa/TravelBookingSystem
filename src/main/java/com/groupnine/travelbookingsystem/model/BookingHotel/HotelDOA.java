package com.groupnine.travelbookingsystem.model.BookingHotel;

import java.sql.Date;
import java.util.List;

public interface HotelDOA {
    // Insert new hotel
    void insert(Hotel hotel);

    // get the number of hotels
    long getHotelsCount();

    // get the number of Bookings
    long getBookingsCount();

    // get the last booking
    public List<HotelBookingModel> getLastBooking();

    // Get all hotels
    List<Hotel> getAllHotels();

    // Update hotel details
    void update(Hotel hotel);
    // Delete hotel by id
    void delete(int id);

    // Get hotel by id
    Hotel getById(int id);
    // Get all hotel bookings
    List<HotelBookingModel> getAllBookings();

    // Save a new booking
    void save(HotelBookingModel hotelBooking);

    // Update the booking status
    void updateBookingStatus(int bookingId, String status);

    // Update hotel booking details
    void updateBooking(int bookingId, String customerName, Date checkIn, Date checkOut, String status);
    /*
    public void insert(Hotel_reem_deprecated hotel);
    public List<Hotel_reem_deprecated> getAllHotels();
    public void update(Hotel_reem_deprecated hotel);
    public void delete(int id);
    public Hotel_reem_deprecated getById(int id);*/

}