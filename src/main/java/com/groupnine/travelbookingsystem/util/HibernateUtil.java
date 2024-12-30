package com.groupnine.travelbookingsystem.util;

import com.groupnine.travelbookingsystem.model.BookingFlight.FlightBookingModel;
import com.groupnine.travelbookingsystem.model.BookingHotel.HotelBookingModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static HibernateUtil instance ;

    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry serviceRegistry;

    private HibernateUtil(){
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass( FlightBookingModel.class);
        configuration.addAnnotatedClass( HotelBookingModel.class);
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static HibernateUtil getInstance(){
        if(instance == null) instance = new HibernateUtil();
        return instance;
    }

    public synchronized static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static boolean isConnected() {
        try (Session session = sessionFactory.openSession()) {
            return session.isConnected();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}