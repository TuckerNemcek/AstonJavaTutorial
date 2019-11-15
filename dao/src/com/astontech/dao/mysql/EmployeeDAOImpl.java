package com.astontech.dao.mysql;

import com.astontech.bo.Employee;
import com.astontech.bo.Person;
import com.astontech.dao.PersonDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl extends MySQL implements EmployeeDAO {

    private static PersonDAO personDAO = new PersonDAOImpl();

    @Override
    public Employee getEmployeeBy(Employee employee) {
        Connect();
        Employee myEmployee = null;
        try {
            String sp = "{call GetEmployee(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,GET_BY_ID);
            cStmt.setInt(2, myEmployee.getPersonId());
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
        return 0;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        return false;
    }
    /*

     */
    private static Employee HydrateEmployee(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setPersonId(rs.getInt(4));
        employee.setHireDate(rs.getDate(2));
        employee.setTermDate(rs.getDate(3));
        Person person = personDAO.getPersonById(rs.getInt(4));

        employee.setFirstName(person.getFirstName());
        employee.setLastName(person.getLastName());

        return employee;
    }
}
