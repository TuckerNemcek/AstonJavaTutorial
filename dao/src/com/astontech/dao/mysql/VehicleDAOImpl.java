package com.astontech.dao.mysql;

import com.astontech.bo.Vehicle;
import com.astontech.bo.VehicleModel;
import common.helpers.DateHelper;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAOImpl extends MySQL implements VehicleDAO {
    @Override
    public Vehicle getVehicleById(int vehicleId){
        Connect();
        Vehicle vehicle = null;
        try{
            String sp = "{call GetVehicle(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1,GET_BY_ID);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()){
                vehicle = HydrateVehicle(rs);
            }

        } catch (SQLException sqlEx){
            logger.error(sqlEx);
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> getVehicleList() {
        Connect();
        List<Vehicle> vehicleList = new ArrayList<>();
        try{
            String sp = "{call GetVehicle(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1,GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()){
                vehicleList.add(HydrateVehicle(rs));
            }

        } catch (SQLException sqlEx){
            logger.error(sqlEx);
        }
        return vehicleList;
    }

    @Override
    public int insertVehicle(Vehicle vehicle) {
        Connect();
        int id = 0;
        try{
            String sp = "{call ExecVehicle(?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1, INSERT);
            cStmt.setInt(2,0);
            cStmt.setDate(3,DateHelper.utilDateToSqlDate(vehicle.getYear()));
            cStmt.setString(4, vehicle.getLicensePlate());
            cStmt.setString(5, vehicle.getVin());
            cStmt.setString(6, vehicle.getColor());
            cStmt.setBoolean(7, vehicle.getIsPurchase());
            cStmt.setInt(8, vehicle.getPurchasePrice());
            cStmt.setDate(9, DateHelper.utilDateToSqlDate(vehicle.getPurchaseDate()));
            cStmt.setInt(10, vehicle.getVehicleModel().getVehicleModelId());

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }

        }catch (SQLException sqlEx){
            logger.error(sqlEx);
        }
        return id;
    }

    @Override
    public boolean updateVehicle(Vehicle vehicle) {
        Connect();
        int id = 0;
        try{
            String sp = "{call ExecVehicle(?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2,vehicle.getVehicleId());
            cStmt.setDate(3,DateHelper.utilDateToSqlDate(vehicle.getYear()));
            cStmt.setString(4, vehicle.getLicensePlate());
            cStmt.setString(5, vehicle.getVin());
            cStmt.setString(6, vehicle.getColor());
            cStmt.setBoolean(7, vehicle.getIsPurchase());
            cStmt.setInt(8, vehicle.getPurchasePrice());
            cStmt.setDate(9, DateHelper.utilDateToSqlDate(vehicle.getPurchaseDate()));
            cStmt.setInt(10, vehicle.getVehicleModel().getVehicleModelId());

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }

        }catch (SQLException sqlEx){
            logger.error(sqlEx);
        }
        return id > 0;
    }

    @Override
    public boolean deleteVehicle(int vehicleId) {
        Connect();
        int id = 0;
        try{
            String sp = "{call ExecVehicle(?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1, DELETE);
            cStmt.setInt(2,vehicleId);
            cStmt.setDate(3, null);
            cStmt.setString(4, null);
            cStmt.setString(5,null);
            cStmt.setString(6, null);
            cStmt.setBoolean(7, false);
            cStmt.setInt(8, 0);
            cStmt.setDate(9, null);
            cStmt.setInt(10, 0);

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }

        }catch (SQLException sqlEx){
            logger.error(sqlEx);
        }
        return id > 0;
    }

    private static  Vehicle HydrateVehicle(ResultSet rs)throws SQLException {
        //   VehicleModelDAO // COME BACK TO THIS AFTER YOU HAVE MADE THE VEHICLE MODE//   L AND VEHICLE MAKE DAOS
        VehicleModelDAO vehicleModelDAO = new VehicleModelDAOImpl();

        VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.setVehicleModelId(4);

        Vehicle vehicle = new Vehicle();

        vehicle.setVehicleId(rs.getInt(1));
        vehicle.setYear(rs.getDate(2));
        vehicle.setLicensePlate(rs.getString(3));
        vehicle.setVin(rs.getString(4));
        vehicle.setColor(rs.getString(5));
        vehicle.setIsPurchase(rs.getBoolean(6));
        vehicle.setPurchasePrice(rs.getInt(7));
        vehicle.setPurchaseDate(rs.getDate(8));
        vehicle.setVehicleModel(vehicleModel);


     //   vehicle.setVehicleModel(vehicleModel.getVehicleModelId());

        return vehicle;
    }
}
//            cStmt.setInt(1, INSERT);
//                    cStmt.setInt(2,0);
//                    cStmt.setDate(3,DateHelper.utilDateToSqlDate(vehicle.getYear()));
//                    cStmt.setString(4, vehicle.getLicensePlate());
//                    cStmt.setString(5, vehicle.getVin());
//                    cStmt.setString(6, vehicle.getColor());
//                    cStmt.setBoolean(7, vehicle.getIsPurchase());
//                    cStmt.setInt(8, vehicle.getPurchasePrice());
//                    cStmt.setDate(9, DateHelper.utilDateToSqlDate(vehicle.getPurchaseDate()));
//                    cStmt.setInt(10, vehicle.getVehicleModel().getVehicleModelId());