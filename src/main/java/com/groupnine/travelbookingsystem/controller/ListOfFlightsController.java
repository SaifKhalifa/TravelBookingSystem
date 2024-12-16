package com.groupnine.travelbookingsystem.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

public class ListOfFlightsController {

    @FXML
    private Button hotel;

    @FXML
    private Button flight;

    @FXML
    private Button addnewflight;

    @FXML
    private TableView<FlightData> flightTable;

    @FXML
    private TableColumn<FlightData, Integer> flightId;

    @FXML
    private TableColumn<FlightData, String> departureTime;

    @FXML
    private TableColumn<FlightData, String> flightDuration;

    @FXML
    private TableColumn<FlightData, Void> editColumn;

    @FXML
    private TableColumn<FlightData, Void> deleteColumn;

    // ObservableList to store flight data
    private final ObservableList<FlightData> flightData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Make the TableView responsive
        flightTable.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        flightTable.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            double totalWidth = newWidth.doubleValue();
            double columnWidth = totalWidth / flightTable.getColumns().size();

            for (TableColumn<?, ?> column : flightTable.getColumns()) {
                column.setPrefWidth(columnWidth);
            }
        });

        // Initialize the TableView with data
        initializeTableData();

        // Add Edit and Delete button columns
        addEditButtonToTable();
        addDeleteButtonToTable();

        // Set up button actions
        if (addnewflight != null) {
            addnewflight.setOnAction(event -> navigateToAddFlight());
        }

        if (hotel != null) {
            hotel.setOnAction(event -> navigateToHotel());
        }
    }

    private void initializeTableData() {
        // Add some sample flight data to the ObservableList
        flightData.add(new FlightData(101, "2024-12-20 09:00", "2h 30m"));
        flightData.add(new FlightData(102, "2024-12-21 14:00", "3h 15m"));
        flightData.add(new FlightData(103, "2024-12-22 18:30", "1h 45m"));

        // Set the data to the TableView
        flightTable.setItems(flightData);

        // Configure the columns to display data from the FlightData object
        flightId.setCellValueFactory(cellData -> cellData.getValue().flightIdProperty().asObject());
        departureTime.setCellValueFactory(cellData -> cellData.getValue().departureTimeProperty());
        flightDuration.setCellValueFactory(cellData -> cellData.getValue().flightDurationProperty());
    }

    private void addEditButtonToTable() {
        Callback<TableColumn<FlightData, Void>, TableCell<FlightData, Void>> cellFactory = param -> new TableCell<>() {
            private final Button editButton = new Button("Edit");

            {
                editButton.setOnAction(event -> {
                    FlightData data = getTableView().getItems().get(getIndex());
                    System.out.println("Editing: " + data);
                    // Add edit logic here, e.g., open a new window
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(editButton);
                }
            }
        };

        editColumn.setCellFactory(cellFactory);
    }

    private void addDeleteButtonToTable() {
        Callback<TableColumn<FlightData, Void>, TableCell<FlightData, Void>> cellFactory = param -> new TableCell<>() {
            private final Button deleteButton = new Button("Delete");

            {
                deleteButton.setOnAction(event -> {
                    FlightData data = getTableView().getItems().get(getIndex());
                    flightTable.getItems().remove(data);
                    System.out.println("Deleted: " + data);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(deleteButton);
                }
            }
        };

        deleteColumn.setCellFactory(cellFactory);
    }

    public void navigateToAddFlight() {
        System.out.println("Navigating to AddFlight...");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/AddFlight.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root, 1280, 832));
            stage.setTitle("Add Flight");
            stage.show();

            Stage currentStage = (Stage) addnewflight.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: Unable to load AddFlight.fxml");
        }
    }

    private void navigateToHotel() {
        System.out.println("Navigating to Hotel screen...");
        // Add logic for navigation here
    }

    // Simple internal class to hold the flight data, without creating a separate class
    public static class FlightData {
        private final SimpleIntegerProperty flightId;
        private final SimpleStringProperty departureTime;
        private final SimpleStringProperty flightDuration;

        public FlightData(int flightId, String departureTime, String flightDuration) {
            this.flightId = new SimpleIntegerProperty(flightId);
            this.departureTime = new SimpleStringProperty(departureTime);
            this.flightDuration = new SimpleStringProperty(flightDuration);
        }

        public SimpleIntegerProperty flightIdProperty() {
            return flightId;
        }

        public SimpleStringProperty departureTimeProperty() {
            return departureTime;
        }

        public SimpleStringProperty flightDurationProperty() {
            return flightDuration;
        }

        @Override
        public String toString() {
            return "FlightData{" +
                    "flightId=" + flightId.get() +
                    ", departureTime='" + departureTime.get() + '\'' +
                    ", flightDuration='" + flightDuration.get() + '\'' +
                    '}';
        }
    }
}
