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

    opens com.groupnine.travelbookingsystem to javafx.fxml;
    exports com.groupnine.travelbookingsystem;
    exports com.groupnine.travelbookingsystem.controller;
    opens com.groupnine.travelbookingsystem.controller to javafx.fxml;
    exports com.groupnine.travelbookingsystem.controller.BookingController;
    opens com.groupnine.travelbookingsystem.controller.BookingController to javafx.fxml;
    exports com.groupnine.travelbookingsystem.controller.HomeController;
    opens com.groupnine.travelbookingsystem.controller.HomeController to javafx.fxml;
    exports com.groupnine.travelbookingsystem.controller.SidebarController;
    opens com.groupnine.travelbookingsystem.controller.SidebarController to javafx.fxml;
    exports com.groupnine.travelbookingsystem.Sana;
    opens com.groupnine.travelbookingsystem.Sana to javafx.fxml;
    exports com.groupnine.travelbookingsystem.Roaa;
    opens com.groupnine.travelbookingsystem.Roaa to javafx.fxml;
}