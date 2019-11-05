package com.astontech.bo;

import java.time.Year;
import java.util.Date;

public class Vehicle extends BaseBo {
    // PARAMETERS

    private int VehicleId;
    private String year;
    private String LicensePlate;
    private String Vin;
    private String Color;
    private char IsPurchase;
    private int PurchasePrice;
    private String PurchaseDate;
    private VehicleModel vehicleModel;
    private VehicleStatus vehicleStatus;

    //CONSTRUCTORS
    public Vehicle(){}
    public Vehicle(int vehicleId, String year, String licensePlate, String vin, String color, char isPurchase, int purchasePrice, String purchaseDate, VehicleModel vehicleModel) {
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
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

    public char getIsPurchase() {
        return IsPurchase;
    }

    public void setIsPurchase(char isPurchase) {
        IsPurchase = isPurchase;
    }

    public int getPurchasePrice() {
        return PurchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        PurchasePrice = purchasePrice;
    }

    public String getPurchaseDate() {
        return PurchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        PurchaseDate = purchaseDate;
    }

    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
}
