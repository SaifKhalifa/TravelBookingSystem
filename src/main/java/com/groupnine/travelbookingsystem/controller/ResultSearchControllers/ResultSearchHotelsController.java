package com.groupnine.travelbookingsystem.controller.ResultSearchControllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class ResultSearchHotelsController {

    @FXML
    private Button myBookingButton;
    @FXML
    private Button profileButton;
    @FXML
    private Button homeButton;
    @FXML
    private ComboBox<String> comboBox1;
    @FXML
    private ComboBox<String> comboBox2;
    @FXML
    private Button card1Button;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;

    // Initializes the controller
    public void initialize() {
        // Initialize ComboBoxes
        comboBox1.getItems().addAll("Flights", "Hotels");
        comboBox2.getItems().addAll("Signup", "Login");
        setCard1();
        setCard2();
        setCard3();
        setCard4();
        setCard5();
        setCard6();
    }


    //card 1
    private void setCard1() {
        card1Button.setOnAction(event -> handleCard1Button());
    }

    //card2
    private void setCard2() {
        button2.setOnAction(event -> handleCard2Button());
    }

    //card3

    private void setCard3() {
        button3.setOnAction(event -> handleCard3Button());
    }

    //card4
    private void setCard4() {
        button4.setOnAction(event -> handleCard4Button());
    }

    //card5
    private void setCard5() {
        button5.setOnAction(event -> handleCard5Button());
    }

    //card6
    private void setCard6() {
        button6.setOnAction(event -> handleCard6Button());
    }

    private void setHomeButton() {
        homeButton.setOnAction(event -> handleHomeButton());
    }

    private void setMyBookingButton() {
        myBookingButton.setOnAction(event -> handleMyBookingButton());
    }

    private void setProfileButton() {
        profileButton.setOnAction(event -> handleProfileButton());
    }

    // Navigation logic
    private void navigateToPage(String fxmlPath, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene newScene = new Scene(fxmlLoader.load());

            // Get the current stage
            Stage currentStage = (Stage) homeButton.getScene().getWindow();

            // Set the new scene
            currentStage.setScene(newScene);
            currentStage.setTitle(title);
        } catch (IOException e) {
            e.printStackTrace(); // Log any loading errors
        }
    }

    // Handle button clicks
    @FXML
    private void handleHomeButton() {
        System.out.println("Home button clicked");
        navigateToPage("/com/groupnine/travelbookingsystem/view/Home/Homepage_V2.fxml", "Home");
    }

    @FXML
    private void handleMyBookingButton() {
        System.out.println("My Booking button clicked");
        navigateToPage("/com/groupnine/travelbookingsystem/view/my_booking.fxml", "My Booking");
    }

    @FXML
    private void handleProfileButton() {
        System.out.println("Profile button clicked");
        navigateToPage("/com/groupnine/travelbookingsystem/view/profile.fxml", "Profile");
    }

    @FXML
    private void handleCard1Button() {
        System.out.println("Card 1 button clicked");
        // Action for Card 1 button click
        navigateToPage("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_h.fxml", "Hotel Details");

    }

    @FXML
    private void handleCard2Button() {
        System.out.println("Card 2 button clicked");
        // Action for Card 2 button click
        navigateToPage("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_h.fxml", "Hotel Details");
    }

    @FXML
    private void handleCard3Button() {
        System.out.println("Card 3 button clicked");
        // Action for Card 3 button click
        navigateToPage("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_h.fxml", "Hotel Details");
    }

    @FXML
    private void handleCard4Button() {
        System.out.println("Card 4 button clicked");
        // Action for Card 4 button click
        navigateToPage("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_h.fxml", "Hotel Details");
    }

    @FXML
    private void handleCard5Button() {
        System.out.println("Card 5 button clicked");
        // Action for Card 5 button click
        navigateToPage("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_h.fxml", "Hotel Details");
    }

    @FXML
    private void handleCard6Button() {
        System.out.println("Card 6 button clicked");
        // Action for Card 6 button click
        navigateToPage("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_h.fxml", "Hotel Details");
    }

    @FXML
    private void handleComboBox1Selection() {
        String selectedOption = comboBox1.getSelectionModel().getSelectedItem();
        System.out.println("ComboBox1 selected: " + selectedOption);
    }

    @FXML
    private void handleComboBox2Selection() {
        String selectedOption = comboBox2.getSelectionModel().getSelectedItem();
        System.out.println("ComboBox2 selected: " + selectedOption);
    }
}
