package com.groupnine.travelbookingsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FlightConttroller {

    @FXML
    private TextField customerNameFieldNameField; // مطابق للـ FXML

    @FXML
    private TextField departureDateField; // مطابق للـ FXML

    @FXML
    private TextField airlineNameField; // مطابق للـ FXML

    @FXML
    private TextField arrivalDateFiled; // مطابق للـ FXML

    @FXML
    private Label customerNameLabelNameLabel; // مطابق للـ FXML

    @FXML
    private Label departureDateLabel; // مطابق للـ FXML

    @FXML
    private Label airlineNameLabel; // مطابق للـ FXML

    @FXML
    private Label arrivalDateLabel; // مطابق للـ FXML

    @FXML
    private Button bookingButton;

    // This method will be called when the "Booking" button is clicked
    @FXML
    private void onBookingButtonClick() {
        // Get the values entered by the user
        String customerName = customerNameFieldNameField.getText();
        String departureDate = departureDateField.getText();
        String airlineName = airlineNameField.getText();
        String arrivalDate = arrivalDateFiled.getText();

        // Check if all fields are filled
        if (customerName.isEmpty() || departureDate.isEmpty() || airlineName.isEmpty() || arrivalDate.isEmpty()) {
            // Show error message if any field is empty
            showAlert(Alert.AlertType.ERROR, "Error", "Please fill all the fields.");
        } else {
            // Here you can implement the logic for booking the flight with the inputs
            // For example, show a success message
            showAlert(Alert.AlertType.INFORMATION, "Success", "Flight booking completed successfully!");
        }
    }

    // Method to show alert messages
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
