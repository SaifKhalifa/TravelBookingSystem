package com.groupnine.travelbookingsystem.controller.authentication;

import com.groupnine.travelbookingsystem.MainApplication_DEFAULT;
import com.groupnine.travelbookingsystem.model.userMangment.User;
import com.groupnine.travelbookingsystem.model.userMangment.UserDAO;
import com.groupnine.travelbookingsystem.model.userMangment.UserDAOImpl;
import com.groupnine.travelbookingsystem.util.HibernateUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

public class LoginController {
    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField passwordTextField, usernameTextField;

    @FXML
    private ImageView passwordToggleIcon, statusIcon;

    @FXML
    private Button passwordToggleButton;

    @FXML
    private Label statusLabel, errorLabel;

    private final UserDAO userDAO = new UserDAOImpl();

    @FXML
    private void initialize() {
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
    private void onLoginButtonClick()
    {
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

        if(usernameTextField.getText().isEmpty() || passwordField.getText().isEmpty())
        {
            errorLabel.setVisible(true);
            errorLabel.setText("Username and password are required!");
        }
        else
        {
            User user = userDAO.getUserByUsername(usernameTextField.getText());

            if (user != null)
            {
                if(user.getPassword().equals(passwordField.getText())) {
                    errorLabel.setVisible(false);
                    statusLabel.setText("Success, Welcome " + user.getUsername() + "!, Loading app...");
                    userDAO.updateLastLogin(usernameTextField.getText());
                    user.setLastLogin(LocalDateTime.now());

                    MainApplication_DEFAULT.setLoggedInUser(user.getName());
                    MainApplication_DEFAULT.setLoggedInUserRole(user.getRole());

                    MainApplication_DEFAULT.loadScene(
                            "/com/groupnine/travelbookingsystem/view/Home/HomePage_V2.fxml",
                            "Welcome " + user.getName() + "! - " + "(" + user.getRole() + ")",
                            true
                    );
                }
                else {
                    errorLabel.setVisible(true);
                    errorLabel.setText("Entered password is wrong!");
                }
            }
            else{
                errorLabel.setVisible(true);
                errorLabel.setText("No user account found with this username '" + usernameTextField.getText() + "' !");
            }
        }
    }

    @FXML
    private void onForgetPasswordButtonClick()
    {
        MainApplication_DEFAULT.loadScene(
                "/com/groupnine/travelbookingsystem/view/authentication/forget_password.fxml",
                "Forget Password",
                false
        );
    }

    @FXML
    private void onCreateAccountButtonClick()
    {
        /*if(MainApplication_DEFAULT.getLoggedInUser() != null
            || !Objects.equals(MainApplication_DEFAULT.getLoggedInUserRole(), "")
            && Objects.equals(MainApplication_DEFAULT.getLoggedInUserRole(), "admin"))
        {
            MainApplication_DEFAULT.loadScene(
                    "/com/groupnine/travelbookingsystem/view/authentication/create_account.fxml",
                    "Create Account",
                    false
            );
        } else {
            showAlert("Access Denied", "You need to be logged in as an admin to create accounts.");
        }*/

        //just for debugging
        MainApplication_DEFAULT.loadScene(
                "/com/groupnine/travelbookingsystem/view/authentication/create_account.fxml",
                "Create Account",
                false
        );
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
