package com.astontech.dao.mysql;

import com.astontech.bo.Phone;

import java.util.List;

public interface PhoneDAO {
    //region GET METHODS
    public Phone getPhoneById(Phone phone);
    public List<Phone> getPhoneList();
    //endregion
}
