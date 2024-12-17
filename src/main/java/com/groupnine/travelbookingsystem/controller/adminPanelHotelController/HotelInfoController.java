package com.groupnine.travelbookingsystem.controller.adminPanelHotelController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.*;

import java.io.IOException;

import javafx.scene.image.Image;

import java.io.File;
import java.util.List;

public class HotelInfoController {
    @FXML
    private Button SaveButton;

    @FXML
    private Button uploadButton;

    @FXML
    private HBox photoContainer;

    @FXML
    private Label star1;
    @FXML
    private Label star2;
    @FXML
    private Label star3;
    @FXML
    private Label star4;
    @FXML
    private Label star5;

    private int currentRating = 0; // Store the current rating (1-5)

    @FXML
    public void BackToHotelsList(ActionEvent event) {
        try {
            NavigationHelper.switchToPage(event, "/com/groupnine/travelbookingsystem/view/adminPanelHotelView/manageHotelsList.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Label TitleInfo;

    // Method to set the title text from the first page
    public void setTitleText(String titleText) {
        if (TitleInfo != null) {
            TitleInfo.setText(titleText);
        } else {
            System.out.println("Error: Label not initialized properly.");
        }
    }

    @FXML
    public void SaveHotelInfo() throws Exception {
        if (TitleInfo.getText().equals("Add a Hotel Information")) {
            SetLabelText("Hotel Added to the System Successfully!");
        } else {
            SetLabelText("Hotel Information Updated Successfully!");
        }
    }

    private void SetLabelText(String titleText) throws Exception {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/adminPanelHotelView/hotelConfirmAddEdit.fxml"));
            AnchorPane root = loader.load();

            // Get the controller of the second page to set the label text
            HotelConfirmAddEditController hotelConfirmAddEditController = loader.getController();
            hotelConfirmAddEditController.setTitleText(titleText); // Pass the title text to the second page controller

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

    @FXML
    private ComboBox<String> AvailabilityComboBox;

    @FXML
    public void initialize() {
        // Set default selection if needed
        AvailabilityComboBox.getSelectionModel().select("Available");

        // Handle item selection change
        AvailabilityComboBox.setOnAction(event -> {
            String selectedAvailability = AvailabilityComboBox.getSelectionModel().getSelectedItem();
            // System.out.println("Selected availability: " + selectedAvailability);
        });

        // Disable focus on all star labels
//        star1.setFocusTraversable(false);
//        star2.setFocusTraversable(false);
//        star3.setFocusTraversable(false);
//        star4.setFocusTraversable(false);
//        star5.setFocusTraversable(false);

        // Add click event listeners to each star
        star1.setOnMouseClicked(event -> updateRating(1));
        star2.setOnMouseClicked(event -> updateRating(2));
        star3.setOnMouseClicked(event -> updateRating(3));
        star4.setOnMouseClicked(event -> updateRating(4));
        star5.setOnMouseClicked(event -> updateRating(5));
    }

    private void updateRating(int rating) {
        currentRating = rating;
        //System.out.println("Selected Rating: " + currentRating);

        // Reset all stars to default (unselected color)
        resetStars();

        // Highlight stars according to the current rating
        if (rating >= 1) star1.setStyle("-fx-text-fill: #FFD700;"); // Gold color
        if (rating >= 2) star2.setStyle("-fx-text-fill: #FFD700;");
        if (rating >= 3) star3.setStyle("-fx-text-fill: #FFD700;");
        if (rating >= 4) star4.setStyle("-fx-text-fill: #FFD700;");
        if (rating >= 5) star5.setStyle("-fx-text-fill: #FFD700;");

    }

    private void resetStars() {
        star1.setStyle("-fx-text-fill: #cccccc;"); // Gray color for unselected
        star2.setStyle("-fx-text-fill: #cccccc;");
        star3.setStyle("-fx-text-fill: #cccccc;");
        star4.setStyle("-fx-text-fill: #cccccc;");
        star5.setStyle("-fx-text-fill: #cccccc;");
    }


    @FXML
    public void onUploadButtonClick() {
        FileChooser fileChooser = new FileChooser();

        // Allow only image files
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        // Allow user to select multiple files
        List<File> files = fileChooser.showOpenMultipleDialog(null);

        if (files != null) {
            photoContainer.getChildren().clear(); // Clear previous images
            for (File file : files) {
                Image image = new Image(file.toURI().toString());
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(100); // Set image width
                imageView.setFitHeight(100); // Set image height
                imageView.setPreserveRatio(true);
                photoContainer.getChildren().add(imageView); // Add each image to the HBox
            }
        }
    }

    public void GoBackIcon(MouseEvent event) {
        try {
            ActionEvent actionEvent = new ActionEvent(event.getSource(), null);
            NavigationHelper.switchToPage(actionEvent, "/com/groupnine/travelbookingsystem/view/adminPanelHotelView/manageHotelsList.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}