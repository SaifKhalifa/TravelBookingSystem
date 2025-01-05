package com.groupnine.travelbookingsystem.model.hotel;

import com.groupnine.travelbookingsystem.model.hotelBooking.HotelBooking;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.sql.Date;
import java.util.List;

public class HotelDAOImpl implements HotelDAO {
    private SessionFactory sessionFactory;

    public HotelDAOImpl() {}
    
    public HotelDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addHotel(Hotel hotel) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(hotel);
        tx.commit();
        session.close();
    }

    @Override
    public List<Hotel> getAllHotels() {
        Session session = sessionFactory.openSession();
        Query<Hotel> query = session.createQuery("FROM Hotel", Hotel.class);
        List<Hotel> hotels = query.list();
        session.close();
        return hotels;
    }

    @Override
    public void updateHotel(Hotel hotel) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(hotel);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Hotel hotel = session.get(Hotel.class, id);
        if (hotel != null) {
            session.delete(hotel);
        }
        tx.commit();
        session.close();
    }

    @Override
    public Hotel getHotelById(int id) {
        Session session = sessionFactory.openSession();
        Hotel hotel = session.get(Hotel.class, id);
        session.close();
        return hotel;
    }

    @Override
    public List<HotelBooking> getAllBookings() {
        Session session = sessionFactory.openSession();
        Query<HotelBooking> query = session.createQuery("FROM HotelBooking", HotelBooking.class);
        List<HotelBooking> bookings = query.list();
        session.close();
        return bookings;
    }

    @Override
    public void saveBooking(HotelBooking hotelBooking) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(hotelBooking);
        tx.commit();
        session.close();
    }

    @Override
    public void updateBookingStatus(int bookingId, String status) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        HotelBooking booking = session.get(HotelBooking.class, bookingId);
        if (booking != null) {
            booking.setStatus(status);
            session.update(booking);
        }
        tx.commit();
        session.close();
    }

    @Override
    public void updateBooking(int bookingId, String customerName, Date checkIn, Date checkOut, String status) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        HotelBooking booking = session.get(HotelBooking.class, bookingId);
        if (booking != null) {
            booking.setCustomerName(customerName);
            booking.setCheckIn(checkIn);
            booking.setCheckOut(checkOut);
            booking.setStatus(status);
            session.update(booking);
        }
        tx.commit();
        session.close();
    }
}