package com.groupnine.travelbookingsystem.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;


public class SidebarController {

    @FXML
    private BorderPane root;

    @FXML
    private void handleHomeClick(MouseEvent event) {
        try {
            Stage stage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/groupnine/travelbookingsystem/view/Homepage.fxml")));
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleDashboardClick(MouseEvent event) {
        try {
            Stage stage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/groupnine/travelbookingsystem/view/FlightBooking.fxml")));
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}