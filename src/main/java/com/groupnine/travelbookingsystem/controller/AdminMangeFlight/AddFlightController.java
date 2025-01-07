package com.groupnine.travelbookingsystem.controller.AdminMangeFlight;

import com.groupnine.travelbookingsystem.model.flight.Flight;
import com.groupnine.travelbookingsystem.model.flight.FlightDAO;
import com.groupnine.travelbookingsystem.model.flight.FlightDAOImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class AddFlightController {

    @FXML
    private TextField departuretime;
    @FXML
    private TextField flightduration;
    @FXML
    private TextField destination;
    @FXML
    private TextField origin;
    @FXML
    private Button addButton;
    @FXML
    private TextField arrivaltime;
    @FXML
    private DatePicker departuredate;
    @FXML
    private DatePicker arrivaldate;
    @FXML
    private TextField gatenumber;
    @FXML
    private TextField seatcapacity;
    @FXML
    private TextField flightprice;

    @FXML
    private TextArea notes;
    @FXML
    private Button back_to_list_flight;

    private int currentFlightId = -1;
    @FXML
    private ChoiceBox<String>offerType;
    @FXML
    private TextField promotionalOffer;
    @FXML
    private Button uploadImageButton;
    @FXML
    private Label imageFileNameLabel;

    private File selectedImageFile;


    @FXML
    private void initialize() {

        offerType.getItems().addAll("Economy", "Premium Economy", "Business" , "First");

        offerType.setValue("Economy");
    }

    @FXML
    private void navigateToListOfFlights() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/AdminMangeFlight/ListFlights.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root, 1280, 832));
            stage.setTitle("List Of Flights");
            stage.show();

            // Close current stage
            Stage currentStage = (Stage) back_to_list_flight.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Unable to load ListFlights.fxml", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void addOrUpdateFlight() {
        try {
            // Check required fields
            if (origin.getText().isEmpty() || destination.getText().isEmpty() || departuretime.getText().isEmpty() || arrivaltime.getText().isEmpty()) {
                showAlert("Error", "Please fill in all the required fields.", Alert.AlertType.ERROR);
                return;
            }

            if (departuredate.getValue() == null || arrivaldate.getValue() == null) {
                showAlert("Error", "Please select both departure and arrival dates.", Alert.AlertType.ERROR);
                return;
            }

            // Parse and validate fields
            LocalTime parsedDepartureTime = parseTime(departuretime.getText(), "Departure Time");
            LocalTime parsedArrivalTime = parseTime(arrivaltime.getText(), "Arrival Time");
            LocalTime parsedFlightDuration = parseTime(flightduration.getText(), "Flight Duration");
            LocalDate parsedDepartureDate = departuredate.getValue();
            LocalDate parsedArrivalDate = arrivaldate.getValue();
            int parsedGateNumber = parseInteger(gatenumber.getText(), "Gate Number");
            int parsedSeatCapacity = parseInteger(seatcapacity.getText(), "Seat Capacity");
            BigDecimal parsedFlightPrice = parseBigDecimal(flightprice.getText(), "Flight Price");

            // Validate promotional offer
            BigDecimal parsedPromotionalOffer = BigDecimal.ZERO;
            if (!promotionalOffer.getText().isEmpty()) {
                parsedPromotionalOffer = parseBigDecimal(promotionalOffer.getText(), "Promotional Offer");
            }


            if (selectedImageFile == null) {
                selectedImageFile = new File("");
            }

            // Create or update flight model object
            Flight flight = new Flight();
            flight.setOrigin(origin.getText());
            flight.setDestination(destination.getText());
            flight.setDepartureTime(parsedDepartureTime);
            flight.setArrivalTime(parsedArrivalTime);
            flight.setFlightDuration(parsedFlightDuration);
            flight.setGateNumber(parsedGateNumber);
            flight.setSeatCapacity(parsedSeatCapacity);
            flight.setPrice(parsedFlightPrice);
            flight.setClassType(offerType.getValue());
            flight.setNotes(notes.getText());
            flight.setDepartureDate(parsedDepartureDate);
            flight.setArrivalDate(parsedArrivalDate);
            flight.setPromotionalOffer(String.valueOf(parsedPromotionalOffer));
            flight.setImagePath(selectedImageFile.getAbsolutePath());
            // Create service
            FlightDAOImpl service = new FlightDAOImpl();

            if (currentFlightId == -1) {
                // Add new flight
                service.addFlight(flight);
                showAlert("Success", "Flight has been added successfully.", Alert.AlertType.INFORMATION);
            } else {
                // Update existing flight
                flight.setFlightId(currentFlightId);
                service.updateFlight(flight);
                showAlert("Success", "Flight has been updated successfully.", Alert.AlertType.INFORMATION);
            }

            // Clear fields after adding/updating flight
            clearFields();

        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid number format: " + e.getMessage(), Alert.AlertType.ERROR);
        } catch (Exception e) {
            showAlert("Error", "An error occurred while adding/updating the flight: " + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    public void setFlightDataForEditing(int flightId) {
        try {
            FlightDAOImpl adminFlightInterface = new FlightDAOImpl();
            Flight flightData = adminFlightInterface.getFlightById(flightId);

            if (flightData != null) {
                origin.setText(flightData.getOrigin());
                destination.setText(flightData.getDestination());
                departuretime.setText(flightData.getDepartureTime().toString());
                arrivaltime.setText(flightData.getArrivalTime().toString());
                flightduration.setText(flightData.getFlightDuration().toString());
                gatenumber.setText(String.valueOf(flightData.getGateNumber()));
                seatcapacity.setText(String.valueOf(flightData.getSeatCapacity()));
                flightprice.setText(flightData.getPrice().toString());
                offerType.setValue(flightData.getClassType());
                notes.setText(flightData.getNotes());
                departuredate.setValue(flightData.getDepartureDate());
                arrivaldate.setValue(flightData.getArrivalDate());
                promotionalOffer.setText(flightData.getPromotionalOffer());
                imageFileNameLabel.setText(flightData.getImagePath() != null ? new File(flightData.getImagePath()).getName() : "No Image Selected");

                currentFlightId = flightId;
                addButton.setText("Update Flight");
            } else {
                showAlert("Error", "Flight not found.", Alert.AlertType.ERROR);
            }

        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred while fetching the flight data.", Alert.AlertType.ERROR);
        }
    }


    private LocalTime parseTime(String timeString, String fieldName) {
        try {
            return LocalTime.parse(timeString);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(fieldName + " is invalid. Please enter it in HH:mm:ss format.");
        }
    }

    private int parseInteger(String numberString, String fieldName) {
        try {
            return Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(fieldName + " must be a valid integer.");
        }
    }

    private BigDecimal parseBigDecimal(String numberString, String fieldName) {
        try {
            return new BigDecimal(numberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(fieldName + " must be a valid decimal number.");
        }
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        departuretime.clear();
        flightduration.clear();
        destination.clear();
        origin.clear();
        arrivaltime.clear();
        gatenumber.clear();
        seatcapacity.clear();
        flightprice.clear();
        offerType.setValue(null);
        notes.clear();
        departuredate.setValue(null);
        arrivaldate.setValue(null);
        promotionalOffer.clear();
        imageFileNameLabel.setText("No Image Selected");
        selectedImageFile = null;

        addButton.setText("Add Flight");
        currentFlightId = -1;
    }
    @FXML
    private void uploadImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Flight Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            selectedImageFile = file;
            imageFileNameLabel.setText(file.getName());
        }
    }

}
