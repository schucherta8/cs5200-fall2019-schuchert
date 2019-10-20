package edu.northeastern.cs5200.dao;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.model.Phone;

import java.sql.SQLException;

public class PhoneImpl implements PhoneDao {

    private static final String CREATE_PHONE = "INSERT INTO phone";
    private static PhoneImpl instance = null;

    private PhoneImpl() {}
    public static PhoneImpl getInstance() {
        if(instance == null) {//If the instance doesn't already exist
            instance = new PhoneImpl();//Instaniate it just this once
        }
        return instance;//If it exists, ill return it to you.
    }

    @Override
    public void createPhoneForDeveloper(int developerId, Phone phone) {
        try{
            java.sql.Connection conn = Connection.getConnection();

        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Phone findPhoneByDeveloper(int developerId) {
        return null;
    }
}
