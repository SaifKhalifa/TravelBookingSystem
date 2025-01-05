package com.groupnine.travelbookingsystem.controller.adminPanelHotelController;

import com.groupnine.travelbookingsystem.model.BookingHotel.Hotel;
import com.groupnine.travelbookingsystem.model.BookingHotel.HotelDAOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import java.io.IOException;
import java.util.List;


public class ManageHotelsListController {

    private HotelDAOImpl hotelDAOImp;

    @FXML
    private ToggleButton flightsButton;

    @FXML
    private ToggleButton hotelsButton;

    @FXML
    private Button AddHotelBtn;

    @FXML
    private Button EditHotelBtn;

    @FXML
    private TableView<Hotel> tableView;
    @FXML
    private TableColumn<Hotel, Number> idColumn;
    @FXML
    private TableColumn<Hotel, String> nameColumn;
    @FXML
    private TableColumn<Hotel, String> locationColumn;
    @FXML
    private TableColumn<Hotel, Double> pricePerNightColumn;
    @FXML
    private TableColumn<Hotel, Integer> totalRoomsColumn;
    @FXML
    private TableColumn<Hotel, String> roomTypesColumn;
    @FXML
    private TableColumn<Hotel, String> facilitiesColumn;
    @FXML
    private TableColumn<Hotel, String> amenitiesColumn;
    //    @FXML
//    private TableColumn<Hotel, String> promotionalOffersColumn;
    @FXML
    private TableColumn<Hotel, String> availabilityColumn;
    @FXML
    private TableColumn<Hotel, Number> ratingColumn;
    @FXML
    private TableColumn<Hotel, Void> editColumn;
    @FXML
    private TableColumn<Hotel, Void> deleteColumn;

    @FXML
    public void AddHotelBtn() throws Exception {
        try {
            openHotelInfoPage("Add a Hotel Information", -1);
        } catch (Exception e) {
            e.printStackTrace();  // This will print the error stack trace in the console
        }
    }

    private void addEditButtonToColumn() {
        editColumn.setCellFactory(new Callback<TableColumn<Hotel, Void>, TableCell<Hotel, Void>>() {
            @Override
            public TableCell<Hotel, Void> call(TableColumn<Hotel, Void> param) {
                return new TableCell<Hotel, Void>() {
                    private final Button editButton = new Button("Edit");

                    {
                        editButton.setOnAction(event -> {
                            Hotel hotel = getTableView().getItems().get(getIndex());
                            int hotelId = hotel.getId();  // الحصول على الـ ID للفندق
                            // تنفيذ إجراء التعديل هنا
                            try {
                                openHotelInfoPage("Edit a Hotel Information", hotelId); // افتح صفحة التعديل مع الـ ID
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
                    }

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            HBox box = new HBox(editButton);
                            setGraphic(box);
                        }
                    }
                };
            }
        });
    }

    private void addDeleteButtonToColumn() {
        deleteColumn.setCellFactory(new Callback<TableColumn<Hotel, Void>, TableCell<Hotel, Void>>() {
            @Override
            public TableCell<Hotel, Void> call(TableColumn<Hotel, Void> param) {
                return new TableCell<Hotel, Void>() {
                    private final Button deleteButton = new Button("Delete");

                    {
                        deleteButton.setStyle("-fx-background-color: #d9534f; -fx-text-fill: white;");
                        // إضافة تأثير hover
                        deleteButton.setOnMouseEntered(event -> {
                            deleteButton.setStyle("-fx-background-color: #9e4040; -fx-text-fill: white;");
                        });

                        deleteButton.setOnMouseExited(event -> {
                            deleteButton.setStyle("-fx-background-color: #d9534f; -fx-text-fill: white;");
                        });

                        deleteButton.setOnAction(event -> {
                            Hotel hotel = getTableView().getItems().get(getIndex());
                            int hotelId = hotel.getId();  // الحصول على الـ ID للفندق
                            // تنفيذ إجراء الحذف هنا
                            DeleteHotel(event, hotelId); // الحذف
                        });
                    }

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            HBox box = new HBox(deleteButton);
                            setGraphic(box);
                        }
                    }
                };
            }
        });
    }


    private void openHotelInfoPage(String titleText, int hotelId) throws Exception {

        // تحميل الـ FXML الخاص بالصفحة الثانية
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/adminPanelHotelView/hotelInfo.fxml"));
        BorderPane root = loader.load();

        // الوصول إلى الكنترولر الخاص بالصفحة الثانية
        HotelInfoController hotelInfoController = loader.getController();
        hotelInfoController.setTitleText(titleText); // تمرير العنوان
        hotelInfoController.setMainController(this); // تمرير الكنترولر الرئيسي
        hotelInfoController.setHotelId(hotelId); // تمرير معرف الفندق

        // استبدال الـ Scene على نفس الـ Stage
        Scene secondScene = new Scene(root);
        Stage primaryStage = (Stage) AddHotelBtn.getScene().getWindow();
        primaryStage.setScene(secondScene);
        primaryStage.setTitle("Hotel Information");

        hotelInfoController.setPrimaryStage(primaryStage);
        primaryStage.show();

    }

    public void initialize() {
        hotelDAOImp = new HotelDAOImpl();

        // Create a ToggleGroup to manage the buttons
        ToggleGroup group = new ToggleGroup();
        // Add the buttons to the ToggleGroup
        flightsButton.setToggleGroup(group);
        hotelsButton.setToggleGroup(group);
        hotelsButton.setSelected(true); // You can change this to hotelsButton if needed

        // Get all columns from TableView
        tableView.getColumns().forEach(column -> {
            column.setResizable(true);
        });

        // Optionally, set dynamic width for each column based on the percentage of total width
        double[] columnRatios = {0.05, 0.1, 0.1, 0.08, 0.08, 0.1, 0.101, 0.101, 0.1, 0.05, 0.05, 0.05}; // Total = 100%
        tableView.widthProperty().addListener((observable, oldValue, newValue) -> {
            double tableWidth = newValue.doubleValue();
            for (int i = 0; i < tableView.getColumns().size(); i++) {
                TableColumn<?, ?> column = tableView.getColumns().get(i);
                column.setPrefWidth(tableWidth * columnRatios[i]);
            }
        });


        // Set up each TableColumn with the correct property from the Hotel class
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        pricePerNightColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        totalRoomsColumn.setCellValueFactory(new PropertyValueFactory<>("totalRooms"));

        roomTypesColumn.setCellValueFactory(new PropertyValueFactory<>("roomTypes"));
        roomTypesColumn.setCellFactory(param -> new TableCell<Hotel, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null && !empty) {
                    Text text = new Text(item);
                    // تحديد العرض الذي سيقوم النص بالتفاف عنده
                    double width = roomTypesColumn.getWidth() - 10;  // تحديد العرض بناءً على حجم العمود
                    text.setWrappingWidth(width); // تحديد الحد الذي سيقوم النص بالتفاف عنده
                    text.setTextOrigin(VPos.TOP); // تحديد موضع النص في أعلى الخلية
                    setGraphic(text);  // إضافة الـText إلى الخلية
                } else {
                    setGraphic(null);
                }
            }
        });

