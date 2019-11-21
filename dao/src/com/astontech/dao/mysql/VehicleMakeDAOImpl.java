package com.astontech.dao.mysql;

import com.astontech.bo.VehicleMake;
import common.helpers.DateHelper;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleMakeDAOImpl extends MySQL implements VehicleMakeDAO {

    @Override
    public VehicleMake getVehicleMakeById(int vehicleMakeId) {
        Connect();
        VehicleMake vehicleMake = null;
        try{
            String sp = "{call GetVehicleMake(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, vehicleMakeId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()){
                vehicleMake = HydrateVehicleMake(rs);
            }

        }catch(SQLException sqlEx){
            logger.error(sqlEx);
        }

        return vehicleMake;

    }



    @Override
    public List<VehicleMake> getVehicleMakeList() {
        Connect();
        List<VehicleMake> personList = new ArrayList<VehicleMake>();
        try {
            String sp = "{call GetVehicleMake(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1,GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()){
                personList.add(HydrateVehicleMake(rs));
            }

        }catch (SQLException sqlEx){
            logger.error(sqlEx);
        }
        return personList;
    }

    @Override
    public int insertVehicleMake(VehicleMake vehicleMake) {
        Connect();
        int id = 0;
        try{
            String sp = "{call ExecVehicleMake(?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1, INSERT);
            cStmt.setInt(2,0);
            cStmt.setString(3, vehicleMake.getVehicleMakeName());
            cStmt.setDate(4, DateHelper.utilDateToSqlDate(vehicleMake.getCreateDate()));

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
    public boolean updateVehicleMake(VehicleMake vehicleMake) {
        Connect();
        int id = 0;
        try{
            String sp = "{call ExecVehicleMake(?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2,vehicleMake.getVehicleMakeId());
            cStmt.setString(3, vehicleMake.getVehicleMakeName());
            cStmt.setDate(4, DateHelper.utilDateToSqlDate(vehicleMake.getCreateDate()));

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
    public boolean deleteVehicleMake(int vehicleMakeId) {
        Connect();
        int id = 0;
        try{
            String sp = "{call ExecVehicleMake(?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1, DELETE);
            cStmt.setInt(2,vehicleMakeId);
            cStmt.setString(3, " ");
            cStmt.setDate(4,  null);

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }

        }catch (SQLException sqlEx){
            logger.error(sqlEx);
        }
        return id > 0;
    }

    private static VehicleMake HydrateVehicleMake (ResultSet rs) throws SQLException{
        VehicleMake vehicleMake = new VehicleMake();
        vehicleMake.setVehicleMakeId(rs.getInt(1));
        vehicleMake.setVehicleMakeName(rs.getString(2));
        vehicleMake.setCreateDate(rs.getDate(3));

        return vehicleMake;
    }

}

