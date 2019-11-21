package com.astontech.dao.mysql;

import com.astontech.bo.Email;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmailDAOImpl extends MySQL implements  EmailDAO {
    @Override
    public Email getEmailById(int emailId) {
        Connect();
        Email email = null;
        try {
            String sp = "{call GetEmail(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,GET_BY_ID);
            cStmt.setInt(2, emailId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()){
                email = HydrateEmail(rs);
            }

        }catch (SQLException sqlEx){
            logger.error(sqlEx);
        }
        return email;
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

    @Override
        public int insertEmail(Email email) {
            Connect();
            int id =0;
            try {
                String sp = "{call ExecEmail(?,?,?,?,?)}";
                CallableStatement cStmt = connection.prepareCall(sp);
                cStmt.setInt(1, INSERT);
                cStmt.setInt(2, 0);
                cStmt.setString(3, email.getEmailAddress());
                cStmt.setInt(4, email.getEmployeeId());
                cStmt.setInt(5, 1);

                ResultSet rs =cStmt.executeQuery();
                if(rs.next()){
                    id = rs.getInt(1);
                }

            } catch (SQLException sqlEx){
                logger.error(sqlEx);
            }
            return id;
        }


    @Override
    public boolean updateEmail(Email email) {
        Connect();
        int id =0;
        try {
            String sp = "{call ExecEmail(?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, email.getEmailId());
            cStmt.setString(3, email.getEmailAddress());
            cStmt.setInt(4, email.getEmployeeId());
            cStmt.setInt(5, 1);

            ResultSet rs =cStmt.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }

        } catch (SQLException sqlEx){
            logger.error(sqlEx);
        }
        return id > 0;
    }

    @Override
    public boolean deleteEmail(int emailId) {
        Connect();
        int id =0;
        try {
            String sp = "{call ExecEmail(?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, DELETE);
            cStmt.setInt(2,emailId);
            cStmt.setString(3, "");
            cStmt.setInt(4, 0);
            cStmt.setInt(5, 0);

            ResultSet rs =cStmt.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }

        } catch (SQLException sqlEx){
            logger.error(sqlEx);
        }
        return id > 0;
    }

    private static Email HydrateEmail(ResultSet rs) throws SQLException {
        Email email = new Email();
        email.setEmailId(rs.getInt(1));
        email.setEmailAddress(rs.getString(2));
        return email;
    }
}
