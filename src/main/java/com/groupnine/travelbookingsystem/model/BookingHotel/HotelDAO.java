package com.groupnine.travelbookingsystem.model.BookingHotel;
import java.util.List;
import java.sql.Date;

public interface HotelDAO {
    // Get all hotel bookings
    List<HotelBookingModel> getAllBookings();

    public void save(HotelBookingModel hotelBooking);

    // Update the booking status
    void updateBookingStatus(int bookingId, String status);

    // Update hotel booking details (e.g., change check-in/check-out dates, customer name, etc.)
    void updateBooking(int bookingId, String customerName, String hotelName, Date checkIn, Date checkOut, String status);
}
