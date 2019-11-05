package com.astontech.bo;

public class ClientContact extends BaseBo {
    //PARAMETERS
    private int ClientContactId;
    private int ClientId;
    private int EntityTypeId;

    //CONSTRUCTORS
    public ClientContact(){}
    public ClientContact(int clientContactId, int clientId, int entityTypeId, int personId) {
        this.setClientContactId(clientContactId);
        this.setClientId(clientId);
        this.setEntityTypeId(entityTypeId);
        this.setPersonId(personId);
    }

    //GET AND SET
    public int getClientContactId() {
        return ClientContactId;
    }

    public void setClientContactId(int clientContactId) {
        ClientContactId = clientContactId;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }

    private int PersonId;


}
