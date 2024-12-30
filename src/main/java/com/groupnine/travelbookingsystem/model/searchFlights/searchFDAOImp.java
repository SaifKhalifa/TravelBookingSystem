package com.groupnine.travelbookingsystem.model.searchFlights;

import com.groupnine.travelbookingsystem.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class searchFDAOImp implements searchFDAO {

    @Override
    public List<searchF> searchFlightsByDestination(String destination) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM searchH WHERE destination = :destination";
            Query<searchF> query = session.createQuery(hql, searchF.class);
            query.setParameter("destination", destination);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
