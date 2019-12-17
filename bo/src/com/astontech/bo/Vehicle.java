package com.astontech.bo;

import com.astontech.bo.interfaces.IFeelings;

import java.time.Year;
import java.util.Date;

public class Vehicle extends BaseBo implements IFeelings, Comparable {
    // PARAMETERS

    private int VehicleId;
    private Date year;
    private String LicensePlate;
    private String Vin;
    private String Color;
    private Boolean IsPurchase;
    private int PurchasePrice;
    private Date PurchaseDate;
    private VehicleModel vehicleModel;
    private VehicleStatus vehicleStatus;

    //CONSTRUCTORS
    public Vehicle(){}
    public Vehicle(int vehicleId, Date year, String licensePlate, String vin, String color, Boolean isPurchase, int purchasePrice, Date purchaseDate, VehicleModel vehicleModel) {
        this.setVehicleId(vehicleId);
        this.setYear(year);
        this.setLicensePlate(licensePlate);
        this.setVin(vin);
        this.setColor(color);
        this.setIsPurchase(isPurchase);
        this.setPurchasePrice(purchasePrice);
        this.setPurchaseDate(purchaseDate);
        this.setVehicleModel(vehicleModel);

    }

    //SET AND GET
    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public int getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(int vehicleId) {
        VehicleId = vehicleId;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getLicensePlate() {
        return LicensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        LicensePlate = licensePlate;
    }

    public String getVin() {
        return Vin;
    }

    public void setVin(String vin) {
        Vin = vin;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public Boolean getIsPurchase() {
        return IsPurchase;
    }

    public void setIsPurchase(Boolean isPurchase) {
        IsPurchase = isPurchase;
    }

    public int getPurchasePrice() {
        return PurchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        PurchasePrice = purchasePrice;
    }

    public Date getPurchaseDate() {
        return PurchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        PurchaseDate = purchaseDate;
    }

    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    @Override
    public boolean ownerShip() {
        if(vehicleModel.getVehicleModelName() == "Regal" ||vehicleModel.getVehicleModelName() == "Liberty"){
            return true;
        }
        else return false;
    }

    @Override
    public String mood() {
        if(vehicleModel.getVehicleMake().getVehicleMakeName() == "Buick"){
            return "Never again";
        }
        if(vehicleModel.getVehicleMake().getVehicleMakeName() == "Jeep"){
            return "Hell yeah";
        }
        if(vehicleModel.getVehicleMake().getVehicleMakeName() == "Tesla"){
            return "Someday";
        }
        if(vehicleModel.getVehicleMake().getVehicleMakeName() == "BMW"){
            return "Eat your pheasant \n Drink your wine\n Your day will come bourgeoisie swine";
        }
        else return "meh";
    }

    @Override
    public int passion() {
        if(vehicleModel.getVehicleMake().getVehicleMakeName() == "Buick"){
            return 8;
        }
        if(vehicleModel.getVehicleMake().getVehicleMakeName() == "Jeep"){
            return 10;
        }
        if(vehicleModel.getVehicleMake().getVehicleMakeName() == "Tesla"){
            return 7;
        }
        if(vehicleModel.getVehicleMake().getVehicleMakeName() == "BMW"){
            return 3;
        }
        else return 0;    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
