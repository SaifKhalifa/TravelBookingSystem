package com.groupnine.travelbookingsystem.controller.AdminMangeFlight;
import com.groupnine.travelbookingsystem.controller.adminPanelHotelController.NavigationHelper;
import com.groupnine.travelbookingsystem.model.AdminFlight.AdminFlightModel;
import com.groupnine.travelbookingsystem.model.AdminFlight.ImpAdminFlightInterface;
import com.groupnine.travelbookingsystem.util.HibernateUtil;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class ListOfFlightsController {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    static {
        sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    }
    @FXML
    private TableView<FlightData> flightTable;
    @FXML
    private TableColumn<FlightData, Integer> flightId;
    @FXML
    private TableColumn<FlightData, String> origin;
    @FXML
    private TableColumn<FlightData, String> destination;
    @FXML
    private TableColumn<FlightData, String> departureDate;
    @FXML
    private TableColumn<FlightData, String> arrivalDate;
    @FXML
    private TableColumn<FlightData, String> departureTime;
    @FXML
    private TableColumn<FlightData, String> arrivalTime;
    @FXML
    private TableColumn<FlightData, Integer> gateNumber;
    @FXML
    private TableColumn<FlightData, String> flightDuration;
    @FXML
    private TableColumn<FlightData, Integer> seatCapacity;
    @FXML
    private TableColumn<FlightData, String> classType;
    @FXML
    private TableColumn<FlightData, String> notes;
    @FXML
    private TableColumn<FlightData, BigDecimal> price;
    @FXML
    private TableColumn<FlightData, Void> deleteColumn;
    @FXML
    private TableColumn<FlightData, Void> editColumn;

    @FXML
    private Button hotel;
    @FXML
    private Button addnewflight;


    private final ObservableList<FlightData> flightData = FXCollections.observableArrayList();
//responsive table
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

        initializeTableData();
        addEditButtonToTable();
        addDeleteButtonToTable();
        if (addnewflight != null) {
            addnewflight.setOnAction(event -> navigateToAddFlight());
        }

        if (hotel != null) {
            hotel.setOnAction(event -> navigateToHotel(event));
        }
    }
    private final ImpAdminFlightInterface GetFlight = new ImpAdminFlightInterface();

    private void initializeTableData() {
        try {
            List<AdminFlightModel> flights = GetFlight.getAllFlights();
            ObservableList<FlightData> flightDataList = FXCollections.observableArrayList();
            for (AdminFlightModel flight : flights) {
                flightDataList.add(new FlightData(
                        flight.getFlightId(),
                        flight.getOrigin(),
                        flight.getDestination(),
                        flight.getDepartureDate().toString(),
                        flight.getArrivalDate().toString(),
                        flight.getDepartureTime().toString(),
                        flight.getArrivalTime().toString(),
                        flight.getGateNumber(),  // int
                        flight.getSeatCapacity(), // int
                        new BigDecimal(flight.getPrice().toString()),

                        flight.getClassType(),
                        flight.getFlightDuration().toString(),
                        flight.getNotes()
                ));
            }

            // إعداد الأعمدة وربطها مع الخصائص
            flightId.setCellValueFactory(cellData -> cellData.getValue().flightIdProperty().asObject());
            origin.setCellValueFactory(cellData -> cellData.getValue().originProperty());
            destination.setCellValueFactory(cellData -> cellData.getValue().destinationProperty());
            departureDate.setCellValueFactory(cellData -> cellData.getValue().departureDateProperty());
            arrivalDate.setCellValueFactory(cellData -> cellData.getValue().arrivalDateProperty());
            departureTime.setCellValueFactory(cellData -> cellData.getValue().departureTimeProperty());
            arrivalTime.setCellValueFactory(cellData -> cellData.getValue().arrivalTimeProperty());
            gateNumber.setCellValueFactory(cellData -> cellData.getValue().gateNumberProperty().asObject());
            flightDuration.setCellValueFactory(cellData -> cellData.getValue().flightDurationProperty());
            seatCapacity.setCellValueFactory(cellData -> cellData.getValue().seatCapacityProperty().asObject());

            classType.setCellValueFactory(cellData -> cellData.getValue().classTypeProperty());
            notes.setCellValueFactory(cellData -> cellData.getValue().notesProperty());
            price.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
            flightTable.setItems(flightDataList);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error initializing table data: " + e.getMessage());
        }
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

                    // إنشاء نافذة تأكيد الحذف
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirm Deletion");
                    alert.setHeaderText("Are you sure you want to delete this flight?");
                    alert.setContentText("Once deleted, it cannot be undone.");


                    alert.showAndWait().ifPresent(response -> {
                        if (response == ButtonType.OK) {

                            flightTable.getItems().remove(data);
                            deleteFlightFromDatabase(data);
                            System.out.println("Deleted: " + data);
                        }
                    });
                });
            }
            private void deleteFlightFromDatabase(FlightData data) {
                try (Session session = sessionFactory.openSession()) {
                    Transaction transaction = session.beginTransaction();

                    AdminFlightModel flight = session.get(AdminFlightModel.class, data.flightIdProperty().get());

                    if (flight != null) {
                        session.delete(flight);
                        transaction.commit();
                        System.out.println("Flight deleted from database.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error deleting flight from database: " + e.getMessage());
                }
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/AdminMangeFlight/AddFlight.fxml"));
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

    private void navigateToHotel(ActionEvent event) {
        try {
            NavigationHelper.switchToPage(event, "/com/groupnine/travelbookingsystem/view/adminPanelHotelView/manageHotelsList.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static class FlightData {
        private final SimpleIntegerProperty flightId;
        private final SimpleStringProperty departureTime;
        private final SimpleStringProperty arrivalTime;
        private final SimpleStringProperty departureDate;
        private final SimpleStringProperty arrivalDate;
        private final SimpleStringProperty origin;
        private final SimpleStringProperty destination;
        private final SimpleIntegerProperty gateNumber;
        private final SimpleIntegerProperty seatCapacity;
        private final SimpleObjectProperty<BigDecimal> price;
        private final SimpleStringProperty classType;
        private final SimpleStringProperty flightDuration;
        private final SimpleStringProperty notes;

        public FlightData(int flightId, String origin, String destination, String departureDate, String arrivalDate,
                                   String arrivalTime , String departureTime, int gateNumber, int seatCapacity, BigDecimal price,
                          String classType, String flightDuration, String notes) {
            this.flightId = new SimpleIntegerProperty(flightId);
            this.departureTime = new SimpleStringProperty(departureTime);
            this.arrivalTime = new SimpleStringProperty(arrivalTime);
            this.departureDate = new SimpleStringProperty(departureDate);
            this.arrivalDate = new SimpleStringProperty(arrivalDate);
            this.origin = new SimpleStringProperty(origin);
            this.destination = new SimpleStringProperty(destination);
            this.gateNumber = new SimpleIntegerProperty(gateNumber);
            this.seatCapacity = new SimpleIntegerProperty(seatCapacity);
            this.price = new SimpleObjectProperty<>(price);  // Correct usage of BigDecimal
            this.classType = new SimpleStringProperty(classType);
            this.flightDuration = new SimpleStringProperty(flightDuration);
            this.notes = new SimpleStringProperty(notes);
        }

        public SimpleIntegerProperty flightIdProperty() { return flightId; }
        public SimpleStringProperty departureTimeProperty() { return departureTime; }
        public SimpleStringProperty arrivalTimeProperty() { return arrivalTime; }
        public SimpleStringProperty departureDateProperty() { return departureDate; }
        public SimpleStringProperty arrivalDateProperty() { return arrivalDate; }
        public SimpleStringProperty originProperty() { return origin; }
        public SimpleStringProperty destinationProperty() { return destination; }
        public SimpleIntegerProperty gateNumberProperty() { return gateNumber; }
        public SimpleIntegerProperty seatCapacityProperty() { return seatCapacity; }
        public SimpleObjectProperty<BigDecimal> priceProperty() { return price; }
        public SimpleStringProperty classTypeProperty() { return classType; }
        public SimpleStringProperty flightDurationProperty() { return flightDuration; }
        public SimpleStringProperty notesProperty() { return notes; }
    }


}

