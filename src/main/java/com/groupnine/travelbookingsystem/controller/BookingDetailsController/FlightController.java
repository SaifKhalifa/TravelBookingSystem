package com.groupnine.travelbookingsystem.controller.BookingDetailsController;

import com.groupnine.travelbookingsystem.model.flightBooking.FlightBooking;
import com.groupnine.travelbookingsystem.model.flightBooking.FlightBookingDAOImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.time.LocalDate;

public class FlightController {

    @FXML
    private TextField customerNameField, airlineNameField, flightIdField/*, agentIdField*/;

    @FXML
    private DatePicker departureDatePicker, arrivalDatePicker;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private Button bookingButton;

    int flightId;

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    private FlightBookingDAOImpl bookingFlightDeo = new FlightBookingDAOImpl();

    @FXML
    private void onBookingButtonClick() {
        String customerName = customerNameField.getText();
        LocalDate departureDate = departureDatePicker.getValue();
        String airlineName = airlineNameField.getText();
        LocalDate arrivalDate = arrivalDatePicker.getValue();
        String flightIdText = flightIdField.getText();
        String status = statusComboBox.getValue();

        if (customerName.isEmpty() || departureDate == null || airlineName.isEmpty() ||
                arrivalDate == null || flightIdText.isEmpty() || status == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please fill all the fields.");
            return;
        }

        try {
            flightId = Integer.parseInt(flightIdText);
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Flight ID must be valid.");
            return;
        }

        if (flightId <= 0 ) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid flight ID or agent ID.");
            return;
        }

        try {
            Date departureDateConverted = Date.valueOf(departureDate);
            Date arrivalDateConverted = Date.valueOf(arrivalDate);

            FlightBooking booking = new FlightBooking();
            booking.setCustomerName(customerName);
            booking.setDeparture(departureDateConverted);
            booking.setAirline(airlineName);
            booking.setArrival(arrivalDateConverted);
            booking.setBookingDate(new Date(System.currentTimeMillis()));
            booking.setFlightId(flightId);
            booking.setStatus(status);

            bookingFlightDeo.addFlightBooking(booking);

            showAlert(Alert.AlertType.INFORMATION, "Success", "Flight booking completed successfully!");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            showAlert(Alert.AlertType.ERROR, "Error", "An unexpected error occurred: " + e.getMessage());
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