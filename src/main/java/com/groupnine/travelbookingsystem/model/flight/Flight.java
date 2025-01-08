package com.groupnine.travelbookingsystem.model.flight;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flightId;

    @Column(name = "departure_airport")
    private String departureAirport;

    @Column(name = "departure_time")
    private LocalTime departureTime;

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @Column(name = "arrival_airport")
    private String arrivalAirport;

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "gate_number")
    private int gateNumber;

    @Column(name = "seat_capacity")
    private int seatCapacity;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "class_type")
    private String classType;

    @Column(name = "flight_duration")
    private LocalTime flightDuration;

    @Column(name = "notes")
    private String notes;

    @Column(name = "promotional_offer")
    private String promotionalOffer;

    @Column(name = "image_path")
    private String imagePath;

    //Constructors
    public Flight() {}

    //Getters
    public int getFlightId() {
        return flightId;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getClassType() {
        return classType;
    }

    public LocalTime getFlightDuration() {
        return flightDuration;
    }

    public String getNotes() {
        return notes;
    }

    public String getPromotionalOffer() {
        return promotionalOffer;
    }

    public String getImagePath() {
        return imagePath;
    }

    //Setters
    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public void setFlightDuration(LocalTime flightDuration) {
        this.flightDuration = flightDuration;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setPromotionalOffer(String promotionalOffer) {
        this.promotionalOffer = promotionalOffer;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setFlightId(int currentFlightId) { this.flightId = currentFlightId; }
}