package edu.northeastern.cs5200.dao;

import edu.northeastern.cs5200.model.Phone;

public interface PhoneDao {
    void createPhone(Phone phone);

    int updatePhonePrimary(int personId, Phone phone);
}
