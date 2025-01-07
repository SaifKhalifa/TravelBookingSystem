package com.groupnine.travelbookingsystem.controller.BookingDetailsController;

import com.groupnine.travelbookingsystem.MainApplication_DEFAULT;
import com.groupnine.travelbookingsystem.model.hotel.Hotel;
import com.groupnine.travelbookingsystem.model.hotel.HotelDAOImpl;
import com.groupnine.travelbookingsystem.model.hotelBooking.HotelBooking;
import com.groupnine.travelbookingsystem.model.hotelBooking.HotelBookingDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;

public class HotelController {

    @FXML
    private TextField customerNameField;
    @FXML
    private DatePicker checkInDatePicker;
    @FXML
    private DatePicker checkOutDatePicker;
    @FXML
    private ComboBox<String> statusComboBox;
    @FXML
    private TextField hotelNameField;
    @FXML
    private Button bookingButton, bookNowButton;

    private int hotelId;
    HotelBookingDAOImpl hotelBookingDAO = new HotelBookingDAOImpl();

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
        loadHotelDetails();
    }

    private void loadHotelDetails() {
        HotelDAOImpl hotelDAO = new HotelDAOImpl();
        Hotel hotel = hotelDAO.getHotelById(hotelId);

        if (hotel != null) {
            hotelNameField.setText(hotel.getName());
            hotelNameField.setEditable(false); // Ensure the hotel name is not editable
        } else {
            hotelNameField.setText("Hotel not found");
        }
    }

    @FXML
    public void onBookingButtonClick(ActionEvent actionEvent) {
        if (validateInput()) {
            HotelBooking booking = new HotelBooking();
            booking.setCustomerName(customerNameField.getText());
            booking.setHotelName(hotelNameField.getText());

            booking.setCheckIn(checkInDatePicker.getValue());
            booking.setCheckOut(checkOutDatePicker.getValue());
            booking.setStatus(statusComboBox.getValue());
            booking.setBookingDate(LocalDate.now());

            HotelDAOImpl hotelDAO = new HotelDAOImpl();
            Hotel hotel = hotelDAO.getHotelById(hotelId);
            booking.setHotel(hotel);

            hotelBookingDAO.addHotelBooking(booking);

            showConfirmationDialog();
        }
    }

    private boolean validateInput() {
        String errorMessage = "";

        if (customerNameField.getText().isEmpty()) {
            errorMessage += "Customer name is required.\n";
        }
        if (checkInDatePicker.getValue() == null) {
            errorMessage += "Check-in date is required.\n";
        }
        if (checkOutDatePicker.getValue() == null) {
            errorMessage += "Check-out date is required.\n";
        }
        if (statusComboBox.getValue() == null) {
            errorMessage += "Booking status is required.\n";
        }

        if (!errorMessage.isEmpty()) {
            showErrorDialog(errorMessage);
            return false;
        }
        return true;
    }

    private void showConfirmationDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Booking Confirmed");
        alert.setHeaderText(null);
        alert.setContentText("Hotel booking has been successfully made.");
        alert.showAndWait();
    }

    private void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid Input");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void handleBookNowButtonClick() {
        MainApplication_DEFAULT.showPopup(
                "/com/groupnine/travelbookingsystem/view/BookingDetialsView/BookingHotel.fxml",
                "Book a hotel",
                false
        );
    }
}