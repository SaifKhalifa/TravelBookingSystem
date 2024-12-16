package com.groupnine.travelbookingsystem.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

//
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;

import java.io.File;

public class SearchPageFlightsController {

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }





    // Defining the UI components with fx:id
    @FXML
    private Button btnMyBooking;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnHome;

    @FXML
    private ComboBox<String> cbFlightsHotels;

    @FXML
    private ComboBox<String> cbSignupLogin;

    @FXML
    private ComboBox<String> cbDestination;

    @FXML
    private ComboBox<String> cbPassengers;

    @FXML
    private ComboBox<String> cbCheckIn;

    @FXML
    private ComboBox<String> cbCheckOut;

    @FXML
    private Button btnFlights;

    @FXML
    private Button btnHotels;

    @FXML
    private Button btnSearch;

    @FXML
    public AnchorPane searchPane;

    @FXML
    public AnchorPane navBar;

    @FXML
    public AnchorPane btnHotelsPane;

    @FXML
    public AnchorPane btnFlightsPane;

    @FXML
    public AnchorPane backGround;


    @FXML
    private Label lblFlyStay;

    // Initialize method is called when the FXML file is loaded
    @FXML
    public void initialize() {
        // You can set up any initialization logic here, such as populating ComboBoxes or setting event handlers.
        // For example, filling the ComboBoxes with values:
        cbFlightsHotels.getItems().addAll("Flights", "Hotels");
        cbSignupLogin.getItems().addAll("Sign Up", "Login");
        cbDestination.getItems().addAll("New York", "London", "Paris", "Madrid", "Dobui" , "Maldivs");  // Example destinations
        cbPassengers.getItems().addAll("1", "2", "3", "4", "5" , "6" , "More than 6");
        cbCheckIn.getItems().addAll("2024-12-01", "2024-12-15", "2024-12-30");
        cbCheckOut.getItems().addAll("2024-12-05", "2024-12-20", "2024-12-30");

        // Example event handlers for buttons
        btnMyBooking.setOnAction(event -> handleMyBooking());
        btnProfile.setOnAction(event -> handleProfile());
        btnHome.setOnAction(event -> handleHome());
        btnFlights.setOnAction(event -> handleFlights());
        btnHotels.setOnAction(event -> handleHotels());
        btnSearch.setOnAction(event -> handleSearch());
        //

       try {
            Image backgroundImage = new Image(getClass().getResource("./img/sf.jpeg").toExternalForm());

            // Create a BackgroundImage object
            BackgroundImage background = new BackgroundImage(backgroundImage,
                    BackgroundRepeat.NO_REPEAT,    // Do not repeat the image
                    BackgroundRepeat.NO_REPEAT,    // Do not repeat the image
                    BackgroundPosition.CENTER,     // Center the image
                    BackgroundSize.DEFAULT);       // Scale to the default size

            // Set the background to the AnchorPane
            backGround.setBackground(new Background(background));
        } catch (NullPointerException e) {
            System.out.println("Image not found!");
            e.printStackTrace();
        }

       /* File file = new File("C:/Users/HP/Desktop/TravelBookingSystem/src/main/resources/img/sf.jpeg");
        if (!file.exists()) {
            System.out.println("Image file not found at: " + file.getAbsolutePath());
        } else {
            backGround.setStyle(new StringBuilder().append("-fx-background-image: url('file:").append(file.toURI().toString()).append("'); ").append("-fx-background-radius: 60; ").append("-fx-background-repeat: no-repeat; ").append("-fx-background-size: cover;").toString());
        }*/


    }

    // Event handler methods for buttons
    private void handleMyBooking() {
        // Logic for My Booking button click
        System.out.println("My Booking clicked");
    }

    private void handleProfile() {
        // Logic for Profile button click
        System.out.println("Profile clicked");
    }

    private void handleHome() {
        // Logic for Home button click
        System.out.println("Home clicked");
    }

    private void handleFlights() {
        // Logic for Flights button click
        System.out.println("Flights clicked");
    }

    private void handleHotels() {
        // Logic for Hotels button click
        System.out.println("Hotels clicked");
    }

    private void handleSearch() {
        // Logic for Search button click
        System.out.println("Search clicked");

        // Example: Get selected ComboBox values
        String destination = cbDestination.getValue();
        String passengers = cbPassengers.getValue();
        String checkIn = cbCheckIn.getValue();
        String checkOut = cbCheckOut.getValue();

        System.out.println("Searching for " + passengers + " passengers to " + destination + " from " + checkIn + " to " + checkOut);
    }

}