package com.astontech.dao.mysql;

import com.astontech.bo.Email;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmailDAOImpl extends MySQL implements  EmailDAO {
    @Override
    public Email getEmailbyId(Email email) {
        return null;
    }

    @Override
    public List<Email> getEmailList() {
        Connect();
        List<Email> emailList = new ArrayList<>();
        try{
            String sp = "{call GetEmail(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1,GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()){
                emailList.add(HydrateEmail(rs));
            }
        }
        catch (SQLException sqlEx){
            logger.error(sqlEx);
        }

        return emailList;
    }
    private static Email HydrateEmail(ResultSet rs) throws SQLException {
        Email email = new Email();
        email.setEmailId(rs.getInt(1));
        email.setEmailAddress(rs.getString(2));
        return email;
    }
}
