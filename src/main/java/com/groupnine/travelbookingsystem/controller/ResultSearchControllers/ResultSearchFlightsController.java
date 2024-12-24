package com.groupnine.travelbookingsystem.controller.ResultSearchControllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.IOException;

public class ResultSearchFlightsController {

    @FXML
    private Button myBookingButton;
    @FXML
    private Button profileButton;
    @FXML
    private Button roundTripButton;
    @FXML
    private ComboBox<String> comboBox1;
    @FXML
    private ComboBox<String> comboBox2;
    @FXML
    private Button roundTripButton2;
    @FXML
    private Button roundTripButton3;
    @FXML
    private Button roundTripButton4;
    @FXML
    private Button roundTripButton5;
    @FXML
    private Button roundTripButton6;
    @FXML
    public Button homeButton;

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


    private void setCard1() {
        roundTripButton.setOnAction(event -> handleCard1Button());
    }

    private void setCard2() {
        roundTripButton2.setOnAction(event -> handleCard2Button());
    }

    private void setCard3() {
        roundTripButton3.setOnAction(event -> handleCard3Button());
    }

    private void setCard4() {
        roundTripButton4.setOnAction(event -> handleCard4Button());
    }

    private void setCard5() {
        roundTripButton5.setOnAction(event -> handleCard5Button());
    }

    private void setCard6() {
        roundTripButton6.setOnAction(event -> handleCard6Button());
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

    private void navigateToPage(String fxmlPath, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene newScene = new Scene(fxmlLoader.load());

            // Get the current stage
            Stage currentStage = (Stage) roundTripButton.getScene().getWindow();

            // Set the new scene
            currentStage.setScene(newScene);
            currentStage.setTitle(title);
        } catch (IOException e) {
            e.printStackTrace(); // Log any loading errors
        }
    }

    // Handle button clicks for navigation
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
        System.out.println("Round Trip Button 1 clicked");
        // Action for Round Trip Button 2 click
        navigateToPage("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_f.fxml", "Flight Details");
    }

    @FXML
    private void handleCard2Button() {
        System.out.println("Round Trip Button 3 clicked");
        // Action for Round Trip Button 3 click
        navigateToPage("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_f.fxml", "Flight Details");

    }

    @FXML
    private void handleCard3Button() {
        System.out.println("Round Trip Button 4 clicked");
        // Action for Round Trip Button 4 click
        navigateToPage("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_f.fxml", "Flight Details");

    }

    @FXML
    private void handleCard4Button() {
        System.out.println("Round Trip Button 5 clicked");
        // Action for Round Trip Button 5 click
        navigateToPage("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_f.fxml", "Flight Details");

    }

    @FXML
    private void handleCard5Button() {
        System.out.println("Round Trip Button 6 clicked");
        // Action for Round Trip Button 6 click
        navigateToPage("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_f.fxml", "Flight Details");

    }

    @FXML
    private void handleCard6Button() {
        System.out.println("Round Trip Button 6 clicked");
        // Action for Round Trip Button 6 click
        navigateToPage("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_f.fxml", "Flight Details");

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






















  /*  private void setButtonActions() {
        myBookingButton.setOnAction(event -> handleMyBooking());
        profileButton.setOnAction(event -> handleProfile());
        roundTripButton.setOnAction(event -> handleRoundTrip());
        roundTripButton2.setOnAction(event -> handleRoundTrip());
    }**********////

    /// ////////////////////////////
    // Handle button click for card 1
   /* private void handleCard1Button() {
        System.out.println("Card 1 button clicked");
        // Implement logic when the user interacts with the button
    }

    // Handle button click for card 2
    private void handleCard2Button() {
        System.out.println("Card 2 button clicked");
        // Implement logic when the user interacts with the button
    }

    private void handleCard3Button() {
        System.out.println("Card 1 button clicked");
        // Implement logic when the user interacts with the button
    }

    private void handleCard4Button() {
        System.out.println("Card 1 button clicked");
        // Implement logic when the user interacts with the button
    }

    private void handleCard5Button() {
        System.out.println("Card 1 button clicked");
        // Implement logic when the user interacts with the button
    }

    private void handleCard6Button() {
        System.out.println("Card 1 button clicked");
        // Implement logic when the user interacts with the button
    }

    // Handle "My Booking" button
    @FXML
    private void handleMyBookingButton() {
        System.out.println("My Booking button clicked");
        // Navigate to My Booking page or show booking details
    }

    // Handle "Profile" button
    @FXML
    private void handleProfileButton() {
        System.out.println("Profile button clicked");
        // Navigate to Profile page or show profile details
    }

    // Handle "Home" button
    @FXML
    private void handleHomeButton() {
        System.out.println("Home button clicked");
        // Navigate to the homepage
    }

    // Handle ComboBox selection changes
    @FXML
    private void handleComboBox1Action() {
        String selectedOption = comboBox1.getValue();
        System.out.println("ComboBox1 selected: " + selectedOption);
        // Implement logic based on selected option
    }

    @FXML
    private void handleComboBox2Action() {
        String selectedOption = comboBox2.getValue();
        System.out.println("ComboBox2 selected: " + selectedOption);
        // Implement logic based on selected option
    }*/

