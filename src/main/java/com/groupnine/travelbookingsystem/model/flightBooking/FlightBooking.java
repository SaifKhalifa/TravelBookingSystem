package com.groupnine.travelbookingsystem.model.flightBooking;

import com.groupnine.travelbookingsystem.model.userMangment.User;

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

    @ManyToOne
    @JoinColumn(name = "agent_id", nullable = false)
    private User user;

    //Constructors
    public FlightBooking() {
    }

    public FlightBooking(int id, String customerName, String airline, Date bookingDate, Date departure, Date arrival, String status, int flightId) {
        this.id = id;
        this.customerName = customerName;
        this.airline = airline;
        this.bookingDate = bookingDate;
        this.departure = departure;
        this.arrival = arrival;
        this.status = status;
        this.flightId = flightId;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAirline() {
        return airline;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public Date getDeparture() {
        return departure;
    }

    public Date getArrival() {
        return arrival;
    }

    public String getStatus() {
        return status;
    }

    public int getFlightId() {
        return flightId;
    }

    public User getUser() {
        return user;
    }

    public int getUserId() {
        return user.getId();
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
