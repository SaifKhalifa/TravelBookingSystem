package com.groupnine.travelbookingsystem.model.userMangment;

import java.util.List;

public interface UserDAO {
    User getUserByUsername(String username);
    List<User> getAllUsers();
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(int id);

    String getUserRoleByUsername(String username);
    String getUserNameByUsername(String username);
    String getUserAddressByUsername(String username);

    void updateLastLogin(String username);
}