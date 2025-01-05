package com.groupnine.travelbookingsystem.model.BookingHotel;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "hotel_bookings")
public class BookingHotelModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int bookingId;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "hotel_id", nullable = false)
    private int hotelId;

    @Temporal(TemporalType.DATE)
    @Column(name = "booking_date", nullable = false)
    private Date bookingDate;

    @Column(name = "total_price", nullable = false)
    private double totalPrice;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Temporal(TemporalType.DATE)
    @Column(name = "check_in_date", nullable = false)
    private LocalDate checkInDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "check_out_date", nullable = false)
    private LocalDate checkOutDate;

    @Column(name = "hotel_name", nullable = false)
    private String hotelName;

    public BookingHotelModel(int userId, int hotelId, Date bookingDate, double totalPrice, String customerName, LocalDate checkInDate, LocalDate checkOutDate, String hotelName) {
        this.userId = userId;
        this.hotelId = hotelId;
        this.bookingDate = bookingDate;
        this.totalPrice = totalPrice;
        this.customerName = customerName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.hotelName = hotelName;
    }

    public BookingHotelModel() {
    }
    public BookingHotelModel(String hotelName, String customerName, LocalDate checkInDate, LocalDate checkOutDate) {
        this.hotelName = hotelName;
        this.customerName = customerName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
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

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    @Override
    public String toString() {
        return "BookingHotelModel{" +
                "bookingId=" + bookingId +
                ", userId=" + userId +
                ", hotelId=" + hotelId +
                ", bookingDate=" + bookingDate +
                ", totalPrice=" + totalPrice +
                ", customerName='" + customerName + '\'' +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", hotelName='" + hotelName + '\'' +
                '}';
    }
}
