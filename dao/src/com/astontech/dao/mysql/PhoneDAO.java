package com.astontech.dao.mysql;

import com.astontech.bo.Email;
import com.astontech.bo.Phone;

import java.util.List;

public interface PhoneDAO {
    //region GET METHODS
    public Phone getPhoneById(int phoneId);
    public List<Phone> getPhoneList();
    //endregion

    //region EXECUTE METHODS
    public int insertPhone(Phone phone);
    public boolean updatePhone(Phone phone);
    public boolean deletePhone(int phoneId);
    //endregion
}
