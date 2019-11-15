package com.astontech.bo;

import java.util.Date;

public class Employee extends Person {
    // PARAMETER
    private int employeeId;
    private Date HireDate;
    private Date TermDate;

    //CONSTRUCTORS
    public Employee() {};

    public Employee( String firstName, String lastName, Date hireDate, Date termDate ){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setHireDate(hireDate);
        this.setTermDate(termDate);
    };

    public Employee(String firstName, String lastName){
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public Employee(int employeeId, String firstName){
        this.setFirstName(firstName);
    }

    public Employee(String lastName){
        this.setLastName(lastName);
    }


    //GETTERS / SETTERS



    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setHireDate(Date hireDate){
        this.HireDate = hireDate;
    }

    public Date getHireDate(){
        return this.HireDate;
    }

    public void setTermDate(Date termDate){
        this.TermDate = termDate;
    }

    public Date getTermDate(){
        return this.TermDate;
    }

}
