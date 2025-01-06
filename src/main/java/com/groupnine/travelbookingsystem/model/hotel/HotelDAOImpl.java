package com.groupnine.travelbookingsystem.model.hotel;

import com.groupnine.travelbookingsystem.model.hotelBooking.HotelBooking;
import com.groupnine.travelbookingsystem.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.List;

public class HotelDAOImpl implements HotelDAO {
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
    public void deleteHotelById(int id) {
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
}