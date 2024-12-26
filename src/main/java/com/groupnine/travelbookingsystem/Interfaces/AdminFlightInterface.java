package com.groupnine.travelbookingsystem.Interfaces;

import com.groupnine.travelbookingsystem.model.AdminFlightModel;

public interface AdminFlightInterface {
    // Method to add flight, throws Exception
    void addFlight(AdminFlightModel flight) throws Exception;
}
