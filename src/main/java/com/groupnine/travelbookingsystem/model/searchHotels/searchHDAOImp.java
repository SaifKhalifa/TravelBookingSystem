package com.groupnine.travelbookingsystem.model.searchHotels;

import com.groupnine.travelbookingsystem.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class searchHDAOImp implements searchHDAO {

    @Override
    public List<searchH> searchHotelsByDestination(String destination) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM searchH WHERE destination = :destination";
            Query<searchH> query = session.createQuery(hql, searchH.class);
            query.setParameter("destination", destination);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
