module com.groupnine.travelbookingsystem {
    // JavaFX dependencies
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    // External UI Libraries
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    // Hibernate ORM dependencies
    requires org.hibernate.orm.core;

    // Database dependencies
    requires java.naming;
    requires java.persistence;
    requires java.sql;

    // Spring Framework dependencies
    requires spring.context;
    requires spring.beans;
    requires mysql.connector.java;

    // Authentication and Security
    opens com.groupnine.travelbookingsystem to javafx.fxml;
    exports com.groupnine.travelbookingsystem;

    opens com.groupnine.travelbookingsystem.controller to javafx.fxml;
    exports com.groupnine.travelbookingsystem.controller;

    opens com.groupnine.travelbookingsystem.controller.authentication to javafx.fxml;
    exports com.groupnine.travelbookingsystem.controller.authentication;

    // Admin Panel controllers
    opens com.groupnine.travelbookingsystem.controller.adminPanelHotelController to javafx.fxml;
    exports com.groupnine.travelbookingsystem.controller.adminPanelHotelController;

    // Homepage controllers
    exports com.groupnine.travelbookingsystem.controller.HomeController;
    opens com.groupnine.travelbookingsystem.controller.HomeController to javafx.fxml;

    // Admin Flight management controllers
    exports com.groupnine.travelbookingsystem.controller.AdminMangeFlight;
    opens com.groupnine.travelbookingsystem.controller.AdminMangeFlight to javafx.fxml;

    // Booking controllers
    exports com.groupnine.travelbookingsystem.controller.BookingController;
    opens com.groupnine.travelbookingsystem.controller.BookingController to javafx.fxml;

    // Sidebar controllers
    exports com.groupnine.travelbookingsystem.controller.SidebarController;
    opens com.groupnine.travelbookingsystem.controller.SidebarController to javafx.fxml;

    // Booking Details controllers
    exports com.groupnine.travelbookingsystem.controller.BookingDetailsController;
    opens com.groupnine.travelbookingsystem.controller.BookingDetailsController to javafx.fxml;

    // Search Page controllers
    exports com.groupnine.travelbookingsystem.controller.SearchPageControllers;
    opens com.groupnine.travelbookingsystem.controller.SearchPageControllers to javafx.fxml;

    // Result Search controllers
    exports com.groupnine.travelbookingsystem.controller.ResultSearchControllers;
    opens com.groupnine.travelbookingsystem.controller.ResultSearchControllers to javafx.fxml;

    // Other applications (optional)
    exports com.groupnine.travelbookingsystem.otherApplications;
    opens com.groupnine.travelbookingsystem.otherApplications to javafx.fxml;

    // Specific application exports
    exports com.groupnine.travelbookingsystem.otherApplications.Sana;

    exports com.groupnine.travelbookingsystem.otherApplications.Roaa;

    // Hibernate model exports
    opens com.groupnine.travelbookingsystem.model.BookingFlight to org.hibernate.orm.core;
}
