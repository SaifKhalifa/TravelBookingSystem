package com.groupnine.travelbookingsystem.controller.ResultSearchControllers;

import com.groupnine.travelbookingsystem.controller.BookingDetailsController.DetailsController;
import com.groupnine.travelbookingsystem.model.resultSearchFlights.resultF;
import com.groupnine.travelbookingsystem.model.resultSearchHotels.resultH;
import com.groupnine.travelbookingsystem.model.searchFlights.searchF;
import com.groupnine.travelbookingsystem.model.searchFlights.searchFDAO;
import com.groupnine.travelbookingsystem.model.searchFlights.searchFDAOImp;
import com.groupnine.travelbookingsystem.model.searchHotels.searchH;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    @FXML
    private List<searchF> allFlights;
    @FXML
    private ListView<resultF> resultCardsList;
    @FXML
    private ComboBox<String> cbDestination;



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

        allFlights = new ArrayList<>(); // Create an empty list of hotels

        allFlights.add(new searchF("Paris",6));
        allFlights.add(new searchF("London",2));
        allFlights.add(new searchF("Madrid",15));
        allFlights.add(new searchF("Maldives",9));
        allFlights.add(new searchF("Dubai",10));
        allFlights.add(new searchF("Istanbul",4));

        String destination = cbDestination.getValue(); // Get the selected destination from the ComboBox
        loadSearchResults(destination);

        ListView<resultH> resultCardsList = new ListView<>();
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


    private void navigateToPageWithCardId(String fxmlPath, String title, int cardId) {
        try {
            // Load the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = fxmlLoader.load();

            // Get the controller of the next page
            DetailsController controller = fxmlLoader.getController();
            if (controller != null) {
                // Pass the cardId to the next page's controller
               // controller.setCardId(cardId);
            }

            // Get the current stage and set the new scene
            Stage currentStage = (Stage) roundTripButton.getScene().getWindow();
            currentStage.setScene(new Scene(root));
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
        int cardId = 1; // Replace with the actual cardId of the clicked card
        System.out.println("Round Trip Button clicked, cardId: " + cardId);
        navigateToPageWithCardId("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_f.fxml", "Flight Details", cardId);
    }

    @FXML
    private void handleCard2Button() {
        int cardId = 2; // Replace with the actual cardId of the clicked card
        System.out.println("Round Trip Button clicked, cardId: " + cardId);
        navigateToPageWithCardId("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_f.fxml", "Flight Details", cardId);
    }

    @FXML
    private void handleCard3Button() {
        int cardId = 3; // Replace with the actual cardId of the clicked card
        System.out.println("Round Trip Button clicked, cardId: " + cardId);
        navigateToPageWithCardId("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_f.fxml", "Flight Details", cardId);
    }

    @FXML
    private void handleCard4Button() {
        int cardId = 4; // Replace with the actual cardId of the clicked card
        System.out.println("Round Trip Button clicked, cardId: " + cardId);
        navigateToPageWithCardId("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_f.fxml", "Flight Details", cardId);
    }

    @FXML
    private void handleCard5Button() {
        int cardId = 5; // Replace with the actual cardId of the clicked card
        System.out.println("Round Trip Button clicked, cardId: " + cardId);
        navigateToPageWithCardId("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_f.fxml", "Flight Details", cardId);
    }

    @FXML
    private void handleCard6Button() {
        int cardId = 6; // Replace with the actual cardId of the clicked card
        System.out.println("Round Trip Button clicked, cardId: " + cardId);
        navigateToPageWithCardId("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_f.fxml", "Flight Details", cardId);
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








        public void loadSearchResults(String destination) {
            // Create an instance of flightDAOImp (assuming the name of the implementation class)
            searchFDAO flightDao = new searchFDAOImp();  // Create an instance of flightDAOImp
            List<searchF> filteredFlights = flightDao.getFlightsByDestination(destination);  // Use the instance to call the method

            if (filteredFlights.isEmpty()) {
                System.out.println("No flights found for destination: " + destination);
                return;
            }

            // Populate the ListView or UI component with the filtered results
            ObservableList<resultF> cards = FXCollections.observableArrayList();
            for (searchF flight : filteredFlights) {
                // Create UI cards or components to represent each flight
                // Example: Replace with your actual card creation logic
                resultF flightCard = new resultF(flight.getBookingId());  // Use resultF directly as the card
                cards.add(flightCard);
            }

            resultCardsList.setItems(cards);  // Set the ObservableList to the ListView
        }
    }