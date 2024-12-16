package com.groupnine.travelbookingsystem.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BookingController {

    @FXML
    private TextField customerNameField;

    @FXML
    private TextField hotelNameField;

    @FXML
    private TextField checkInDateField;

    @FXML
    private TextField checkOutDateField;

    @FXML
    private Button bookingButton;

    @FXML
    private Label statusLabel;

    @FXML
    public void initialize() {
        // أي إعدادات افتراضية عند تحميل الواجهة
        statusLabel.setText(""); // تفريغ رسالة الحالة عند البداية
    }

    @FXML
    private void handleBookingButton() {
        // الحصول على النصوص المدخلة من الحقول
        String customerName = customerNameField.getText();
        String hotelName = hotelNameField.getText();
        String checkInDate = checkInDateField.getText();
        String checkOutDate = checkOutDateField.getText();

        // التحقق من البيانات المدخلة
        if (customerName.isEmpty() || hotelName.isEmpty() || checkInDate.isEmpty() || checkOutDate.isEmpty()) {
            statusLabel.setText("Please fill in all the fields.");
            statusLabel.setStyle("-fx-text-fill: red;");
        } else {
            // منطق الحجز (يمكنك استبدال هذا بطباعة أو تنفيذ عملية الحجز)
            System.out.println("Booking Successful:");
            System.out.println("Customer Name: " + customerName);
            System.out.println("Hotel Name: " + hotelName);
            System.out.println("Check-in Date: " + checkInDate);
            System.out.println("Check-out Date: " + checkOutDate);

            // تحديث الحالة
            statusLabel.setText("Booking Successful!");
            statusLabel.setStyle("-fx-text-fill: green;");
        }
    }
}

