package com.groupnine.travelbookingsystem.model.searchFlights;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class searchFDAOImp implements searchFDAO {

    @Override
    public List<searchF> getFlightsByDestination(String destination) {
        List<searchF> flights = new ArrayList<>();

        // Replace with actual database query logic
        try (Connection connection = DriverManager.getConnection("DB_URL", "root", "ReemaK")) {
            String query = "SELECT * FROM flightbookings WHERE destination = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, destination);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                searchF flight = new searchF(
                        resultSet.getString("destination"),
                        resultSet.getInt("passenger_count"),
                        resultSet.getDate("check_in_date"),
                        resultSet.getDate("check_out_date")
                );
                flight.setBookingId(resultSet.getInt("booking_id"));
                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }
}
