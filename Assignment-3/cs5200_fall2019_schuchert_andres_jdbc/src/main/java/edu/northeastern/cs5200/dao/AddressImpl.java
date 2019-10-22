package edu.northeastern.cs5200.dao;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.model.Address;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class AddressImpl implements AddressDao {

    private static final String CREATE_ADDRESS = "INSERT INTO address " +
            "(person_id,street1, street2, city, state, zip, `primary`) " +
            "VALUES (?,?,?,?,?,?,?)";
    private static final String DELETE_ADDRESS_PRIMARY = "DELETE FROM address " +
            "WHERE address.person_id = ? AND address.`primary` = ?";
    private static AddressImpl instance = null;

    private AddressImpl() {}
    public static AddressImpl getInstance() {
        if(instance == null) {
            instance = new AddressImpl();
        }
        return instance;
    }

    @Override
    public void createAddress(Address address){
        try{
            java.sql.Connection conn = Connection.getConnection();
            PreparedStatement statement = conn.prepareStatement(CREATE_ADDRESS);
            statement.setInt(1,address.getPersonId());
            statement.setString(2,address.getStreet1());
            statement.setString(3,address.getStreet2());
            statement.setString(4,address.getCity());
            statement.setString(5,address.getState());
            statement.setString(6,address.getZip());
            statement.setObject(7,address.isPrimary(), Types.BOOLEAN);
            statement.executeUpdate();
            Connection.closeConnection();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAddressPrimary(int personId) {
        try{
            java.sql.Connection conn = Connection.getConnection();
            PreparedStatement statement = conn.prepareStatement(DELETE_ADDRESS_PRIMARY);
            statement.setInt(1,personId);
            statement.setObject(2,true,Types.BOOLEAN);
            statement.executeUpdate();
            Connection.closeConnection();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
