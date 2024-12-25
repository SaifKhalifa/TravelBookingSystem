package com.groupnine.travelbookingsystem.controller.BookingDetailsController;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FlightConttroller {

    @FXML
    private TextField customerNameFieldNameField;

    @FXML
    private TextField departureDateField;

    @FXML
    private TextField airlineNameField;

    @FXML
    private TextField arrivalDateFiled;

    @FXML
    private Label customerNameLabelNameLabel;

    @FXML
    private Label departureDateLabel;

    @FXML
    private Label airlineNameLabel;

    @FXML
    private Label arrivalDateLabel;

    @FXML
    private Button bookingButton;

    @FXML
    private void onBookingButtonClick() {
        // Get the values entered by the user
        String customerName = customerNameFieldNameField.getText();
        String departureDate = departureDateField.getText();
        String airlineName = airlineNameField.getText();
        String arrivalDate = arrivalDateFiled.getText();

        if (customerName.isEmpty() || departureDate.isEmpty() || airlineName.isEmpty() || arrivalDate.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please fill all the fields.");
        } else {
            showAlert(Alert.AlertType.INFORMATION, "Success", "Flight booking completed successfully!");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
