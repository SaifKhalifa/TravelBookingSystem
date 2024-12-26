package com.groupnine.travelbookingsystem.controller.AdminMangeFlight;

import com.groupnine.travelbookingsystem.Services.ImpAdminFlightInterface;
import com.groupnine.travelbookingsystem.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class AddFlightController {

    @FXML
    private TextField departuretime;
    @FXML
    private TextField flightduration;
    @FXML
    private TextField destination;
    @FXML
    private TextField origin;
    @FXML
    private Button addButton;
    @FXML
    private TextField arrivaltime;
    @FXML
    private DatePicker departuredate;
    @FXML
    private DatePicker arrivaldate;
    @FXML
    private TextField gatenumber;
    @FXML
    private TextField seatcapacity;
    @FXML
    private TextField flightprice;
    @FXML
    private TextField classtype;
    @FXML
    private TextArea notes;
    @FXML
    private Button back_to_list_flight;

    @FXML
    private void navigateToListOfFlights() {
        System.out.println("Navigating to List Of Flights...");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/AdminMangeFlight/ListFlights.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root, 1280, 832));
            stage.setTitle("List Of Flights");
            stage.show();

            // Close current stage
            Stage currentStage = (Stage) back_to_list_flight.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: Unable to load ListFlights.fxml");
        }
    }

    @FXML
    private void addFlight() {
        try {
            // Check required fields
            if (origin.getText().isEmpty() || destination.getText().isEmpty() || departuretime.getText().isEmpty() || arrivaltime.getText().isEmpty()) {
                showAlert("Error", "Please fill in all the required fields.", Alert.AlertType.ERROR);
                return;
            }

            if (departuredate.getValue() == null || arrivaldate.getValue() == null) {
                showAlert("Error", "Please select both departure and arrival dates.", Alert.AlertType.ERROR);
                return;
            }

            // Parse and validate fields
            LocalTime parsedDepartureTime = parseTime(departuretime.getText(), "Departure Time");
            LocalTime parsedArrivalTime = parseTime(arrivaltime.getText(), "Arrival Time");
            LocalTime parsedFlightDuration = parseTime(flightduration.getText(), "Flight Duration");
            LocalDate parsedDepartureDate = departuredate.getValue();
            LocalDate parsedArrivalDate = arrivaldate.getValue();
            int parsedGateNumber = parseInteger(gatenumber.getText(), "Gate Number");
            int parsedSeatCapacity = parseInteger(seatcapacity.getText(), "Seat Capacity");
            BigDecimal parsedFlightPrice = parseBigDecimal(flightprice.getText(), "Flight Price");
            AdminFlightModel flight = new AdminFlightModel();

            // Create flight model object and set fields
            flight.setOrigin(origin.getText());
            flight.setDestination(destination.getText());
            flight.setDepartureTime(parsedDepartureTime); // وقت المغادرة
            flight.setArrivalTime(parsedArrivalTime);     // وقت الوصول
            flight.setFlightDuration(parsedFlightDuration); // مدة الرحلة
            flight.setGateNumber(parsedGateNumber);
            flight.setSeatCapacity(parsedSeatCapacity);
            flight.setPrice(parsedFlightPrice);
            flight.setClassType(classtype.getText());
            flight.setNotes(notes.getText());
            flight.setDepartureDate(parsedDepartureDate); // تاريخ المغادرة
            flight.setArrivalDate(parsedArrivalDate);     // تاريخ الوصول


            // Create service and add the flight
            ImpAdminFlightInterface service = new ImpAdminFlightInterface();
            service.addFlight(flight);

            // Show success message
            showAlert("Success", "Flight has been added successfully.", Alert.AlertType.INFORMATION);

            // Clear fields after adding flight
            clearFields();

        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid number format: " + e.getMessage(), Alert.AlertType.ERROR);
        } catch (Exception e) {
            showAlert("Error", "An error occurred while adding the flight: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    // Utility methods for parsing and validation
    private LocalTime parseTime(String timeString, String fieldName) {
        try {
            return LocalTime.parse(timeString);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(fieldName + " is invalid. Please enter it in HH:mm:ss format.");
        }
    }

    private int parseInteger(String numberString, String fieldName) {
        try {
            return Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(fieldName + " must be a valid integer.");
        }
    }

    private BigDecimal parseBigDecimal(String numberString, String fieldName) {
        try {
            return new BigDecimal(numberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(fieldName + " must be a valid decimal number.");
        }
    }

    // Show alert method for error/success messages
    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Clear fields after successful flight addition
    private void clearFields() {
        departuretime.clear();
        flightduration.clear();
        destination.clear();
        origin.clear();
        arrivaltime.clear();
        gatenumber.clear();
        seatcapacity.clear();
        flightprice.clear();
        classtype.clear();
        notes.clear();
        departuredate.setValue(null);
        arrivaldate.setValue(null);
    }
}