//        promotionalOffersColumn.setCellValueFactory(new PropertyValueFactory<>("promotionalOffers"));
        availabilityColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));

        // تعديل facilitiesColumn
        facilitiesColumn.setCellValueFactory(new PropertyValueFactory<>("facilities"));
        facilitiesColumn.setCellFactory(param -> new TableCell<Hotel, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null && !empty) {
                    Text text = new Text(item);
                    // تحديد العرض الذي سيقوم النص بالتفاف عنده
                    double width = facilitiesColumn.getWidth() - 10;  // تحديد العرض بناءً على حجم العمود
                    text.setWrappingWidth(width); // تحديد الحد الذي سيقوم النص بالتفاف عنده
                    text.setTextOrigin(VPos.TOP); // تحديد موضع النص في أعلى الخلية
                    setGraphic(text);  // إضافة الـText إلى الخلية
                } else {
                    setGraphic(null);
                }
            }
        });

// تعديل amenitiesColumn
        amenitiesColumn.setCellValueFactory(new PropertyValueFactory<>("amenities"));
        amenitiesColumn.setCellFactory(param -> new TableCell<Hotel, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null && !empty) {
                    Text text = new Text(item);
                    // تحديد العرض الذي سيقوم النص بالتفاف عنده
                    double width = amenitiesColumn.getWidth() - 10;  // تحديد العرض بناءً على حجم العمود
                    text.setWrappingWidth(width); // تحديد الحد الذي سيقوم النص بالتفاف عنده
                    text.setTextOrigin(VPos.TOP); // تحديد موضع النص في أعلى الخلية
                    setGraphic(text);  // إضافة الـText إلى الخلية
                } else {
                    setGraphic(null);
                }
            }
        });

        addEditButtonToColumn();
        addDeleteButtonToColumn();
// تحميل البيانات
        loadHotels();
    }


    public void DeleteHotel(ActionEvent event, int id) {

        try {
            // Load the FXML for the confirmation popup
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/adminPanelHotelView/hotelConfirmDeletion.fxml"));
            AnchorPane root = loader.load();

            // Get controller for confirmation popup
            HotelConfirmDeletionController confirmController = loader.getController();
            confirmController.setMainController(this);
            // Set ID for hotel to delete in the confirmation popup (pass the hotel ID here)
            confirmController.setHotelId(id);  // Make sure `hotelId` is the ID of the hotel to be deleted

            // Create a new stage for the modal dialog
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); // Makes it a modal
            stage.initStyle(StageStyle.UNDECORATED); // Remove the title bar

            // Get the primary screen bounds (screen width and height)
            Screen screen = Screen.getPrimary();
            double screenWidth = screen.getBounds().getWidth();
            double screenHeight = screen.getBounds().getHeight();

            // Calculate the center of the screen
            stage.setX((screenWidth - 400) / 2); // Center on X, adjusted for the popup size
            stage.setY((screenHeight - 200) / 2); // Center on Y, adjusted for the popup size

            // Set the scene with the loaded FXML content
            Scene scene = new Scene(root);
            stage.setScene(scene);

            // Show the popup
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void loadHotels() {
        List<Hotel> hotelList = hotelDAOImp.getAllHotels(); // جلب البيانات من قاعدة البيانات
        ObservableList<Hotel> observableList = FXCollections.observableArrayList(hotelList);
        tableView.setItems(observableList); // عرض البيانات داخل الجدول
        tableView.refresh();
    }

    public void updateTableView() {
        // تحميل البيانات الجديدة من قاعدة البيانات
        ObservableList<Hotel> hotels = FXCollections.observableArrayList(hotelDAOImp.getAllHotels());
        // تحديث الجدول بالبيانات الجديدة
        tableView.setItems(hotels);
    }

    public void ToFlightsList(ActionEvent event) {
        try {
            NavigationHelper.switchToPage(event, "/com/groupnine/travelbookingsystem/view/AdminMangeFlight/ListFlights.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
