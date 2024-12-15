package com.groupnine.travelbookingsystem.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class FlightBookingController {

    @FXML
    private TableView<Flight> flightsTable;

    @FXML
    private TableColumn<Flight, String> flightIdColumn;

    @FXML
    private TableColumn<Flight, String> customerNameColumn;

    @FXML
    private TableColumn<Flight, String> airlineColumn;

    @FXML
    private TableColumn<Flight, String> bookingDateColumn;

    @FXML
    private TableColumn<Flight, String> departureColumn;

    @FXML
    private TableColumn<Flight, String> arrivalColumn;

    @FXML
    private TableColumn<Flight, String> statusColumn;

    private Flight lastSelectedFlight = null;  // Track the last selected flight

    public void initialize() {

        // Setting column value factories
        flightIdColumn.setCellValueFactory(new PropertyValueFactory<>("flightId"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        airlineColumn.setCellValueFactory(new PropertyValueFactory<>("airline"));
        bookingDateColumn.setCellValueFactory(new PropertyValueFactory<>("bookingDate"));
        departureColumn.setCellValueFactory(new PropertyValueFactory<>("departure"));
        arrivalColumn.setCellValueFactory(new PropertyValueFactory<>("arrival"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Adding test data to the table
        ObservableList<Flight> flightData = FXCollections.observableArrayList(
                new Flight("F001", "Flight 101", "Air Arabia", "2024-12-01", "2024-12-10", "2024-12-11", "Confirmed"),
                new Flight("F002", "Flight 102", "Qatar Airways", "2024-12-02", "2024-12-15", "2024-12-16", "Pending"),
                new Flight("F003", "Flight 103", "Emirates", "2024-12-03", "2024-12-20", "2024-12-21", "Confirmed")
        );

        flightsTable.setItems(flightData);

        // Center align column headers
        flightIdColumn.setStyle("-fx-alignment: CENTER;");
        customerNameColumn.setStyle("-fx-alignment: CENTER;");
        airlineColumn.setStyle("-fx-alignment: CENTER;");
        bookingDateColumn.setStyle("-fx-alignment: CENTER;");
        departureColumn.setStyle("-fx-alignment: CENTER;");
        arrivalColumn.setStyle("-fx-alignment: CENTER;");
        statusColumn.setStyle("-fx-alignment: CENTER;");

        // Apply constrained resize policy to the table
        flightsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Add event listener for row click
        flightsTable.setOnMouseClicked(this::handleRowClick);
    }

    private void handleRowClick(MouseEvent event) {
        // Get the clicked row (flight)
        Flight selectedFlight = flightsTable.getSelectionModel().getSelectedItem();

        if (selectedFlight != null) {
            if (selectedFlight.equals(lastSelectedFlight)) {
                // If the same row is clicked again, deselect it
                flightsTable.getSelectionModel().clearSelection();
                lastSelectedFlight = null; // Reset the last selected flight
            } else {
                // If a new row is clicked, select it
                lastSelectedFlight = selectedFlight;
            }
        }
    }

    @FXML
    private void cancelFlightBooking() {
        // Get the selected flight
        Flight selectedFlight = flightsTable.getSelectionModel().getSelectedItem();

        if (selectedFlight != null) {
            if (!selectedFlight.getStatus().equalsIgnoreCase("Cancelled")) {
                // Update the status to "Cancelled"
                selectedFlight.setStatus("Cancelled");
                flightsTable.refresh();

                // Show success message
                showAlert(Alert.AlertType.INFORMATION, "Cancellation Successful", "The flight has been successfully cancelled.");
            } else {
                // If already cancelled
                showAlert(Alert.AlertType.WARNING, "Already Cancelled", "This flight is already cancelled.");
            }
        } else {
            // No flight selected
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a flight to cancel.");
        }
    }

    @FXML
    private void setPendingBooking() {
        // Get the selected flight
        Flight selectedFlight = flightsTable.getSelectionModel().getSelectedItem();

        if (selectedFlight != null) {
            if (!selectedFlight.getStatus().equalsIgnoreCase("Pending")) {
                // Update the status to "Pending Booking"
                selectedFlight.setStatus("Pending");
                flightsTable.refresh();

                // Show success message
                showAlert(Alert.AlertType.INFORMATION, "Status Updated", "The flight is now in Pending Booking status.");
            } else {
                // If already pending
                showAlert(Alert.AlertType.WARNING, "Already Pending", "This flight is already in Pending Booking status.");
            }
        } else {
            // No flight selected
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a flight to set to Pending Booking.");
        }
    }

    @FXML
    private void cancelPendingBooking() {
        // Get the selected flight
        Flight selectedFlight = flightsTable.getSelectionModel().getSelectedItem();

        if (selectedFlight != null) {
            if (selectedFlight.getStatus().equalsIgnoreCase("Pending")) {
                // Change the status back to "Confirmed"
                selectedFlight.setStatus("Confirmed");
                flightsTable.refresh();

                // Show success message
                showAlert(Alert.AlertType.INFORMATION, "Status Updated", "The Pending Booking status has been cancelled.");
            } else {
                // If not in Pending Booking
                showAlert(Alert.AlertType.WARNING, "Not Pending", "This flight is not in Pending Booking status.");
            }
        } else {
            // No flight selected
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a flight to cancel Pending Booking.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }




    // Flight class representing flight data
    public static class Flight {
        private String flightId;
        private String customerName;
        private String airline;
        private String bookingDate;
        private String departure;
        private String arrival;
        private String status;

        // Constructor
        public Flight(String flightId, String customerName, String airline, String bookingDate, String departure, String arrival, String status) {
            this.flightId = flightId;
            this.customerName = customerName;
            this.airline = airline;
            this.bookingDate = bookingDate;
            this.departure = departure;
            this.arrival = arrival;
            this.status = status;
        }

        // Getters and setters
        public String getFlightId() {
            return flightId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getAirline() {
            return airline;
        }

        public String getBookingDate() {
            return bookingDate;
        }

        public String getDeparture() {
            return departure;
        }

        public String getArrival() {
            return arrival;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}