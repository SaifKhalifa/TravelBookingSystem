module com.groupnine.travelbookingsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.transaction;
    requires spring.context;
    requires spring.beans;
    requires spring.core;
    requires spring.tx;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.persistence;
    requires java.sql;
    requires mysql.connector.java;
    requires java.smartcardio;


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

    //models
    opens com.groupnine.travelbookingsystem.model.customerManagment to javafx.base, javafx.fxml, org.hibernate.orm.core;
    opens com.groupnine.travelbookingsystem.model.flight to javafx.base, javafx.fxml, org.hibernate.orm.core;
    opens com.groupnine.travelbookingsystem.model.hotel to javafx.base, javafx.fxml, org.hibernate.orm.core;
    opens com.groupnine.travelbookingsystem.model.flightBooking to javafx.base, javafx.fxml, org.hibernate.orm.core;
    opens com.groupnine.travelbookingsystem.model.hotelBooking to javafx.base, javafx.fxml, org.hibernate.orm.core;
    opens com.groupnine.travelbookingsystem.model.resultSearchFlights to javafx.base, javafx.fxml, org.hibernate.orm.core;
    opens com.groupnine.travelbookingsystem.model.resultSearchHotels to javafx.base, javafx.fxml, org.hibernate.orm.core;
    opens com.groupnine.travelbookingsystem.model.searchFlights to javafx.base, javafx.fxml, org.hibernate.orm.core;
    opens com.groupnine.travelbookingsystem.model.searchHotels to javafx.base, javafx.fxml, org.hibernate.orm.core;
    opens com.groupnine.travelbookingsystem.model.userMangment to javafx.base, javafx.fxml, org.hibernate.orm.core;

    // Hibernate model exports
}