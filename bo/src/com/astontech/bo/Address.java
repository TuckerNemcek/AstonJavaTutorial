package com.astontech.bo;

import java.util.Date;
import java.util.List;

public class Address extends BaseBo {
    //PARAMETERS
    private int AddressId;

    private int AddressNumber;
    private int StateId;
    private int CountryId;
    private Date DateCreate;
    private String Street;
    private String Street02;
    private String City;
    private Client ClientAd;
    private Person PersonAd;


    //CONSTRUCTORS
    public Address(){}

    public Address(int addressId, int addressNumber,
                   String street, String street02, String city, int stateId, int countryId, Date dateCreate){
        this.setAddressId(addressId);
        this.setAddressNumber(addressNumber);
        this.setStreet(street);
        this.setStreet02(street02);
        this.setCity(city);
        this.setStateId(stateId);
        this.setCountryId(countryId);
        this.setDateCreate(dateCreate);
        this.PersonAd = new Person();
        this.ClientAd = new Client();
    }


    public Address(int addressId, int addressNumber,
                   String street, String city, int stateId, int countryId, Date dateCreate){
        this.setAddressId(addressId);

        this.setAddressNumber(addressNumber);
        this.setStreet(street);
        this.setCity(city);
        this.setStateId(stateId);
        this.setCountryId(countryId);
        this.setDateCreate(dateCreate);
    }

    //GET // SET


    public int getAddressId() {
        return AddressId;
    }

    public void setAddressId(int addressId) {
        AddressId = addressId;
    }

    public Client getClientAd() {
        return ClientAd;
    }

    public void setClientAd(Client clientAd) {
        ClientAd = clientAd;
    }

    public Person getPersonAd() {
        return PersonAd;
    }

    public void setPersonAd(Person personAd) {
        PersonAd = personAd;
    }

    public int getAddressNumber() {
        return AddressNumber;
    }

    public void setAddressNumber(int addressNumber) {
        AddressNumber = addressNumber;
    }

    public int getStateId() {
        return StateId;
    }

    public void setStateId(int stateId) {
        StateId = stateId;
    }

    public int getCountryId() {
        return CountryId;
    }

    public void setCountryId(int countryId) {
        CountryId = countryId;
    }

    public Date getDateCreate() {
        return DateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        DateCreate = dateCreate;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getStreet02() {
        return Street02;
    }

    public void setStreet02(String street02) {
        Street02 = street02;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }


    //HELPER METHODS


    public String AddressChecker(){
        String adStr = String.valueOf(getAddressNumber());
        int adLength = adStr.length();
        if(adLength == 5){
            return "Nice Address";
        }
        else return "Incorrect or non-typical address";
    }

}
