package com.astontech.dao.mysql;

import com.astontech.bo.VehicleMake;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleMakeDAOImpl extends MySQL implements VehicleMakeDAO {
    @Override
    public VehicleMake getVehicleMakeById(VehicleMake vehicleMake) {
        return null;
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
    private static VehicleMake HydrateVehicleMake (ResultSet rs) throws SQLException{
        VehicleMake vehicleMake = new VehicleMake();
        vehicleMake.setVehicleMakeId(rs.getInt(1));
        vehicleMake.setVehicleMakeName(rs.getString(2));

        return vehicleMake;
    }

}

