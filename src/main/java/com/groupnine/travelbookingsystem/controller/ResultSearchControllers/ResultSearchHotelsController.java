package com.groupnine.travelbookingsystem.controller.ResultSearchControllers;

import com.groupnine.travelbookingsystem.controller.BookingDetailsController.DetailsController;
import com.groupnine.travelbookingsystem.model.resultSearchHotels.resultH;
import com.groupnine.travelbookingsystem.model.searchHotels.searchH;
import com.groupnine.travelbookingsystem.model.searchHotels.searchHDAO;
import com.groupnine.travelbookingsystem.model.searchHotels.searchHDAOImp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.smartcardio.Card;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    @FXML
    private searchH searchCriteria;

    @FXML
    private searchHDAO searchHDao = new searchHDAOImp();
    @FXML
    private List<searchH> allHotels;
    @FXML
    private ListView<resultH> resultCardsList;
    @FXML
    private AnchorPane cardsContainer;

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
        //loadSearchResults();

        allHotels = new ArrayList<>(); // Create an empty list of hotels

        allHotels.add(new searchH("Big White Village",6));
        allHotels.add(new searchH("Condo To The Beach",10));
        allHotels.add(new searchH("Big White Village",15));
        allHotels.add(new searchH("Condo To The Beach",5));
        allHotels.add(new searchH("Outstanding house",10));
        allHotels.add(new searchH("Outstanding house",4));

        String destination = cbDestination.getValue(); // Get the selected destination from the ComboBox
        loadSearchResults(destination);

        ListView<resultH> resultCardsList = new ListView<>();

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


    private void navigateToPageWithCardId(String fxmlPath, String title, int cardId) {
        try {
            // Load the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = fxmlLoader.load();

            // Get the controller of the next page
            DetailsController controller = fxmlLoader.getController();
            if (controller != null) {
                // Pass the cardId to the next page's controller
                //controller.setCardId(cardId);
            }

            // Get the current stage and set the new scene
            Stage currentStage = (Stage) homeButton.getScene().getWindow();
            currentStage.setScene(new Scene(root));
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
        int cardId = 1; // Replace with the actual cardId of the clicked card
        System.out.println("Round Trip Button clicked, cardId: " + cardId);
        navigateToPageWithCardId("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_h.fxml", "Hotel Details", cardId);

    }

    @FXML
    private void handleCard2Button() {
        int cardId = 2; // Replace with the actual cardId of the clicked card
        System.out.println("Round Trip Button clicked, cardId: " + cardId);
        navigateToPageWithCardId("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_h.fxml", "Hotel Details", cardId);

    }

    @FXML
    private void handleCard3Button() {
        int cardId = 3; // Replace with the actual cardId of the clicked card
        System.out.println("Round Trip Button clicked, cardId: " + cardId);
        navigateToPageWithCardId("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_h.fxml", "Hotel Details", cardId);

    }

    @FXML
    private void handleCard4Button() {
        int cardId = 4; // Replace with the actual cardId of the clicked card
        System.out.println("Round Trip Button clicked, cardId: " + cardId);
        navigateToPageWithCardId("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_h.fxml", "Hotel Details", cardId);

    }

    @FXML
    private void handleCard5Button() {
        int cardId = 5; // Replace with the actual cardId of the clicked card
        System.out.println("Round Trip Button clicked, cardId: " + cardId);
        navigateToPageWithCardId("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_h.fxml", "Hotel Details", cardId);

    }

    @FXML
    private void handleCard6Button() {
        int cardId = 6; // Replace with the actual cardId of the clicked card
        System.out.println("Round Trip Button clicked, cardId: " + cardId);
        navigateToPageWithCardId("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_h.fxml", "Hotel Details", cardId);

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
        searchHDAO searchHDao = new searchHDAOImp();  // Create an instance of searchHDAOImp
        List<searchH> filteredHotels = searchHDao.getHotelsByDestination(destination);  // Use the instance to call the method

        if (filteredHotels.isEmpty()) {
            System.out.println("No hotels found for destination: " + destination);
            return;
        }

        // Populate the ListView or UI component with the filtered results
        ObservableList<resultH> cards = FXCollections.observableArrayList();
        for (searchH hotel : filteredHotels) {
            // Create UI cards or components to represent each hotel
            // Example: Replace with your actual card creation logic
            resultH hotelCard = new resultH(hotel.getHotelId());  // Use resultH directly as the card
            cards.add(hotelCard);
        }

        resultCardsList.setItems(cards);  // Set the ObservableList to the ListView
    }


}