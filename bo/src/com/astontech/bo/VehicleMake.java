package com.astontech.bo;

import java.util.Date;

public class VehicleMake extends BaseBo {
    //PARAMETERS
    private int VehicleMakeId;
    private String VehicleMakeName;
    private String CreateDate;

    //CONSTRUCTORS
    public VehicleMake(){}
    public VehicleMake(int vehicleMakeId, String vehicleMakeName, String createDate) {
        this.setVehicleMakeId(vehicleMakeId);
        this.setVehicleMakeName(vehicleMakeName);
        this.setCreateDate(createDate);
    }

    //SET AND GET
    public int getVehicleMakeId() {
        return VehicleMakeId;
    }

    public void setVehicleMakeId(int vehicleMakeId) {
        VehicleMakeId = vehicleMakeId;
    }

    public String getVehicleMakeName() {
        return VehicleMakeName;
    }

    public void setVehicleMakeName(String vehicleMakeName) {
        VehicleMakeName = vehicleMakeName;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String createDate) {
        CreateDate = createDate;
    }

    //HELPER METHODS
    public  String CarNoise(){
        String carName = getVehicleMakeName();
        if (carName.equals("Tesla")){
            return "bzz bzz";
        }
        else if (carName.equals(("Jeep"))){
            return "Jeep Jeep";
        }
        else if (carName.equals(("BMW"))){
            return "Out of the way peasant!";
        }
        else {
            return "Beep Beep";
        }
    };

}
