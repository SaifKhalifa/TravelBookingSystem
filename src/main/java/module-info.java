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

    // Open only necessary packages to javafx.fxml for FXML reflection
    opens com.groupnine.travelbookingsystem to javafx.fxml;
    opens com.groupnine.travelbookingsystem.controller to javafx.fxml;
    opens com.groupnine.travelbookingsystem.controller.authentication to javafx.fxml;
    opens com.groupnine.travelbookingsystem.Sana to javafx.fxml;
    opens com.groupnine.travelbookingsystem.Roaa to javafx.fxml;

    // Export only top-level packages that should be accessible by other modules
    exports com.groupnine.travelbookingsystem;
    exports com.groupnine.travelbookingsystem.controller;
}
