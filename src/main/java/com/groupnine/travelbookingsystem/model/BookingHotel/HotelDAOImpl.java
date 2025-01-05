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

    public HotelDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // دالة لاسترجاع عدد الفنادق
    public long getHotelsCount() {
        long count = 0;
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // HQL لاسترجاع عدد الفنادق
            Query<Long> query = session.createQuery("SELECT COUNT(h) FROM Hotel h", Long.class);
            count = query.getSingleResult();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error fetching hotel count: " + e.getMessage());
        }

        return count;
    }

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
        Session session = sessionFactory.openSession();
        Query<Hotel> query = session.createQuery("FROM Hotel", Hotel.class);
        List<Hotel> hotels = query.list();
        session.close();
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

    @Override
    public List<HotelBookingModel> getAllBookings() {
        Session session = sessionFactory.openSession();
        Query<HotelBookingModel> query = session.createQuery("FROM HotelBookingModel", HotelBookingModel.class);
        List<HotelBookingModel> bookings = query.list();
        session.close();
        return bookings;
    }

    @Override
    public void save(HotelBookingModel hotelBooking) {
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
        HotelBookingModel booking = session.get(HotelBookingModel.class, bookingId);
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
        HotelBookingModel booking = session.get(HotelBookingModel.class, bookingId);
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

    // get the number of bookings
    public long getBookingsCount() {
        long count = 0;
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Long> query = session.createQuery("SELECT COUNT(b) FROM HotelBookingModel b", Long.class);
            count = query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error fetching booking count: " + e.getMessage());
        }

        return count;
    }

    public List<HotelBookingModel> getLastBooking() {
        Transaction transaction = null;
        List<HotelBookingModel> lastBooking = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // جلب آخر حجز
            Query<HotelBookingModel> query = session.createQuery(
                    "FROM HotelBookingModel ORDER BY id DESC", HotelBookingModel.class
            );
            query.setMaxResults(1); // تحديد نتيجة واحدة

            lastBooking = query.getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return lastBooking;
    }
}