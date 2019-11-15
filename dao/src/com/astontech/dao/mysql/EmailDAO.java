package com.astontech.dao.mysql;

import com.astontech.bo.Email;

import java.util.List;

public interface EmailDAO {
    //region GET METHODS
    public Email getEmailbyId(Email email);
    public List<Email> getEmailList();
    //endregion
}
