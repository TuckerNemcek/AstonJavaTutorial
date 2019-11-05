package com.astontech.bo;

import java.util.Date;

public class Training extends BaseBo {
    //PARAMETERS
    private int TrainingId;
    private int EmployeeId;
    private String TrainingName;
    private Date CreateDate;

    //CONSTRUCTORS
    public Training(){}
    public Training(int trainingId, int employeeId, String trainingName, Date createDate) {
        this.setTrainingId(trainingId);
        this.setEmployeeId(employeeId);
        this.setTrainingName(trainingName);
        this.setCreateDate(createDate);
    }


    //SET AND GET
    public int getTrainingId() {
        return TrainingId;
    }

    public void setTrainingId(int trainingId) {
        TrainingId = trainingId;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public String getTrainingName() {
        return TrainingName;
    }

    public void setTrainingName(String trainingName) {
        TrainingName = trainingName;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
}
