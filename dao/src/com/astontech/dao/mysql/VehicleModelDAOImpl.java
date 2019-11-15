package com.astontech.dao.mysql;

import com.astontech.bo.VehicleModel;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleModelDAOImpl extends MySQL implements VehicleModelDAO {
    @Override
    public VehicleModel getVehicleModelById(VehicleModel vehicleModel) {
        return null;
    }

    @Override
    public List<VehicleModel> getVehicleModelList() {
        Connect();
        List<VehicleModel> employeeList = new ArrayList<VehicleModel>();
        try{
            String sp = "{call GetVehicleModel(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1,GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()){
                employeeList.add(HydrateVehicleModel(rs));
            }

        }catch (SQLException sqlEx){
            logger.error(sqlEx);
        }
        return employeeList;
    }

    private static VehicleModel HydrateVehicleModel(ResultSet rs) throws SQLException{
        VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.setVehicleModelId(rs.getInt(1));
        vehicleModel.setVehicleModelName(rs.getString(2));

        return vehicleModel;
    }
}
