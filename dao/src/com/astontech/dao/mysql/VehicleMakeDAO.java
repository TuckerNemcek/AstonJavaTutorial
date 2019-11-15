package com.astontech.dao.mysql;

import com.astontech.bo.VehicleMake;

import java.util.List;

public interface VehicleMakeDAO {
    public VehicleMake getVehicleMakeById(VehicleMake vehicleMake);
    public List<VehicleMake> getVehicleMakeList();
}
