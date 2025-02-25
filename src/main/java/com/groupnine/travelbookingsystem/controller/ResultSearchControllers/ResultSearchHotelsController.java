package com.groupnine.travelbookingsystem.controller.ResultSearchControllers;

import com.groupnine.travelbookingsystem.controller.BookingDetailsController.DetailsController;
import com.groupnine.travelbookingsystem.model.searchHotels.searchH;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class ResultSearchHotelsController {


    @FXML
    private AnchorPane card_BigWhiteVillage, card_BigWhiteVillage2, card_CondoToTheBeach, card_CondoToTheBeach2, card_OutstandingHouse, card_OutstandingHouse2;
    @FXML
    private Button cardBtn_BigWhiteVillage, cardBtn_BigWhiteVillage2, cardBtn_CondoToTheBeach, cardBtn_CondoToTheBeach2, cardBtn_OutstandingHouse, cardBtn_OutstandingHouse2;
    @FXML
    private searchH searchH;


    // Initialize the controller and set up event listeners for card buttons
    public void initialize() {

        setCard1();
        setCard2();
        setCard3();
        setCard4();
        setCard5();
        setCard6();

        handleSearchResult();
    }


    // Setter method to pass searchH from SearchHotelsController
    public void setSearchH(searchH searchH) {
        this.searchH = searchH;
        handleSearchResult();
    }

    // Set the actions for all the cards buttons
    private void setCard1() {
        cardBtn_BigWhiteVillage.setOnAction(event -> handleCard1Button());
    }

    private void setCard2() {
        cardBtn_OutstandingHouse.setOnAction(event -> handleCard2Button());
    }

    private void setCard3() {
        cardBtn_CondoToTheBeach.setOnAction(event -> handleCard3Button());
    }

    private void setCard4() {
        cardBtn_OutstandingHouse2.setOnAction(event -> handleCard4Button());
    }

    private void setCard5() {
        cardBtn_BigWhiteVillage2.setOnAction(event -> handleCard5Button());
    }

    private void setCard6() {
        cardBtn_CondoToTheBeach2.setOnAction(event -> handleCard6Button());
    }


    // Navigate to another page (e.g., booking details) by loading an FXML file
    private void navigateToPage(String fxmlPath, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene newScene = new Scene(fxmlLoader.load());

            Stage currentStage = (Stage) cardBtn_BigWhiteVillage.getScene().getWindow();

            currentStage.setScene(newScene);
            currentStage.setTitle(title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Navigate to a page with cardId to pass information to the next page
    private void navigateToPageWithCardId(String fxmlPath, String title, int cardId) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = fxmlLoader.load();

            // Pass card ID to the controller if it is an instance of DetailsController
            Object controller = fxmlLoader.getController();
            if (controller instanceof DetailsController) {
                ((DetailsController) controller).setCardId(cardId);
            } else {
                System.err.println("Controller is not an instance of DetailsController.");
            }

            // Create a new stage for the popup
            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL); // Makes the stage modal
            popupStage.setTitle(title);
            popupStage.setScene(new Scene(root));

            // Disable resizing
            popupStage.setResizable(false);

            // Show the popup and wait for it to close
            popupStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    // Handle cards actions
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

    // Handle the results based on the destination selected
    private void handleSearchResult() {
        // If searchH is null, we won't show anything
        if (searchH == null) {
            return;
        }

        resetCards();  // Hide all cards first

        String destination = searchH.getDestination();

        // If the destination is "See All", show all cards
        if (destination.equalsIgnoreCase("See All")) {
            showAllCards();
            return;
        }

        switch (destination.toLowerCase()) {
            case "big white village":
                card_BigWhiteVillage.setVisible(true);
                card_BigWhiteVillage.setLayoutX(402);
                card_BigWhiteVillage.setLayoutY(256);

                card_BigWhiteVillage2.setVisible(true);
                card_BigWhiteVillage2.setLayoutX(802);
                card_BigWhiteVillage2.setLayoutY(256);
                break;

            case "condo to the beach":
                card_CondoToTheBeach.setVisible(true);
                card_CondoToTheBeach.setLayoutX(402);
                card_CondoToTheBeach.setLayoutY(256);

                card_CondoToTheBeach2.setVisible(true);
                card_CondoToTheBeach2.setLayoutX(802);
                card_CondoToTheBeach2.setLayoutY(256);
                break;

            case "outstanding house":
                card_OutstandingHouse.setVisible(true);
                card_OutstandingHouse.setLayoutX(402);
                card_OutstandingHouse.setLayoutY(256);

                card_OutstandingHouse2.setVisible(true);
                card_OutstandingHouse2.setLayoutX(802);
                card_OutstandingHouse2.setLayoutY(256);
                break;

            default:
                System.out.println("Destination not recognized: " + destination);
                break;
        }
    }

    // Reset all cards to be hidden and enabled
    private void resetCards() {
        card_BigWhiteVillage.setVisible(false);
        card_BigWhiteVillage2.setVisible(false);
        card_CondoToTheBeach.setVisible(false);
        card_CondoToTheBeach2.setVisible(false);
        card_OutstandingHouse.setVisible(false);
        card_OutstandingHouse2.setVisible(false);
    }

    // Show all cards (if type is not selected or is "See All")
    private void showAllCards() {
        card_BigWhiteVillage.setVisible(true);
        card_BigWhiteVillage2.setVisible(true);
        card_CondoToTheBeach.setVisible(true);
        card_CondoToTheBeach2.setVisible(true);
        card_OutstandingHouse.setVisible(true);
        card_OutstandingHouse2.setVisible(true);
    }
}