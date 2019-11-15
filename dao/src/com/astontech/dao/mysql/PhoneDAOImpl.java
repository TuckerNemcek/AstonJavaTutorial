package com.astontech.dao.mysql;

import com.astontech.bo.Phone;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDAOImpl extends MySQL implements PhoneDAO {
    @Override
    public Phone getPhoneById(Phone phone) {
        Connect();
        Phone myPhone = null;
        try {
            String sp = "{call GetPhone(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,GET_BY_ID);
            cStmt.setInt(2, myPhone.getPhoneId());
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()){
                phone = HydratePhone(rs);
            }

        }catch(SQLException sqlEx){
            logger.error(sqlEx);
        }

        return phone;
    }


    @Override
    public List<Phone> getPhoneList() {
        Connect();
        List<Phone> phoneList = new ArrayList<Phone>();
        try {
            String sp = "{call GetPhone(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()){
                phoneList.add(HydratePhone(rs));
            }

        }catch(SQLException sqlEx){
            logger.error(sqlEx);
        }

        return phoneList;
    }
    private static Phone HydratePhone(ResultSet rs) throws SQLException {
        Phone phone = new Phone();
        phone.setPhoneId(rs.getInt(1));
        phone.setPhoneNumber(rs.getInt(6));

        return phone;
    }
}
