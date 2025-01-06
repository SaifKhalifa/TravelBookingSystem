package com.groupnine.travelbookingsystem.model.hotelBooking;

import java.util.List;

public interface HotelBookingDAO {
    //Creation
    void addHotelBooking(HotelBooking hotelBooking);

    //Reading
    List<HotelBooking> getAllHotelBookings();
    HotelBooking getHotelBookingById(int hotelBookingId);
    HotelBooking getLatestHotelBooking();
    long getBookingsCount();

    //Updating
    void updateHotelBookingStatus(int bookingId, String status);
    void updateHotelBooking(HotelBooking hotelBooking);

    //Deleting
    void deleteHotelBookingById(int hotelBookingId);
}
