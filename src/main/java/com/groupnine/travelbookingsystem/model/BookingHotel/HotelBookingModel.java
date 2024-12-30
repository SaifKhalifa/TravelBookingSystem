package com.groupnine.travelbookingsystem.model.BookingHotel;

import com.groupnine.travelbookingsystem.model.BookingHotel.Hotel;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "hotel_booking")
class HotelBookingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Custmer_Name")
    private String customerName;

    @Column(name = "Booking_Date")
    private Date bookingDate;

    @Column(name = "Check_in")
    private Date checkIn;

    @Column(name = "Check_out")
    private Date checkOut;

    @Column(name = "Status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public HotelBookingModel() {}

    public HotelBookingModel(String customerName, Date bookingDate, Date checkIn, Date checkOut, String status, Hotel hotel) {
        this.customerName = customerName;
        this.bookingDate = bookingDate;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = status;
        this.hotel = hotel;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public Date getBookingDate() { return bookingDate; }
    public void setBookingDate(Date bookingDate) { this.bookingDate = bookingDate; }
    public Date getCheckIn() { return checkIn; }
    public void setCheckIn(Date checkIn) { this.checkIn = checkIn; }
    public Date getCheckOut() { return checkOut; }
    public void setCheckOut(Date checkOut) { this.checkOut = checkOut; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Hotel getHotel() { return hotel; }
    public void setHotel(Hotel hotel) { this.hotel = hotel; }
}