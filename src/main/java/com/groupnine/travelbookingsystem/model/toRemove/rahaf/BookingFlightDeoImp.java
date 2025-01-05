package com.groupnine.travelbookingsystem.model.toRemove.rahaf;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BookingFlightDeoImp implements BookingFlightDeo {
    private SessionFactory sessionFactory;

    public BookingFlightDeoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
   
    @Override
    public void saveBooking(BookingFlightModel booking) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(booking);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

