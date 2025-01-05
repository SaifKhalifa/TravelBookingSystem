package com.groupnine.travelbookingsystem.model.rahaf;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "bookings")
public class BookingFlightModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int bookingId;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "flight_id", nullable = false)
    private int flightId;

    @Temporal(TemporalType.DATE)
    @Column(name = "booking_date", nullable = false)
    private Date bookingDate;

    @Column(name = "total_price", nullable = false)
    private double totalPrice;
    @Column(name = "CustomerName", nullable = false)
    private String customer_name;
    @Column(name = "DepartureDate", nullable = false)
    private Date departure_date;

    @Column(name = "AirlineName", nullable = false)
    private String airline_name ;
    @Column(name = "AirlineDate", nullable = false)
    private Date airline_date;




    public BookingFlightModel(int userId, int flightId, Date bookingDate, double totalPrice, String customerName, Date DepartureDate, String airlineName, Date airlineDate) {
        this.userId = userId;
        this.flightId = flightId;
        this.bookingDate = bookingDate;
        this.totalPrice = totalPrice;
       this.customer_name = customerName;
        this.departure_date=DepartureDate;
       this. airline_name = airlineName;
       this. airline_date = airlineDate;
    }

    public BookingFlightModel(String airlineName, Date airlineDate) {

        airline_name = airlineName;
        airline_date = airlineDate;
    }

    public BookingFlightModel() {

    }

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public Date getAirline_date() {
        return airline_date;
    }

    public void setAirline_date(Date airline_date) {
        this.airline_date = airline_date;
    }

    public String getAirline_name() {
        return airline_name;
    }

    public void setAirline_name(String airline_name) {
        this.airline_name = airline_name;
    }
    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", userId=" + userId +
                ", flightId=" + flightId +
                ", bookingDate=" + bookingDate +
                ", totalPrice=" + totalPrice +
                ", customerName='" + customer_name + '\'' +
                ", departureDate=" + departure_date +
                ", airlineName='" + airline_name + '\'' +
                ", airlineDate=" + airline_date +
                '}';
    }


}
