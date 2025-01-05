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

    @Column(name = "price")
    private double price;

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


}