package com.groupnine.travelbookingsystem.model.searchFlights;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "flightbookings")
public class searchF {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int bookingId;

    @Column(name = "destination", nullable = false)
    private static String destination;

    @Column(name = "passenger_count", nullable = false)
    private int passengerCount;

    @Column(name = "check_in_date", nullable = false)
    private Date checkInDate;

    @Column(name = "check_out_date", nullable = false)
    private Date checkOutDate;

    // Constructors
    public searchF() {}

    public searchF(String destination, int passengerCount, Date checkInDate, Date checkOutDate) {
        this.destination = destination;
        this.passengerCount = passengerCount;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public searchF(String destination, int passengerCount) {
        this.passengerCount = passengerCount;
        this.destination = destination;
    }

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getDestination() {
        return destination;
    }

    public static void setDestination(String destination) {
        searchF.destination = destination;
    }


    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    // toString Method
    @Override
    public String toString() {
        return "FlightSearchModel{" +
                "bookingId=" + bookingId +
                ", destination='" + destination + '\'' +
                ", passengerCount=" + passengerCount +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                '}';
    }

}