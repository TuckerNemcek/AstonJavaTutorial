package com.astontech.bo;

public class Phone extends BaseBo {
    //SET AND GET
    private int PhoneId;
    private int EntityTypeId;
    private int ClientId;
    private int PersonId;
    private int AreaCode;
    private long PhoneNumber;
    private int PhoneNumberPost;

    //CONSTRUCTOR
    public Phone(){}
    public Phone(int phoneId, int entityTypeId, int clientId, int personId, int areaCode, long phoneNumber, int phoneNumberPost) {
        this.setPhoneId(phoneId);
        this.setEntityTypeId(entityTypeId);
        this.setClientId(clientId);
        this.setPersonId(personId);
        this.setAreaCode(areaCode);
        this.setPhoneNumber(phoneNumber);
        this.setPhoneNumber(phoneNumber);
        this.setPhoneNumberPost(phoneNumberPost);
    }

    //CONSTRUCTORS
    public int getPhoneId() {
        return PhoneId;
    }

    public void setPhoneId(int phoneId) {
        PhoneId = phoneId;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }

    public int getAreaCode() {
        return AreaCode;
    }

    public void setAreaCode(int areaCode) {
        AreaCode = areaCode;
    }

    public long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getPhoneNumberPost() {
        return PhoneNumberPost;
    }

    public void setPhoneNumberPost(int phoneNumberPost) {
        PhoneNumberPost = phoneNumberPost;
    }

    //HELPER METHODS




    public String PhoneNumLength(){
        String phStr = Long.toString(getPhoneNumber());
        long phLength = phStr.length();
        if(phLength == 10){
            return "You have a normal number";
        }
        else return "You have an abnormal phone number";
    }

}
