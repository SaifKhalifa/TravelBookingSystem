package com.groupnine.travelbookingsystem.model.HotelDetalisModel;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "hotels")
public class HotelDetalisModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private int hotelId;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "location")
    private String location;

    @Column(name = "price_per_night")
    private double pricePerNight;

    @Column(name = "amenities")
    private String amenities;

    @Column(name = "image_urls")
    private String imageUrls;

    // Getter and Setter Methods
    public String getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String imageUrls) {
        this.imageUrls = imageUrls;
    }

    public List<String> getImageUrlsList() {
        return Arrays.asList(imageUrls.split(","));
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }
}
