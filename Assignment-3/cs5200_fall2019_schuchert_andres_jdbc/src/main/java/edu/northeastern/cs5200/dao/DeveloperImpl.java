package edu.northeastern.cs5200.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.model.Developer;
import edu.northeastern.cs5200.model.Phone;

public class DeveloperImpl implements DeveloperDao {
	private static final String CREATE_PERSON = "INSERT INTO person_generalization"
			+ "(person_id, firstname, lastname, username, password, email, dob)"
			+ "VALUES (?,?,?,?,?,?,?)";
	private static final String CREATE_DEVELOPER = "INSERT INTO developer_person_generalization"
			+ "(developer_id, developer_key) "
			+ "VALUES (?,?)";
	private static final String FIND_ALL_DEVELOPERS = "SELECT * FROM person_generalization "
			+ "INNER JOIN developer_person_generalization "
			+ "ON person_generalization.person_id = developer_person_generalization.developer_id";
	private static final String FIND_DEVELOPER_BY_ID = "SELECT * FROM person_generalization "
			+ "INNER JOIN developer_person_generalization "
			+ "WHERE person_generalization.person_id = developer_person_generalization.developer_id "
			+ "AND developer_person_generalization.developer_id = ?";
	private static final String FIND_DEVELOPER_BY_USERNAME = "SELECT * FROM person_generalization "
			+ "INNER JOIN developer_person_generalization "
			+ "WHERE person_generalization.person_id = developer_person_generalization.developer_id "
			+ "AND person_generalization.username = ?";
	private static final String FIND_DEVELOPER_BY_CREDENTIALS = "SELECT * FROM person_generalization "
			+ "INNER JOIN developer_person_generalization "
			+ "WHERE person_generalization.person_id = developer_person_generalization.developer_id "
			+ "AND person_generalization.username = ? "
			+ "AND person_generalization.password = ?";
	private static final String UPDATE_PERSON_BY_ID = "UPDATE person_generalization "
			+ "SET firstname = ?, lastname = ?, username = ?, password = ?, email = ?, dob = ? "
			+ "WHERE person_generalization.person_id = ?";
	private static final String UPDATE_DEVELOPER_BY_ID = "UPDATE developer_person_generalization "
			+ "SET developer_key = ? "
			+ "WHERE developer_generalization.developer_id = ?";
	private static final String DELETE_PERSON_BY_ID = "DELETE FROM person_generalization "
			+ "WHERE person_generalization.person_id = ?";
	private static final String DELETE_DEVELOPER_BY_ID = "DELETE FROM developer_person_generalization "
			+ "WHERE developer_person_generalization.developer_id = ?";
	
	private static DeveloperImpl instance = null;
	
	/*
	 * Create a SingleTon DeveloperDao
	 */
	private DeveloperImpl() {}
	public static DeveloperImpl getInstance() {
		if(instance == null) {//If the instance doesn't already exist
			instance = new DeveloperImpl();//Instaniate it just this once
		}
		return instance;//If it exists, ill return it to you.
	}
	
