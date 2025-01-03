package com.groupnine.travelbookingsystem.controller.ResultSearchControllers;

import com.groupnine.travelbookingsystem.controller.BookingDetailsController.DetailsController;
import com.groupnine.travelbookingsystem.model.searchFlights.searchF;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;



public class ResultSearchFlightsController {

    @FXML
    private AnchorPane card_paris, card_london, card_maldives, card_istanbul, card_madrid, card_dubai;
    @FXML
    private Button cardBtn_paris, cardBtn_london, cardBtn_maldives, cardBtn_dubai, cardBtn_istanbul, cardBtn_madrid;


    public void initialize() {
        setCard1();
        setCard2();
        setCard3();
        setCard4();
        setCard5();
        setCard6();

        handleSearchResult();
    }


    // Sets the actions for all the cards buttons
    private void setCard1() {
        cardBtn_paris.setOnAction(event -> handleCard1Button());
    }

    private void setCard2() {
        cardBtn_london.setOnAction(event -> handleCard2Button());
    }

    private void setCard3() {
        cardBtn_maldives.setOnAction(event -> handleCard3Button());
    }

    private void setCard4() {
        cardBtn_dubai.setOnAction(event -> handleCard4Button());
    }

    private void setCard5() {
        cardBtn_istanbul.setOnAction(event -> handleCard5Button());
    }

    private void setCard6() {
        cardBtn_madrid.setOnAction(event -> handleCard6Button());
    }


    //Navigates to the specified FXML page with the given title
    private void navigateToPage(String fxmlPath, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene newScene = new Scene(fxmlLoader.load());

            Stage currentStage = (Stage) cardBtn_paris.getScene().getWindow();

            currentStage.setScene(newScene);
            currentStage.setTitle(title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Navigates to a details page and passes a card ID to the controller
    private void navigateToPageWithCardId(String fxmlPath, String title, int cardId) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = fxmlLoader.load();

            DetailsController controller = fxmlLoader.getController();
            if (controller != null) {

            }

            Stage currentStage = (Stage) cardBtn_paris.getScene().getWindow();
            currentStage.setScene(new Scene(root));
            currentStage.setTitle(title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    // Handlers for individual card buttons, each passes a unique card ID
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


    //Handles the search result display by showing or hiding cards based on the destination
    private void handleSearchResult() {
        // Reset all cards to default state
        resetCards();

        searchF searchF = new searchF();
        String destination = searchF.getDestination();
        if (destination == null || destination.trim().isEmpty() || destination.equalsIgnoreCase("See All")) {
            // Show all cards if no destination is entered or "All" is selected
            showAllCards();
            return;
        }

        switch (searchF.getDestination().toLowerCase()) {
            case "paris":
                card_paris.setVisible(true);
                card_paris.setLayoutX(502);
                card_paris.setLayoutY(256);
                break;
            case "london":
                card_london.setVisible(true);
                card_london.setLayoutX(502);
                card_london.setLayoutY(256);
                break;
            case "maldives":
                card_maldives.setVisible(true);
                card_maldives.setLayoutX(502);
                card_maldives.setLayoutY(256);
                break;
            case "istanbul":
                card_istanbul.setVisible(true);
                card_istanbul.setLayoutX(502);
                card_istanbul.setLayoutY(256);
                break;
            case "madrid":
                card_madrid.setVisible(true);
                card_madrid.setLayoutX(502);
                card_madrid.setLayoutY(256);
                break;
            case "dubai":
                card_dubai.setVisible(true);
                card_dubai.setLayoutX(502);
                card_dubai.setLayoutY(256);
                break;
            default:
                System.out.println("Destination not recognized: " + searchF.getDestination());
                break;
        }
    }


    // Resets all cards to their hidden state
    private void resetCards() {
        card_paris.setVisible(false);
        card_london.setVisible(false);
        card_maldives.setVisible(false);
        card_istanbul.setVisible(false);
        card_madrid.setVisible(false);
        card_dubai.setVisible(false);

        card_paris.setDisable(false);
        card_london.setDisable(false);
        card_maldives.setDisable(false);
        card_istanbul.setDisable(false);
        card_madrid.setDisable(false);
        card_dubai.setDisable(false);
    }


    // Shows all cards
    private void showAllCards() {
        card_paris.setVisible(true);
        card_london.setVisible(true);
        card_maldives.setVisible(true);
        card_istanbul.setVisible(true);
        card_madrid.setVisible(true);
        card_dubai.setVisible(true);
    }

}