package com.groupnine.travelbookingsystem.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ResultSearchHotelsController {

    @FXML public AnchorPane card1Background;
    @FXML private Button myBookingButton;
    @FXML private Button profileButton;
    @FXML private Button homeButton;
    @FXML private ComboBox<String> comboBox1;
    @FXML private ComboBox<String> comboBox2;

    @FXML private TextField suggestedStayTextField;
    @FXML private TextField chooseFromTextField;

    @FXML private AnchorPane card1AnchorPane;
    @FXML private ImageView card1ImageView;
    @FXML private TextField card1TitleTextField;
    @FXML private TextField card1RatingTextField;
    @FXML private TextField card1LocationTextField;
    @FXML private TextField card1DetailsTextField;
    @FXML private TextField card1PriceTextField;
    @FXML private Button card1Button;

    @FXML private AnchorPane card2AnchorPane;
    @FXML private ImageView imageView2;
    @FXML private TextField textField1;
    @FXML private TextField ratingTextField2;
    @FXML private TextField locationTextField2;
    @FXML private TextField detailsTextField2;
    @FXML private TextField priceTextField2;
    @FXML private Button button2;

    @FXML private AnchorPane card3AnchorPane;
    @FXML private ImageView imageView3;
    @FXML private TextField textField3;

    // Initializes the controller
    public void initialize() {
        // Initialize ComboBoxes
        comboBox1.getItems().addAll("Flights", "Hotels");
        comboBox2.getItems().addAll("Signup", "Login");

        // Set default values for text fields
        suggestedStayTextField.setText("Suggested Stay");
        chooseFromTextField.setText("Choose From The Top Rated Stays");

        // Example card 1 setup
        setCard1();
        setCard2();
        setCard3();
    }

    private void setCard1() {
        // Set data for card 1
        card1TitleTextField.setText("Big White Village");
        card1RatingTextField.setText("4.7");
        card1LocationTextField.setText("Maui Banayan, HI");
        card1DetailsTextField.setText("6 Max - 5 Rooms - 3 Bathroom");
        card1PriceTextField.setText("145$");

        // Set the image for card 1
        Image card1Image = new Image(getClass().getResourceAsStream("/img/s1.png"));
        card1ImageView.setImage(card1Image);

        // Set button action
        card1Button.setOnAction(event -> handleCard1Button());
    }

    private void setCard2() {
        // Set data for card 2
        textField1.setText("Outstanding House");
        ratingTextField2.setText("4.9");
        locationTextField2.setText("Maui Banayan, HI");
        detailsTextField2.setText("4 Max - 3 Rooms - 2 Bathrooms");
        priceTextField2.setText("140$");

        // Set the image for card 2
        Image card2Image = new Image(getClass().getResourceAsStream("/img/s3.png"));
        imageView2.setImage(card2Image);


        // Set button action
        button2.setOnAction(event -> handleCard2Button());
    }

    private void setCard3() {
        // Set data for card 3
        textField3.setText("Beautiful Escape");
        // Add more details if necessary

        // Set the image for card 3
        Image card3Image = new Image(getClass().getResourceAsStream("/img/s2.png"));
        imageView3.setImage(card3Image);
    }

    // Handle button click for card 1
    private void handleCard1Button() {
        System.out.println("Card 1 button clicked");
        // Implement logic when the user interacts with the button
    }

    // Handle button click for card 2
    private void handleCard2Button() {
        System.out.println("Card 2 button clicked");
        // Implement logic when the user interacts with the button
    }

    // Handle "My Booking" button
    @FXML
    private void handleMyBookingButton() {
        System.out.println("My Booking button clicked");
        // Navigate to My Booking page or show booking details
    }

    // Handle "Profile" button
    @FXML
    private void handleProfileButton() {
        System.out.println("Profile button clicked");
        // Navigate to Profile page or show profile details
    }

    // Handle "Home" button
    @FXML
    private void handleHomeButton() {
        System.out.println("Home button clicked");
        // Navigate to the homepage
    }

    // Handle ComboBox selection changes
    @FXML
    private void handleComboBox1Action() {
        String selectedOption = comboBox1.getValue();
        System.out.println("ComboBox1 selected: " + selectedOption);
        // Implement logic based on selected option
    }

    @FXML
    private void handleComboBox2Action() {
        String selectedOption = comboBox2.getValue();
        System.out.println("ComboBox2 selected: " + selectedOption);
        // Implement logic based on selected option
    }
}
