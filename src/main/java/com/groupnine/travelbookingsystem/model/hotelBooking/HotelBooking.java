package com.groupnine.travelbookingsystem.model.hotelBooking;

import com.groupnine.travelbookingsystem.model.hotel.Hotel;
import com.groupnine.travelbookingsystem.model.userMangment.User;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "hotel_bookings")
public class HotelBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "booking_date")
    private LocalDate bookingDate;

    @Column(name = "check_in_date")
    private LocalDate checkIn;

    @Column(name = "check_out_date")
    private LocalDate checkOut;

    @Column(name = "status")
    private String status;

    @Column(name = "hotel_name")
    private String hotelName;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "agent_id", nullable = false)
    private User user;

    //Constructors
    public HotelBooking() {}
    public HotelBooking(int id, String customerName, LocalDate bookingDate, LocalDate checkIn, LocalDate checkOut, String status, Hotel hotel, User user) {
        this.id = id;
        this.customerName = customerName;
        this.bookingDate = bookingDate;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = status;
        this.hotel = hotel;
        this.user = user;
    }

    public HotelBooking(String hotelName, String customerName, LocalDate checkInDate, LocalDate checkOutDate) {
        this.hotelName = hotelName;
        this.customerName = customerName;
        this.checkIn = checkInDate;
        this.checkOut = checkOutDate;
    }

    public HotelBooking(int id, String customerName, String hotelName, LocalDate bookingDate, LocalDate checkIn, LocalDate checkOut, String status, Hotel hotel, User user) {
        this.id = id;
        this.customerName = customerName;
        this.hotelName = hotelName;
        this.bookingDate = bookingDate;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = status;
        this.hotel = hotel;
        this.user = user;
    }

    //Getters
    public int getId() {
        return this.id;
    }

    public String getHotelName()
    {
        return this.hotelName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public String getStatus() {
        return status;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public User getUser() {
        return user;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setHotelName(String hotelName) {
        //this.hotel.setName(hotelName);
        this.hotelName = hotelName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setUser(User user) {
        this.user = user;
    }
}