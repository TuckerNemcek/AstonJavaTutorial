package com.astontech.dao.mysql;

import com.astontech.bo.Employee;
import com.astontech.bo.Person;
import com.astontech.dao.PersonDAO;
import common.helpers.DateHelper;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl extends MySQL implements EmployeeDAO {

    private static PersonDAO personDAO = new PersonDAOImpl();

    @Override
    public Employee getEmployeeById(int employeeId) {
        Connect();
        Employee employee = null;
        try {
            String sp = "{call GetEmployee(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,GET_BY_ID);
            cStmt.setInt(2, employeeId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()){
                employee = HydrateEmployee(rs);
            }

        }catch(SQLException sqlEx){
            logger.error(sqlEx);
        }

        return employee;
    }

    @Override
    public List<Employee> getEmployeeList() {
        Connect();
        List<Employee> employeeList = new ArrayList<Employee>();
        try{
            String sp = "{call GetEmployee(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1,GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()){
                employeeList.add(HydrateEmployee(rs));
            }

        }catch (SQLException sqlEx){
            logger.error(sqlEx);
        }
        return employeeList;
    }

    @Override
    public int insertEmployee(Employee employee) {
        Connect();
        int id = 0;
        try{
            String sp = "{call ExecEmployee(?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1, INSERT);
            cStmt.setInt(2,0);
            cStmt.setDate(3, DateHelper.utilDateToSqlDate((employee.getHireDate())));
            cStmt.setDate(4, DateHelper.utilDateToSqlDate((employee.getTermDate())));
            cStmt.setInt(5, employee.getPersonId());

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }

        } catch (SQLException sqlEx){
            logger.error(sqlEx);
        }
        return id;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        Connect();
        int id = 0;
        try{
            String sp = "{call ExecEmployee(?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2,employee.getEmployeeId());
            cStmt.setDate(3, DateHelper.utilDateToSqlDate((employee.getHireDate())));
            cStmt.setDate(4, DateHelper.utilDateToSqlDate((employee.getTermDate())));
            cStmt.setInt(5, employee.getPersonId());

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }

        } catch (SQLException sqlEx){
            logger.error(sqlEx);
        }
        return id > 0;
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        Connect();
        int id = 0;
        try{
            String sp = "{call ExecEmployee(?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1, DELETE);
            cStmt.setInt(2,employeeId);
            cStmt.setDate(3, new java.sql.Date(0));
            cStmt.setDate(4, new java.sql.Date(0));
            cStmt.setInt(5, 0);

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }

        } catch (SQLException sqlEx){
            logger.error(sqlEx);
        }
        return id > 0;
    }
    /*

     */
    private static Employee HydrateEmployee(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setPersonId(rs.getInt(1));
        employee.setHireDate(rs.getDate(2));
        employee.setTermDate(rs.getDate(3));
        employee.setPersonId(rs.getInt(4));

        return employee;
    }
}
