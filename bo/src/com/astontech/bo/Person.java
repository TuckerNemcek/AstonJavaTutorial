package com.astontech.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person extends BaseBo {
    //region PROPERTIES

    // PersonId
    private int PersonId;
    //Title
    private String Title;
    //First Name
    private String FirstName;
    //Last Name
    private String LastName;
    //DisplayFirstName
    private String DisplayFirstName;
    //Create date
    private Date CreateDate;
    //Gender
    private String Gender;
    //Is Deleted
    private boolean isDeleted;

    private List<Email> Emails;

    private List<Address> Adresses;

    //endregion

    //region CONSTRUCTORS

    public Person(){
        this.Emails = new ArrayList<>();
    }



//region SET AND GET

    public List<Email> getEmails() {
        return Emails;
    }

    public void setEmails(List<Email> emailList) {
        Emails = emailList;
    }


    public boolean isDeleted() {
        return isDeleted;
    }
    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void setPersonId(int personId){
        this.PersonId = personId;
    }

    public int getPersonId(){
        return this.PersonId;
    }

    public void setFirstName(String firstName){
        this.FirstName = firstName;
    }

    public String getFirstName(){
        return this.FirstName;
    }

    public void setTitle(String title){
        this.Title = title;
    }

    public String getTitle(){
        return this.Title;
    }

    public void setLastName(String lastName){
        this.LastName = lastName;
    }

    public String getLastName(){
        return this.LastName;
    }

    public void setDisplayFirstName (String DisplayFirstName){
        this.DisplayFirstName = DisplayFirstName;
    }

    public String getDisplayFirstName (){
        return this.DisplayFirstName;
    }

    public void setGender(String gender){
        this.Gender = gender;
    }

    public String getGender(){
        return this.Gender;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }

    //endregion

    //region CUSTOM METHODS
    //notes:    this will become an extension method.

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public String GetFullName() {
        if(isNullOrEmpty(this.FirstName) && isNullOrEmpty(this.LastName))
            return "No name set";
            else{
                if (isNullOrEmpty(this.FirstName))
                    return this.LastName;
                else if (isNullOrEmpty(this.LastName))
                    return this.FirstName;
                else  return this.FirstName + " " + this.LastName;
        }

    }
    //endregion
}
