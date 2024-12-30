module com.groupnine.travelbookingsystem {
    requires org.hibernate.orm.core;
    requires java.persistence;

    opens com.groupnine.travelbookingsystem.model.userMangment to org.hibernate.orm.core;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.naming;
    requires java.sql;

    // authentication
    opens com.groupnine.travelbookingsystem to javafx.fxml;
    exports com.groupnine.travelbookingsystem;

    opens com.groupnine.travelbookingsystem.controller to javafx.fxml;
    exports com.groupnine.travelbookingsystem.controller;

    opens com.groupnine.travelbookingsystem.controller.authentication to javafx.fxml;
    exports com.groupnine.travelbookingsystem.controller.authentication;

    //admin panel
    opens com.groupnine.travelbookingsystem.controller.adminPanelHotelController to javafx.fxml;
    exports com.groupnine.travelbookingsystem.controller.adminPanelHotelController;

    //homepage
    exports com.groupnine.travelbookingsystem.controller.HomeController;
    opens com.groupnine.travelbookingsystem.controller.HomeController to javafx.fxml;

    //admin manager
    exports com.groupnine.travelbookingsystem.controller.AdminMangeFlight;
    opens com.groupnine.travelbookingsystem.controller.AdminMangeFlight to javafx.fxml;

    //booking
    exports com.groupnine.travelbookingsystem.controller.BookingController;
    opens com.groupnine.travelbookingsystem.controller.BookingController to javafx.fxml;

    //sidebar
    exports com.groupnine.travelbookingsystem.controller.SidebarController;
    opens com.groupnine.travelbookingsystem.controller.SidebarController to javafx.fxml;

    //booking details
    exports com.groupnine.travelbookingsystem.controller.BookingDetailsController;
    opens com.groupnine.travelbookingsystem.controller.BookingDetailsController to javafx.fxml;

    //search page
    exports com.groupnine.travelbookingsystem.controller.SearchPageControllers;
    opens com.groupnine.travelbookingsystem.controller.SearchPageControllers to javafx.fxml;
    exports com.groupnine.travelbookingsystem.controller.ResultSearchControllers;
    opens com.groupnine.travelbookingsystem.controller.ResultSearchControllers to javafx.fxml;

    //TO REMOVE LATER:
    exports com.groupnine.travelbookingsystem.otherApplications;
    opens com.groupnine.travelbookingsystem.otherApplications to javafx.fxml;

    opens com.groupnine.travelbookingsystem.model to javafx.base, javafx.fxml, org.hibernate.orm.core;

}