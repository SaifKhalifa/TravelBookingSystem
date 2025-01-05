package com.groupnine.travelbookingsystem.controller.HomeController;

import com.groupnine.travelbookingsystem.MainApplication_DEFAULT;
import com.groupnine.travelbookingsystem.model.BookingFlight.FlightBookingModel;
import com.groupnine.travelbookingsystem.model.BookingFlight.FlightDAOImp;
import com.groupnine.travelbookingsystem.model.BookingHotel.HotelBookingModel;
import com.groupnine.travelbookingsystem.model.BookingHotel.HotelDAOImpl;
import com.groupnine.travelbookingsystem.model.customerManagment.CustomerDAOImpl;
import com.groupnine.travelbookingsystem.model.userMangment.User;
import com.groupnine.travelbookingsystem.model.userMangment.UserDAOImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class HomepageController {

    @FXML
    private VBox vbox;
    @FXML
    private Label hotelsCount;
    @FXML
    private Label flightsCount;
    @FXML
    private Label customersCount;
    @FXML
    private Label bookingsCount;
    @FXML
    private Label agentName;
    @FXML
    private Label agentLastLogin;
    @FXML
    private Label agentEmail;
    @FXML
    private Label helloName;
    @FXML
    private Label roleLabel;
    @FXML
    private Label hotelBookingID;
    @FXML
    private Label customerNameHotel;
    @FXML
    private Label hotelName;
    @FXML
    private Label bookingDateHotel;
    @FXML
    private Label checkIn;
    @FXML
    private Label checkOut;
    @FXML
    private Label statusHotel;
    @FXML
    private Label flightBookingID;
    @FXML
    private Label customerNameFlight;
    @FXML
    private Label airline;
    @FXML
    private Label bookingDateFlight;
    @FXML
    private Label departure;
    @FXML
    private Label arrival;
    @FXML
    private Label statusFlight;
    @FXML
    private VBox flightBookingContainer;
    @FXML
    private VBox hotelBookingContainer;
    @FXML
    private Button hotelBtn;
    @FXML
    private Button flightBtn;

    private final UserDAOImpl userDAOImp = new UserDAOImpl();
    private HotelDAOImpl hotelDAOImp = new HotelDAOImpl();
    private FlightDAOImp flightDAOImp = new FlightDAOImp();

    public void initialize() {
        vbox.setStyle("-fx-background-image: url('" + getClass().getResource("/com/groupnine/travelbookingsystem/Assets/imgs/homePage_V2/space.jpg") + "');");

        // استرجاع البيانات من MainApplication_DEFAULT
        String loggedInUser = MainApplication_DEFAULT.getLoggedInUser();
        String loggedInUserRole = MainApplication_DEFAULT.getLoggedInUserRole();

        // تعيين البيانات في الواجهة
        helloName.setText(loggedInUser);
        roleLabel.setText(loggedInUserRole);

        HotelDAOImpl hotelDAO = new HotelDAOImpl();
        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        FlightDAOImp flightDAO = new FlightDAOImp();


        long countHotel = hotelDAO.getHotelsCount();
//        long countFlight= flightDAO.getFlightsCount();
        long countBookingHotel = hotelDAO.getBookingsCount();
        long countBookingFlight = flightDAO.getBookingsCount();
        long countBookings = countBookingHotel + countBookingFlight;
        long countCustomer = customerDAO.getCustomersCount();

        hotelsCount.setText(String.valueOf(countHotel));
//        flightsCount.setText(String.valueOf(countFlight));
        bookingsCount.setText(String.valueOf(countBookings));
        customersCount.setText(String.valueOf(countCustomer));

        User lastAgent = userDAOImp.getLastLoggedInAgent();

        if (lastAgent != null) {
            agentName.setText(lastAgent.getName());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            agentLastLogin.setText(lastAgent.getLastLogin().format(formatter));
            agentEmail.setText(lastAgent.getEmail());
        } else {
            agentName.setText("Agent: N/A");
            agentLastLogin.setText("Last Login: N/A");
        }

//        // Get all columns from TableView
//        latestHotelBookingTable.getColumns().forEach(column -> {
//            column.setResizable(true);
//        });
//
//        latestFlightBookingTable.getColumns().forEach(column -> {
//            column.setResizable(true);
//        });
//        loadHotelBooking();
//        loadFlightBooking();
//
//        latestFlightBookingTable.setVisible(true);
//        latestHotelBookingTable.setVisible(false);
//
//        loadLastBooking();

        showFlightBooking();
    }


    @FXML
    public void showFlightBooking() {

        flightBtn.setStyle("-fx-background-color: #6E9FC1; -fx-text-fill: white; -fx-font-size: 14; -fx-background-radius: 10;");
        hotelBtn.setStyle("-fx-background-color: #CCD2D9FF; -fx-text-fill: black; -fx-font-size: 14; -fx-background-radius: 10;");


        flightBookingContainer.setVisible(true);
        hotelBookingContainer.setVisible(false); // إخفاء حجوزات الفنادق

        // تحميل آخر حجز طيران
        List<FlightBookingModel> lastBooking = flightDAOImp.getLastBooking();

        if (lastBooking != null && !lastBooking.isEmpty()) {
            FlightBookingModel booking = lastBooking.get(0);

            // تعبئة البيانات في الـ Labels
            flightBookingID.setText(String.valueOf(booking.getFlightId()));
            customerNameFlight.setText(booking.getCustomerName());
            airline.setText(booking.getAirline());
            bookingDateFlight.setText(booking.getBookingDate().toString());
            departure.setText(booking.getDeparture().toString());
            arrival.setText(booking.getArrival().toString());
            statusFlight.setText(booking.getStatus());
        }
    }


    @FXML
    public void showHotelBooking() {

        hotelBtn.setStyle("-fx-background-color: #6E9FC1; -fx-text-fill: white; -fx-font-size: 14; -fx-background-radius: 10;");
        flightBtn.setStyle("-fx-background-color: #CCD2D9FF; -fx-text-fill: black; -fx-font-size: 14; -fx-background-radius: 10;");

        hotelBookingContainer.setVisible(true);
        flightBookingContainer.setVisible(false); // إخفاء حجوزات الطيران

        // تحميل آخر حجز فندق
        List<HotelBookingModel> lastBooking = hotelDAOImp.getLastBooking();

        if (lastBooking != null && !lastBooking.isEmpty()) {
            HotelBookingModel booking = lastBooking.get(0);

            // تعبئة البيانات في الـ Labels
            hotelBookingID.setText(String.valueOf(booking.getId()));
            customerNameHotel.setText(booking.getCustomerName());
            hotelName.setText(booking.getHotel().getName());
            bookingDateHotel.setText(booking.getBookingDate().toString());
            checkIn.setText(booking.getCheckIn().toString());
            checkOut.setText(booking.getCheckOut().toString());
            statusHotel.setText(booking.getStatus());
        }
    }
}
