package com.groupnine.travelbookingsystem.model.BookingFlightDetalisModel;

import com.groupnine.travelbookingsystem.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FlightDetailsDeoImpl implements FlightDeatailsDeo {

    private final SessionFactory sessionFactory;

    public FlightDetailsDeoImpl() {
        HibernateUtil hibernateUtil = HibernateUtil.getInstance();
        this.sessionFactory = hibernateUtil.getSessionFactory();
    }

    @Override
    public FlightDeatailsModel getFlightDetails(int flightId) {
        FlightDeatailsModel flightDetails = null;

        try (Session session = sessionFactory.openSession()) {
            flightDetails = session.get(FlightDeatailsModel.class, flightId);

            if (flightDetails != null) {
                System.out.println("Flight details fetched for flightId: " + flightId);
            } else {
                System.out.println("No flight details found for flightId: " + flightId);
            }
        } catch (Exception e) {
            System.err.println("Error fetching flight details for flightId " + flightId + ": " + e.getMessage());
            e.printStackTrace();
        }

        return flightDetails;
    }
}
