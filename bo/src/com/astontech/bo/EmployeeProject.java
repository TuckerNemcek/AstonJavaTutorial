package com.astontech.bo;

import java.util.Date;

public class EmployeeProject extends BaseBo {
    //PARAMETERS
    private int EmployeeProjectId;
    private int ProjectId;
    private Employee employee;
    private int EntityTypeId;
    private int VehicleId;
    private Date StartDate;
    private Date EndDate;
    private String Notes;

    //CONSTRUCTORS
    public EmployeeProject(){}
    public EmployeeProject(int employeeProjectId, int projectId, int entityTypeId, int vehicleId, Date startDate, Date endDate, String notes) {
        this.setEmployeeProjectId(employeeProjectId);
        this.setProjectId(projectId);
        this.setEntityTypeId(entityTypeId);
        this.setVehicleId(vehicleId);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setNotes(notes);
    }

    //SETTERS AND GETTERS
    public int getEmployeeProjectId() {
        return EmployeeProjectId;
    }

    public void setEmployeeProjectId(int employeeProjectId) {
        EmployeeProjectId = employeeProjectId;
    }

    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public int getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(int vehicleId) {
        VehicleId = vehicleId;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }
}
