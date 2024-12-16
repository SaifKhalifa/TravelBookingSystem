package com.groupnine.travelbookingsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BookingHotel {

    @FXML
    private TextField hotelNameField;

    @FXML
    private TextField checkOutDateField;

    @FXML
    private TextField customerNameField;

    @FXML
    private TextField checkInDateField;

    @FXML
    private Button bookingButton;

    @FXML
    private Label hotelNameLabel;

    @FXML
    private Label customerNameLabel;

    @FXML
    private Label checkOutDateLabel;

    @FXML
    private Label checkInDateLabel;

    // Method to handle booking button click
    @FXML
    private void onBookingButtonClick() {

        String hotelName = hotelNameField.getText();
        String customerName = customerNameField.getText();
        String checkInDate = checkInDateField.getText();
        String checkOutDate = checkOutDateField.getText();

        // Print the entered details in the console
        System.out.println("Hotel Name: " + hotelName);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Check-In Date: " + checkInDate);
        System.out.println("Check-Out Date: " + checkOutDate);
        System.out.println("Button clicked!");

        // Show the booking confirmation in an alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Booking Confirmation");
        alert.setHeaderText("Booking Successful!");
        alert.setContentText("Thank you, " + customerName + ". Your booking for hotel '" + hotelName + "' from " + checkInDate + " to " + checkOutDate + " is confirmed.");
        alert.showAndWait();
    }

    // Initialize method to set up the event handler for the button
    @FXML
    public void initialize() {
        bookingButton.setOnAction(event -> onBookingButtonClick());
    }
}
