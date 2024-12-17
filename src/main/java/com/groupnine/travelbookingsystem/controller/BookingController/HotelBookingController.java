package com.groupnine.travelbookingsystem.controller.BookingController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.Optional;



public class HotelBookingController {

    @FXML
    private TableView<Hotel> hotelsTable;

    @FXML
    private TableColumn<Hotel, String> hotleIdColumn;

    @FXML
    private TableColumn<Hotel, String> customerrNameColumn;

    @FXML
    private TableColumn<Hotel, String> hotelNameColumn;

    @FXML
    private TableColumn<Hotel, String> bookinggDateColumn;

    @FXML
    private TableColumn<Hotel, String> checkInColumn;

    @FXML
    private TableColumn<Hotel, String> checkOutColumn;

    @FXML
    private TableColumn<Hotel, String> statussColumn;


    private Hotel lastSelectedHotel = null;  // Track the last selected hotel

    public void initialize() {
        // Setting column value factories
        hotleIdColumn.setCellValueFactory(new PropertyValueFactory<>("hotelId"));
        customerrNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        hotelNameColumn.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
        bookinggDateColumn.setCellValueFactory(new PropertyValueFactory<>("bookingDate"));
        checkInColumn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        checkOutColumn.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        statussColumn.setCellValueFactory(new PropertyValueFactory<>("status"));



        // Adding test data to the table
        ObservableList<Hotel> hotelData = FXCollections.observableArrayList(
                new Hotel("H001", "John Doe", "Hilton", "2024-12-01", "2024-12-05", "2024-12-10", "Confirmed"),
                new Hotel("H002", "Jane Smith", "Marriott", "2024-12-02", "2024-12-10", "2024-12-15", "Pending"),
                new Hotel("H003", "Alice Brown", "Sheraton", "2024-12-03", "2024-12-12", "2024-12-18", "Pending")
        );

        hotelsTable.setItems(hotelData);

        // Center align column headers
        hotleIdColumn.setStyle("-fx-alignment: CENTER;");
        customerrNameColumn.setStyle("-fx-alignment: CENTER;");
        hotelNameColumn.setStyle("-fx-alignment: CENTER;");
        bookinggDateColumn.setStyle("-fx-alignment: CENTER;");
        checkInColumn.setStyle("-fx-alignment: CENTER;");
        checkOutColumn.setStyle("-fx-alignment: CENTER;");
        statussColumn.setStyle("-fx-alignment: CENTER;");

        // Apply constrained resize policy to the table
        hotelsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Add event listener for row click
        hotelsTable.setOnMouseClicked(this::handleRowClick);
    }

    private void handleRowClick(MouseEvent event) {
        // Get the clicked row (hotel)
        Hotel selectedHotel = hotelsTable.getSelectionModel().getSelectedItem();

        if (selectedHotel != null) {
            if (selectedHotel.equals(lastSelectedHotel)) {
                // If the same row is clicked again, deselect it
                hotelsTable.getSelectionModel().clearSelection();
                lastSelectedHotel = null; // Reset the last selected hotel
            } else {
                // If a new row is clicked, select it
                lastSelectedHotel = selectedHotel;
            }
        }
    }

    @FXML
    private void cancelHotelBooking() {
        // Get the selected hotel
        Hotel selectedHotel = hotelsTable.getSelectionModel().getSelectedItem();

        if (selectedHotel != null) {
            if (!selectedHotel.getStatus().equalsIgnoreCase("Cancelled")) {
                // Update the status to "Cancelled"
                selectedHotel.setStatus("Cancelled");
                hotelsTable.refresh();

                // Show success message
                showAlert(Alert.AlertType.INFORMATION, "Cancellation Successful", "The booking has been successfully cancelled.");
            } else {
                // If already cancelled
                showAlert(Alert.AlertType.WARNING, "Already Cancelled", "This booking is already cancelled.");
            }
        } else {
            // No hotel selected
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a booking to cancel.");
        }
    }

    @FXML
    private void setPendingBooking() {
        // Get the selected hotel
        Hotel selectedHotel = hotelsTable.getSelectionModel().getSelectedItem();

        if (selectedHotel != null) {
            if (!selectedHotel.getStatus().equalsIgnoreCase("Pending")) {
                // Update the status to "Pending Booking"
                selectedHotel.setStatus("Pending");
                hotelsTable.refresh();

                // Show success message
                showAlert(Alert.AlertType.INFORMATION, "Status Updated", "The booking is now in Pending Booking status.");
            } else {
                // If already pending
                showAlert(Alert.AlertType.WARNING, "Already Pending", "This booking is already in Pending Booking status.");
            }
        } else {
            // No hotel selected
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a booking to set to Pending Booking.");
        }
    }

