package com.astontech.bo;

public class VehicleModel extends BaseBo {
    //PARAMETERS
    private int VehicleModelId;
    private String VehicleModelName;
    private VehicleMake vehicleMake;

    //CONSTRUCTORS
    public VehicleModel(){}
    public VehicleModel(int vehicleModelId, String vehicleModelName, VehicleMake vehicleMake) {
        this.setVehicleModelId(vehicleModelId);
        this.setVehicleModelName(vehicleModelName);
        this.setVehicleMake(vehicleMake);
    }

    //SET AND GET
    public int getVehicleModelId() {
        return VehicleModelId;
    }

    public void setVehicleModelId(int vehicleModelId) {
        VehicleModelId = vehicleModelId;
    }

    public VehicleMake getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(VehicleMake vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleModelName() {
        return VehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        VehicleModelName = vehicleModelName;
    }

    //HELPER METHODS

}
