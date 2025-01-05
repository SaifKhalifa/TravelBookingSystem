package com.groupnine.travelbookingsystem.model.userMangment;

import com.groupnine.travelbookingsystem.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public User getUserByUsername(String username) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery("FROM User WHERE username = :username", User.class);
            query.setParameter("username", username);
            return query.uniqueResult();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM User", User.class).list();
        }
    }

    @Override
    public int addUser(User user){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Query<Long> usernameCount = session.createQuery(
                    "SELECT COUNT(u) FROM User u WHERE u.username = :username AND u.id != :id", Long.class);
            usernameCount.setParameter("username", user.getUsername());
            usernameCount.setParameter("id", user.getId());

            Query<Long> emailCount = session.createQuery(
                    "SELECT COUNT(u) FROM User u WHERE u.email = :email AND u.id != :id", Long.class);
            emailCount.setParameter("email", user.getEmail());
            emailCount.setParameter("id", user.getId());

            long usernameExists = usernameCount.uniqueResult();
            long emailExists = emailCount.uniqueResult();

            if (usernameExists > 0 && emailExists > 0) {
                return -3;
                // Both username and email already exist.
            } else if (usernameExists > 0) {
                return -2;
                // Username already exists.
            } else if (emailExists > 0) {
                return -1;
                // Email already exists.
            }

            session.save(user);
            transaction.commit();
            return 1;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public boolean updateUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String getUserRoleByUsername(String username) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<String> query = session.createQuery("SELECT role FROM User WHERE username = :username", String.class);
            query.setParameter("username", username);
            return query.uniqueResult();
        }
    }

    @Override
    public String getUserNameByUsername(String username) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<String> query = session.createQuery("SELECT name FROM User WHERE username = :username", String.class);
            query.setParameter("username", username);
            return query.uniqueResult();
        }
    }

    @Override
    public String getUserAddressByUsername(String username) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<String> query = session.createQuery("SELECT address FROM User WHERE username = :username", String.class);
            query.setParameter("username", username);
            return query.uniqueResult();
        }
    }

    @Override
    public void updateLastLogin(String username) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE User SET lastLogin = :now WHERE username = :username");
            query.setParameter("now", LocalDateTime.now());
            query.setParameter("username", username);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // to get Last Logged-In Agent
    public User getLastLoggedInAgent() {
        User agent = null;
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Query<User> query = session.createQuery(
                    "FROM User u WHERE u.role = :role AND u.lastLogin IS NOT NULL ORDER BY u.lastLogin DESC",
                    User.class
            );
            query.setParameter("role", "Agent");
            query.setMaxResults(1); // استرجاع آخر Agent فقط

            agent = query.uniqueResult();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error fetching last logged-in agent: " + e.getMessage());
        }

        return agent;
    }
}