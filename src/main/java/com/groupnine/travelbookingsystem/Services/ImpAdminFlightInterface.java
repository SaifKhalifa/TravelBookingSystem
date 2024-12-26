package com.groupnine.travelbookingsystem.Services;

import com.groupnine.travelbookingsystem.Interfaces.AdminFlightInterface;
import com.groupnine.travelbookingsystem.model.AdminFlightModel;
import com.groupnine.travelbookingsystem.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.transaction.Transactional;

public class ImpAdminFlightInterface implements AdminFlightInterface {
    private HibernateUtil hibernateUtil;
    private SessionFactory sessionFactory;

    public ImpAdminFlightInterface() {
        hibernateUtil = HibernateUtil.getInstance();
        sessionFactory = hibernateUtil.getSessionFactory();
    }

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

    // Add additional methods as necessary for other operations like fetching flights
}
