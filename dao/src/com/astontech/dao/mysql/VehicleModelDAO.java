package com.astontech.dao.mysql;

import com.astontech.bo.VehicleModel;

import java.util.List;

public interface VehicleModelDAO {
    public VehicleModel getVehicleModelById(VehicleModel vehicleModel);
    public List<VehicleModel> getVehicleModelList();

    public int insertVehicleModel(VehicleModel vehicleModel);
    public boolean updateVehicleModel(VehicleModel vehicleModel);
    public boolean deleteVehicleModel(int vehicleModelId);
}
