package com.astontech.bo;

import java.util.Date;

public class ProjectStatus extends BaseBo {
    //PARAMETERS
    private int ProjectStatusId;
    private int EntityTypeId;
    private String Notes;
    private int PercentComplete;
    private Date StartDate;
    private Date EndDate;
    private Project project;


    //CONSTRUCTORS
    public ProjectStatus(){}
    public ProjectStatus(int projectStatusId, int entityTypeId, String notes, int percentComplete, Date startDate, Date endDate) {
        this.setProjectStatusId(projectStatusId);
        this.setEntityTypeId(entityTypeId);
        this.setNotes(notes);
        this.setPercentComplete(percentComplete);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
    }

    //SET AND GET
    public int getProjectStatusId() {
        return ProjectStatusId;
    }

    public void setProjectStatusId(int projectStatusId) {
        ProjectStatusId = projectStatusId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public int getPercentComplete() {
        return PercentComplete;
    }

    public void setPercentComplete(int percentComplete) {
        PercentComplete = percentComplete;
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

    //HELPER METHODS
    public String ProgressYeller(){
        int per = getPercentComplete();
        if(per < 10){
            return "LESS THAN 10%?! GET TO WORK!";
        }
        else if (per < 50){
            return "UNDER HALFWAY DONE GET TO WORK!!!";
        }
        else if (per < 90){
            return "OVER HALFWAY DONE GET TO WORK";
        }
        else if (per < 100){
            return "ALMOST DONE GET TO WORK";
        }
        else if (per >= 100){
            return "ATTABOY NOW I GOT ANOTHER PROJECT FOR YOU";
        }
        else return "GET TO WORK";
    }
}
