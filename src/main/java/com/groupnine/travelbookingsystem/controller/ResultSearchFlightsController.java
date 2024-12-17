package com.groupnine.travelbookingsystem.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import java.awt.*;
import java.io.IOException;

public class ResultSearchFlightsController {

    public ImageView destinationImageView;
    public AnchorPane destinationImageAnchorPane;
    public TextField tripTypeField2;
    public DropShadow card2DropShadow;
    public AnchorPane card3;
    public ImageView imageView3;
    public AnchorPane backgroundImage3;
    public TextField destinationNameField3;
    public ImageView ratingPointerImageView3;
    public Circle ratingCircle3;
    public ImageView starImageView3;
    public Button roundTripButton3;
    public DropShadow card3DropShadow;
    public AnchorPane card4;
    public ImageView imageView4;
    public AnchorPane backgroundImage4;
    public TextField destinationNameField4;
    public ImageView ratingPointerImageView4;
    public Circle ratingCircle4;
    public ImageView starImageView4;
    public Button roundTripButton4;
    public DropShadow card4DropShadow;
    public AnchorPane card5;
    public ImageView imageView5;
    public AnchorPane backgroundImage5;
    public TextField destinationNameField5;
    public TextField ratingField5;
    public ImageView ratingPointerImageView5;
    public Circle ratingCircle5;
    public ImageView starImageView5;
    public Button roundTripButton5;
    public AnchorPane card6;
    public ImageView imageView6;
    public AnchorPane backgroundImage6;
    public TextField destinationNameField6;
    public TextField ratingField6;
    public Circle ratingCircle6;
    public ImageView ratingPointerImageView6;
    public ImageView starImageView6;
    public Button roundTripButton6;
    public TextField tripTypeField6;
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
    private Label flyStayLabel;

    @FXML
    private TextField destinationNameField;

    @FXML
    private TextField ratingField;

    @FXML
    private Circle ratingCircle;

    @FXML
    private ImageView ratingPointerImageView;

    @FXML
    private ImageView starImageView;

    @FXML
    private TextField destinationInfoField;

    @FXML
    private TextField travelDatesField;

    @FXML
    private TextField priceField;

    @FXML
    private Slider verticalSlider;

    @FXML
    private TextField popularDestinationsText;

    @FXML
    private TextField descriptionText;

    @FXML
    private AnchorPane popularDestinationCard;

    @FXML
    private AnchorPane card2;

    @FXML
    private ImageView imageView2;

    @FXML
    private AnchorPane backgroundImage2;

    @FXML
    private TextField destinationNameField2;

    @FXML
    private TextField ratingField2;

    @FXML
    private Circle ratingCircle2;

    @FXML
    private ImageView ratingPointerImageView2;

    @FXML
    private ImageView starImageView2;

    @FXML
    private TextField destinationInfoField2;

    @FXML
    private TextField travelDatesField2;

    @FXML
    private TextField priceField2;

    @FXML
    private Button roundTripButton2;

    @FXML
    private DropShadow cardDropShadow;

    // Initializes the controller
    public void initialize() {
        // Initialize ComboBoxes
        comboBox1.getItems().addAll("Flights", "Hotels");
        comboBox2.getItems().addAll("Signup", "Login");

        // Example card 1 setup
        setCard1();
        setCard2();
        setCard3();
        setCard4();
        setCard5();
        setCard6();
    }


    private void setCard1() {
        destinationImageView.setImage(new Image(getClass().getResource("/img/ss1.png").toExternalForm()));
        ratingPointerImageView.setImage(new Image(getClass().getResource("/img/pointer2.png").toExternalForm()));
        starImageView.setImage(new Image(getClass().getResource("/img/star.png").toExternalForm()));
        // Set button action
        roundTripButton.setOnAction(event -> handleCard1Button());
    }

    private void setCard2() {
        imageView2.setImage(new Image(getClass().getResource("/img/ss2.png").toExternalForm()));
        ratingPointerImageView2.setImage(new Image(getClass().getResource("/img/pointer2.png").toExternalForm()));
        starImageView2.setImage(new Image(getClass().getResource("/img/star.png").toExternalForm()));
        // Set button action
        roundTripButton2.setOnAction(event -> handleCard2Button());
    }

    private void setCard3() {
        imageView3.setImage(new Image(getClass().getResource("/img/ss3.png").toExternalForm()));
        ratingPointerImageView3.setImage(new Image(getClass().getResource("/img/pointer2.png").toExternalForm()));
        starImageView3.setImage(new Image(getClass().getResource("/img/star.png").toExternalForm()));
        // Set button action
        roundTripButton3.setOnAction(event -> handleCard3Button());
    }

    private void setCard4() {
        imageView4.setImage(new Image(getClass().getResource("/img/ss4.jpg").toExternalForm()));
        ratingPointerImageView4.setImage(new Image(getClass().getResource("/img/pointer2.png").toExternalForm()));
        starImageView4.setImage(new Image(getClass().getResource("/img/star.png").toExternalForm()));
        // Set button action
        roundTripButton4.setOnAction(event -> handleCard4Button());
    }

    private void setCard5() {
        imageView5.setImage(new Image(getClass().getResource("/img/ss5.jpg").toExternalForm()));
        ratingPointerImageView5.setImage(new Image(getClass().getResource("/img/pointer2.png").toExternalForm()));
        starImageView5.setImage(new Image(getClass().getResource("/img/star.png").toExternalForm()));
        // Set button action
        roundTripButton5.setOnAction(event -> handleCard5Button());
    }

    private void setCard6() {
        imageView6.setImage(new Image(getClass().getResource("/img/ss6.jpg").toExternalForm()));
        ratingPointerImageView6.setImage(new Image(getClass().getResource("/img/pointer2.png").toExternalForm()));
        starImageView6.setImage(new Image(getClass().getResource("/img/star.png").toExternalForm()));
        // Set button action
        roundTripButton6.setOnAction(event -> handleCard6Button());
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
        navigateToPage("/com/groupnine/travelbookingsystem/view/home.fxml", "Home");
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
        System.out.println("Round Trip Button 2 clicked");
        // Action for Round Trip Button 2 click
    }

    @FXML
    private void handleCard2Button() {
        System.out.println("Round Trip Button 3 clicked");
        // Action for Round Trip Button 3 click
    }

    @FXML
    private void handleCard3Button() {
        System.out.println("Round Trip Button 4 clicked");
        // Action for Round Trip Button 4 click
    }

    @FXML
    private void handleCard4Button() {
        System.out.println("Round Trip Button 5 clicked");
        // Action for Round Trip Button 5 click
    }

    @FXML
    private void handleCard5Button() {
        System.out.println("Round Trip Button 6 clicked");
        // Action for Round Trip Button 6 click
    }

    @FXML
    private void handleCard6Button() {
        System.out.println("Round Trip Button 6 clicked");
        // Action for Round Trip Button 6 click
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

