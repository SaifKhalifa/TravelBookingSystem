package com.groupnine.travelbookingsystem.util;


import com.groupnine.travelbookingsystem.model.toRemove.AdminFlight.AdminFlightModel;
import com.groupnine.travelbookingsystem.model.toRemove.BookingFlight.FlightBookingModel; //sana
import com.groupnine.travelbookingsystem.model.userMangment.User;
//import com.groupnine.travelbookingsystem.model.toRemove.rahaf.BookingFlightModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static HibernateUtil instance = null;

    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry serviceRegistry;

    private HibernateUtil(){
        try {
            Configuration configuration = new Configuration();


            configuration.addAnnotatedClass(AdminFlightModel.class);  // Ensure User class is mapped
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(FlightBookingModel.class);
           // configuration.addAnnotatedClass(BookingFlightModel.class);

            configuration.configure();

            serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Failed to initialize Hibernate: " + e.getMessage());
        }
        /*Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);*/
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