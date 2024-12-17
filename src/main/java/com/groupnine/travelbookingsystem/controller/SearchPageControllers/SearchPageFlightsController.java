package com.groupnine.travelbookingsystem.controller.SearchPageControllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

//
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchPageFlightsController {

    public ImageView backG;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    // Defining the UI components with fx:id
    @FXML
    private Button btnMyBooking;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnHome;

    @FXML
    private ComboBox<String> cbFlightsHotels;

    @FXML
    private ComboBox<String> cbSignupLogin;

    @FXML
    private ComboBox<String> cbDestination;

    @FXML
    private ComboBox<String> cbPassengers;

    @FXML
    private ComboBox<String> cbCheckIn;

    @FXML
    private ComboBox<String> cbCheckOut;

    @FXML
    private Button btnFlights;

    @FXML
    private Button btnHotels;

    @FXML
    private Button btnSearch;

    @FXML
    public AnchorPane searchPane;

    @FXML
    public AnchorPane navBar;

    @FXML
    public AnchorPane btnHotelsPane;

    @FXML
    public AnchorPane btnFlightsPane;

    @FXML
    public AnchorPane backGroundd;


    @FXML
    private Label lblFlyStay;

    // Initialize method is called when the FXML file is loaded
    @FXML
    public void initialize() {
        // You can set up any initialization logic here, such as populating ComboBoxes or setting event handlers.
        // For example, filling the ComboBoxes with values:
        cbFlightsHotels.getItems().addAll("Flights", "Hotels");
        cbSignupLogin.getItems().addAll("Sign Up", "Login");
        cbDestination.getItems().addAll("New York", "London", "Paris", "Madrid", "Dobui", "Maldivs");  // Example destinations
        cbPassengers.getItems().addAll("1", "2", "3", "4", "5", "6", "More than 6");
        cbCheckIn.getItems().addAll("2024-12-01", "2024-12-15", "2024-12-30");
        cbCheckOut.getItems().addAll("2024-12-05", "2024-12-20", "2024-12-30");

        /* Example event handlers for buttons
        btnMyBooking.setOnAction(event -> handleMyBooking());
        btnProfile.setOnAction(event -> handleProfile());
        btnHome.setOnAction(event -> handleHome());
        btnFlights.setOnAction(event -> handleFlights());
        btnHotels.setOnAction(event -> handleHotels());
        btnSearch.setOnAction(event -> handleSearch());
        */
        btnHome.setOnAction(event -> handleHomeButton());
        btnMyBooking.setOnAction(event -> handleMyBookingButton());
        btnProfile.setOnAction(event -> handleProfileButton());

        btnFlights.setOnAction(event -> handleFlightsButton());
        btnHotels.setOnAction(event -> handleHotelsButton());
        btnSearch.setOnAction(event -> handleSearchButton());

        // Set combo box actions
        cbFlightsHotels.setOnAction(event -> handleFlightsHotelsCombo());
        cbSignupLogin.setOnAction(event -> handleSignupLoginCombo());

        setBackgroundImage();
    }

    private void setBackgroundImage() {
        backG.setImage(new Image(getClass().getResource("/img/sf.jpeg").toExternalForm()));

    }


    private void navigateToPage(String fxmlPath, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene newScene = new Scene(fxmlLoader.load());

            // Get the current stage
            Stage currentStage = (Stage) btnHome.getScene().getWindow();

            // Set the new scene
            currentStage.setScene(newScene);
            currentStage.setTitle(title);
        } catch (IOException e) {
            e.printStackTrace(); // Log any loading errors
        }
    }

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
    private void handleFlightsButton() {
        System.out.println("Flights button clicked");
        navigateToPage("/com/groupnine/travelbookingsystem/view/flights.fxml", "Flights");
    }

    @FXML
    private void handleHotelsButton() {
        System.out.println("Hotels button clicked");
        navigateToPage("/com/groupnine/travelbookingsystem/view/hotels.fxml", "Hotels");
    }

    @FXML
    private void handleSearchButton() {
        System.out.println("Search button clicked");
        navigateToPage("/com/groupnine/travelbookingsystem/view/search_results.fxml", "Search Results");
    }

    @FXML
    private void handleFlightsHotelsCombo() {
        String selectedOption = cbFlightsHotels.getSelectionModel().getSelectedItem();
        System.out.println("Flights/Hotels ComboBox selected: " + selectedOption);

        if (selectedOption != null) {
            switch (selectedOption) {
                case "Flights":
                    navigateToPage("/com/groupnine/travelbookingsystem/view/flights.fxml", "Flights");
                    break;
                case "Hotels":
                    navigateToPage("/com/groupnine/travelbookingsystem/view/hotels.fxml", "Hotels");
                    break;
                default:
                    System.out.println("Unknown option selected.");
            }
        }
    }

    @FXML
    private void handleSignupLoginCombo() {
        String selectedOption = cbSignupLogin.getSelectionModel().getSelectedItem();
        System.out.println("Signup/Login ComboBox selected: " + selectedOption);

        if (selectedOption != null) {
            switch (selectedOption) {
                case "Signup":
                    navigateToPage("/com/groupnine/travelbookingsystem/view/signup.fxml", "Signup");
                    break;
                case "Login":
                    navigateToPage("/com/groupnine/travelbookingsystem/view/login.fxml", "Login");
                    break;
                default:
                    System.out.println("Unknown option selected.");
            }
        }
    }


        /*private void handleSearch () {
            // Logic for Search button click
            System.out.println("Search clicked");

            // Example: Get selected ComboBox values
            String destination = cbDestination.getValue();
            String passengers = cbPassengers.getValue();
            String checkIn = cbCheckIn.getValue();
            String checkOut = cbCheckOut.getValue();

            System.out.println("Searching for " + passengers + " passengers to " + destination + " from " + checkIn + " to " + checkOut);
        }*/


}

