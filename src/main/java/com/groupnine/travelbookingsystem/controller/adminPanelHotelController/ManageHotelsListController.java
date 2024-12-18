package com.groupnine.travelbookingsystem.controller.adminPanelHotelController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class ManageHotelsListController {
    @FXML
    private ToggleButton flightsButton;

    @FXML
    private ToggleButton hotelsButton;

    @FXML
    private Button AddHotelBtn;
    @FXML
    private Button EditHotelBtn;

    @FXML
    public void AddHotel() throws Exception{
       try{
        openSecondPage("Add a Hotel Information");
       } catch (Exception e) {
           e.printStackTrace();  // This will print the error stack trace in the console
       }
    }

    @FXML
    public void EditHotel()throws Exception {
        openSecondPage("Edit a Hotel Information");
    }

    private void openSecondPage(String titleText) throws Exception {
        // Load the second page's FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/adminPanelHotelView/hotelInfo.fxml"));
        BorderPane root = loader.load();

        // Get the controller of the second page to set the label text
        HotelInfoController hotelInfoController = loader.getController();
        hotelInfoController.setTitleText(titleText); // Pass the title text to the second page controller

        // Create a new scene for the second page
        Scene secondScene = new Scene(root);

        // Get the current stage (window) and switch the scene
        Stage primaryStage = (Stage) AddHotelBtn.getScene().getWindow(); // You can also use EditBtn if needed
        primaryStage.setScene(secondScene);

    }
    @FXML
    public void initialize() {
        // Create a ToggleGroup to manage the buttons
        ToggleGroup group = new ToggleGroup();

        // Add the buttons to the ToggleGroup
        flightsButton.setToggleGroup(group);
        hotelsButton.setToggleGroup(group);

        flightsButton.setSelected(true); // You can change this to hotelsButton if needed

        // Ensure flightsButton stays selected if clicked again
        flightsButton.setOnAction(event -> {
            if (!flightsButton.isSelected()) {
                flightsButton.setSelected(true); // Keep the button selected
            }
        });

        // Ensure hotelsButton stays selected if clicked again
        hotelsButton.setOnAction(event -> {
            if (!hotelsButton.isSelected()) {
                hotelsButton.setSelected(true); // Keep the button selected
            }
        });
    }

    public void DeleteHotel(ActionEvent event) {

        try {
            // Load the FXML for the confirmation popup
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/adminPanelHotelView/hotelConfirmDeletion.fxml"));
            AnchorPane root = loader.load();

            // Create a new stage for the modal dialog
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); // Makes it a modal
            stage.initStyle(StageStyle.UNDECORATED); // Remove the title bar

            // Get the primary screen bounds (screen width and height)
            Screen screen = Screen.getPrimary();
            double screenWidth = screen.getBounds().getWidth();
            double screenHeight = screen.getBounds().getHeight();

            // Calculate the center of the screen
            stage.setX((screenWidth - 400) / 2); // Center on X, adjusted for the popup size
            stage.setY((screenHeight - 200) / 2); // Center on Y, adjusted for the popup size

            // Set the scene with the loaded FXML content
            Scene scene = new Scene(root);
            stage.setScene(scene);

            // Show the popup
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ToFlightsList(ActionEvent event) {
        try {
            NavigationHelper.switchToPage(event, "/com/groupnine/travelbookingsystem/view/AdminMangeFlight/ListFlights.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
