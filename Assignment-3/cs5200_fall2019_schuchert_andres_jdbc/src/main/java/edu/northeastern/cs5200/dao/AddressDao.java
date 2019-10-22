package edu.northeastern.cs5200.dao;

import edu.northeastern.cs5200.model.Address;

public interface AddressDao {

    void createAddress(Address address);

    void deleteAddressPrimary(int personId);
}
