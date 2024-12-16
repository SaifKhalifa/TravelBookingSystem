package com.groupnine.travelbookingsystem.controller.adminPanelHotelController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HotelConfirmAddEditController {

    @FXML
    private Label ConfirmLabel;

    public void onOKButtonClick(javafx.event.ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void setTitleText(String titleText) {
        ConfirmLabel.setText(titleText);
    }
}
