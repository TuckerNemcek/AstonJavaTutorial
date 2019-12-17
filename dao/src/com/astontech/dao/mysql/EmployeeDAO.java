package com.astontech.dao.mysql;

import com.astontech.bo.Employee;

import java.util.List;

public interface EmployeeDAO {
    //region GET METHODS
    public Employee getEmployeeById(int employeeId);
    public List<Employee> getEmployeeList();
    //endregion

    //region EXECUTE METHODS
    public int insertEmployee(Employee employee);
    public boolean updateEmployee(Employee employee);
    public boolean deleteEmployee (int employeeId);
}
