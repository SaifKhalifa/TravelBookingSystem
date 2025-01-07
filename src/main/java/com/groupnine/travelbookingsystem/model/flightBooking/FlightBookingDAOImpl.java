package com.groupnine.travelbookingsystem.model.flightBooking;

import com.groupnine.travelbookingsystem.MainApplication_DEFAULT;
import com.groupnine.travelbookingsystem.model.userMangment.User;
import com.groupnine.travelbookingsystem.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class FlightBookingDAOImpl implements FlightBookingDAO {
    public FlightBookingDAOImpl() {}

    @Override
    public void addFlightBooking(FlightBooking flightBooking) {
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

            flightBooking.setUser(user);  // Associate user with booking
            session.save(flightBooking);  // Persist booking

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
    public List<FlightBooking> getAllFlightBookings() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from FlightBooking", FlightBooking.class).list();
        }
    }

    @Override
    public void getFlightBookingById(int flightBookingID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            FlightBooking booking = session.get(FlightBooking.class, flightBookingID);
            if (booking != null) {
                System.out.println(booking);
            } else {
                System.out.println("Flight booking not found.");
            }
        }
    }

    @Override
    public long getBookingsCount() {
        Transaction transaction = null;
        long count = 0;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // HQL to count flight bookings
            count = (Long) session.createQuery(
                            "SELECT COUNT(*) FROM FlightBooking")
                    .uniqueResult();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public FlightBooking getLatestFlightBooking(){
        Transaction transaction = null;
        FlightBooking latestBooking = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // HQL to fetch the latest hotel booking
            latestBooking = session.createQuery(
                            "FROM FlightBooking ORDER BY bookingDate DESC", FlightBooking.class)
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
    public void updateFlightBookingStatus(int flightId, String status) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            FlightBooking booking = session.get(FlightBooking.class, flightId);
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
    public void updateFlightBooking(FlightBooking flightBooking) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(flightBooking);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFlightBookingById(int flightId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            FlightBooking booking = session.get(FlightBooking.class, flightId);
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
