package com.groupnine.travelbookingsystem.model.BookingHotel;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "price")
    private double price;

    @Column(name = "totalRooms")
    private int totalRooms;

    @Column(name = "rating")
    private int rating;

    @Column(name = "roomTypes")
    private String roomTypes;

    @Column(name = "promotionalOffers")
    private String promotionalOffers;

    @Column(name = "availability")
    private String availability;

    @Column(name = "facilities")
    private String facilities;

    @Column(name = "amenities")
    private String amenities;

    @Column(name = "photos")
    private String photos;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<HotelBookingModel> bookings;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getTotalRooms() { return totalRooms; }
    public void setTotalRooms(int totalRooms) { this.totalRooms = totalRooms; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
    public String getRoomTypes() { return roomTypes; }
    public void setRoomTypes(String roomTypes) { this.roomTypes = roomTypes; }
    public String getPromotionalOffers() { return promotionalOffers; }
    public void setPromotionalOffers(String promotionalOffers) { this.promotionalOffers = promotionalOffers; }
    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }
    public String getFacilities() { return facilities; }
    public void setFacilities(String facilities) { this.facilities = facilities; }
    public String getAmenities() { return amenities; }
    public void setAmenities(String amenities) { this.amenities = amenities; }
    public String getPhotos() { return photos; }
    public void setPhotos(String photos) { this.photos = photos; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<HotelBookingModel> getBookings() { return bookings; }
    public void setBookings(List<HotelBookingModel> bookings) { this.bookings = bookings; }
}