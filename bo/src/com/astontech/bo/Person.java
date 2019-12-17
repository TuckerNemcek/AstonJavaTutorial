package com.astontech.bo;

import common.helpers.StringHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Person extends BaseBo implements Serializable {
    //region PROPERTIES

    private int PersonId;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private Date BirthDate;
    private transient String SocialSecurityNumber;


    //endregion

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }

    public String getSocialSecurityNumber() {
        return SocialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        SocialSecurityNumber = socialSecurityNumber;
    }

    //region CONSTRUCTORS

    public Person(){
    }



//region SET AND GET

//    public List<Email> getEmails() {
//        return Emails;
//    }
//
//    public void setEmails(List<Email> emailList) {
//        Emails = emailList;
//    }


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

//    public void setTitle(String title){
//        this.Title = title;
//    }
//
//    public String getTitle(){
//        return this.Title;
 //   }

    public void setLastName(String lastName){
        this.LastName = lastName;
    }

    public String getLastName(){
        return this.LastName;
    }

//    public void setDisplayFirstName (String DisplayFirstName){
//        this.DisplayFirstName = DisplayFirstName;
//    }
//
//    public String getDisplayFirstName (){
//        return this.DisplayFirstName;
//    }

//    public void setGender(String gender){
//        this.Gender = gender;
//    }
//
//    public String getGender(){
//        return this.Gender;
//    }
//
//    public String getMiddleName() {
//        return MiddleName;
//    }
//
//    public void setMiddleName(String middleName) {
//        MiddleName = middleName;
//    }
//
//    public Date getBirthDate() {
//        return BirthDate;
//    }
//
//    public void setBirthDate(Date birthDate) {
//        BirthDate = birthDate;
//    }
//
//    public String getSSN() {
//        return SSN;
//    }
//
//    public void setSSN(String SSN) {
//        this.SSN = SSN;
//    }
//
//    public List<Address> getAdresses() {
//        return Adresses;
//    }
//
//    public void setAdresses(List<Address> adresses) {
//        Adresses = adresses;
//    }

//endregion

    //region CUSTOM METHODS
    //notes:    this will become an extension method.

    private static final long serialVersionUID = 54622233600l;

    public String GetFullName() {
        if(StringHelper.isNullOrEmpty(this.FirstName) && StringHelper.isNullOrEmpty(this.LastName))
            return "No name set";
            else{
                if (StringHelper.isNullOrEmpty(this.FirstName))
                    return this.LastName;
                else if (StringHelper.isNullOrEmpty(this.LastName))
                    return this.FirstName;
                else  return this.FirstName + " " + this.LastName;
        }
    }

    public String ToString(){
        return "PersonId= " + this.getPersonId() + " Full Name= " + this.GetFullName() + " DOB=" + this.BirthDate + this.SocialSecurityNumber;
    }

    //endregion
}