    @FXML
    private void cancelPendingBooking() {
        // Get the selected hotel
        Hotel selectedHotel = hotelsTable.getSelectionModel().getSelectedItem();

        if (selectedHotel != null) {
            if (selectedHotel.getStatus().equalsIgnoreCase("Pending")) {
                // Change the status back to "Confirmed"
                selectedHotel.setStatus("Confirmed");
                hotelsTable.refresh();

                // Show success message
                showAlert(Alert.AlertType.INFORMATION, "Status Updated", "The Pending Booking status has been cancelled.");
            } else {
                // If not in Pending Booking
                showAlert(Alert.AlertType.WARNING, "Not Pending", "This booking is not in Pending Booking status.");
            }
        } else {
            // No hotel selected
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a booking to cancel Pending Booking.");
        }
    }



    @FXML
    private void modifyBooking() {
        // Get the selected hotel booking
        Hotel selectedHotel = hotelsTable.getSelectionModel().getSelectedItem();

        if (selectedHotel != null) {
            // Create a dialog for the user to modify booking details
            TextInputDialog dialog = new TextInputDialog(selectedHotel.getCustomerName());
            dialog.setTitle("Modify Booking");
            dialog.setHeaderText("Edit the booking details");

            // Create a custom content for the dialog (multiple fields)
            VBox vbox = new VBox(10);

            // Create the text fields for modifying booking details
            TextField customerNameField = new TextField(selectedHotel.getCustomerName());
            TextField hotelNameField = new TextField(selectedHotel.getHotelName());
            TextField bookingDateField = new TextField(selectedHotel.getBookingDate());
            TextField checkInDateField = new TextField(selectedHotel.getCheckIn());
            TextField checkOutDateField = new TextField(selectedHotel.getCheckOut());

            // Create a ComboBox for status modification
            ComboBox<String> statusComboBox = new ComboBox<>();
            statusComboBox.getItems().addAll("Confirmed", "Pending", "Cancelled");
            statusComboBox.setValue(selectedHotel.getStatus());

            // Add the fields to the VBox
            vbox.getChildren().addAll(
                    new Label("Customer Name:"), customerNameField,
                    new Label("Hotel Name:"), hotelNameField,
                    new Label("Booking Date:"), bookingDateField,
                    new Label("Check-In Date:"), checkInDateField,
                    new Label("Check-Out Date:"), checkOutDateField,
                    new Label("Status:"), statusComboBox
            );

            dialog.getDialogPane().setContent(vbox);

            // Show the dialog and wait for the result
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                // Apply the modifications if the user confirmed
                selectedHotel.setCustomerName(customerNameField.getText());
                selectedHotel.setHotelName(hotelNameField.getText());
                selectedHotel.setBookingDate(bookingDateField.getText());
                selectedHotel.setCheckIn(checkInDateField.getText());
                selectedHotel.setCheckOut(checkOutDateField.getText());
                selectedHotel.setStatus(statusComboBox.getValue());

                // Refresh the table to reflect the changes
                hotelsTable.refresh();

                // Show a success message
                showAlert(Alert.AlertType.INFORMATION, "Booking Updated", "The booking has been successfully updated.");
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a booking to modify.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Hotel class representing hotel booking data
    public static class Hotel {
        private String hotelId;
        private String customerrName;
        private String hotelName;
        private String bookinggDate;
        private String checkIn;
        private String checkOut;
        private String statuss;

        // Constructor
        public Hotel(String hotelId, String customerName, String hotelName, String bookingDate, String checkIn, String checkOut, String status) {
            this.hotelId = hotelId;
            this.customerrName = customerName;
            this.hotelName = hotelName;
            this.bookinggDate = bookingDate;
            this.checkIn = checkIn;
            this.checkOut = checkOut;
            this.statuss = status;
        }

        // Getters and setters
        public String getHotelId() {
            return hotelId;
        }

        public String getCustomerName() {
            return customerrName;
        }

        public String getHotelName() {
            return hotelName;
        }

        public String getBookingDate() {
            return bookinggDate;
        }

        public String getCheckIn() {
            return checkIn;
        }

        public String getCheckOut() {
            return checkOut;
        }

        public String getStatus() {
            return statuss;
        }

        public void setStatus(String status) {
            this.statuss = status;
        }

        public void setHotelName(String hotelName) {
            this.hotelName = hotelName;
        }
        public void setHotelId(String hotelId) {
            this.hotelId = hotelId;
        }

        public void setCustomerName(String customerName) {
            this.customerrName = customerName;
        }


        public void setBookingDate(String bookingDate) {
            this.bookinggDate = bookingDate;
        }

        public void setCheckIn(String checkIn) {
            this.checkIn = checkIn;
        }

        public void setCheckOut(String checkOut) {
            this.checkOut = checkOut;
        }


    }



    @FXML
    private TableView<FlightBookingController.Flight> flightsTable;
    @FXML
    private void cancelFlightBooking() {
        // Get the selected flight
        FlightBookingController.Flight selectedFlight = flightsTable.getSelectionModel().getSelectedItem();

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

}