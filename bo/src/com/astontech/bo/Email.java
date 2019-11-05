package com.astontech.bo;

public class Email extends BaseBo {
    //region PARAMETERS
    private int EmailId;
    private int EmployeeId;
    private String EmailAddress;
    private EntityType emailType;


    //endregion

    //region CONSTRUCTORS
    public Email(){}

    public Email(String emailAddress){
        this.emailType = new EntityType();
        this.EmailAddress = emailAddress;
    }

    public Email(int emailId, int employeeId, String emailAddress) {
        this.setEmailId(emailId);
        this.setEmployeeId(employeeId);
        this.setEmailAddress(emailAddress);
    }
    //endregion

    //region SET AND GET

    public EntityType getEmailType() {
        return emailType;
    }

    public void setEmailType(EntityType emailType) {
        emailType = emailType;
    }

    public int getEmailId() {
        return EmailId;
    }

    public void setEmailId(int emailId) {
        EmailId = emailId;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }


    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }
    //endregion

    //regionHELPER METHODS

    public String EmailChecker(){
        String str = this.getEmailAddress();
        if (str.contains("@gmail")){
            return("You have a gmail address");
        }
        else if (str.contains("@astontech")){
            return("You have an Aston address");
        }
        else if (str.contains("@hotmail")){
            return("You have an Hotmail address");
        }
        else if (str.contains("@msn")){
            return("You have an msn address");
        }
        else {
            return("You have an email address I don't recognize");
        }
    }
    //endregion
}

