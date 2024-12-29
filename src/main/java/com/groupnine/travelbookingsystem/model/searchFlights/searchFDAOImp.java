package com.groupnine.travelbookingsystem.model.searchFlights;

//import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
//import org.springframework.data.jpa.repository.JpaRepository;


//@Repository
@Transactional
public class searchFDAOImp implements searchFDAO {

    @PersistenceContext
    private EntityManager entityManager;

    // Add a flight booking
    @Override
    public void addFlightBooking(searchF flightBooking) {
        entityManager.persist(flightBooking);
    }

    // Get a flight booking by ID
    @Override
    public searchF getFlightBookingById(int id) {
        return entityManager.find(searchF.class, id);
    }

    // Get all flight bookings
    @Override
    public List<searchF> getAllFlightBookings() {
        String query = "SELECT f FROM searchF f";
        return entityManager.createQuery(query, searchF.class).getResultList();
    }

    // Update an existing flight booking
    @Override
    public void updateFlightBooking(searchF flightBooking) {
        entityManager.merge(flightBooking);
    }

    // Delete a flight booking by ID
    @Override
    public void deleteFlightBooking(int id) {
        searchF flightBooking = getFlightBookingById(id);
        if (flightBooking != null) {
            entityManager.remove(flightBooking);
        }
    }
}


