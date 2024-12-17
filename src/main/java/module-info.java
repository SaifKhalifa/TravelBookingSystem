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
    exports com.groupnine.travelbookingsystem.controller.ResultSearchControllers;
    opens com.groupnine.travelbookingsystem.controller.ResultSearchControllers to javafx.fxml;
    exports com.groupnine.travelbookingsystem.controller.SearchPageControllers;
    opens com.groupnine.travelbookingsystem.controller.SearchPageControllers to javafx.fxml;
    exports com.groupnine.travelbookingsystem.ResultSearchJava;
    opens com.groupnine.travelbookingsystem.ResultSearchJava to javafx.fxml;
    exports com.groupnine.travelbookingsystem.SearchPageJava;
    opens com.groupnine.travelbookingsystem.SearchPageJava to javafx.fxml;
}