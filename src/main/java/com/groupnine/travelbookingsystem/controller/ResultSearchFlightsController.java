package com.groupnine.travelbookingsystem.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class ResultSearchFlightsController {

    @FXML
    private Button myBookingButton;

    @FXML
    private Button profileButton;

    @FXML
    private Button roundTripButton;

    @FXML
    private ComboBox<String> comboBox1;

    @FXML
    private ComboBox<String> comboBox2;

    @FXML
    private Label flyStayLabel;

    @FXML
    private TextField destinationNameField;

    @FXML
    private TextField ratingField;

    @FXML
    private Circle ratingCircle;

    @FXML
    private ImageView ratingPointerImageView;

    @FXML
    private ImageView starImageView;

    @FXML
    private TextField destinationInfoField;

    @FXML
    private TextField travelDatesField;

    @FXML
    private TextField priceField;

    @FXML
    private Slider verticalSlider;

    @FXML
    private TextField popularDestinationsText;

    @FXML
    private TextField descriptionText;

    @FXML
    private AnchorPane popularDestinationCard;

    @FXML
    private AnchorPane card2;

    @FXML
    private ImageView imageView2;

    @FXML
    private AnchorPane backgroundImage2;

    @FXML
    private TextField destinationNameField2;

    @FXML
    private TextField ratingField2;

    @FXML
    private Circle ratingCircle2;

    @FXML
    private ImageView ratingPointerImageView2;

    @FXML
    private ImageView starImageView2;

    @FXML
    private TextField destinationInfoField2;

    @FXML
    private TextField travelDatesField2;

    @FXML
    private TextField priceField2;

    @FXML
    private Button roundTripButton2;

    @FXML
    private DropShadow cardDropShadow;

    // Initialize method to set up any initial behavior or properties
    @FXML
    public void initialize() {
        // Set comboBox1 items
        comboBox1.getItems().addAll("Flights", "Hotels");

        // Set comboBox2 items
        comboBox2.getItems().addAll("Sign Up", "Log In");

        // Add default event handlers
        setButtonActions();
    }

    private void setButtonActions() {
        myBookingButton.setOnAction(event -> handleMyBooking());
        profileButton.setOnAction(event -> handleProfile());
        roundTripButton.setOnAction(event -> handleRoundTrip());
        roundTripButton2.setOnAction(event -> handleRoundTrip());
    }

    private void handleMyBooking() {
        System.out.println("My Booking button clicked.");
        // Add functionality to navigate to the 'My Booking' page
    }

    private void handleProfile() {
        System.out.println("Profile button clicked.");
        // Add functionality to navigate to the 'Profile' page
    }

    private void handleRoundTrip() {
        System.out.println("Round Trip button clicked.");
        // Add functionality for round trip action
    }

    // Add more methods for other interactions as needed
}

