package com.groupnine.travelbookingsystem.controller.SidebarController;

import com.groupnine.travelbookingsystem.MainApplication_DEFAULT;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;

public class SidebarController {
    private static String activeTabId = "homeBox";

    @FXML
    private BorderPane root;
    @FXML
    private HBox homeBox, flightsBox, agentDashboardBox, adminDashboardBox;

    @FXML
    public void initialize() {
        String userRole = MainApplication_DEFAULT.getLoggedInUserRole();

        if (userRole.equals("Agent")) {
            agentDashboardBox.setVisible(true);
            adminDashboardBox.setVisible(false);
        } else if (userRole.equals("Admin")) {
            agentDashboardBox.setVisible(false);
            adminDashboardBox.setVisible(true);
        } else {
            agentDashboardBox.setVisible(false);
            adminDashboardBox.setVisible(false);
        }

        restoreActiveTab();
    }

    // Set active tab by storing fx:id
    private void setActiveTab(HBox selectedTab) {
        if (activeTabId != null) {
            HBox previousTab = (HBox) root.lookup("#" + activeTabId);
            if (previousTab != null) {
                previousTab.getStyleClass().remove("sidebar-item-active");
            }
        }
        activeTabId = selectedTab.getId();
        selectedTab.getStyleClass().add("sidebar-item-active");
    }

    // Restore active tab using stored fx:id
    private void restoreActiveTab() {
        if (activeTabId != null) {
            HBox activeTab = (HBox) root.lookup("#" + activeTabId);
            if (activeTab != null) {
                activeTab.getStyleClass().add("sidebar-item-active");
            }
        }
    }

    @FXML
    private void handleHomeClick(MouseEvent event) {
        setActiveTab(homeBox);
        MainApplication_DEFAULT.loadScene(
                "/com/groupnine/travelbookingsystem/view/Home/Homepage_V2.fxml",
                "Home",
                true,
                true
        );
    }

    @FXML
    private void handleAgentDashboardClick(MouseEvent event) {
        setActiveTab(agentDashboardBox);
        MainApplication_DEFAULT.loadScene(
                "/com/groupnine/travelbookingsystem/view/Booking/FlightBooking.fxml",
                "Agent Dashboard",
                true,
                true
        );
    }

    @FXML
    private void handleAdminDashboardClick(MouseEvent event) {
        setActiveTab(adminDashboardBox);
        MainApplication_DEFAULT.loadScene(
                "/com/groupnine/travelbookingsystem/view/AdminMangeFlight/ListFlights_V2.fxml",
                "Admin Dashboard",
                true,
                true
        );
    }

    @FXML
    private void handleLogoutClick(MouseEvent event) {
        activeTabId = null;
        MainApplication_DEFAULT.loadScene(
                "/com/groupnine/travelbookingsystem/view/authentication/login.fxml",
                "Login",
                false,
                false
        );
    }

    @FXML
    private void handleFlightsSearchClick(MouseEvent event) {
        setActiveTab(flightsBox);
        MainApplication_DEFAULT.loadScene(
                "/com/groupnine/travelbookingsystem/view/SearchPageFlighte-Hotels/searchPageFlights.fxml",
                "Search",
                true,
                true
        );
    }
}
