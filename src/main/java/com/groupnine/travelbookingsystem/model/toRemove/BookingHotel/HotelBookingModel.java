package com.groupnine.travelbookingsystem.model.toRemove.BookingHotel;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "hotel_booking")
public class HotelBookingModel {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Custmer_Name")
    private String customerName;

    @Column(name = "Hotel_name")
    private String hotelName;

    @Column(name = "Booking_Date")
    private Date bookingDate;

    @Column(name = "Check_in")
    private Date checkIn;

    @Column(name = "Check_out")
    private Date checkOut;

    @Column(name = "Status")
    private String status;

    public HotelBookingModel() {}

    public HotelBookingModel(String customerName, String hotelName, Date bookingDate, Date checkIn, Date checkOut, String status) {
        this.customerName = customerName;
        this.hotelName = hotelName;
        this.bookingDate = bookingDate;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = status;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HotelBookingModel{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", bookingDate=" + bookingDate +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", status='" + status + '\'' +
                '}';
    }
}
