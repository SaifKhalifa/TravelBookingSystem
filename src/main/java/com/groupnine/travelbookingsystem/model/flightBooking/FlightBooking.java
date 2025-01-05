package com.groupnine.travelbookingsystem.model.flightBooking;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "flight_bookings")
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int id;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "airline")
    private String airline;

    @Column(name = "booking_date")
    private Date bookingDate;

    @Column(name = "departure")
    private Date departure;

    @Column(name = "arrival")
    private Date arrival;

    @Column(name = "status")
    private String status;

    @Column(name = "flight_id", nullable = false)
    private int flightId;
}
