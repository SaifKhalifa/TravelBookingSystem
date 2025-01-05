package com.groupnine.travelbookingsystem.model.hotelBooking;

import com.groupnine.travelbookingsystem.model.hotel.Hotel;
import com.groupnine.travelbookingsystem.model.userMangment.User;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "hotel_bookings")
public class HotelBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
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

    @OneToOne
    @JoinColumn(name = "agent_id")
    private User user;

    //Constructors
    public HotelBooking() {}

}