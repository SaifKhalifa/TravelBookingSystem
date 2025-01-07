package com.groupnine.travelbookingsystem.model.hotelBooking;

import com.groupnine.travelbookingsystem.MainApplication_DEFAULT;
import com.groupnine.travelbookingsystem.model.userMangment.User;
import com.groupnine.travelbookingsystem.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class HotelBookingDAOImpl implements HotelBookingDAO {
    public HotelBookingDAOImpl() {}

    @Override
    public void addHotelBooking(HotelBooking hotelBooking) {
        Transaction transaction = null;
        Session session = null;  // Declare session outside try block

        try {
            session = HibernateUtil.getSessionFactory().openSession();  // Open session
            transaction = session.beginTransaction();

            int loggedInUserId = MainApplication_DEFAULT.getLoggedInUserId();
            User user = session.get(User.class, loggedInUserId);  // Fetch user while session is open

            if (user == null) {
                throw new Exception("User not found with ID: " + loggedInUserId);
            }

            hotelBooking.setUser(user);  // Associate user with booking
            session.save(hotelBooking);  // Persist booking

            transaction.commit();  // Commit transaction
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();  // Close session in finally block
            }
        }
    }

    @Override
    public List<HotelBooking> getAllHotelBookings() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from HotelBooking", HotelBooking.class).list();
        }
    }

    @Override
    public HotelBooking getHotelBookingById(int hotelBookingId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(HotelBooking.class, hotelBookingId);
        }
    }

    @Override
    public HotelBooking getLatestHotelBooking() {
        Transaction transaction = null;
        HotelBooking latestBooking = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // HQL to fetch the latest hotel booking
            latestBooking = session.createQuery(
                            "FROM HotelBooking ORDER BY bookingDate DESC", HotelBooking.class)
                    .setMaxResults(1)  // Limit to 1 result
                    .uniqueResult();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return latestBooking;
    }

    @Override
    public long getBookingsCount() {
        Transaction transaction = null;
        long count = 0;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // HQL to count flight bookings
            count = (Long) session.createQuery(
                            "SELECT COUNT(*) FROM HotelBooking")
                    .uniqueResult();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return count;
    }


    @Override
    public void updateHotelBookingStatus(int bookingId, String status) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            HotelBooking booking = session.get(HotelBooking.class, bookingId);
            if (booking != null) {
                booking.setStatus(status);
                session.update(booking);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void updateHotelBooking(HotelBooking hotelBooking) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(hotelBooking);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteHotelBookingById(int hotelBookingId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            HotelBooking booking = session.get(HotelBooking.class, hotelBookingId);
            if (booking != null) {
                session.delete(booking);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

}
