package com.groupnine.travelbookingsystem.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ListOfFlightsController {

    @FXML
    private Button hotel;

    @FXML
    private Button flight;

    @FXML
    private Button addnewflight;

    // This method is called when the FXML file is loaded
    @FXML
    public void initialize() {
        if (addnewflight != null) {
            addnewflight.setOnAction(event -> navigateToAddFlight());
        } else {
            System.out.println("addnewflight button is null.");
        }

        // actions for hotel buttons
        if (hotel != null) {
            hotel.setOnAction(event -> navigateToHotel());
        }


    }

    // Method to navigate to AddFlight screen
    public void navigateToAddFlight() {
        System.out.println("Navigating to AddFlight...");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/AddFlight.fxml"));


            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root, 1280, 832));
            stage.setTitle("Add Flight");
            stage.show();

            // Close the current stage (List of Flights screen)
            Stage currentStage = (Stage) addnewflight.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: Unable to load AddFlight.fxml");
        }
    }

    //  methods for hotel  buttons
    private void navigateToHotel() {
        System.out.println("Navigating to Hotel screen...");
        // Implement the hotel navigation logic here
    }


}
