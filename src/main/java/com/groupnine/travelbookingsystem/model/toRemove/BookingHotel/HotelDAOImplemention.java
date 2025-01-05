package com.groupnine.travelbookingsystem.model.toRemove.BookingHotel;

import com.groupnine.travelbookingsystem.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.util.List;

public class HotelDAOImplemention implements HotelDAO{

    HibernateUtil hibernateUtil;
    SessionFactory sessionFactory;

    public HotelDAOImplemention() {
        hibernateUtil = HibernateUtil.getInstance();
        sessionFactory = hibernateUtil.getSessionFactory();
    }

    @Override
    public List<HotelBookingModel> getAllBookings() {
        try (Session session = sessionFactory.openSession()) {
            // Query to fetch all hotel bookings
            List<HotelBookingModel> bookings = session.createQuery("from HotelBookingModel", HotelBookingModel.class).getResultList();
            if (bookings != null && !bookings.isEmpty()) {
                System.out.println("Fetched Bookings: " + bookings);
            } else {
                System.out.println("No bookings retrieved from database.");
            }

            return bookings != null ? bookings : List.of(); // Return an empty list if null
        } catch (Exception e) {
            System.err.println("Error fetching bookings: " + e.getMessage());
            e.printStackTrace();
            return List.of(); // Return an empty list in case of exception
        }
    }

    @Override
    public void save(HotelBookingModel hotelBooking) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(hotelBooking);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Error saving booking: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void updateBookingStatus(int bookingId, String status) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            HotelBookingModel booking = session.get(HotelBookingModel.class, bookingId);
            if (booking != null) {
                booking.setStatus(status);
                session.update(booking);
                session.getTransaction().commit();
                System.out.println("Booking status updated for Booking ID " + bookingId);
            } else {
                System.out.println("Booking with ID " + bookingId + " not found.");
            }
        } catch (Exception e) {
            System.err.println("Error updating booking status for Booking ID " + bookingId + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void updateBooking(int bookingId, String customerName, String hotelName, Date checkIn, Date checkOut, String status) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            HotelBookingModel booking = session.get(HotelBookingModel.class, bookingId);
            if (booking != null) {
                booking.setCustomerName(customerName);
                booking.setHotelName(hotelName);
                booking.setCheckIn(checkIn);
                booking.setCheckOut(checkOut);
                booking.setStatus(status);
                session.update(booking);
                session.getTransaction().commit();
                System.out.println("Booking updated for Booking ID " + bookingId);
            } else {
                System.out.println("Booking with ID " + bookingId + " not found.");
            }
        } catch (Exception e) {
            System.err.println("Error updating booking for Booking ID " + bookingId + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
}
