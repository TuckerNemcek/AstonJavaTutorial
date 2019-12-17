package com.astontech.dao.mysql;

import com.astontech.bo.VehicleMake;

import java.util.List;

public interface VehicleMakeDAO {
    public VehicleMake getVehicleMakeById(int vehicleMakeId);
    public List<VehicleMake> getVehicleMakeList();

    public int insertVehicleMake(VehicleMake vehicleMakeId);
    public boolean updateVehicleMake(VehicleMake vehicleMake);
    public boolean deleteVehicleMake(int vehicleMake);
}
