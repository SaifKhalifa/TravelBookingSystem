package com.groupnine.travelbookingsystem.model.BookingFlight;
import javax.persistence.*;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

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
    private Date bookingDate;

    @Column(name = "departure")
    private Date departure;

    @Column(name = "arrival")
    private Date arrival;

    @Column(name = "status")
    private String status;

    public FlightBookingModel() {}

    public FlightBookingModel(String customerName, String airline, Date bookingDate, Date departure, Date arrival, String status) {
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

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
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