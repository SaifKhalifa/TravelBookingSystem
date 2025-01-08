package com.groupnine.travelbookingsystem.controller.HomeController;

import com.groupnine.travelbookingsystem.MainApplication_DEFAULT;
import com.groupnine.travelbookingsystem.model.customerManagment.CustomerDAOImpl;
import com.groupnine.travelbookingsystem.model.flight.FlightDAOImpl;
import com.groupnine.travelbookingsystem.model.flightBooking.FlightBooking;
import com.groupnine.travelbookingsystem.model.flightBooking.FlightBookingDAOImpl;
import com.groupnine.travelbookingsystem.model.hotel.HotelDAOImpl;
import com.groupnine.travelbookingsystem.model.hotelBooking.HotelBooking;
import com.groupnine.travelbookingsystem.model.hotelBooking.HotelBookingDAOImpl;
import com.groupnine.travelbookingsystem.model.userMangment.User;
import com.groupnine.travelbookingsystem.model.userMangment.UserDAOImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.time.format.DateTimeFormatter;

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
    private HotelBookingDAOImpl hotelBookingDAOImp = new HotelBookingDAOImpl();
    private FlightBookingDAOImpl flightBookingDAOImp = new FlightBookingDAOImpl();

    public void initialize() {
        vbox.setStyle("-fx-background-image: url('" + getClass().getResource("/com/groupnine/travelbookingsystem/Assets/imgs/homePage_V2/space.jpg") + "');");

        // استرجاع البيانات من MainApplication_DEFAULT
        String loggedInUser = MainApplication_DEFAULT.getLoggedInUser();
        String loggedInUserRole = MainApplication_DEFAULT.getLoggedInUserRole();

        // تعيين البيانات في الواجهة
        helloName.setText(loggedInUser);
        roleLabel.setText(loggedInUserRole);

        HotelDAOImpl hotelDAO = new HotelDAOImpl();
        FlightDAOImpl flightDAO = new FlightDAOImpl();

        HotelBookingDAOImpl hotelBookingDAO = new HotelBookingDAOImpl();
        FlightBookingDAOImpl flightBookingDAO = new FlightBookingDAOImpl();

        CustomerDAOImpl customerDAO = new CustomerDAOImpl();


        long countHotel = hotelDAO.getHotelsCount();
        long countFlight = flightDAO.getFlightsCount();

        long countBookingHotel = hotelBookingDAO.getBookingsCount();
        long countBookingFlight = flightBookingDAO.getBookingsCount();
        long countBookings = countBookingHotel + countBookingFlight;

        long countCustomer = customerDAO.getCustomersCount();

        hotelsCount.setText(String.valueOf(countHotel));
        flightsCount.setText(String.valueOf(countFlight));
        bookingsCount.setText(String.valueOf(countBookings));
        customersCount.setText(String.valueOf(countCustomer));

        User lastAgent = userDAOImp.getLastLoggedInAgent();

        if (lastAgent != null) {
            agentName.setText(lastAgent.getName());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            agentLastLogin.setText(lastAgent.getLastLogin().format(formatter));
            agentEmail.setText(lastAgent.getEmail());
        } else {
           System.out.println("No last logged in user");
        }

        showFlightBooking();
    }


    @FXML
    public void showFlightBooking() {

        flightBtn.setStyle("-fx-background-color: #6E9FC1; -fx-text-fill: white; -fx-font-size: 14; -fx-background-radius: 10;");
        hotelBtn.setStyle("-fx-background-color: #CCD2D9FF; -fx-text-fill: black; -fx-font-size: 14; -fx-background-radius: 10;");


        flightBookingContainer.setVisible(true);
        hotelBookingContainer.setVisible(false); // إخفاء حجوزات الفنادق

        // تحميل آخر حجز طيران
        FlightBooking lastBooking = flightBookingDAOImp.getLatestFlightBooking();

        if (lastBooking != null) {
            // تعبئة البيانات في الـ Labels
            flightBookingID.setText(String.valueOf(lastBooking.getFlightId()));
            customerNameFlight.setText(lastBooking.getCustomerName());
            airline.setText(lastBooking.getAirline());
            bookingDateFlight.setText(lastBooking.getBookingDate().toString());
            departure.setText(lastBooking.getDeparture().toString());
            arrival.setText(lastBooking.getArrival().toString());
            statusFlight.setText(lastBooking.getStatus());
        }

    }


    @FXML
    public void showHotelBooking() {

        hotelBtn.setStyle("-fx-background-color: #6E9FC1; -fx-text-fill: white; -fx-font-size: 14; -fx-background-radius: 10;");
        flightBtn.setStyle("-fx-background-color: #CCD2D9FF; -fx-text-fill: black; -fx-font-size: 14; -fx-background-radius: 10;");

        hotelBookingContainer.setVisible(true);
        flightBookingContainer.setVisible(false); // إخفاء حجوزات الطيران

        // تحميل آخر حجز فندق
        HotelBooking lastBooking = hotelBookingDAOImp.getLatestHotelBooking();

        if (lastBooking != null) {
            // تعبئة البيانات في الـ Labels
            hotelBookingID.setText(String.valueOf(lastBooking.getId()));
            customerNameHotel.setText(lastBooking.getCustomerName());
            hotelName.setText(lastBooking.getHotel().getName());
            bookingDateHotel.setText(lastBooking.getBookingDate().toString());
            checkIn.setText(lastBooking.getCheckIn().toString());
            checkOut.setText(lastBooking.getCheckOut().toString());
            statusHotel.setText(lastBooking.getStatus());
        }

    }
}
