package com.groupnine.travelbookingsystem.model.BookingHotel;

import com.groupnine.travelbookingsystem.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.List;

public class HotelDAOImpl implements HotelDOA {
    SessionFactory sessionFactory;
    HibernateUtil hibernateUtil;

    public HotelDAOImpl() {
        hibernateUtil = HibernateUtil.getInstance();
        sessionFactory = hibernateUtil.getSessionFactory();
    }

//    public HotelDAOImpl(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }


    @Override
    public void insert(Hotel hotel) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(hotel);
        tx.commit();
        session.close();
    }

    @Override
    public List<Hotel> getAllHotels() {
//        Session session = sessionFactory.openSession();
//        Query<Hotel> query = session.createQuery("FROM Hotel", Hotel.class);
//        List<Hotel> hotels = query.list();
//        session.close();
//        return hotels;
      //  System.out.println("Opening session...");
        Session session = sessionFactory.openSession();
      //  System.out.println("Session opened.");

        Query<Hotel> query = session.createQuery("FROM Hotel", Hotel.class);
      //  System.out.println("Query created: FROM Hotel");

        List<Hotel> hotels = query.list();
       // System.out.println("Hotels fetched: " + hotels.size());

        session.close();
       // System.out.println("Session closed.");
        return hotels;
    }

    @Override
    public void update(Hotel hotel) {
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
    public Hotel getById(int id) {
        Session session = sessionFactory.openSession();
        Hotel hotel = session.get(Hotel.class, id);
        session.close();
        return hotel;
    }

//    @Override
//    public List<HotelBookingModel> getAllBookings() {
//        Session session = sessionFactory.openSession();
//        Query<HotelBookingModel> query = session.createQuery("FROM HotelBookingModel", HotelBookingModel.class);
//        List<HotelBookingModel> bookings = query.list();
//        session.close();
//        return bookings;
//    }
//
//    @Override
//    public void save(HotelBookingModel hotelBooking) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//        session.save(hotelBooking);
//        tx.commit();
//        session.close();
//    }
//
//    @Override
//    public void updateBookingStatus(int bookingId, String status) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//        HotelBookingModel booking = session.get(HotelBookingModel.class, bookingId);
//        if (booking != null) {
//            booking.setStatus(status);
//            session.update(booking);
//        }
//        tx.commit();
//        session.close();
//    }
//
//    @Override
//    public void updateBooking(int bookingId, String customerName, Date checkIn, Date checkOut, String status) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//        HotelBookingModel booking = session.get(HotelBookingModel.class, bookingId);
//        if (booking != null) {
//            booking.setCustomerName(customerName);
//            booking.setCheckIn(checkIn);
//            booking.setCheckOut(checkOut);
//            booking.setStatus(status);
//            session.update(booking);
//        }
//        tx.commit();
//        session.close();
//    }

}