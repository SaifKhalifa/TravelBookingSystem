package com.groupnine.travelbookingsystem.model.BookingFlight;

import javax.persistence.*;

@Entity
@Table(name = "flights")
public class FlightBookingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flightId")
    private int flightId;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "airline")
    private String airline;

    @Column(name = "bookingDate")
    private String bookingDate;

    @Column(name = "departure")
    private String departure;

    @Column(name = "arrival")
    private String arrival;

    @Column(name = "status")
    private String status;

    // منشئ فارغ
    public FlightBookingModel() {}

    public FlightBookingModel(String customerName, String airline, String bookingDate, String departure, String arrival, String status) {
        this.customerName = customerName;
        this.airline = airline;
        this.bookingDate = bookingDate;
        this.departure = departure;
        this.arrival = arrival;
        this.status = status;
    }

    // Getter and Setter methods
    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FlightBookingModel{" +
                "flightId=" + flightId +
                ", customerName='" + customerName + '\'' +
                ", airline='" + airline + '\'' +
                ", bookingDate='" + bookingDate + '\'' +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}