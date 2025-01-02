package com.groupnine.travelbookingsystem.controller.BookingDetailsController;

import com.groupnine.travelbookingsystem.model.FlightDetalisModel.FlightDeatailsModel;
import com.groupnine.travelbookingsystem.model.FlightDetalisModel.FlightDetailsDeoImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DetailsController {

    @FXML
    private Label departureLabel;
    @FXML
    private Label arrivalLabel;
    @FXML
    private Label durationLabel;
    @FXML
    private Label airlineLabel;
    @FXML
    private Label departureAirportLabel;
    @FXML
    private Label arrivalAirportLabel;
    @FXML
    private Label priceLabel;

    @FXML
    private Button bookNowButton;

    private int flightId; // Store the passed flightId

    // New method to set flightId dynamically
    public void setCardId(int cardId) {
        this.flightId = cardId;
        loadFlightDetails(); // Load details for the provided cardId
    }

    @FXML
    private void initialize() {
        // Initialization logic if needed
        bookNowButton.setOnAction(event -> handleBookNow());
    }

    private void loadFlightDetails() {
        if (flightId <= 0) {
            System.err.println("Invalid flightId: " + flightId);
            departureLabel.setText("Invalid flight ID provided.");
            return;
        }

        FlightDetailsDeoImpl dao = new FlightDetailsDeoImpl();
        FlightDeatailsModel flightDetails = dao.getFlightDetails(flightId);

        if (flightDetails != null) {
            departureLabel.setText("Departure Time: " + flightDetails.getDepartureTime());
            arrivalLabel.setText("Arrival Time: " + flightDetails.getArrivalTime());
            durationLabel.setText("Flight Duration: " + flightDetails.getFlightDuration());
            airlineLabel.setText("Airline: " + flightDetails.getAirlineName());
            departureAirportLabel.setText("Departure Airport: " + flightDetails.getDepartureAirport());
            arrivalAirportLabel.setText("Arrival Airport: " + flightDetails.getArrivalAirport());
            priceLabel.setText("Price: $" + flightDetails.getPrice());
        } else {
            departureLabel.setText("No flight details found.");
            arrivalLabel.setText("");
            durationLabel.setText("");
            airlineLabel.setText("");
            departureAirportLabel.setText("");
            arrivalAirportLabel.setText("");
            priceLabel.setText("");
        }
    }

    private void handleBookNow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/BookingDetailsView/BookingFlight.fxml"));
            Scene scene = new Scene(loader.load());

            FlightController controller = loader.getController();

            controller.setFlightId(flightId);

            Stage stage = new Stage();
            stage.setTitle("Booking Flight");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
