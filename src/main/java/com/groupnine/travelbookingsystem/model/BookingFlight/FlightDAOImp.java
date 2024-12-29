package com.groupnine.travelbookingsystem.model.BookingFlight;

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
}