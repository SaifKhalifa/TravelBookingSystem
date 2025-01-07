package com.groupnine.travelbookingsystem.controller.BookingDetailsController;

import com.groupnine.travelbookingsystem.model.hotelBooking.HotelBooking;
import com.groupnine.travelbookingsystem.model.hotelBooking.HotelBookingDAOImpl;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class BookingHotelControoler {

    @FXML
    private TextField hotelNameField;

    @FXML
    private DatePicker checkOutDatePicker;

    @FXML
    private TextField customerNameField;

    @FXML
    private DatePicker checkInDatePicker;

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
    private int hotelId;
    private HotelBookingDAOImpl bookingHotelDeo;

    public BookingHotelControoler() {
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
        System.out.println("Received hotelId: " + hotelId);
    }

    @FXML
    private void onBookingButtonClick() {
        String hotelName = hotelNameField.getText();
        String customerName = customerNameField.getText();
        LocalDate checkInDate = checkInDatePicker.getValue();
        LocalDate checkOutDate = checkOutDatePicker.getValue();

        if (hotelName.isEmpty() || customerName.isEmpty() || checkInDate == null || checkOutDate == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Please fill in all fields correctly.");
            alert.showAndWait();
            return;
        }

        HotelBooking booking = new HotelBooking(hotelName, customerName, checkInDate, checkOutDate);

        bookingHotelDeo.addHotelBooking(booking);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Booking Confirmation");
        alert.setHeaderText("Booking Successful!");
        alert.setContentText("Thank you, " + customerName + ". Your booking for hotel '" + hotelName + "' from " + checkInDate + " to " + checkOutDate + " is confirmed.");
        alert.showAndWait();
    }

    @FXML
    public void initialize() {
        bookingButton.setOnAction(event -> onBookingButtonClick());
    }
}
