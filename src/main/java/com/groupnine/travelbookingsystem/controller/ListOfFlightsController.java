package com.groupnine.travelbookingsystem.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class ListOfFlightsController {

    @FXML
    private Button hotel;

    @FXML
    private Button flight;

    @FXML
    private Button addnewflight;

    @FXML
    private TableView<?> flightTable;

    @FXML
    public void initialize() {
        // Make the TableView responsive
        flightTable.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        flightTable.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            double totalWidth = newWidth.doubleValue();
            double columnWidth = totalWidth / flightTable.getColumns().size();

            for (TableColumn<?, ?> column : flightTable.getColumns()) {
                column.setPrefWidth(columnWidth);
            }
        });

        if (addnewflight != null) {
            addnewflight.setOnAction(event -> navigateToAddFlight());
        } else {
            System.out.println("addnewflight button is null.");
        }

        if (hotel != null) {
            hotel.setOnAction(event -> navigateToHotel());
        }
    }
    public void navigateToAddFlight() {
        System.out.println("Navigating to AddFlight...");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/AddFlight.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root, 1280, 832));
            stage.setTitle("Add Flight");
            stage.show();

            Stage currentStage = (Stage) addnewflight.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: Unable to load AddFlight.fxml");
        }
    }

    // Navigation for hotel button
    private void navigateToHotel() {
        System.out.println("Navigating to Hotel screen...");
        // Add logic for navigation here
    }
}
