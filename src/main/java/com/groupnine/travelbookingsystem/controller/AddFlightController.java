package com.groupnine.travelbookingsystem.controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class AddFlightController {

    @FXML
    private TextField flightname;
    @FXML
    private TextField departuretime;
    @FXML
    private TextField flightduration;
    @FXML
    private TextField detination;
    @FXML
    private TextField origin;
    @FXML
    private Button addflight;
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
    private TextField classtype;
    @FXML
    private TextArea notes;
    @FXML
    private Button back_to_list_flight;




    @FXML
    private void navigateToListOfFlights() {
        System.out.println("Navigating to List Of Flights...");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/ListFlights.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root, 1280, 832));
            stage.setTitle("List Of Flights");
            stage.show();


            Stage currentStage = (Stage) back_to_list_flight.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: Unable to load ListFlights.fxml");
        }
    }

    }




