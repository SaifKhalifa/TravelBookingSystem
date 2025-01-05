package com.groupnine.travelbookingsystem.model.resultSearchFlights;

import com.groupnine.travelbookingsystem.model.resultSearchFlights.resultF;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class resultFDAOImp implements resultFDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Integer> getAllCardIds() {
        // Fetching only card IDs
        String query = "SELECT f.cardId FROM resultF f";
        return entityManager.createQuery(query, Integer.class).getResultList();
    }
}
