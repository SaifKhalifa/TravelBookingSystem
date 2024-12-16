package com.groupnine.travelbookingsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HotelController {

    @FXML private ImageView starsImage;
    @FXML private Label hotelTitle;
    @FXML private ImageView hotelImage;
    @FXML private ImageView emptyImage1;
    @FXML private ImageView emptyImage2;
    @FXML private ImageView emptyImage3;
    @FXML private ImageView emptyImage4;
    @FXML private VBox aboutHotelBox;
    @FXML private Label aboutHotelLabel;
    @FXML private Label hotelDescription;
    @FXML private VBox amenityBox;
    @FXML private Label amenityLabel;
    @FXML private HBox firstAmenityRow;
    @FXML private Label swimmingPoolLabel;
    @FXML private Label spaLabel;
    @FXML private Label barLabel;
    @FXML private Label restaurantLabel;
    @FXML private HBox secondAmenityRow;
    @FXML private Label breakfastLabel;
    @FXML private Label wifiLabel;
    @FXML private Label roomServiceLabel;
    @FXML private HBox thirdAmenityRow;
    @FXML private Label coastalLabel;
    @FXML private Label fitnessLabel;
    @FXML private Label airportShuttleLabel;
    @FXML private Button bookNowButton;

    @FXML
    public void handleBookNowButton() {
        System.out.println("Button clicked: Booking now!");

        // فتح نافذة جديدة (الصفحة المنبثقة) عند الضغط على الزر
        try {
            // تحميل الصفحة المنبثقة
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/BookingHotel.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));

            // إظهار النافذة المنبثقة
            stage.setTitle("Booking Hotel");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            // معالجة الأخطاء إذا حدثت أثناء تحميل الصفحة المنبثقة
        }
    }

    @FXML
    public void initialize() {
        hotelTitle.setText("Condo To The Beach");
        hotelDescription.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        swimmingPoolLabel.setText("Open Pool");
        spaLabel.setText("SPA Center");
        barLabel.setText("Bar");
        restaurantLabel.setText("Restaurant");
        breakfastLabel.setText("Breakfast Included");
        wifiLabel.setText("Wi-Fi");
        roomServiceLabel.setText("Room Service");
        coastalLabel.setText("First Coastal");
        fitnessLabel.setText("Fitness Center");
        airportShuttleLabel.setText("Airport Shuttle");

        bookNowButton.setOnAction(event -> handleBookNowButton());
    }
}
