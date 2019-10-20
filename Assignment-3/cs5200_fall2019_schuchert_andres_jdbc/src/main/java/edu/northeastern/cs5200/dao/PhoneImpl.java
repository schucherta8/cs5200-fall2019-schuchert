package edu.northeastern.cs5200.dao;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.model.Phone;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PhoneImpl implements PhoneDao {

    private static final String CREATE_PHONE = "INSERT INTO phone(person_id, phone, `primary`) VALUES (?,?,?)";
    private static final String UPDATE_PHONE = "UPDATE phone " +
            "SET phone = ? primary = ?" +
            "WHERE phone.person_id = ?";
    private static PhoneImpl instance = null;

    private PhoneImpl() {}
    public static PhoneImpl getInstance() {
        if(instance == null) {
            instance = new PhoneImpl();
        }
        return instance;
    }

    @Override
    public void createPhone(Phone phone) {
        try{
            java.sql.Connection conn = Connection.getConnection();
            PreparedStatement statement = conn.prepareStatement(CREATE_PHONE);
            statement.setInt(1,phone.getPersonId());
            statement.setString(2,phone.getPhone());
            statement.setBoolean(3,phone.isPrimary());
            statement.executeUpdate();
            Connection.closeConnection();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Phone findPhoneByCredentials(String number, boolean primary) {
        return null;
    }


    @Override
    public int updatePhone(int personId, Phone phone) {
        int res = -1;
        try{
            java.sql.Connection conn = Connection.getConnection();
            PreparedStatement statement = conn.prepareStatement(UPDATE_PHONE);
            statement.setInt(1,phone.getPersonId());
            statement.setString(2,phone.getPhone());
            statement.setBoolean(3,phone.isPrimary());
            statement.setInt(4,personId);
            statement.executeUpdate();
            Connection.closeConnection();
            res = 0;
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }
}
