package com.astontech.dao.mysql;

import com.astontech.bo.Vehicle;

import java.util.List;

public interface VehicleDAO {
    public Vehicle getVehicleById(Vehicle vehicle);
    public List<Vehicle> getVehicleList();
}
