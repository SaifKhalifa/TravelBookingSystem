package com.groupnine.travelbookingsystem.util;

import com.groupnine.travelbookingsystem.model.Users;
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
        Configuration configuration = new Configuration();
        //configuration.addAnnotatedClass(Users.class);
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