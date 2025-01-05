package com.groupnine.travelbookingsystem.model.AdminFlight;

import com.groupnine.travelbookingsystem.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.transaction.Transactional;
import java.util.List;

public class ImpAdminFlightInterface implements AdminFlightInterface {
    private HibernateUtil hibernateUtil;
    private SessionFactory sessionFactory;

    public ImpAdminFlightInterface() {
        hibernateUtil = HibernateUtil.getInstance();
        sessionFactory = hibernateUtil.getSessionFactory();
    }
    //add flight
    @Override
    @Transactional
    public void addFlight(AdminFlightModel flight) throws Exception {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(flight);
            transaction.commit();
            System.out.println("Flight added successfully!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new Exception("Error adding flight: " + e.getMessage(), e);
        }
    }

    // get flight
    @Override
    public List<AdminFlightModel> getAllFlights() throws Exception {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM AdminFlightModel", AdminFlightModel.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error fetching all flights: " + e.getMessage(), e);
        }
    }
    @Override
    public void deleteFlight(int flightId) throws Exception {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            AdminFlightModel flight = session.get(AdminFlightModel.class, flightId);

            if (flight != null) {
                session.delete(flight);
                transaction.commit();
                System.out.println("Flight deleted successfully!");
            } else {
                System.out.println("Flight not found with ID: " + flightId);
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new Exception("Error deleting flight: " + e.getMessage(), e);
        }
    }
    @Override
    public void updateFlight(AdminFlightModel flight) throws Exception {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(flight);  // Update the flight object in DB
            transaction.commit();
            System.out.println("Flight updated successfully!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback if an error occurs
            }
            e.printStackTrace();
            throw new Exception("Error updating flight: " + e.getMessage(), e);
        }}
    public  AdminFlightModel getFlightById(int flightId) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            return session.get(AdminFlightModel.class, flightId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error fetching flight by ID: " + e.getMessage(), e);
        }
    }

}
