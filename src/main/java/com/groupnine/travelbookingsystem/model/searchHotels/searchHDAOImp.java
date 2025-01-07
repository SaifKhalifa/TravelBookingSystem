package com.groupnine.travelbookingsystem.model.searchHotels;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class searchHDAOImp implements searchHDAO {

    @Override
    public List<searchH> getHotelsByDestination(String destination) {
        List<searchH> hotels = new ArrayList<>();

        // Replace with actual database query logic
        try (Connection connection = DriverManager.getConnection("DB_URL", "root", "ReemaK")) {
            String query = "SELECT * FROM hotelsbookings WHERE destination = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, destination);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                searchH hotel = new searchH(
                        resultSet.getString("destination"),
                        resultSet.getInt("roomCount"),
                        resultSet.getDate("checkInDate"),
                        resultSet.getDate("checkOutDate")
                );
                hotel.setHotelId(resultSet.getInt("hotelId"));
                hotels.add(hotel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hotels;
    }


}