	@Override
	public void createDeveloper(Developer developer) {
		// TODO Auto-generated method stub
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement create_person = conn.prepareStatement(CREATE_PERSON);
			create_person.setInt(1, developer.getId());
			create_person.setString(2,developer.getFirstName());
			create_person.setString(3, developer.getLastName());
			create_person.setString(4, developer.getUsername());
			create_person.setString(5,developer.getPassword());
			create_person.setString(6,developer.getEmail());
			create_person.setDate(7, developer.getDob());
			create_person.executeUpdate();
			PreparedStatement create_developer = conn.prepareStatement(CREATE_DEVELOPER);
			create_developer.setInt(1, developer.getId());
			create_developer.setString(2, developer.getDeveloperKey());
			create_developer.executeUpdate();
			conn.close();
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Collection<Developer> findAllDevelopers() {
		// returns all joined records from Developer and Person tables as a Collection of Developer instances.
		Collection<Developer> developers = new ArrayList<Developer>();
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(FIND_ALL_DEVELOPERS);
			ResultSet res = statement.executeQuery();
			while(res.next()) {
				String developerKey = res.getString("developer_key");
				int developerId = res.getInt("developer_id");
				String firstName = res.getString("firstname");
				String lastName = res.getString("lastname");
				String username = res.getString("username");
				String password = res.getString("password");
				String email = res.getString("email");
				Date dob = res.getDate("dob");
				/*
				String phone = res.getString("phone");
				boolean primary = res.getBoolean("`primary`");
				Phone devPhone = new Phone(phone,primary,developerId);
				String street1 = res.getString("street1");
				String street2 = res.getString("street2");
				*/
				Developer developer = new Developer(developerKey,developerId,
						firstName,lastName,username,password,email,dob);
				/*
				developer.insertPhone(devPhone);
				developer.insertAddress(devAddress);
				*/
				developers.add(developer);
			}
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return developers;
	}

	@Override
	public Developer findDeveloperById(int developerId) {
		// returns a joined record from Developer and Person tables
		//whose id field is equal to the developerId parameter
		Developer developer = null;
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(FIND_DEVELOPER_BY_ID);
			statement.setInt(1,developerId);
			ResultSet res = statement.executeQuery();
			if(res.next()) {
				developerId = res.getInt("developer_id");
				String developerKey = res.getString("developer_key");
				String firstName = res.getString("firstname");
				String lastName = res.getString("lastname");
				String username = res.getString("username");
				String password = res.getString("password");
				String email = res.getString("email");
				Date dob = res.getDate("dob");
				developer = new Developer(developerKey,developerId,firstName,lastName,username,password,email,dob);
			}
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return developer;
	}

	@Override
	public Developer findDeveloperByUsername(String username) {
		// TODO Auto-generated method stub
		Developer developer = null;
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(FIND_DEVELOPER_BY_USERNAME);
			statement.setString(1,username);
			ResultSet res = statement.executeQuery();
			if(res.next()) {
				username = res.getString("username");
				int developerId = res.getInt("developer_id");
				String developerKey = res.getString("developer_key");
				String firstName = res.getString("firstname");
				String lastName = res.getString("lastname");
				String password = res.getString("password");
				String email = res.getString("email");
				Date dob = res.getDate("dob");
				developer = new Developer(developerKey,developerId,firstName,lastName,username,password,email,dob);
			}
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return developer;
	}

	@Override
	public Developer findDeveloperByCredentials(String username, String password) {
		// TODO Auto-generated method stub
		Developer developer = null;
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(FIND_DEVELOPER_BY_CREDENTIALS);
			statement.setString(1,username);
			statement.setString(2, password);
			ResultSet res = statement.executeQuery();
			if(res.next()) {
				username = res.getString("username");
				password = res.getString("password");
				int developerId = res.getInt("developer_id");
				String developerKey = res.getString("developer_key");
				String firstName = res.getString("firstname");
				String lastName = res.getString("lastname");
				String email = res.getString("email");
				Date dob = res.getDate("dob");
				developer = new Developer(developerKey,developerId,firstName,lastName,username,password,email,dob);
			}
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return developer;
	}

	@Override
	public int updateDeveloper(int developerId, Developer developer) {
		// TODO Auto-generated method stub
		int res = -1;
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement person_statement = conn.prepareStatement(UPDATE_PERSON_BY_ID);
			person_statement.setString(1,developer.getFirstName());
			person_statement.setString(2, developer.getLastName());
			person_statement.setString(3, developer.getUsername());
			person_statement.setString(4, developer.getPassword());
			person_statement.setString(5, developer.getEmail());
			person_statement.setDate(6, developer.getDob());
			person_statement.setInt(7, developerId);
			res = person_statement.executeUpdate();
			
			PreparedStatement developer_statement = conn.prepareStatement(UPDATE_DEVELOPER_BY_ID);
			developer_statement.setString(1, developer.getDeveloperKey());
			developer_statement.setInt(2, developer.getId());
			res = developer_statement.executeUpdate();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int deleteDeveloper(int developerId) {
		// TODO Auto-generated method stub
		int res = -1;
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement person_statement = conn.prepareStatement(DELETE_PERSON_BY_ID);
			person_statement.setInt(1, developerId);
			res = person_statement.executeUpdate();
			
			PreparedStatement developer_statement = conn.prepareStatement(DELETE_DEVELOPER_BY_ID);
			developer_statement.setInt(1, developerId);
			res = person_statement.executeUpdate();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return res;
	}

}
