package com.groupnine.travelbookingsystem.model.BookingFlight;
import com.groupnine.travelbookingsystem.model.BookingFlight.FlightBookingModel;
import java.util.List;

public interface FlightRepository {
    // جلب جميع الرحلات
    List<FlightBookingModel> getAllFlights();

    // تحديث حالة الرحلة
    void updateFlightStatus(int flightId, String status);
}