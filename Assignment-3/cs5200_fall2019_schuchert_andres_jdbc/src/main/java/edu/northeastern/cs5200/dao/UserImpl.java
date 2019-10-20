package edu.northeastern.cs5200.dao;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserImpl implements UserDao {
    private static final String CREATE_PERSON = "INSERT INTO person_generalization "
            + "(person_id, firstname, lastname, username, password, email, dob)"
            + "VALUES (?,?,?,?,?,?,?)";
    private static final String CREATE_USER = "INSERT INTO user_person_generalization " +
            "(user_id, user_agreement) " +
            "VALUES (?,?)";
    private static UserImpl instance = null;

    private UserImpl() {}
    public static UserImpl getInstance() {
        if(instance == null) {
            instance = new UserImpl();
        }
        return instance;
    }
    @Override
    public void createUser(User user) {
        try {
            java.sql.Connection conn = Connection.getConnection();
            PreparedStatement create_person = conn.prepareStatement(CREATE_PERSON);
            create_person.setInt(1, user.getId());
            create_person.setString(2,user.getFirstName());
            create_person.setString(3, user.getLastName());
            create_person.setString(4, user.getUsername());
            create_person.setString(5,user.getPassword());
            create_person.setString(6,user.getEmail());
            create_person.setDate(7, user.getDob());
            create_person.executeUpdate();
            PreparedStatement create_user = conn.prepareStatement(CREATE_USER);
            create_user.setInt(1, user.getId());
            create_user.setBoolean(2, user.isUserAgreement());
            create_user.executeUpdate();
            Connection.closeConnection();
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
