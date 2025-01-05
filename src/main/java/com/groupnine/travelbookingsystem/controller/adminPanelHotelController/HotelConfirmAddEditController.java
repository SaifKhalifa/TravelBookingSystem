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

    @FXML
    public void onOKButtonClick() {
        try {
            // إغلاق الـ Popup الحالي
            Stage popupStage = (Stage) OKButton.getScene().getWindow();
            popupStage.close();

            // الوصول إلى الـ Stage الرئيسي (Stage الخاص بـ Hotel Info)
            //  Stage primaryStage = (Stage) popupStage.getOwner();

            // تحميل صفحة Hotel List
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/adminPanelHotelView/manageHotelsList.fxml"));
            BorderPane root = loader.load();
            System.out.println("from Hotel Confirm Add Edit to hotels list");

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Hotels List");
            primaryStage.show();

            // Refresh the table if the controller is available
            if (manageHotelsListController != null) {
                manageHotelsListController.updateTableView(); // Refresh the table
                System.out.println("Controller is notNull. Table refreshed.");
            } else {
                System.err.println("Controller is null. Table cannot be refreshed.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load Hotel List page: " + e.getMessage());
        }
    }

    public void setTitleText(String titleText) {
        ConfirmLabel.setText(titleText);
    }

    Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
