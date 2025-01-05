package com.groupnine.travelbookingsystem.model.userMangment;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    User getUserByUsername(String username);
    List<User> getAllUsers();

    int addUser(User user) throws Exception;
    boolean updateUser(User user);

    boolean deleteUser(int id);

    String getUserRoleByUsername(String username);
    String getUserNameByUsername(String username);
    String getUserAddressByUsername(String username);

    void updateLastLogin(String username);

    // to get Last Logged-In Agent
    User getLastLoggedInAgent();
}