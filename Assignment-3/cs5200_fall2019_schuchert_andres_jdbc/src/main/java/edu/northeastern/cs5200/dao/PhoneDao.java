package edu.northeastern.cs5200.dao;

import edu.northeastern.cs5200.model.Phone;

public interface PhoneDao {
    void createPhoneForDeveloper(int developerId, Phone phone);

    Phone findPhoneByDeveloper(int developerId);
}
