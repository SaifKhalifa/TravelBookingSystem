package com.groupnine.travelbookingsystem.controller.adminPanelHotelController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HotelConfirmAddEditController {

    @FXML
    private Label ConfirmLabel;
    @FXML
    private Button OKButton;
    private ManageHotelsListController manageHotelsListController;  // مرجع للكونترولر الذي يحتوي على الجدول

    // دالة لتعيين مرجع الـ controller الرئيسي (الذي يحتوي على الجدول)
    public void setMainController(ManageHotelsListController manageHotelsListController) {
        this.manageHotelsListController = manageHotelsListController;
    }

    public void onOKButtonClick(javafx.event.ActionEvent event) {
//        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
//        stage.close();
//        try {
//            NavigationHelper.switchToPage(event, "/com/groupnine/travelbookingsystem/view/adminPanelHotelView/manageHotelsList.fxml");
//
//            if (manageHotelsListController != null) {
//                manageHotelsListController.updateTableView();  // استدعاء دالة تحديث الجدول
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            // Navigate to the table page
            NavigationHelper.switchToPage(event, "/com/groupnine/travelbookingsystem/view/adminPanelHotelView/manageHotelsList.fxml");

            // Refresh the table if the controller is available
            if (manageHotelsListController != null) {
                manageHotelsListController.updateTableView(); // Refresh the table
                System.out.println("Controller is notNull. Table refreshed.");
            } else {
                System.err.println("Controller is null. Table cannot be refreshed.");
            }
        } catch (IOException e) {
            System.err.println("Failed to switch to Manage Hotels List page: " + e.getMessage());
        }

        // Load the second page's FXML
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/adminPanelHotelView/manageHotelsList.fxml"));
//            BorderPane root = loader.load();
//
//            // Create a new scene for the second page
//            Scene secondScene = new Scene(root);
//
//            // Get the current stage (window) and switch the scene
//            Stage primaryStage = (Stage) OKButton.getScene().getWindow();
//            primaryStage.setScene(secondScene);
//
//            // Refresh the table if the controller is available
//            if (manageHotelsListController != null) {
//                manageHotelsListController.updateTableView(); // Refresh the table
//                System.out.println("Controller is notNull. Table refreshed.");
//            } else {
//                System.err.println("Controller is null. Table cannot be refreshed.");
//            }
//        } catch (IOException e) {
//            System.err.println("Failed to switch to Manage Hotels List page: " + e.getMessage());
//        }
    }

    public void setTitleText(String titleText) {
        ConfirmLabel.setText(titleText);
    }
}
