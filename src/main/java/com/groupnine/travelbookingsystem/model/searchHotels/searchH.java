package com.groupnine.travelbookingsystem.model.searchHotels;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "hotelsbookings")
public class searchH {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotelId")
    private int hotelId;

    @Column(name = "destination")
    private String destination;

    @Column(name = "roomCount")
    private int roomCount;

    @Column(name = "checkInDate")
    private Date checkInDate;

    @Column(name = "checkOutDate")
    private Date checkOutDate;

   public searchH(String destination, int roomCount) {
       this.destination = destination;
       this.roomCount = roomCount;
   }

    public searchH(String destination){}

    public searchH(String destination, int roomCount, Date checkInDate, Date checkOutDate) {
        this.destination = destination;
        this.roomCount = roomCount;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    // Getter and Setter methods
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "HotelBookingModel{" +
                "hotelId=" + hotelId +
                ", destination='" + destination + '\'' +
                ", roomCount=" + roomCount +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                '}';
    }

}
