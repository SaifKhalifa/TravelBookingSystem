package com.groupnine.travelbookingsystem.model.toRemove.BookingFlight;

import com.groupnine.travelbookingsystem.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class FlightDAOImp implements FlightDAO {

HibernateUtil hibernateUtil;
SessionFactory sessionFactory;

    public FlightDAOImp(){
    hibernateUtil= HibernateUtil.getInstance();
    sessionFactory = hibernateUtil.getSessionFactory();
}

    @Override
    public List<FlightBookingModel> getAllFlights() {

        try (Session session = sessionFactory.openSession()) {
            List<FlightBookingModel> flights = session.createQuery("from FlightBookingModel", FlightBookingModel.class).list();

            if (flights != null && !flights.isEmpty()) {
                System.out.println("Fetched Flights: " + flights);
            } else {
                System.out.println("No flights retrieved from database.");
            }
            return flights != null ? flights : List.of(); // Return an empty list if null
        } catch (Exception e) {
            System.err.println("Error fetching flights: " + e.getMessage());
            e.printStackTrace();
            return List.of(); // Return an empty list in case of exception
        }
    }

    @Override
    public void updateFlightStatus(int flightId, String status) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            FlightBookingModel flight = session.get(FlightBookingModel.class, flightId);
            if (flight != null) {
                flight.setStatus(status);
                session.update(flight);
                session.getTransaction().commit();
                System.out.println("Flight status updated for Flight ID " + flightId);
            } else {
                System.out.println("Flight with ID " + flightId + " not found.");
            }
        } catch (Exception e) {
            System.err.println("Error updating flight status for Flight ID " + flightId + ": " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error updating flight status. Please try again later.", e);
        }
    }
package com.groupnine.travelbookingsystem.model.BookingFlight;

import com.groupnine.travelbookingsystem.model.BookingHotel.HotelBookingModel;
import com.groupnine.travelbookingsystem.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class FlightDAOImp implements FlightDAO {

HibernateUtil hibernateUtil;
SessionFactory sessionFactory;

    public FlightDAOImp(){
    hibernateUtil= HibernateUtil.getInstance();
    sessionFactory = hibernateUtil.getSessionFactory();
}

    @Override
    public List<FlightBookingModel> getAllFlights() {

        try (Session session = sessionFactory.openSession()) {
            List<FlightBookingModel> flights = session.createQuery("from FlightBookingModel", FlightBookingModel.class).list();

            if (flights != null && !flights.isEmpty()) {
                System.out.println("Fetched Flights: " + flights);
            } else {
                System.out.println("No flights retrieved from database.");
            }
            return flights != null ? flights : List.of(); // Return an empty list if null
        } catch (Exception e) {
            System.err.println("Error fetching flights: " + e.getMessage());
            e.printStackTrace();
            return List.of(); // Return an empty list in case of exception
        }
    }

    @Override
    public void updateFlightStatus(int flightId, String status) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            FlightBookingModel flight = session.get(FlightBookingModel.class, flightId);
            if (flight != null) {
                flight.setStatus(status);
                session.update(flight);
                session.getTransaction().commit();
                System.out.println("Flight status updated for Flight ID " + flightId);
            } else {
                System.out.println("Flight with ID " + flightId + " not found.");
            }
        } catch (Exception e) {
            System.err.println("Error updating flight status for Flight ID " + flightId + ": " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error updating flight status. Please try again later.", e);
        }
    }


    // get the number of bookings
    public long getBookingsCount() {
        long count = 0;
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Long> query = session.createQuery("SELECT COUNT(b) FROM FlightBookingModel b", Long.class);
            count = query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Error fetching booking count: " + e.getMessage());
        }

        return count;
    }


    // get the last flight booking
    public List<FlightBookingModel> getLastBooking() {
        Transaction transaction = null;
        List<FlightBookingModel> lastBooking = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // جلب آخر حجز
            Query<FlightBookingModel> query = session.createQuery(
                    "FROM FlightBookingModel ORDER BY flightId DESC", FlightBookingModel.class
            );
            query.setMaxResults(1); // تحديد نتيجة واحدة

            lastBooking = query.getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return lastBooking;
    }

    // get the number of Flights
//    public long getFlightsCount() {
//        long count = 0;
//        Transaction transaction = null;
//
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            Query<Long> query = session.createQuery("SELECT COUNT(f) FROM Flight f", Long.class);
//            count = query.getSingleResult();
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) transaction.rollback();
//            System.out.println("Error fetching flight count: " + e.getMessage());
//        }
//
//        return count;
//    }


}