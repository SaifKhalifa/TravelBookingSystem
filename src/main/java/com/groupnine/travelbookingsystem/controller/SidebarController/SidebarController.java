package com.groupnine.travelbookingsystem.controller.SidebarController;

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
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/groupnine/travelbookingsystem/view/Home/Homepage_V2.fxml")));
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAgentDashboardClick(MouseEvent event) {
        try {
            Stage stage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/groupnine/travelbookingsystem/view/Booking/FlightBooking.fxml")));
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAdminDashboardClick(MouseEvent event) {
        try {
            Stage stage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/groupnine/travelbookingsystem/view/AdminMangeFlight/ListFlights.fxml")));
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLogoutClick(MouseEvent event) {
        try {
            Stage stage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/groupnine/travelbookingsystem/view/authentication/login.fxml")));
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleFlightsSearchClick(MouseEvent event) {
        try {
            Stage stage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/groupnine/travelbookingsystem/view/SearchPageFlighte-Hotels/searchPageFlights.fxml")));
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}