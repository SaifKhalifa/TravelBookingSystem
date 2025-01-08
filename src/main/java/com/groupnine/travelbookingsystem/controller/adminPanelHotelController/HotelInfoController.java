package com.groupnine.travelbookingsystem.controller.adminPanelHotelController;

import com.groupnine.travelbookingsystem.model.hotel.Hotel;
import com.groupnine.travelbookingsystem.model.hotel.HotelDAOImpl;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.*;

import java.io.IOException;

import javafx.scene.image.Image;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HotelInfoController {

    private HotelDAOImpl hotelDOAImp = new HotelDAOImpl();
    @FXML
    private Label TitleInfo;
    @FXML
    private TextField HotelName;
    @FXML
    private TextField Location;
    @FXML
    private TextField Price;
    @FXML
    private TextField TotalRooms;
    @FXML
    private Label star1;
    @FXML
    private Label star2;
    @FXML
    private Label star3;
    @FXML
    private Label star4;
    @FXML
    private Label star5;
    @FXML
    private TextArea Description;
    @FXML
    private CheckBox SingleRoom;
    @FXML
    private CheckBox DoubleRoom;
    @FXML
    private CheckBox TwinRoom;
    @FXML
    private CheckBox TripleRoom;
    @FXML
    private CheckBox DeluxeRoom;
    @FXML
    private CheckBox FamilyRoom;
    @FXML
    private CheckBox Villa;
    @FXML
    private CheckBox Bungalow;
    @FXML
    private TextField PromotionalOffers;
    @FXML
    private ComboBox<String> AvailabilityComboBox;
    @FXML
    private CheckBox Garden;
    @FXML
    private CheckBox Restaurant;
    @FXML
    private CheckBox Lounge;
    @FXML
    private CheckBox BusinessCenter;
    @FXML
    private CheckBox MeetingRooms;
    @FXML
    private CheckBox SwimmingPool;
    @FXML
    private CheckBox GymFitnessCenter;
    @FXML
    private CheckBox KidsPlayArea;
    @FXML
    private CheckBox TennisCourt;
    @FXML
    private CheckBox Parking;
    @FXML
    private CheckBox AirConditioning;
    @FXML
    private CheckBox FreeWiFi;
    @FXML
    private CheckBox Television;
    @FXML
    private CheckBox CoffeTeaMaker;
    @FXML
    private CheckBox HairDryer;
    @FXML
    private CheckBox DeskWorkspace;
    @FXML
    private CheckBox FreeBreakfast;
    @FXML
    private CheckBox BottledWater;
    @FXML
    private CheckBox PremiumBedding;
    @FXML
    private CheckBox BathrobeSlippers;
    @FXML
    private Button uploadPhotoButton;
    @FXML
    private GridPane GridPhotos;
    @FXML
    private Button SaveButton;
    @FXML
    private int currentRating = 0; // Store the current rating (1-5)
    @FXML
    private Label nameErrorLabel;
    @FXML
    private Label descriptionErrorLabel;
    @FXML
    private Label priceErrorLabel;
    @FXML
    private Label totalRoomsErrorLabel;
    @FXML
    private Label locationErrorLabel;
    @FXML
    private Label photoErrorLabel;
    @FXML
    private Label promotionalOffersErrorLabel;

    private List<String> photoPaths = new ArrayList<>();
    private ManageHotelsListController manageHotelsListController;  // مرجع للكونترولر الذي يحتوي على الجدول
    private int hotelId;

    @FXML
    public void BackToHotelsList(ActionEvent event) {
        try {
            NavigationHelper.switchToPage(event, "/com/groupnine/travelbookingsystem/view/adminPanelHotelView/manageHotelsList.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void SaveHotelInfoBtn() throws Exception {
        if (TitleInfo.getText().equals("Add a Hotel Information")) {
            if (saveHotelToDatabase()) {
               // SetLabelText("Hotel Added to the System Successfully!");
                showAlert("Success", "Hotel has been added successfully.", Alert.AlertType.INFORMATION);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/adminPanelHotelView/manageHotelsList.fxml"));
                BorderPane root = loader.load();
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.setTitle("Hotels List");
                primaryStage.show();
                if (manageHotelsListController != null) {
                    manageHotelsListController.updateTableView(); // Refresh the table
                    System.out.println("Controller is notNull. Table refreshed.");
                } else {
                    System.err.println("Controller is null. Table cannot be refreshed.");
                }

            }
        } else {

            if (updateHotelInDatabase(hotelId)) // check if the data modified
               // SetLabelText("Hotel Information Updated Successfully!");
            showAlert("Success", "Hotel has been updated successfully.", Alert.AlertType.INFORMATION);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/adminPanelHotelView/manageHotelsList.fxml"));
            BorderPane root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Hotels List");
            primaryStage.show();
            if (manageHotelsListController != null) {
                manageHotelsListController.updateTableView(); // Refresh the table
                System.out.println("Controller is notNull. Table refreshed.");
            } else {
                System.err.println("Controller is null. Table cannot be refreshed.");
            }
        }
    }

    public void initialize() {
        // Set default selection if needed
        AvailabilityComboBox.getSelectionModel().select("Available");

        // Handle item selection change
        AvailabilityComboBox.setOnAction(event -> {
            String selectedAvailability = AvailabilityComboBox.getSelectionModel().getSelectedItem();
        });
        // Add click event listeners to each star
        star1.setOnMouseClicked(event -> updateRating(1));
        star2.setOnMouseClicked(event -> updateRating(2));
        star3.setOnMouseClicked(event -> updateRating(3));
        star4.setOnMouseClicked(event -> updateRating(4));
        star5.setOnMouseClicked(event -> updateRating(5));

        // Name Field Listener
        HotelName.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) { // Focus lost
                if (HotelName.getText().trim().isEmpty()) {
                    nameErrorLabel.setText("Name is required!");
                    nameErrorLabel.setVisible(true);
                    HotelName.setStyle("-fx-border-color: red");
                }
            } else { // Focus gained
                nameErrorLabel.setVisible(false);
                HotelName.setStyle("");
            }
        });

        HotelName.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.trim().isEmpty()) { // While typing
                nameErrorLabel.setVisible(false);
                HotelName.setStyle("");
            }
        });

        // Description Field Listener
        Description.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal && Description.getText().trim().isEmpty()) {
                descriptionErrorLabel.setText("Description is required!");
                descriptionErrorLabel.setVisible(true);
                Description.setStyle("-fx-border-color: red");
            } else {
                descriptionErrorLabel.setVisible(false);
                Description.setStyle("");
            }
        });

        Description.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.trim().isEmpty()) {
                descriptionErrorLabel.setVisible(false);
                Description.setStyle("");
            }
        });

        // Price Field Listener
        Price.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal && (Price.getText().trim().isEmpty() || !isPositiveDouble(Price.getText()))) {
                priceErrorLabel.setText("Price must be a positive number!");
                priceErrorLabel.setVisible(true);
                Price.setStyle("-fx-border-color: red");
            } else {
                priceErrorLabel.setVisible(false);
                Price.setStyle("");
            }
        });

        Price.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.trim().isEmpty() && isPositiveDouble(newValue)) {
                priceErrorLabel.setVisible(false);
                Price.setStyle("");
            }
        });

        // Total Rooms Field Listener
        TotalRooms.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal && (TotalRooms.getText().trim().isEmpty() || !isPositiveInteger(TotalRooms.getText()))) {
                totalRoomsErrorLabel.setText("Total rooms must be a positive number!");
                totalRoomsErrorLabel.setVisible(true);
                TotalRooms.setStyle("-fx-border-color: red");
            } else {
                totalRoomsErrorLabel.setVisible(false);
                TotalRooms.setStyle("");
            }
        });

        TotalRooms.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.trim().isEmpty() && isPositiveInteger(newValue)) {
                totalRoomsErrorLabel.setVisible(false);
                TotalRooms.setStyle("");
            }
        });

        // Location Field Listener
        Location.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal && Location.getText().trim().isEmpty()) {
                locationErrorLabel.setText("Location is required!");
                locationErrorLabel.setVisible(true);
                Location.setStyle("-fx-border-color: red");
            } else {
                locationErrorLabel.setVisible(false);
                Location.setStyle("");
            }
        });

        Location.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.trim().isEmpty()) {
                locationErrorLabel.setVisible(false);
                Location.setStyle("");
            }
        });

        // Promotional Offers Field Listener
        PromotionalOffers.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal && PromotionalOffers.getText().trim().isEmpty()) {
                promotionalOffersErrorLabel.setText("Promotional Offers is required!");
                promotionalOffersErrorLabel.setVisible(true);
                PromotionalOffers.setStyle("-fx-border-color: red");
            } else {
                promotionalOffersErrorLabel.setVisible(false);
                PromotionalOffers.setStyle("");
            }
        });

        PromotionalOffers.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.trim().isEmpty()) {
                promotionalOffersErrorLabel.setVisible(false);
                PromotionalOffers.setStyle("");
            }
        });

        // Listener for image changes in GridPhotos
        GridPhotos.getChildren().addListener((ListChangeListener<Node>) change -> {
            boolean hasImage = false;

            // Check if any ImageView in the GridPane contains an image
            for (Node node : GridPhotos.getChildren()) {
                if (node instanceof ImageView) {
                    ImageView imageView = (ImageView) node;
                    if (imageView.getImage() != null) { // Check if the image exists
                        hasImage = true;
                        break; // Exit loop once an image is found
                    }
                }
            }

            // Update the error label and button style based on validation
            if (hasImage) {
                photoErrorLabel.setVisible(false); // Hide error
                uploadPhotoButton.setStyle("");    // Reset button style
            } else {
                photoErrorLabel.setText("At least one image is required!");
                photoErrorLabel.setVisible(true);  // Show error
                uploadPhotoButton.setStyle("-fx-border-color: red");
            }
        });

    }

    // Method to set the title text from Hotel list page
    public void setTitleText(String titleText) {
        if (TitleInfo != null) {
            TitleInfo.setText(titleText);
        } else {
            System.out.println("Error: Label not initialized properly.");
        }
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // دالة لتعيين مرجع الـ controller الرئيسي (الذي يحتوي على الجدول)
    public void setMainController(ManageHotelsListController manageHotelsListController) {
        this.manageHotelsListController = manageHotelsListController;
    }

    private boolean checkValidation() {
        boolean isValid = true;
//        // التحقق من حقل الاسم
        if (HotelName.getText().trim().isEmpty()) {
            nameErrorLabel.setText("Name is required!");
            nameErrorLabel.setVisible(true);
            HotelName.setStyle("-fx-border-color: red");
            isValid = false;
        } else {
            nameErrorLabel.setVisible(false);
            HotelName.setStyle("");
        }
        // التحقق من حقل الوصف
        if (Description.getText().trim().isEmpty()) {
            descriptionErrorLabel.setText("Description is required!");
            descriptionErrorLabel.setVisible(true);
            Description.setStyle("-fx-border-color: red");
            isValid = false;
        } else {
            descriptionErrorLabel.setVisible(false);
            Description.setStyle("");
        }

        // التحقق من حقل السعر
        try {
            if (Price.getText().trim().isEmpty() || Double.parseDouble(Price.getText()) <= 0) {
                priceErrorLabel.setText("Price must be a positive number!");
                priceErrorLabel.setVisible(true);
                Price.setStyle("-fx-border-color: red");
                isValid = false;
            } else {
                priceErrorLabel.setVisible(false);
                Price.setStyle("");
            }
        } catch (NumberFormatException e) {
            priceErrorLabel.setText("Invalid price!");
            priceErrorLabel.setVisible(true);
            isValid = false;
        }

        // التحقق من حقل عدد الغرف
        try {
            if (TotalRooms.getText().trim().isEmpty() || Integer.parseInt(TotalRooms.getText()) <= 0) {
                totalRoomsErrorLabel.setText("Total rooms must be a positive number!");
                totalRoomsErrorLabel.setVisible(true);
                TotalRooms.setStyle("-fx-border-color: red");
                isValid = false;
            } else {
                totalRoomsErrorLabel.setVisible(false);
                TotalRooms.setStyle("");
            }
        } catch (NumberFormatException e) {
            totalRoomsErrorLabel.setText("Invalid number of rooms!");
            totalRoomsErrorLabel.setVisible(true);
            isValid = false;
        }

        // التحقق من حقل الموقع
        if (Location.getText().trim().isEmpty()) {
            locationErrorLabel.setText("Location is required!");
            locationErrorLabel.setVisible(true);
            Location.setStyle("-fx-border-color: red");
            isValid = false;
        } else {
            locationErrorLabel.setVisible(false);
            Location.setStyle("");
        }


        if (PromotionalOffers.getText().trim().isEmpty()) {
            promotionalOffersErrorLabel.setText("Promotional Offers is required!");
            promotionalOffersErrorLabel.setVisible(true);
            PromotionalOffers.setStyle("-fx-border-color: red");
            isValid = false;
        } else {
            promotionalOffersErrorLabel.setVisible(false);
            PromotionalOffers.setStyle("");
        }
        // Validate if the GridPane has any images
        boolean hasImage = false;

        // Loop through all children in the GridPane
        for (Node node : GridPhotos.getChildren()) {
            if (node instanceof ImageView) { // Check if the node is an ImageView
                ImageView imageView = (ImageView) node;
                if (imageView.getImage() != null) { // Check if the ImageView has an image
                    hasImage = true;
                    break; // Exit the loop once an image is found
                }
            }
        }
        // Handle validation result
        if (!hasImage) {
            photoErrorLabel.setText("At least one image is required!");
            photoErrorLabel.setVisible(true);
            uploadPhotoButton.setStyle("-fx-border-color: red"); // Highlight button in red
            isValid = false;
        } else {
            photoErrorLabel.setVisible(false); // Hide error if valid
            uploadPhotoButton.setStyle("");    // Reset button style
        }
        return isValid;
    }

    private boolean saveHotelToDatabase() {

        boolean isValid = checkValidation();

        // إذا كانت جميع الحقول صحيحة، إضافة الفندق إلى قاعدة البيانات
        if (isValid) {
            Hotel hotel = new Hotel();
            hotel.setName(HotelName.getText());
            hotel.setLocation(Location.getText());
            hotel.setPrice(Double.parseDouble(Price.getText()));
            hotel.setTotalRooms(Integer.parseInt(TotalRooms.getText()));
            hotel.setDescription(Description.getText());
            hotel.setPromotionalOffers(PromotionalOffers.getText());
            hotel.setAvailability(AvailabilityComboBox.getValue());
            hotel.setRating(currentRating);

            List<String> selectedRoomTypes = new ArrayList<>();
            if (SingleRoom.isSelected()) selectedRoomTypes.add("Single Room");
            if (DoubleRoom.isSelected()) selectedRoomTypes.add("Double Room");
            if (TwinRoom.isSelected()) selectedRoomTypes.add("Twin Room");
            if (TripleRoom.isSelected()) selectedRoomTypes.add("Triple Room");
            if (DeluxeRoom.isSelected()) selectedRoomTypes.add("Deluxe Room");
            if (FamilyRoom.isSelected()) selectedRoomTypes.add("Family Room");
            if (Villa.isSelected()) selectedRoomTypes.add("Villa");
            if (Bungalow.isSelected()) selectedRoomTypes.add("Bungalow");

            // Convert List<String> to a comma-separated String
            String roomTypesString = String.join(",", selectedRoomTypes);
            hotel.setRoomTypes(roomTypesString);

            // Add the selected checkboxes to the hotel object
            List<String> selectedFacilities = new ArrayList<>();
            if (Garden.isSelected()) selectedFacilities.add("Garden");
            if (Restaurant.isSelected()) selectedFacilities.add("Restaurant");
            if (Lounge.isSelected()) selectedFacilities.add("Lounge");
            if (BusinessCenter.isSelected()) selectedFacilities.add("Business Center");
            if (MeetingRooms.isSelected()) selectedFacilities.add("Meeting Rooms");
            if (SwimmingPool.isSelected()) selectedFacilities.add("Swimming Pool");
            if (GymFitnessCenter.isSelected()) selectedFacilities.add("Gym/Fitness Center");
            if (KidsPlayArea.isSelected()) selectedFacilities.add("Kids Play Area");
            if (TennisCourt.isSelected()) selectedFacilities.add("Tennis Court");
            if (Parking.isSelected()) selectedFacilities.add("Parking");
            String FacilitiesString = String.join(",", selectedFacilities);
            hotel.setFacilities(FacilitiesString);

            List<String> selectedAmenities = new ArrayList<>();
            if (AirConditioning.isSelected()) selectedAmenities.add("Air Conditioning");
            if (FreeWiFi.isSelected()) selectedAmenities.add("Free WiFi");
            if (Television.isSelected()) selectedAmenities.add("Television");
            if (CoffeTeaMaker.isSelected()) selectedAmenities.add("Coffee/Tea Maker");
            if (HairDryer.isSelected()) selectedAmenities.add("Hair Dryer");
            if (DeskWorkspace.isSelected()) selectedAmenities.add("Desk/Workspace");
            if (FreeBreakfast.isSelected()) selectedAmenities.add("Free Breakfast");
            if (BottledWater.isSelected()) selectedAmenities.add("Bottled Water");
            if (PremiumBedding.isSelected()) selectedAmenities.add("Premium Bedding");
            if (BathrobeSlippers.isSelected()) selectedAmenities.add("Bathrobe/Slippers");
            String AmenitiesString = String.join(",", selectedAmenities);
            hotel.setAmenities(AmenitiesString);

            // Set the photos collected earlier
            hotel.setPhotoPath(String.join(",", photoPaths));

            hotelDOAImp.addHotel(hotel);


        }
        return isValid;
    }

    private boolean updateHotelInDatabase(int hotelId) {

        boolean isValid = checkValidation();
        if (isValid) {
            HotelDAOImpl hotelDAO = new HotelDAOImpl();
            Hotel hotel = hotelDAO.getHotelById(hotelId);

            hotel.setName(HotelName.getText());
            hotel.setLocation(Location.getText());
            hotel.setPrice(Double.parseDouble(Price.getText()));
            hotel.setTotalRooms(Integer.parseInt(TotalRooms.getText()));
            hotel.setDescription(Description.getText());
            hotel.setPromotionalOffers(PromotionalOffers.getText());
            hotel.setAvailability(AvailabilityComboBox.getValue());
            hotel.setRating(currentRating);

            List<String> selectedRoomTypes = new ArrayList<>();
            if (SingleRoom.isSelected()) selectedRoomTypes.add("Single Room");
            if (DoubleRoom.isSelected()) selectedRoomTypes.add("Double Room");
            if (TwinRoom.isSelected()) selectedRoomTypes.add("Twin Room");
            if (TripleRoom.isSelected()) selectedRoomTypes.add("Triple Room");
            if (DeluxeRoom.isSelected()) selectedRoomTypes.add("Deluxe Room");
            if (FamilyRoom.isSelected()) selectedRoomTypes.add("Family Room");
            if (Villa.isSelected()) selectedRoomTypes.add("Villa");
            if (Bungalow.isSelected()) selectedRoomTypes.add("Bungalow");

            // Convert List<String> to a comma-separated String
            String roomTypesString = String.join(",", selectedRoomTypes);
            hotel.setRoomTypes(roomTypesString);

            // Add the selected checkboxes to the hotel object
            List<String> selectedFacilities = new ArrayList<>();
            if (Garden.isSelected()) selectedFacilities.add("Garden");
            if (Restaurant.isSelected()) selectedFacilities.add("Restaurant");
            if (Lounge.isSelected()) selectedFacilities.add("Lounge");
            if (BusinessCenter.isSelected()) selectedFacilities.add("Business Center");
            if (MeetingRooms.isSelected()) selectedFacilities.add("Meeting Rooms");
            if (SwimmingPool.isSelected()) selectedFacilities.add("Swimming Pool");
            if (GymFitnessCenter.isSelected()) selectedFacilities.add("Gym/Fitness Center");
            if (KidsPlayArea.isSelected()) selectedFacilities.add("Kids Play Area");
            if (TennisCourt.isSelected()) selectedFacilities.add("Tennis Court");
            if (Parking.isSelected()) selectedFacilities.add("Parking");
            String FacilitiesString = String.join(",", selectedFacilities);
            hotel.setFacilities(FacilitiesString);

            List<String> selectedAmenities = new ArrayList<>();
            if (AirConditioning.isSelected()) selectedAmenities.add("Air Conditioning");
            if (FreeWiFi.isSelected()) selectedAmenities.add("Free WiFi");
            if (Television.isSelected()) selectedAmenities.add("Television");
            if (CoffeTeaMaker.isSelected()) selectedAmenities.add("Coffee/Tea Maker");
            if (HairDryer.isSelected()) selectedAmenities.add("Hair Dryer");
            if (DeskWorkspace.isSelected()) selectedAmenities.add("Desk/Workspace");
            if (FreeBreakfast.isSelected()) selectedAmenities.add("Free Breakfast");
            if (BottledWater.isSelected()) selectedAmenities.add("Bottled Water");
            if (PremiumBedding.isSelected()) selectedAmenities.add("Premium Bedding");
            if (BathrobeSlippers.isSelected()) selectedAmenities.add("Bathrobe/Slippers");
            String AmenitiesString = String.join(",", selectedAmenities);
            hotel.setAmenities(AmenitiesString);

            hotel.setPhotoPath(String.join(",", photoPaths));

            hotelDAO.updateHotel(hotel);

        }
        return isValid;
    }

    private void loadHotelPhotos(int hotelId) {
        HotelDAOImpl hotelDAO = new HotelDAOImpl();
        Hotel hotel = hotelDAO.getHotelById(hotelId);

        if (hotel != null && hotel.getPhotoPath() != null && !hotel.getPhotoPath().isEmpty()) {
            GridPhotos.getChildren().clear();
            int row = 0;
            int column = 0;


            try {
                // تقسيم النصوص المخزنة في photos إلى قائمة مسارات
                String[] photoPaths = hotel.getPhotoPath().split(",");

                for (String path : photoPaths) {
                    if (row > 2) break; // الحد الأقصى 3 صفوف

                    path = path.trim();
                    System.out.println("Loading image from path: " + path); // تحقق من المسار

                    try {
                        Image image = new Image(path, true); // true لتحميل الصورة بشكل آمن
                        if (image.isError()) {
                            System.out.println("Failed to load image: " + path);
                            continue; // تجاوز الصورة المعطوبة
                        }

                        ImageView imageView = new ImageView(image);
                        imageView.setFitWidth(100);
                        imageView.setFitHeight(100);
                        imageView.setPreserveRatio(true);

                        GridPhotos.add(imageView, column, row);

                        column++;
                        if (column > 2) { // الانتقال إلى الصف التالي بعد 3 أعمدة
                            column = 0;
                            row++;
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid image path: " + path);
                    }
                }

                System.out.println("Photos loaded successfully!");
            } catch (Exception e) {
                System.out.println("Failed to load photos: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("No photos found for this hotel!");
        }
    }

    // Setter method to receive hotel ID from the Hotel list page
    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
        if (hotelId == -1) {
            System.out.println("Hotel id is add page!");
        } else
            loadHotelData();
    }

    private void loadHotelData() {
        HotelDAOImpl hotelDAO = new HotelDAOImpl();
        Hotel hotel;
        hotel = hotelDAO.getHotelById(hotelId);

        if (hotel != null) {
            try {
                HotelName.setText(hotel.getName());
                Location.setText(hotel.getLocation());
                Price.setText(String.valueOf(hotel.getPrice()));
                TotalRooms.setText(String.valueOf(hotel.getTotalRooms()));
                PromotionalOffers.setText(hotel.getPromotionalOffers());
                Description.setText(hotel.getDescription());
                AvailabilityComboBox.setValue(hotel.getAvailability());
                updateRating(hotel.getRating());

                // Load Room Types
                String[] roomTypes = hotel.getRoomTypes().split(",");
                SingleRoom.setSelected(Arrays.asList(roomTypes).contains("Single Room"));
                DoubleRoom.setSelected(Arrays.asList(roomTypes).contains("Double Room"));
                TwinRoom.setSelected(Arrays.asList(roomTypes).contains("Twin Room"));
                TripleRoom.setSelected(Arrays.asList(roomTypes).contains("Triple Room"));
                DeluxeRoom.setSelected(Arrays.asList(roomTypes).contains("Deluxe Room"));
                FamilyRoom.setSelected(Arrays.asList(roomTypes).contains("Family Room"));
                Villa.setSelected(Arrays.asList(roomTypes).contains("Villa"));
                Bungalow.setSelected(Arrays.asList(roomTypes).contains("Bungalow"));

                // Load Facilities
                String[] facilities = hotel.getFacilities().split(",");
                Garden.setSelected(Arrays.asList(facilities).contains("Garden"));
                Restaurant.setSelected(Arrays.asList(facilities).contains("Restaurant"));
                Lounge.setSelected(Arrays.asList(facilities).contains("Lounge"));
                BusinessCenter.setSelected(Arrays.asList(facilities).contains("Business Center"));
                MeetingRooms.setSelected(Arrays.asList(facilities).contains("Meeting Rooms"));
                SwimmingPool.setSelected(Arrays.asList(facilities).contains("Swimming Pool"));
                GymFitnessCenter.setSelected(Arrays.asList(facilities).contains("Gym/Fitness Center"));
                KidsPlayArea.setSelected(Arrays.asList(facilities).contains("Kids Play Area"));
                TennisCourt.setSelected(Arrays.asList(facilities).contains("Tennis Court"));
                Parking.setSelected(Arrays.asList(facilities).contains("Parking"));

                // Load Amenities
                String[] amenities = hotel.getAmenities().split(",");
                AirConditioning.setSelected(Arrays.asList(amenities).contains("Air Conditioning"));
                FreeWiFi.setSelected(Arrays.asList(amenities).contains("Free WiFi"));
                Television.setSelected(Arrays.asList(amenities).contains("Television"));
                CoffeTeaMaker.setSelected(Arrays.asList(amenities).contains("Coffee/Tea Maker"));
                HairDryer.setSelected(Arrays.asList(amenities).contains("Hair Dryer"));
                DeskWorkspace.setSelected(Arrays.asList(amenities).contains("Desk/Workspace"));
                FreeBreakfast.setSelected(Arrays.asList(amenities).contains("Free Breakfast"));
                BottledWater.setSelected(Arrays.asList(amenities).contains("Bottled Water"));
                PremiumBedding.setSelected(Arrays.asList(amenities).contains("Premium Bedding"));
                BathrobeSlippers.setSelected(Arrays.asList(amenities).contains("Bathrobe/Slippers"));
                loadHotelPhotos(hotelId);

                System.out.println("Hotel data successfully loaded into the UI!");
            } catch (Exception e) {
                System.out.println("Failed to load hotel data: " + e.getMessage());
            }
        } else {
            System.out.println("Hotel not found!");
        }
    }

    private boolean isPositiveDouble(String text) {
        try {
            return Double.parseDouble(text) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isPositiveInteger(String text) {
        try {
            return Integer.parseInt(text) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void updateRating(int rating) {
        currentRating = rating;
        resetStars();
        // Highlight stars according to the current rating
        if (rating >= 1) star1.setStyle("-fx-text-fill: #FFD700;"); // Gold color
        if (rating >= 2) star2.setStyle("-fx-text-fill: #FFD700;");
        if (rating >= 3) star3.setStyle("-fx-text-fill: #FFD700;");
        if (rating >= 4) star4.setStyle("-fx-text-fill: #FFD700;");
        if (rating >= 5) star5.setStyle("-fx-text-fill: #FFD700;");

    }

    private void resetStars() {
        star1.setStyle("-fx-text-fill: #cccccc;"); // Gray color for unselected
        star2.setStyle("-fx-text-fill: #cccccc;");
        star3.setStyle("-fx-text-fill: #cccccc;");
        star4.setStyle("-fx-text-fill: #cccccc;");
        star5.setStyle("-fx-text-fill: #cccccc;");
    }

    @FXML
    public void onUploadPhotoButtonClick() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );
        List<File> files = fileChooser.showOpenMultipleDialog(null);

        if (files != null) {
            GridPhotos.getChildren().clear();
            int row = 0;
            int column = 0;

            photoPaths.clear();  // Clear previous photo paths

            for (File file : files) {
                if (row > 2) break;

                Image image = new Image(file.toURI().toString());
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(100);
                imageView.setFitHeight(100);
                imageView.setPreserveRatio(true);

                GridPhotos.add(imageView, column, row);
                photoPaths.add(file.toURI().toString());  // Add path to the list

                column++;
                if (column > 2) {
                    column = 0;
                    row++;
                }
            }
        }
    }

    @FXML
    public void GoBackIcon(MouseEvent event) {
        try {
            ActionEvent actionEvent = new ActionEvent(event.getSource(), null);
            NavigationHelper.switchToPage(actionEvent, "/com/groupnine/travelbookingsystem/view/adminPanelHotelView/manageHotelsList.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}