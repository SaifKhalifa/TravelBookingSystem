package com.groupnine.travelbookingsystem.controller.adminPanelHotelController;

import com.groupnine.travelbookingsystem.model.hotel.HotelDAOImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HotelConfirmDeletionController {

    @FXML
    private Button YesButton;
    private int hotelID;
    private HotelDAOImpl hotelDOAImp = new HotelDAOImpl();
    private ManageHotelsListController manageHotelsListController;  // مرجع للكونترولر الذي يحتوي على الجدول

    // دالة لتعيين مرجع الـ controller الرئيسي (الذي يحتوي على الجدول)
    public void setMainController(ManageHotelsListController manageHotelsListController) {
        this.manageHotelsListController = manageHotelsListController;
    }

    public void setHotelId(int hotelId) {
        this.hotelID = hotelId;
    }

    @FXML
    public void onYesButtonClick() {
        hotelDOAImp.delete(this.hotelID);
        Stage stage = (Stage) YesButton.getScene().getWindow();
        stage.close();
// تحديث الجدول بعد الحذف
        if (manageHotelsListController != null) {
            manageHotelsListController.updateTableView();  // استدعاء دالة تحديث الجدول
        }
    }

    @FXML
    public void onNoButtonClick(javafx.event.ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();

    }
}
