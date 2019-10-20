package edu.northeastern.cs5200.dao;

import edu.northeastern.cs5200.model.Phone;

public interface PhoneDao {
    void createPhone(Phone phone);

    Phone findPhoneByCredentials(String phone, boolean primary);

    int updatePhone(int personId, Phone phone);
}
