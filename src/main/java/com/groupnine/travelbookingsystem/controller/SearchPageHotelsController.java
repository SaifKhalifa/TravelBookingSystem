package com.groupnine.travelbookingsystem.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class SearchPageHotelsController {

    // FXML fields to bind the UI components
    @FXML private AnchorPane backGround;
    @FXML private Button btnMyBooking;
    @FXML private Button btnProfile;
    @FXML private Button btnHome;
    @FXML private Button btnFlights;
    @FXML private Button btnHotels;
    @FXML private Button btnSearch;

    @FXML private ComboBox<String> cbFlightsHotels;
    @FXML private ComboBox<String> cbSignupLogin;
    @FXML private ComboBox<String> cbDestination;
    @FXML private ComboBox<String> cbRooms;
    @FXML private ComboBox<String> cbCheckIn;
    @FXML private ComboBox<String> cbCheckOut;
    @FXML private ComboBox<String> cbPersons;

    // Event handlers for buttons
    @FXML
    private void initialize() {
        // Initialize ComboBoxes with sample data or dynamic data from a service
        cbFlightsHotels.getItems().addAll("Flights", "Hotels");
        cbSignupLogin.getItems().addAll("Signup", "Login");
        cbDestination.getItems().addAll("New York", "Paris", "London");
        cbRooms.getItems().addAll("1", "2", "3", "4");
        cbCheckIn.getItems().addAll("2024-01-01", "2024-02-01", "2024-03-01");
        cbCheckOut.getItems().addAll("2024-01-05", "2024-02-05", "2024-03-05");
        cbPersons.getItems().addAll("1", "2", "3", "4");
    }

    // Event handler for the Home button
    @FXML
    private void handleHomeAction() {
        System.out.println("Home button clicked");
        // Navigate to home page logic
    }

    // Event handler for the My Booking button
    @FXML
    private void handleMyBookingAction() {
        System.out.println("My Booking button clicked");
        // Navigate to the My Booking page logic
    }

    // Event handler for the Profile button
    @FXML
    private void handleProfileAction() {
        System.out.println("Profile button clicked");
        // Navigate to profile page logic
    }

    // Event handler for the Search button
    @FXML
    private void handleSearchAction() {
        String destination = cbDestination.getValue();
        String rooms = cbRooms.getValue();
        String checkIn = cbCheckIn.getValue();
        String checkOut = cbCheckOut.getValue();
        String persons = cbPersons.getValue();

        // Handle the search functionality (you could call a service or update UI with results)
        System.out.println("Searching for hotels in " + destination + " for " + rooms + " rooms, check-in: " + checkIn + ", check-out: " + checkOut + " for " + persons + " person(s).");

        // Logic for the search (e.g., connecting to an API or database to fetch search results)
    }

    // Event handler for the Flights/Hotels combo box change
    @FXML
    private void handleFlightsHotelsChange() {
        String selectedOption = cbFlightsHotels.getValue();
        if ("Flights".equals(selectedOption)) {
            System.out.println("Flights selected");
            // Show flight-related UI components
        } else if ("Hotels".equals(selectedOption)) {
            System.out.println("Hotels selected");
            // Show hotel-related UI components
        }
    }

    // Event handler for the Signup/Login combo box change
    @FXML
    private void handleSignupLoginChange() {
        String selectedOption = cbSignupLogin.getValue();
        if ("Signup".equals(selectedOption)) {
            System.out.println("Signup selected");
            // Show signup UI components or navigate to the signup page
        } else if ("Login".equals(selectedOption)) {
            System.out.println("Login selected");
            // Show login UI components or navigate to the login page
        }
    }
}
