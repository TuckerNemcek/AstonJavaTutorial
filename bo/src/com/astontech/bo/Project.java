package com.astontech.bo;

import java.util.Date;
import java.util.List;

public class Project extends BaseBo {
    //PARAMETERS
    private int ProjectId;
    private EntityType entityType;
    private int Rate;
    private Date StartDate;
    private List<Client> clients;

    //CONSTRUCTORS
    public Project(){}
    public Project(int projectId, int rate, Date startDate, Date endDate, String projectName) {
        this.setProjectId(projectId);
        this.setRate(rate);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setProjectName(projectName);
    }

    private Date EndDate;
    private String ProjectName;

    //SET AND GET



    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    public int getRate() {
        return Rate;
    }

    public void setRate(int rate) {
        Rate = rate;
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

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }
}
