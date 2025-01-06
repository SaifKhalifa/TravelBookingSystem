package com.groupnine.travelbookingsystem.controller.authentication;

import com.groupnine.travelbookingsystem.MainApplication_DEFAULT;
import com.groupnine.travelbookingsystem.model.userMangment.User;
import com.groupnine.travelbookingsystem.model.userMangment.UserDAOImpl;
import com.groupnine.travelbookingsystem.util.HibernateUtil;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class AccountCreationController {
    public static boolean showLogin = true;
    @FXML
    private TextField nameTextField, usernameTextField, emailTextField, phoneNumberTextField, addressTextField, passwordTextField;

    @FXML
    private ComboBox<String> userRoleComboBox;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel, statusLabel;

    @FXML
    private ImageView passwordToggleIcon, statusIcon;

    @FXML
    private Button passwordToggleButton, createAccountBtn;

    @FXML
    private Group backToLoginBtn;

    @FXML
    private void initialize() {
        if (showLogin) {
            backToLoginBtn.setVisible(true);
        }
        else {
            backToLoginBtn.setVisible(false);
        }

        if(!HibernateUtil.getInstance().isConnected())
        {
            statusLabel.setText("Error connecting to database");
            //statusLabel.setStyle("-fx-text-fill: #FF6B6B;");
            statusIcon.setImage(new Image(getClass().getResource("/com/groupnine/travelbookingsystem/Assets/imgs/auth/disconnected_icon.png").toExternalForm()));
        }
        else{
            statusLabel.setText("Connected to database");
            statusIcon.setImage(new Image(getClass().getResource("/com/groupnine/travelbookingsystem/Assets/imgs/auth/connected_icon.png").toExternalForm()));
        }

        errorLabel.setVisible(false);
        // Sync password fields
        passwordTextField.textProperty().bindBidirectional(passwordField.textProperty());

        // Set toggle button action
        /*passwordToggleButton.setOnMouseClicked(event -> togglePasswordVisibility());*/
        passwordToggleButton.setOnAction(event -> togglePasswordVisibility());
    }

    @FXML
    private void onCreateAccountButtonClick(){

        usernameTextField.setOnMouseClicked(event ->
        {
            errorLabel.setVisible(false);
            //username.clear();
            usernameTextField.selectAll();
        });

        passwordField.setOnMouseClicked(event ->
        {
            errorLabel.setVisible(false);
            //password.clear();
            passwordField.selectAll();
        });

        // Clear previous error messages
        errorLabel.setVisible(true);
        errorLabel.setText("");

        // Retrieve form values
        String name = nameTextField.getText();
        String userName = usernameTextField.getText().trim();
        String email = emailTextField.getText().trim();
        String phone = phoneNumberTextField.getText().trim();
        String address = addressTextField.getText().trim();
        String role = userRoleComboBox.getValue();
        String password = passwordField.getText();

        // Validate the fields
        if (name.isEmpty() || userName.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || role == null || password.isEmpty()) {
            errorLabel.setText("All fields are required!");
            errorLabel.setTextFill(Color.RED);
            return;
        }

        if (!isValidEmail(email)) {
            emailTextField.requestFocus();
            emailTextField.selectAll();
            errorLabel.setText("Invalid email address!");
            errorLabel.setTextFill(Color.RED);
            return;
        }

        if (!isValidPhone(phone)) {
            phoneNumberTextField.requestFocus();
            phoneNumberTextField.selectAll();
            errorLabel.setText("Invalid phone number!");
            errorLabel.setTextFill(Color.RED);
            return;
        }

        if (password.length() < 8) {
            passwordTextField.requestFocus();
            passwordTextField.selectAll();
            errorLabel.setText("Password must be at least 8 characters long!");
            errorLabel.setTextFill(Color.RED);
            return;
        }


        /*
            String address,
            String email,
            String password,
            String phoneNumber,
            String role,
            String username,
            String name
        */
        User user = new User(address, email, password, phone, role, userName, name);
        UserDAOImpl userDAO = new UserDAOImpl();

        switch (userDAO.addUser(user))
        {
            case 1:
                createAccountBtn.setStyle("-fx-background-color: #078f07");
                createAccountBtn.setText("Account Created");
                errorLabel.setVisible(true);
                errorLabel.setText("Account created successfully!");
                errorLabel.setTextFill(Color.GREEN);
                clearForm();

                PauseTransition pause = new PauseTransition(Duration.seconds(2));
                pause.setOnFinished(e -> {
                    createAccountBtn.setStyle("");
                    createAccountBtn.setText("Create Account");
                });
                pause.play();

                break;

            case -1:
                errorLabel.setVisible(true);
                errorLabel.setText("Email already exists.");
                errorLabel.setTextFill(Color.RED);
                break;
            case -2:
                errorLabel.setVisible(true);
                errorLabel.setText("Username already exists.");
                errorLabel.setTextFill(Color.RED);
                break;
            case -3:
                errorLabel.setVisible(true);
                errorLabel.setText("Both username and email already exist.");
                errorLabel.setTextFill(Color.RED);
                break;
            default:
                errorLabel.setVisible(true);
                errorLabel.setText("Unknown error!");
                errorLabel.setTextFill(Color.RED);
                break;
        }
    }

    private boolean isValidEmail(String email) {
        // Basic email validation regex
        String emailRegex = "^[\\w-\\._%+]+@[\\w-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }

    private boolean isValidPhone(String phone) {
        // Check if phone number contains only digits and has a reasonable length
        return phone.matches("\\d{8,15}");
    }

    private void clearForm() {
        nameTextField.clear();
        usernameTextField.clear();
        emailTextField.clear();
        phoneNumberTextField.clear();
        addressTextField.clear();
        userRoleComboBox.setValue(null);
        passwordField.clear();
        errorLabel.setText("");
    }

    private void togglePasswordVisibility() {
        if (passwordField.isVisible()) {
            passwordField.setVisible(false);
            passwordTextField.setVisible(true);
            passwordToggleIcon.setImage(new Image(getClass().getResourceAsStream("/com/groupnine/travelbookingsystem/Assets/imgs/auth/hide-password-logo.png")));
        } else {
            passwordField.setVisible(true);
            passwordTextField.setVisible(false);
            passwordToggleIcon.setImage(new Image(getClass().getResourceAsStream("/com/groupnine/travelbookingsystem/Assets/imgs/auth/show-password-logo.png")));
        }
    }

    @FXML
    public void onBackToLoginButtonClick() {
        MainApplication_DEFAULT.loadScene(
                "/com/groupnine/travelbookingsystem/view/authentication/login.fxml",
                "Login",
                false
        );
    }
}