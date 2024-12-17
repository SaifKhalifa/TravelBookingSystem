package com.groupnine.travelbookingsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class ResultSearchHotelsController {

    @FXML public AnchorPane card1Background;
    public Label flyStayLabel;
    public Slider verticalSlider;
    public Circle card1Circle;
    public ImageView card1PointerImageView;
    public ImageView card1StarImageView;
    public AnchorPane backgroundPane2;
    public Circle circle2;
    public AnchorPane backgroundPane3;
    public TextField ratingTextField3;
    public ImageView pointerImageView3;
    public ImageView starImageView3;
    public TextField locationTextField3;
    public TextField detailsTextField3;
    public TextField priceTextField3;
    public Button button3;
    public AnchorPane card4AnchorPane;
    public ImageView imageView4;
    public AnchorPane backgroundPane4;
    public TextField textField4;
    public TextField ratingTextField4;
    public Circle circle4;
    public ImageView pointerImageView4;
    public TextField locationTextField4;
    public ImageView starImageView4;
    public TextField detailsTextField4;
    public TextField priceTextField4;
    public Button button4;
    public AnchorPane card5AnchorPane;
    public ImageView imageView5;
    public AnchorPane backgroundPane5;
    public TextField textField5;
    public TextField ratingTextField5;
    public ImageView pointerImageView5;
    public ImageView starImageView5;
    public TextField locationTextField5;
    public Button button5;
    public AnchorPane card6AnchorPane;
    public ImageView imageView6;
    public AnchorPane backgroundPane6;
    public ImageView pointerImageView6;
    public ImageView starImageView6;
    public Button button6;
    public Circle circle3;
    public DropShadow dropShadow3;
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
    @FXML private ImageView pointerImageView2;
    @FXML private ImageView starImageView2;

    @FXML private AnchorPane card3AnchorPane;
    @FXML private ImageView imageView3;
    @FXML private TextField textField3;

    // Initializes the controller
    public void initialize() {
        // Initialize ComboBoxes
        comboBox1.getItems().addAll("Flights", "Hotels");
        comboBox2.getItems().addAll("Signup", "Login");

        // Example card 1 setup
        setCard1();
        setCard2();
        setCard3();
        setCard4();
        setCard5();
        setCard6();
    }


    //card 1
    private void setCard1() {
        card1ImageView.setImage(new Image(getClass().getResource("/img/s1.png").toExternalForm()));
        card1PointerImageView.setImage(new Image(getClass().getResource("/img/pointer2.png").toExternalForm()));
        card1StarImageView.setImage(new Image(getClass().getResource("/img/star.png").toExternalForm()));
        // Set button action
        card1Button.setOnAction(event -> handleCard1Button());
    }

    //card2
    private void setCard2() {

        imageView2.setImage(new Image(getClass().getResource("/img/s2.png").toExternalForm()));
        pointerImageView2.setImage(new Image(getClass().getResource("/img/pointer2.png").toExternalForm()));
        starImageView2.setImage(new Image(getClass().getResource("/img/star.png").toExternalForm()));
        // Set button action
        button2.setOnAction(event -> handleCard2Button());

    }

   //card3

    private void setCard3() {
        imageView3.setImage(new Image(getClass().getResource("/img/s3.png").toExternalForm()));
        pointerImageView3.setImage(new Image(getClass().getResource("/img/pointer2.png").toExternalForm()));
        starImageView3.setImage(new Image(getClass().getResource("/img/star.png").toExternalForm()));
        // Set button action
        button3.setOnAction(event -> handleCard3Button());
    }

    //card4
    private void setCard4() {
        imageView4.setImage(new Image(getClass().getResource("/img/s5.jpg").toExternalForm()));
        pointerImageView4.setImage(new Image(getClass().getResource("/img/pointer2.png").toExternalForm()));
        starImageView4.setImage(new Image(getClass().getResource("/img/star.png").toExternalForm()));
        // Set button action
        button4.setOnAction(event -> handleCard4Button());
    }

    //card5
    private void setCard5() {
        imageView5.setImage(new Image(getClass().getResource("/img/s6.jpg").toExternalForm()));
        pointerImageView5.setImage(new Image(getClass().getResource("/img/pointer2.png").toExternalForm()));
        starImageView5.setImage(new Image(getClass().getResource("/img/star.png").toExternalForm()));
        // Set button action
        button5.setOnAction(event -> handleCard5Button());
    }

    //card6
    private void setCard6() {
        imageView6.setImage(new Image(getClass().getResource("/img/s7.jpg").toExternalForm()));
        pointerImageView6.setImage(new Image(getClass().getResource("/img/pointer2.png").toExternalForm()));
        starImageView6.setImage(new Image(getClass().getResource("/img/star.png").toExternalForm()));
        // Set button action
        button6.setOnAction(event -> handleCard6Button());
    }




    /// ////////////////////////////
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

    private void handleCard3Button() {
        System.out.println("Card 1 button clicked");
        // Implement logic when the user interacts with the button
    }

    private void handleCard4Button() {
        System.out.println("Card 1 button clicked");
        // Implement logic when the user interacts with the button
    }

    private void handleCard5Button() {
        System.out.println("Card 1 button clicked");
        // Implement logic when the user interacts with the button
    }

    private void handleCard6Button() {
        System.out.println("Card 1 button clicked");
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
   /* @FXML
    private void handleHomeButton() {
        System.out.println("Home button clicked");
        // Navigate to the homepage
    }*/


   /* @FXML
    private void handleHomeButtonAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication_DEFAULT.class.getResource("/com/groupnine/travelbookingsystem/view/home.fxml"));
            Scene homeScene = new Scene(fxmlLoader.load());
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(homeScene);
            currentStage.setTitle("Home");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*****////



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
