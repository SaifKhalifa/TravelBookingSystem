package com.groupnine.travelbookingsystem.controller.adminPanelHotelController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class NavigationHelper {

    /**
     * Method to switch from one FXML page to another.
     *
     * @param event The ActionEvent (used when button is clicked)
     * @param fxmlFilePath The relative path of the FXML file (e.g., "/views/Home.fxml")
     * @throws IOException if the FXML file is not found or cannot be loaded
     */
    public static void switchToPage(javafx.event.ActionEvent event, String fxmlFilePath) throws IOException {
        // Load the new FXML file
        Parent root = FXMLLoader.load(NavigationHelper.class.getResource(fxmlFilePath));

        // Get the current stage (window) using the source of the event
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(new Scene(root));

        stage.centerOnScreen();
        // Show the stage
        stage.show();
    }
}


