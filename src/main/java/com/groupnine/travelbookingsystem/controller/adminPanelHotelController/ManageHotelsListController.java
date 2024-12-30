package com.groupnine.travelbookingsystem.controller.adminPanelHotelController;

import com.groupnine.travelbookingsystem.model.BookingHotel.Hotel;
import com.groupnine.travelbookingsystem.model.services.HotelDOAImp_reem_deprecated;
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

    private HotelDOAImp_reem_deprecated hotelDOAImp;

    @FXML
    private ToggleButton flightsButton;

    @FXML
    private ToggleButton hotelsButton;

    @FXML
    private Button AddHotelBtn;

    @FXML
    private Button EditHotelBtn;

    @FXML
    private TableView<Hotel_reem_deprecated> tableView;
    @FXML
    private TableColumn<Hotel_reem_deprecated, Number> idColumn;
    @FXML
    private TableColumn<Hotel_reem_deprecated, String> nameColumn;
    @FXML
    private TableColumn<Hotel_reem_deprecated, String> locationColumn;
    @FXML
    private TableColumn<Hotel_reem_deprecated, Double> pricePerNightColumn;
    @FXML
    private TableColumn<Hotel_reem_deprecated, Integer> totalRoomsColumn;
    @FXML
    private TableColumn<Hotel_reem_deprecated, String> roomTypesColumn;
    @FXML
    private TableColumn<Hotel_reem_deprecated, String> facilitiesColumn;
    @FXML
    private TableColumn<Hotel_reem_deprecated, String> amenitiesColumn;
    //    @FXML
//    private TableColumn<Hotel, String> promotionalOffersColumn;
    @FXML
    private TableColumn<Hotel_reem_deprecated, String> availabilityColumn;
    @FXML
    private TableColumn<Hotel_reem_deprecated, Number> ratingColumn;
    @FXML
    private TableColumn<Hotel_reem_deprecated, Void> editColumn;
    @FXML
    private TableColumn<Hotel_reem_deprecated, Void> deleteColumn;

    @FXML
    public void AddHotel() throws Exception {
        try {
            openSecondPage("Add a Hotel Information");
        } catch (Exception e) {
            e.printStackTrace();  // This will print the error stack trace in the console
        }
    }

    @FXML
    public void EditHotel() throws Exception {
        try {
            openSecondPage("Edit a Hotel Information");
        } catch (Exception e) {
            e.printStackTrace();  // This will print the error stack trace in the console
        }
    }

    private void openSecondPage(String titleText) throws Exception {
        // Load the second page's FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/adminPanelHotelView/hotelInfo.fxml"));
        BorderPane root = loader.load();

        // Get the controller of the second page to set the label text
        HotelInfoController hotelInfoController = loader.getController();
        hotelInfoController.setTitleText(titleText); // Pass the title text to the second page controller
        hotelInfoController.setMainController(this);
        // Create a new scene for the second page
        Scene secondScene = new Scene(root);

        // Get the current stage (window) and switch the scene
        Stage primaryStage = (Stage) AddHotelBtn.getScene().getWindow(); // You can also use EditBtn if needed
        primaryStage.setScene(secondScene);

    }

    @FXML
    public void initialize() {
        hotelDOAImp = new HotelDOAImp_reem_deprecated();

        // Create a ToggleGroup to manage the buttons
        ToggleGroup group = new ToggleGroup();
        // Add the buttons to the ToggleGroup
        flightsButton.setToggleGroup(group);
        hotelsButton.setToggleGroup(group);
        hotelsButton.setSelected(true); // You can change this to hotelsButton if needed

        // Get all columns from TableView
        tableView.getColumns().forEach(column -> {
            column.setResizable(true);
            // column.setPrefWidth(100); // Set a default width
        });

        // Optionally, set dynamic width for each column based on the percentage of total width
        double[] columnRatios = {0.05, 0.1, 0.1, 0.08, 0.08, 0.1, 0.101, 0.101 , 0.1, 0.05, 0.05, 0.05}; // Total = 100%
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
        roomTypesColumn.setCellFactory(param -> new TableCell<Hotel_reem_deprecated, String>() {
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
        facilitiesColumn.setCellFactory(param -> new TableCell<Hotel_reem_deprecated, String>() {
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
        amenitiesColumn.setCellFactory(param -> new TableCell<Hotel_reem_deprecated, String>() {
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

    // إضافة زر التعديل في العمود
    private void addEditButtonToColumn() {
        editColumn.setCellFactory(new Callback<TableColumn<Hotel_reem_deprecated, Void>, TableCell<Hotel_reem_deprecated, Void>>() {
            @Override
            public TableCell<Hotel_reem_deprecated, Void> call(TableColumn<Hotel_reem_deprecated, Void> param) {
                return new TableCell<Hotel_reem_deprecated, Void>() {
                    private final Button editButton = new Button("Edit");

                    {
                        editButton.setOnAction(event -> {
                            Hotel_reem_deprecated hotel = getTableView().getItems().get(getIndex());

                            // تنفيذ إجراء التعديل هنا
                            try {
                                EditHotel(); // فتح صفحة التعديل
                            } catch (Exception e) {
                                throw new RuntimeException(e);
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

    // إضافة زر الحذف في العمود
    private void addDeleteButtonToColumn() {
        deleteColumn.setCellFactory(new Callback<TableColumn<Hotel_reem_deprecated, Void>, TableCell<Hotel_reem_deprecated, Void>>() {
            @Override
            public TableCell<Hotel_reem_deprecated, Void> call(TableColumn<Hotel_reem_deprecated, Void> param) {
                return new TableCell<Hotel_reem_deprecated, Void>() {
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
                            Hotel_reem_deprecated hotel = getTableView().getItems().get(getIndex());
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


    private void loadHotels() {
        List<Hotel> hotelList = hotelDOAImp.getAllHotels(); // جلب البيانات من قاعدة البيانات
        ObservableList<Hotel                                                            > observableList = FXCollections.observableArrayList(hotelList);
        tableView.setItems(observableList); // عرض البيانات داخل الجدول
        tableView.refresh();
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

    public void updateTableView() {
        // تحميل البيانات الجديدة من قاعدة البيانات
        ObservableList<Hotel> hotels = FXCollections.observableArrayList(hotelDOAImp.getAllHotels());

        // تحديث الجدول بالبيانات الجديدة
        tableView.setItems(hotels);  // تأكد من أن لديك جدول يسمى hotelTable
    }

    public void ToFlightsList(ActionEvent event) {
        try {
            NavigationHelper.switchToPage(event, "/com/groupnine/travelbookingsystem/view/AdminMangeFlight/ListFlights.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
