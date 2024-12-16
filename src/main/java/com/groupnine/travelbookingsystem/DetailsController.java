package com.groupnine.travelbookingsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class DetailsController {

    @FXML
    private Button bookNowButton;

    @FXML
    private Label departureText;

    @FXML
    private Label arrivalText;

    @FXML
    private Label durationText;

    @FXML
    private ImageView mainImage;

    @FXML
    private Label routeLabel;

    @FXML
    private Label departureAirportLabel;

    @FXML
    private Label arrivalAirportLabel;

    // Initialize the controller
    @FXML
    private void initialize() {
        // Set default values for labels
        departureText.setText("Departs on Wednesday, 16 June");
        arrivalText.setText("Arrives on Thursday, 17 June");
        durationText.setText("Duration - 18hr 40m");
        routeLabel.setText("Lagos - London");
        departureAirportLabel.setText("Murtala International Airport, Lagos (LOS)");
        arrivalAirportLabel.setText("Palestine Airport, Palestine (PAL)");

        // Load the main image
        mainImage.setImage(new Image(getClass().getResource("/images/ta.png").toExternalForm()));

        // Add event handling for the Book Now button
        bookNowButton.setOnAction(event -> handleBookNow());
    }

    private void handleBookNow() {
        // Logic for booking action (e.g., navigate to a booking form or show a confirmation dialog)
        System.out.println("Book Now button clicked!");
        // You can replace this with actual functionality like navigating to another scene.
    }
}
