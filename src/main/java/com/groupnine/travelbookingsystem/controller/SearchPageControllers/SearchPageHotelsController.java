package com.groupnine.travelbookingsystem.controller.SearchPageControllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;

public class SearchPageHotelsController {

    @FXML public ImageView backGG;
    @FXML private Button btnMyBooking;
    @FXML private Button btnProfile;
    @FXML private Button btnHome;
    @FXML private Button btnFlights;
    @FXML private Button btnHotels;
    @FXML private Button btnSearch;
    @FXML private ComboBox<String> cbFlightsHotels;
    @FXML private ComboBox<String> cbSignupLogin;
    @FXML private ComboBox<String> cbDestination;
    @FXML private ComboBox<String> cbRooms;
    @FXML private ComboBox<String> cbCheckIn;
    @FXML private ComboBox<String> cbCheckOut;
    @FXML private ComboBox<String> cbPersons;

    // Event handlers for buttons
    @FXML
    private void initialize() {
        // Initialize ComboBoxes with sample data or dynamic data from a service
        cbFlightsHotels.getItems().addAll("Flights", "Hotels");
        cbSignupLogin.getItems().addAll("Signup", "Login");
        cbDestination.getItems().addAll("New York", "Paris", "London");
        cbRooms.getItems().addAll("1", "2", "3", "4");
        cbCheckIn.getItems().addAll("2024-01-01", "2024-02-01", "2024-03-01");
        cbCheckOut.getItems().addAll("2024-01-05", "2024-02-05", "2024-03-05");
        cbPersons.getItems().addAll("1", "2", "3", "4");


        btnHome.setOnAction(event -> handleHomeButton());
        btnMyBooking.setOnAction(event -> handleMyBookingButton());
        btnProfile.setOnAction(event -> handleProfileButton());

        btnFlights.setOnAction(event -> handleFlightsButton());
        btnHotels.setOnAction(event -> handleHotelsButton());
        btnSearch.setOnAction(event -> handleSearchButton());

        cbFlightsHotels.setOnAction(event -> handleFlightsHotelsCombo());
        cbSignupLogin.setOnAction(event -> handleSignupLoginCombo());


        setBackgroundImage();
    }

    private void setBackgroundImage() {
        backGG.setImage(new Image(getClass().getResource("/com/groupnine/travelbookingsystem/Assets/imgs/result_search/sh.jpeg").toExternalForm()));

    }

    // Navigation logic
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
        navigateToPage("/com/groupnine/travelbookingsystem/view/SearchPage;;Flights-Hotels/searchPageHotels.fxml", "Profile");
    }

    @FXML
    private void handleFlightsButton() {
        System.out.println("Flights button clicked");
        navigateToPage("/com/groupnine/travelbookingsystem/view/SearchPageFlighte-Hotels/searchPageFlights.fxml", "Flights");
    }

    @FXML
    private void handleHotelsButton() {
        System.out.println("Hotels button clicked");
        navigateToPage("/com/groupnine/travelbookingsystem/view/SearchPageFlighte-Hotels/searchPageHotels.fxml", "Hotels");
    }

    @FXML
    private void handleSearchButton() {
        System.out.println("Search button clicked");
        navigateToPage("/com/groupnine/travelbookingsystem/view/ResultSearchFlights-Hotels/resultSearchHotels.fxml", "Search Results");
    }

    @FXML
    private void handleFlightsHotelsCombo() {
        String selectedOption = cbFlightsHotels.getSelectionModel().getSelectedItem();
        System.out.println("Flights/Hotels ComboBox selected: " + selectedOption);

        if (selectedOption != null) {
            switch (selectedOption) {
                case "Flights":
                    navigateToPage("/com/groupnine/travelbookingsystem/view/SearchPageFlighte-Hotels/searchPageFlights.fxml", "Flights");
                    break;
                case "Hotels":
                    navigateToPage("/com/groupnine/travelbookingsystem/view/SearchPageFlighte-Hotels/searchPageHotels.fxml", "Hotels");
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
}
