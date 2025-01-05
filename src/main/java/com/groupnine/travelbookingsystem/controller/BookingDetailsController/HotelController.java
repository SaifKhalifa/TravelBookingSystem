package com.groupnine.travelbookingsystem.controller.BookingDetailsController;

import com.groupnine.travelbookingsystem.model.toRemove.HotelDetalisModel.HotelDetailsDeoImp;
import com.groupnine.travelbookingsystem.model.toRemove.HotelDetalisModel.HotelDetalisModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HotelController {

    @FXML
    private Label hotelTitleLabel;
    @FXML
    private Label hotelLocationLabel;
    @FXML
    private Label hotelPriceLabel;
    @FXML
    private Label hotelAmenitiesLabel;

    private int hotelId;

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
        loadHotelDetails();
    }

    private void loadHotelDetails() {
        HotelDetailsDeoImp hotelDetailsDeo = new HotelDetailsDeoImp();
        HotelDetalisModel hotel = hotelDetailsDeo.getHotelById(hotelId);

        if (hotel != null) {
            hotelTitleLabel.setText(hotel.getHotelName());
            hotelLocationLabel.setText(hotel.getLocation());
            hotelPriceLabel.setText("Price per Night: $" + hotel.getPricePerNight());
            hotelAmenitiesLabel.setText("Amenities: " + hotel.getAmenities());
        } else {
            hotelTitleLabel.setText("No details available for this hotel.");
        }
    }
}
