package com.groupnine.travelbookingsystem.controller.BookingDetailsController;

import com.groupnine.travelbookingsystem.model.toRemove.BookingFlight.BookingFlightDeo;
import com.groupnine.travelbookingsystem.model.toRemove.BookingFlight.BookingFlightDeoImp;
import com.groupnine.travelbookingsystem.model.toRemove.BookingFlight.BookingFlightModel;
import com.groupnine.travelbookingsystem.model.userMangment.User;
import com.groupnine.travelbookingsystem.model.userMangment.UserDAOImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Date;
import java.time.LocalDate;

public class FlightController {

    @FXML
    private TextField customerNameField;

    @FXML
    private DatePicker departureDatePicker;

    @FXML
    private TextField airlineNameField;

    @FXML
    private DatePicker arrivalDatePicker;

    @FXML
    private Button bookingButton;

    private BookingFlightDeo bookingFlightDeo;

    private int flightId; // Flight ID passed dynamically

    // Constructor to initialize Hibernate
    public FlightController() {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(BookingFlightModel.class)
                .addAnnotatedClass(User.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        this.bookingFlightDeo = new BookingFlightDeoImp(sessionFactory);
    }

    // Method to dynamically set the flight ID
    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    @FXML
    private void onBookingButtonClick() {
        String customerName = customerNameField.getText();
        LocalDate departureDate = departureDatePicker.getValue();
        String airlineName = airlineNameField.getText();
        LocalDate arrivalDate = arrivalDatePicker.getValue();

        if (customerName.isEmpty() || departureDate == null || airlineName.isEmpty() || arrivalDate == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please fill all the fields.");
            return;
        }

        try {
            UserDAOImpl userDAO = new UserDAOImpl();
            String username = "currentUser";
            User user = userDAO.getUserByUsername(username);

            if (user == null) {
                showAlert(Alert.AlertType.ERROR, "Error", "User not found!");
                return;
            }

            int userId = user.getId();

            Date departureDateConverted = Date.valueOf(departureDate);
            Date arrivalDateConverted = Date.valueOf(arrivalDate);

            BookingFlightModel booking = new BookingFlightModel();
            booking.setCustomer_name(customerName);
            booking.setDeparture_date(departureDateConverted);
            booking.setAirline_name(airlineName);
            booking.setAirline_date(arrivalDateConverted);
            booking.setBookingDate(new Date(System.currentTimeMillis()));
            booking.setUserId(userId);
            booking.setFlightId(flightId);

            bookingFlightDeo.saveBooking(booking);

            showAlert(Alert.AlertType.INFORMATION, "Success", "Flight booking completed successfully!");
        } catch (Exception e) {
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
