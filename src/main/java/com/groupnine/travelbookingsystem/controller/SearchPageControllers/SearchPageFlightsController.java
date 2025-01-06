package com.groupnine.travelbookingsystem.controller.SearchPageControllers;

import com.groupnine.travelbookingsystem.MainApplication_DEFAULT;
import com.groupnine.travelbookingsystem.controller.ResultSearchControllers.ResultSearchFlightsController;
import com.groupnine.travelbookingsystem.model.searchFlights.searchF;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;


public class SearchPageFlightsController {

    @FXML
    public ImageView backG;
    @FXML
    private Button btnHome;
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
    public AnchorPane btnHotelsPane;
    @FXML
    public AnchorPane btnFlightsPane;


    // Initialize the page and setup dropdowns, buttons, and background
    @FXML
    public void initialize() {
        cbDestination.getItems().addAll("See All", "Istanbul", "London", "Paris", "Madrid", "Dubai", "Maldives", "New York");  // Example destinations
        cbPassengers.getItems().addAll("1", "2", "3", "4", "5", "6", "More than 6");
        cbCheckIn.getItems().addAll("2024-12-11", "2025-03-6", "2025-12-20", "2025-11-16", "2025-11-6","2025-04-16");
        cbCheckOut.getItems().addAll("2025-01-30", "2025-03-31", "2025-01-12", "2025-11-30", "2025-05-16","2025-12-16");

        btnFlights.setOnAction(event -> handleFlightsButton());
        btnHotels.setOnAction(event -> handleHotelsButton());

        btnSearch.setOnAction(this::handleSearch);


        setBackgroundImage();
    }


    // Set the background image for the page
    private void setBackgroundImage() {
        backG.setImage(new Image(getClass().getResource("/com/groupnine/travelbookingsystem/Assets/imgs/result_search/sf.jpeg").toExternalForm()));
    }


    // Navigate to a specific page
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


    // Handle Flights button click
    @FXML
    private void handleFlightsButton000() {
        System.out.println("Flights button clicked");
        navigateToPage("/com/groupnine/travelbookingsystem/view/SearchPageFlighte-Hotels/searchPageFlights.fxml", "Flights");
    }


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



    @FXML
    private void handleHotelsButton000() {
        System.out.println("Hotels button clicked");
        navigateToPage("/com/groupnine/travelbookingsystem/view/SearchPageFlighte-Hotels/searchPageHotels.fxml", "Hotels");
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


    // Helper class for navigation (used for results page)
    public class NavigationHelper {

        public static void showResultsPage(Stage stage) throws Exception {
            FXMLLoader loader = new FXMLLoader(NavigationHelper.class.getResource("/path/to/result_page.fxml"));
            Parent root = loader.load();

            ResultSearchFlightsController resultPageController = loader.getController();
            resultPageController.initialize();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }


    // Handle Search button click
    private void handleSearch(ActionEvent event) {

        System.out.println("Search button clicked, storing data in the model..., and moving to search results page!");

        if (cbDestination.getSelectionModel().getSelectedItem() == null) {
            showAlert("Search", "You need to select a destination to search for!");
            return;
        }

        searchF searchF = new searchF();

        String selectedDestination = cbDestination.getValue();
        searchF.setDestination(selectedDestination);
        System.out.println("Search button clicked");
        //navigateToPage("/com/groupnine/travelbookingsystem/view/ResultSearchFlights-Hotels/resultSearchFlights.fxml", "Search Results");
        MainApplication_DEFAULT.loadScene(
                "/com/groupnine/travelbookingsystem/view/ResultSearchFlights-Hotels/resultSearchFlights.fxml",
                "Search Results",
                true,
                true
        );
        try {
            NavigationHelper.showResultsPage((Stage) btnSearch.getScene().getWindow());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Show an alert dialog
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
