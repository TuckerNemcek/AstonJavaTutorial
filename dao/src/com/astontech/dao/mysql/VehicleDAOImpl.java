package com.astontech.dao.mysql;

import com.astontech.bo.Vehicle;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAOImpl extends MySQL implements VehicleDAO {
    @Override
    public Vehicle getVehicleById(Vehicle vehicle) {
        return null;
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
    private static  Vehicle HydrateVehicle(ResultSet rs)throws SQLException {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(rs.getInt(1));
        vehicle.setLicensePlate(rs.getString(3));
        vehicle.setVin(rs.getString(4));

        return vehicle;
    }
}
