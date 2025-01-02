package com.groupnine.travelbookingsystem.controller.adminPanelHotelController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HotelConfirmDeletionController {

    @FXML
    public void onYesButtonClick(javafx.event.ActionEvent event) {
    }

    @FXML
    public void onNoButtonClick(javafx.event.ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();

    }
}
