package com.groupnine.travelbookingsystem.model.services;

import com.groupnine.travelbookingsystem.model.Hotel;
import com.groupnine.travelbookingsystem.model.interfaces.HotelDOA;
import com.groupnine.travelbookingsystem.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HotelDOAImp implements HotelDOA {
    HibernateUtil hibernateUtil;
    SessionFactory sessionFactory;

    public HotelDOAImp() {

        hibernateUtil = hibernateUtil.getInstance();
        sessionFactory = hibernateUtil.getSessionFactory();

    }
    @Override
    public void insert(Hotel hotel) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(hotel);
        session.getTransaction().commit();
        session.close();
    }

    // Retrieve all hotels
    @Override
    public List<Hotel> getAllHotels() {
        try (Session session = sessionFactory.openSession()) {
            Query<Hotel> query = session.createQuery("from Hotel", Hotel.class);//HQL -> hibernate query language
            return query.getResultList(); // Fetch all hotel records
        }
    }

    // Update a hotel record
    @Override
    public void update(Hotel hotel) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(hotel);
            transaction.commit(); // Commit the update
        } catch (Exception e) {
            if (transaction != null) transaction.rollback(); // Rollback on failure
            e.printStackTrace();
        }
    }

    // Delete a hotel record by ID
    @Override
    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Hotel hotel = session.get(Hotel.class, id);
            if (hotel != null) {
                session.delete(hotel); // Delete the record
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback(); // Rollback on failure
            e.printStackTrace();
        }
    }

    // Retrieve a hotel by ID
    @Override
    public Hotel getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Hotel.class, id); // Retrieve by ID
        }
    }
}
