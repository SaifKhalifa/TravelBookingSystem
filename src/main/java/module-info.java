module com.groupnine.travelbookingsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

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

    //TO REMOVE LATER:
    exports com.groupnine.travelbookingsystem.otherApplications;
    opens com.groupnine.travelbookingsystem.otherApplications to javafx.fxml;

}