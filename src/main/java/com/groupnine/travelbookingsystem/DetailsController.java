package com.groupnine.travelbookingsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DetailsController {

    @FXML
    private Button bookNowButton;

    @FXML
    private Label departureLabel;

    @FXML
    private Label arrivalLabel;

    @FXML
    private Label durationLabel;

    @FXML
    private ImageView airlineLogo;

    @FXML
    private Label routeLabel;

    @FXML
    private Label departureAirportLabel;

    @FXML
    private Label arrivalAirportLabel;

    @FXML
    private Label departureTimeLabel;

    @FXML
    private Label arrivalTimeLabel;

    @FXML
    private Label layoverDurationLabel;

    @FXML
    private Label flightInfoLabel;

    @FXML
    private Label layoverTitleLabel;

    @FXML
    private Label layoverDuration;

    @FXML
    private Label finalDepartureTimeLabel;

    @FXML
    private Label finalDepartureAirportLabel;

    @FXML
    private Label finalDepartureCityLabel;

    @FXML
    private Label finalDepartureCity2Label;

    @FXML
    private Label layover2DurationLabel;

    @FXML
    private Label finalArrivalTimeLabel;

    @FXML
    private Label finalArrivalAirportLabel;

    @FXML
    private Label finalArrivalCityLabel;

    @FXML
    private Label finalArrivalDateLabel;

    // Initialize the controller
    @FXML
    private void initialize() {
        // Set default values for labels
        departureLabel.setText("Departs on Wednesday, 16 June");
        arrivalLabel.setText("Arrives on Thursday, 17 June");
        durationLabel.setText("Duration - 18hr 40m");
        routeLabel.setText("Lagos - London");
        departureAirportLabel.setText("Murtala International Airport, Lagos (LOS)");
        arrivalAirportLabel.setText("Palestine Airport, Palestine (PAL)");

        // Load the airline logo image
        airlineLogo.setImage(new Image(getClass().getResource("/images/ta.png").toExternalForm()));

        // Add event handling for the Book Now button
        bookNowButton.setOnAction(event -> handleBookNow());
    }

    private void handleBookNow() {
        try {
            // Load the FXML for the booking window
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/BookingFlight.fxml"));
            Scene scene = new Scene(loader.load());

            // Create a new Stage (window) for the booking window
            Stage stage = new Stage();
            stage.setTitle("Booking Hotel");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
