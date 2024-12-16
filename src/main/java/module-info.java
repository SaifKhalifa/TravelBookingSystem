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
    requires java.desktop;

    opens com.groupnine.travelbookingsystem to javafx.fxml;
    exports com.groupnine.travelbookingsystem;
    exports com.groupnine.travelbookingsystem.controller;
    opens com.groupnine.travelbookingsystem.controller to javafx.fxml;
}