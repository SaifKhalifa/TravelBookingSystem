package com.groupnine.travelbookingsystem.model.hotel;

import com.groupnine.travelbookingsystem.model.hotelBooking.HotelBooking;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

//    @Column(name = "price_per_night")
//    private double price;

    @Column(name = "total_rooms")
    private int totalRooms;

    @Column(name = "rating")
    private int rating;

    @Column(name = "room_types")
    private String roomTypes;

    @Column(name = "promotional_offers")
    private String promotionalOffers;

    @Column(name = "availability")
    private String availability;

    @Column(name = "facilities")
    private String facilities;

    @Column(name = "amenities")
    private String amenities;

    @Column(name = "photo_path")
    private String photoPath;

    @Column(name = "description")
    private String description;

    @Column(name = "price_per_night")
    private double pricePerNight;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<HotelBooking> bookings;

    //Constructors
    public Hotel() {}


    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public double getPrice() {
        return pricePerNight;
    }

    public int getTotalRooms() {
        return totalRooms;
    }

    public int getRating() {
        return rating;
    }

    public String getRoomTypes() {
        return roomTypes;
    }

    public String getPromotionalOffers() {
        return promotionalOffers;
    }

    public String getAvailability() {
        return availability;
    }

    public String getFacilities() {
        return facilities;
    }

    public String getAmenities() {
        return amenities;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public String getDescription() {
        return description;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public List<HotelBooking> getBookings() {
        return bookings;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPrice(double price) {
        this.pricePerNight = price;
    }

    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setRoomTypes(String roomTypes) {
        this.roomTypes = roomTypes;
    }

    public void setPromotionalOffers(String promotionalOffers) {
        this.promotionalOffers = promotionalOffers;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setBookings(List<HotelBooking> bookings) {
        this.bookings = bookings;
    }
}