package com.groupnine.travelbookingsystem.model.resultSearchHotels;


import com.groupnine.travelbookingsystem.model.resultSearchHotels.resultH;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class resultHDAOImp implements resultHDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Integer> getAllCardIds() {
        // Fetching only card IDs
        String query = "SELECT h.cardId FROM resultH h";
        return entityManager.createQuery(query, Integer.class).getResultList();
    }
}

