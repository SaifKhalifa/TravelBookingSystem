package com.groupnine.travelbookingsystem;

import com.groupnine.travelbookingsystem.controller.ResultSearchControllers.ResultSearchHotelsController;
import com.groupnine.travelbookingsystem.model.resultSearchHotels.resultH;
import com.groupnine.travelbookingsystem.model.searchHotels.searchH;
import com.groupnine.travelbookingsystem.model.searchHotels.searchHDAO;
import com.groupnine.travelbookingsystem.model.searchHotels.searchHDAOImp;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class test extends Application {
    private ListView<resultH> resultCardsList = new ListView<>();
    private ComboBox<String> destinationComboBox = new ComboBox<>();

    @Override
    public void start(Stage primaryStage) {
        destinationComboBox.setPromptText("Select Destination");
        destinationComboBox.setItems(FXCollections.observableArrayList("Paris", "London", "New York")); // Sample destinations

        destinationComboBox.setOnAction(e -> {
            String destination = destinationComboBox.getValue();
            if (destination != null) {
                loadSearchResults(destination);
            }
        });

        VBox root = new VBox(10, destinationComboBox, resultCardsList);
        Scene scene = new Scene(root, 400, 600);

        primaryStage.setTitle("Hotel Search");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loadSearchResults(String destination) {
        searchHDAO searchHDao = new searchHDAOImp();
        List<searchH> filteredHotels = searchHDao.getHotelsByDestination(destination);

        if (filteredHotels.isEmpty()) {
            System.out.println("No hotels found for destination: " + destination);
            return;
        }

        ObservableList<resultH> cards = FXCollections.observableArrayList();
        for (searchH hotel : filteredHotels) {
            resultH hotelCard = new resultH(hotel.getHotelId());
            cards.add(hotelCard);
        }

        resultCardsList.setItems(cards);
    }



    public static void loadResultsPage(String destination) {
        try {
            FXMLLoader loader = new FXMLLoader(test.class.getResource("/com/groupnine/travelbookingsystem/view/SearchPageFlights-Hotels/searchPageHotels.fxml"));
            Parent root = loader.load();

            // Pass the destination to the result controller
            ResultSearchHotelsController controller = loader.getController();
            controller.loadSearchResults(destination);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Search Results");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
