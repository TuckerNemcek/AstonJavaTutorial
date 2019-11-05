package com.astontech.bo;

import java.util.Date;

public class Client extends BaseBo {
    //PARAMETERS
    private int ClientId;
    private String ClientName;
    private Date CreateDate;

    //CONSTRUCTORS

    public Client(){}

    public Client(int clientId, String clientName, Date createDate) {
        this.setClientId(clientId);
        this.setClientName(clientName);
        this.setCreateDate(createDate);
    }



    //GET AND SET
    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
}
