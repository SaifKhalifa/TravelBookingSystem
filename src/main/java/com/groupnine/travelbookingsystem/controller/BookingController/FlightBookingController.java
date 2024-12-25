package com.groupnine.travelbookingsystem.controller.BookingController;

import com.groupnine.travelbookingsystem.model.BookingFlight.FlightBookingModel;
import com.groupnine.travelbookingsystem.model.BookingFlight.FlightRepository;
import com.groupnine.travelbookingsystem.model.BookingFlight.FlightRepositoryImp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.util.List;

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

    private FlightRepositoryImp flightRepositoryImp = new FlightRepositoryImp(); // Repository instance

    public void initialize() {
        try {
            // Get all flights from repository
            List<FlightBookingModel> flights = flightRepositoryImp.getAllFlights();
            System.out.println("Flights retrieved: " + (flights != null ? flights.size() : "null"));

            if (flights != null && !flights.isEmpty()) {
                // If flights are retrieved, print them
                flights.forEach(flight -> System.out.println("Flight: " + flight));
            } else {
                System.out.println("No flights retrieved.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set column value factories for binding with Flight object
        flightIdColumn.setCellValueFactory(new PropertyValueFactory<>("flightId"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        airlineColumn.setCellValueFactory(new PropertyValueFactory<>("airline"));
        bookingDateColumn.setCellValueFactory(new PropertyValueFactory<>("bookingDate"));
        departureColumn.setCellValueFactory(new PropertyValueFactory<>("departure"));
        arrivalColumn.setCellValueFactory(new PropertyValueFactory<>("arrival"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Align the columns' headers to the center
        flightIdColumn.setStyle("-fx-alignment: CENTER;");
        customerNameColumn.setStyle("-fx-alignment: CENTER;");

        airlineColumn.setStyle("-fx-alignment: CENTER;");
        bookingDateColumn.setStyle("-fx-alignment: CENTER;");
        departureColumn.setStyle("-fx-alignment: CENTER;");
        arrivalColumn.setStyle("-fx-alignment: CENTER;");
        statusColumn.setStyle("-fx-alignment: CENTER;");

        // Apply constrained resize policy to the table
        flightsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Load flight data from repository
        loadFlightData();

        // Add event listener for row click
        flightsTable.setOnMouseClicked(this::handleRowClick);
    }

    private void handleRowClick(MouseEvent event) {
        // Get the clicked row (flight)
        Flight selectedFlight = flightsTable.getSelectionModel().getSelectedItem();
        System.out.println("Row clicked: " + selectedFlight);

        if (selectedFlight != null) {
            if (selectedFlight.equals(lastSelectedFlight)) {
                // If the same row is clicked again, deselect it
                flightsTable.getSelectionModel().clearSelection();
                lastSelectedFlight = null; // Reset the last selected flight
                System.out.println("Row deselected: " + selectedFlight);
            } else {
                // If a new row is clicked, select it
                lastSelectedFlight = selectedFlight;
                System.out.println("New row selected: " + selectedFlight);
            }
        }
    }

    private void loadFlightData() {
        ObservableList<Flight> flightData = FXCollections.observableArrayList();

        // Retrieve all flights from the repository
        List<FlightBookingModel> flightModels = flightRepositoryImp.getAllFlights();
        System.out.println("Flight models retrieved: " + (flightModels != null ? flightModels.size() : "null"));

        if (flightModels != null && !flightModels.isEmpty()) {
            // Convert to Flight objects for TableView display
            for (FlightBookingModel model : flightModels) {
                System.out.println("Converting FlightBookingModel to Flight: " + model);
                flightData.add(new Flight(
                        String.valueOf(model.getFlightId()),
                        model.getCustomerName(),
                        model.getAirline(),
                        model.getBookingDate(),
                        model.getDeparture(),
                        model.getArrival(),
                        model.getStatus()
                ));
            }
        } else {
            System.out.println("No flight data available to display.");
        }

        // Set data in the TableView
        flightsTable.setItems(flightData);
        System.out.println("Flight data added to TableView.");
    }

    @FXML
    private void cancelFlightBooking() {
        Flight selectedFlight = flightsTable.getSelectionModel().getSelectedItem();
        System.out.println("Cancel booking selected flight: " + selectedFlight);

        if (selectedFlight != null) {
            if (!selectedFlight.getStatus().equalsIgnoreCase("Cancelled")) {
                // Update the status to "Cancelled"
                selectedFlight.setStatus("Cancelled");
                flightsTable.refresh(); // Refresh TableView to reflect changes
                showAlert(Alert.AlertType.INFORMATION, "Cancellation Successful", "The flight has been successfully cancelled.");
            } else {
                showAlert(Alert.AlertType.WARNING, "Already Cancelled", "This flight is already cancelled.");
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a flight to cancel.");
        }
    }

    @FXML
    private void setPendingBooking() {
        Flight selectedFlight = flightsTable.getSelectionModel().getSelectedItem();
        System.out.println("Set pending booking selected flight: " + selectedFlight);

        if (selectedFlight != null) {
            if (!selectedFlight.getStatus().equalsIgnoreCase("Pending")) {
                selectedFlight.setStatus("Pending");
                flightsTable.refresh(); // Refresh TableView to reflect changes
                showAlert(Alert.AlertType.INFORMATION, "Status Updated", "The flight is now in Pending Booking status.");
            } else {
                showAlert(Alert.AlertType.WARNING, "Already Pending", "This flight is already in Pending Booking status.");
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a flight to set to Pending Booking.");
        }
    }

    @FXML
    private void cancelPendingBooking() {
        Flight selectedFlight = flightsTable.getSelectionModel().getSelectedItem();
        System.out.println("Cancel pending booking selected flight: " + selectedFlight);

        if (selectedFlight != null) {
            if (selectedFlight.getStatus().equalsIgnoreCase("Pending")) {
                selectedFlight.setStatus("Confirmed");
                flightsTable.refresh(); // Refresh TableView to reflect changes
                showAlert(Alert.AlertType.INFORMATION, "Status Updated", "The Pending Booking status has been cancelled.");
            } else {
                showAlert(Alert.AlertType.WARNING, "Not Pending", "This flight is not in Pending Booking status.");
            }
        } else {
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

        @Override
        public String toString() {
            return "flights{" +
                    "flightId='" + flightId + '\'' +
                    ", customerName='" + customerName + '\'' +
                    ", airline='" + airline + '\'' +
                    ", bookingDate='" + bookingDate + '\'' +
                    ", departure='" + departure + '\'' +
                    ", arrival='" + arrival + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }
    }
}