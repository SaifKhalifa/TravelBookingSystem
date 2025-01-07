package com.groupnine.travelbookingsystem.controller.BookingController;


import com.groupnine.travelbookingsystem.model.hotel.Hotel;
import com.groupnine.travelbookingsystem.model.hotelBooking.HotelBooking;
import com.groupnine.travelbookingsystem.model.hotelBooking.HotelBookingDAOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import com.groupnine.travelbookingsystem.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class HotelBookingController {

    @FXML
    private TableView<HotelBooking> hotelsTable;

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

    private HotelBooking lastSelectedHotel = null;  // Track the last selected hotel

    private HotelBookingDAOImpl hotelDAO = new HotelBookingDAOImpl();

    public void initialize() {
        // Setting column value factories
        hotleIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        customerrNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        hotelNameColumn.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
        bookinggDateColumn.setCellValueFactory(new PropertyValueFactory<>("bookingDate"));
        checkInColumn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        checkOutColumn.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        statussColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Adding data to the table by reading from the database
        loadHotelData();

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

    // Function to load hotel data from the database
    private void loadHotelData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<HotelBooking> hotelDataList = hotelDAO.getAllHotelBookings();
        ObservableList<HotelBooking> hotelData = FXCollections.observableArrayList();
        hotelsTable.setItems(hotelData);

        /*this.id = id;
        this.customerName = customerName;
        this.bookingDate = bookingDate;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = status;
        this.hotel = hotel;
        this.user = user;*/
        for (HotelBooking hotelBooking : hotelDataList) {
            HotelBooking hotel = new HotelBooking(
                    hotelBooking.getId(),
                    hotelBooking.getCustomerName(),
                    hotelBooking.getBookingDate(),
                    hotelBooking.getCheckIn(),
                    hotelBooking.getCheckOut(),
                    hotelBooking.getStatus(),
                    hotelBooking.getHotel(),
                    hotelBooking.getUser()
            );
            hotelData.add(hotel);
        }

        // Set the data to the TableView
        hotelsTable.setItems(hotelData);
        session.close();
    }

    private void handleRowClick(MouseEvent event) {
        // Get the clicked row (hotel)
        HotelBooking selectedHotel = hotelsTable.getSelectionModel().getSelectedItem();

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

    private void updateHotelStatusInDatabase(HotelBooking hotel) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            HotelBooking hotelModel = session.get(HotelBooking.class, hotel.getId());
            if (hotelModel != null) {
                hotelModel.setStatus(hotel.getStatus());
                session.update(hotelModel);
                transaction.commit();
                System.out.println("Booking status updated successfully in the database.");
            } else {
                System.out.println("Booking not found in the database.");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @FXML
    private void cancelHotelBooking() {
        // Get the selected hotel
        HotelBooking selectedHotel = hotelsTable.getSelectionModel().getSelectedItem();

        if (selectedHotel != null) {
            if (!selectedHotel.getStatus().equalsIgnoreCase("Cancelled")) {
                // Update the status to "Cancelled"
                selectedHotel.setStatus("Cancelled");

                // تحديث الحجز في قاعدة البيانات
                updateHotelStatusInDatabase(selectedHotel);

                // تحديث واجهة المستخدم (Refresh the TableView)
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
    private void cancelPendingBooking() {
        // Get the selected hotel
        HotelBooking selectedHotel = hotelsTable.getSelectionModel().getSelectedItem();

        if (selectedHotel != null) {
            if (!selectedHotel.getStatus().equalsIgnoreCase("Cancelled")) {
                // Update the status to "Cancelled"
                selectedHotel.setStatus("Cancelled");
                updateHotelStatusInDatabase(selectedHotel);
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
        HotelBooking selectedHotel = hotelsTable.getSelectionModel().getSelectedItem();

        if (selectedHotel != null) {
            if (!selectedHotel.getStatus().equalsIgnoreCase("Pending")) {
                // Update the status to "Pending Booking"
                selectedHotel.setStatus("Pending");
                updateHotelStatusInDatabase(selectedHotel);
                hotelsTable.refresh();

                // Show success message
                showAlert(Alert.AlertType.INFORMATION, "Status Updated", "The booking is now in Pending Booking status.");
            }
        }
    }
    private void updateBookingInDatabase(HotelBooking hotel) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            // Fetch the existing booking from the database
            HotelBooking hotelModel = session.get(HotelBooking.class, hotel.getId());
            if (hotelModel != null) {
                // Update the fields in the database object
                hotelModel.setCustomerName(hotel.getCustomerName());
                hotelModel.setHotelName(hotel.getHotelName());
                hotelModel.setBookingDate(hotel.getBookingDate()); // Convert string to Date
                hotelModel.setCheckIn(hotel.getCheckIn());         // Convert string to Date
                hotelModel.setCheckOut(hotel.getCheckOut());       // Convert string to Date
                hotelModel.setStatus(hotel.getStatus());

                // Save the updated object back to the database
                session.update(hotelModel);
                transaction.commit();
                System.out.println("Booking details updated successfully in the database.");
            } else {
                System.out.println("Booking not found in the database.");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    @FXML
    private void modifyBooking() {
        // Get the selected hotel booking
        HotelBooking selectedHotel = hotelsTable.getSelectionModel().getSelectedItem();

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
            /*TextField bookingDateField = new TextField(selectedHotel.getBookingDate());
            TextField checkInDateField = new TextField(selectedHotel.getCheckIn());
            TextField checkOutDateField = new TextField(selectedHotel.getCheckOut());*/
            DatePicker bookingDateField = new DatePicker(selectedHotel.getBookingDate());
            DatePicker checkInDateField = new DatePicker(selectedHotel.getCheckIn());
            DatePicker checkOutDateField = new DatePicker(selectedHotel.getCheckOut());

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
                    new Label("Check-Out Date:"), checkOutDateField
                   // new Label("Status:"), statusComboBox
            );

            dialog.getDialogPane().setContent(vbox);

            // Show the dialog and wait for the result
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                // Apply the modifications to the selectedHotel object
                selectedHotel.setCustomerName(customerNameField.getText());
                selectedHotel.setHotelName(hotelNameField.getText());
                selectedHotel.setBookingDate(bookingDateField.getValue());
                selectedHotel.setCheckIn(checkInDateField.getValue());
                selectedHotel.setCheckOut(checkOutDateField.getValue());
                selectedHotel.setStatus(statusComboBox.getValue());

                // Update the database with all the changes
                updateBookingInDatabase(selectedHotel);

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
}
