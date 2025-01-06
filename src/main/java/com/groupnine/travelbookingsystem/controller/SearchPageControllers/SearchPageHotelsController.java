package com.groupnine.travelbookingsystem.controller.SearchPageControllers;

import com.groupnine.travelbookingsystem.MainApplication_DEFAULT;
import com.groupnine.travelbookingsystem.controller.ResultSearchControllers.ResultSearchFlightsController;
import com.groupnine.travelbookingsystem.model.searchHotels.searchH;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;


public class SearchPageHotelsController {

    @FXML public ImageView backGG;
    @FXML private Button btnHome;
    @FXML private Button btnFlights;
    @FXML private Button btnHotels;
    @FXML private ComboBox<String> cbDestination;
    @FXML private ComboBox<String> cbRooms;
    @FXML private ComboBox<String> cbCheckIn;
    @FXML private ComboBox<String> cbCheckOut;
    @FXML private ComboBox<String> cbPersons;
    @FXML private Button btnSearch;


    // Method to initialize the page and set up the UI elements
    @FXML
    private void initialize() {

        cbDestination.getItems().addAll("See All", "Big White Village", "Condo To The Beach", "Outstanding house");
        cbRooms.getItems().addAll("2", "3", "4", "5", "More than 5");
        cbCheckIn.getItems().addAll("2024-12-11", "2025-03-6", "2025-12-20", "2025-11-16", "2025-11-6","2025-04-16");
        cbCheckOut.getItems().addAll("2025-01-30", "2025-03-31", "2025-01-12", "2025-11-30", "2025-05-16","2025-12-16");
        cbPersons.getItems().addAll("1", "2", "3", "4", "5","6", "More than 6");

        btnFlights.setOnAction(event -> handleFlightsButton());
        btnHotels.setOnAction(event -> handleHotelsButton());

        btnSearch.setOnAction(this::handleSearch);

        setBackgroundImage();
    }


    // Method to set a background image for the page
    private void setBackgroundImage() {
        backGG.setImage(new Image(getClass().getResource("/com/groupnine/travelbookingsystem/Assets/imgs/result_search/sh.jpeg").toExternalForm()));

    }


    // Helper method to navigate to a different page by loading an FXML file
    private void navigateToPage(String fxmlPath, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene newScene = new Scene(fxmlLoader.load());

            Stage currentStage = (Stage) btnHome.getScene().getWindow();

            currentStage.setScene(newScene);
            currentStage.setTitle(title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Methods for handling the buttons
    @FXML
    private void handleFlightsButton() {
        //setActiveTab(flightsBox);
        MainApplication_DEFAULT.loadScene(
                "/com/groupnine/travelbookingsystem/view/SearchPageFlighte-Hotels/searchPageFlights.fxml",
                "Flights",
                true,
                true
        );
    }


    // Handle Hotels button click
    @FXML
    private void handleHotelsButton() {
        //setActiveTab(flightsBox);
        MainApplication_DEFAULT.loadScene(
                "/com/groupnine/travelbookingsystem/view/SearchPageFlighte-Hotels/searchPageHotels.fxml",
                "Hotels",
                true,
                true
        );
    }



    // Inner class to help with navigation between result pages (could be used for flight results as well)
    public class NavigationHelper {

        public static void showResultsPage(Stage stage) throws Exception {
            FXMLLoader loader = new FXMLLoader(SearchPageFlightsController.NavigationHelper.class.getResource("/path/to/result_page.fxml"));
            Parent root = loader.load();

            ResultSearchFlightsController resultPageController = loader.getController();
            resultPageController.initialize();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }


    // Method for handling the search button click (initiates the search process)
    private void handleSearch(ActionEvent event) {

        System.out.println("Search button clicked, storing data in the model..., and moving to search results page!");

        if (cbDestination.getSelectionModel().getSelectedItem() == null) {
            showAlert("Search", "You need to select a hotel type to search for!");
            return;
        }

        searchH searchH = new searchH();

        String selectedDestination = cbDestination.getValue();
        searchH.setDestination(selectedDestination);
        System.out.println("Search button clicked");
        //navigateToPage("/com/groupnine/travelbookingsystem/view/ResultSearchFlights-Hotels/resultSearchHotels.fxml", "Search Results");
        MainApplication_DEFAULT.loadScene(
                "/com/groupnine/travelbookingsystem/view/ResultSearchFlights-Hotels/resultSearchHotels.fxml",
                "Search Results",
                true,
                true
        );
        try {
            SearchPageFlightsController.NavigationHelper.showResultsPage((Stage) btnSearch.getScene().getWindow());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Method to show an alert dialog
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
