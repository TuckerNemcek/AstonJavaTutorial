package com.astontech.dao.mysql;

import com.astontech.bo.Email;

import java.util.List;

public interface EmailDAO {
    //region GET METHODS
    public Email getEmailById(int emailId);
    public List<Email> getEmailList();
    //endregion

    //region EXECUTE METHODS
    public int insertEmail(Email email);
    public boolean updateEmail(Email email);
    public boolean deleteEmail(int emailId);
    //endregion
}
