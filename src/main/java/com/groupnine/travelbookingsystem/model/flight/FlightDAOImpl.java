package com.groupnine.travelbookingsystem.model.flight;

import com.groupnine.travelbookingsystem.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class FlightDAOImpl implements FlightDAO {
    public FlightDAOImpl() {}

    @Override
    public void addFlight(Flight flight) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(flight);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Flight> getFlights() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Flight", Flight.class).list();
        }
    }

    @Override
    public Flight getFlightById(int flightId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Flight.class, flightId);
        }
    }


    @Override
    public void updateFlight(Flight flight) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(flight);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFlightById(int flightId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Flight flight = session.get(Flight.class, flightId);
            if (flight != null) {
                session.delete(flight);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public long getFlightsCount() {
        Transaction transaction = null;
        long count = 0;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // HQL to count flight bookings
            count = (Long) session.createQuery(
                            "SELECT COUNT(*) FROM Flight")
                    .uniqueResult();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return count;
    }
}
