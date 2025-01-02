package com.groupnine.travelbookingsystem.controller.SearchPageControllers;

import com.groupnine.travelbookingsystem.controller.ResultSearchControllers.ResultSearchFlightsController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPageFlightsController {

    @FXML
    public ImageView backG;
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

    // New components for search functionality
    @FXML
    private TextField searchBar; // TextField for entering search query.
    @FXML
    private ListView<String> listView; // Display search results.

    // Mock data for flight bookings.
    private final List<String> flightDestinations = new ArrayList<>(List.of(
            "New York", "London", "Paris", "Madrid", "Dubai", "Maldives"
    ));

    // Initialize method is called when the FXML file is loaded
    @FXML
    public void initialize() {
        cbFlightsHotels.getItems().addAll("Flights", "Hotels");
        cbSignupLogin.getItems().addAll("Sign Up", "Login");
        cbDestination.getItems().addAll("New York", "London", "Paris", "Madrid", "Dubai", "Maldives");  // Example destinations
        cbPassengers.getItems().addAll("1", "2", "3", "4", "5", "6", "More than 6");
        cbCheckIn.getItems().addAll("2024-12-01", "2024-12-15", "2024-12-30");
        cbCheckOut.getItems().addAll("2024-12-05", "2024-12-20", "2024-12-30");

        btnHome.setOnAction(event -> handleHomeButton());
        btnMyBooking.setOnAction(event -> handleMyBookingButton());
        btnProfile.setOnAction(event -> handleProfileButton());
        btnFlights.setOnAction(event -> handleFlightsButton());
        btnHotels.setOnAction(event -> handleHotelsButton());
        btnSearch.setOnAction(event -> handleSearchButton());
        cbFlightsHotels.setOnAction(event -> handleFlightsHotelsCombo());
        cbSignupLogin.setOnAction(event -> handleSignupLoginCombo());

        setBackgroundImage();

        // Initialize search functionality
        listView.setItems(FXCollections.observableArrayList(flightDestinations));
        searchBar.setOnAction(event -> handleSearch());
    }

    private void setBackgroundImage() {
        backG.setImage(new Image(getClass().getResource("/com/groupnine/travelbookingsystem/Assets/imgs/result_search/sf.jpeg").toExternalForm()));
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
        navigateToPage("/com/groupnine/travelbookingsystem/view/ResultSearchFlights-Hotels/resultSearchFlights.fxml", "Search Results");
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

/*
    // New functionality for search
    private void handleSearch() {
        String query = searchBar.getText().toLowerCase().trim();
        List<String> filteredDestinations = filterDestinations(query);
        updateListView(filteredDestinations);
    }

    private List<String> filterDestinations(String query) {
        return flightDestinations.stream()
                .filter(destination -> destination.toLowerCase().contains(query))
                .collect(Collectors.toList());
    }

    private void updateListView(List<String> filteredDestinations) {
        ObservableList<String> observableList = FXCollections.observableArrayList(filteredDestinations);
        listView.setItems(observableList);
    }*/












    @FXML
    private void handleSearchButtonFlights() {
        String selectedDestination = cbDestination.getSelectionModel().getSelectedItem();
        if (selectedDestination != null && !selectedDestination.isEmpty()) {
            System.out.println("Search button clicked with destination: " + selectedDestination);
            navigateToFlightResultsPage(selectedDestination);
        } else {
            System.out.println("No destination selected.");
        }
    }

    private void navigateToFlightResultsPage(String destination) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/ResultSearchFlights-Hotels/resultSearchFlights.fxml"));
            Parent parent = fxmlLoader.load();

            // Pass the destination to the ResultSearchFlightsController
            ResultSearchFlightsController controller = fxmlLoader.getController();
            controller.loadSearchResults(destination);

            // Set up the new scene
            Scene scene = new Scene(parent);
            Stage currentStage = (Stage) btnSearch.getScene().getWindow();
            currentStage.setScene(scene);
            currentStage.setTitle("Flight Search Results - " + destination);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading flight search results page.");
        }
    }

}
