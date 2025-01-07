package com.groupnine.travelbookingsystem.controller.SearchPageControllers;

import com.groupnine.travelbookingsystem.MainApplication_DEFAULT;
import com.groupnine.travelbookingsystem.controller.ResultSearchControllers.ResultSearchFlightsController;
import com.groupnine.travelbookingsystem.model.searchFlights.searchF;
import com.groupnine.travelbookingsystem.util.HibernateUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.sql.Date;
import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class SearchPageFlightsController {

    @FXML public ImageView backG;
    @FXML private Button btnHome;
    @FXML private ComboBox<String> cbDestination;
    @FXML private ComboBox<String> cbPassengers;
    @FXML private ComboBox<String> cbCheckIn;
    @FXML private ComboBox<String> cbCheckOut;
    @FXML private Button btnFlights;
    @FXML private Button btnHotels;
    @FXML private Button btnSearch;
    @FXML public AnchorPane searchPane;
    @FXML public AnchorPane btnHotelsPane;
    @FXML public AnchorPane btnFlightsPane;


    // Initialize the page and setup dropdowns, buttons, and background
    @FXML
    public void initialize() {
        cbDestination.getItems().addAll("See All", "Istanbul", "London", "Paris", "Madrid", "Dubai", "Maldives", "New York");  // Example destinations
        cbPassengers.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "10");
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
    private void handleFlightsButton() {
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


    private void handleSearch(ActionEvent event) {
        System.out.println("Search button clicked, storing data in the model..., and moving to search results page!");

        if (cbDestination.getSelectionModel().getSelectedItem() == null) {
            showAlert("Search", "You need to select a destination to search for!");
            return;
        }

        searchF searchF = new searchF();
        String selectedDestination = cbDestination.getValue();
        searchF.setDestination(selectedDestination);
        Date selectedCheckInDate = Date.valueOf(cbCheckIn.getValue());
        Date selectedCheckOutDate = Date.valueOf(cbCheckOut.getValue());
        Integer selectedPassengerCount = Integer.valueOf(cbPassengers.getValue());


        searchF.setDestination(selectedDestination);
        searchF.setPassengerCount(selectedPassengerCount != null ? selectedPassengerCount : 0);
        searchF.setCheckInDate(selectedCheckInDate);
        searchF.setCheckOutDate(selectedCheckOutDate);

        System.out.println("Selected destination: " + selectedDestination);
        System.out.println("Saving searchF object: " + searchF.toString());

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(searchF);
            transaction.commit();
            System.out.println("Selected flight saved successfully!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error saving the flight search.");
            e.printStackTrace();
        } finally {
            session.close();
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/ResultSearchFlights-Hotels/resultSearchFlights.fxml"));
        try {
            Parent root = loader.load();

            ResultSearchFlightsController controller = loader.getController();
            controller.setSearchF(searchF); // Pass the searchF object to the controller

            Stage stage = (Stage) btnSearch.getScene().getWindow();
            stage.setMaximized(false);
            stage.setScene(null);
            stage.setResizable(true);
            stage.setFullScreen(false);

            stage.setScene(new Scene(root));
            stage.show();
            stage.setMaximized(true);
        } catch (IOException e) {
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
