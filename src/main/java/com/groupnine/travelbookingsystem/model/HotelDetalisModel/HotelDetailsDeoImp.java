package com.groupnine.travelbookingsystem.model.HotelDetalisModel;

import com.groupnine.travelbookingsystem.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HotelDetailsDeoImp implements HotelDetailsDeo {
    private final SessionFactory sessionFactory;

    public HotelDetailsDeoImp() {
        HibernateUtil hibernateUtil = HibernateUtil.getInstance();
        this.sessionFactory = hibernateUtil.getSessionFactory();
    }

    @Override
    public HotelDetalisModel getHotelById(int hotelId) {
        HotelDetalisModel hotel = null;
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            // جلب الفندق باستخدام الـ hotelId
            hotel = session.get(HotelDetalisModel.class, hotelId);

            if (hotel != null) {
                System.out.println("Hotel details fetched for hotelId: " + hotelId);
            } else {
                System.out.println("No hotel details found for hotelId: " + hotelId);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error fetching hotel details for hotelId " + hotelId + ": " + e.getMessage());
            e.printStackTrace();
        }

        return hotel;
    }
}
