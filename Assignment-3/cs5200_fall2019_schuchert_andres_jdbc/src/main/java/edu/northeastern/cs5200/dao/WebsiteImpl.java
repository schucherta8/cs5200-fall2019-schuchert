package edu.northeastern.cs5200.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.model.Developer;
import edu.northeastern.cs5200.model.Website;

public class WebsiteImpl implements WebsiteDao {
	private static final String CREATE_WEBSITE = "INSERT INTO website"
			+ "(website_id,developer_id, `name`,description,created,updated,visits) "
			+ "VALUES (?,?,?,?,?,?,?)";
	private static final String FIND_ALL_WEBSITES = "SELECT * FROM website";
	private static final String FIND_WEBSITES_BY_DEVELOPER = "SELECT * FROM website WHERE website.developer_id = ?";
	private static final String FIND_WEBSITE_BY_ID = "SELECT * FROM website WHERE website.website_id = ?";
	private static final String UPDATE_WEBSITE_BY_ID = "UPDATE website "
			+ "SET `name` = ?, description = ?, created = ?, updated = ?, visits = ? "
			+ "WHERE website.website_id = ?";
	private static final String DELETE_WEBSITE_BY_ID = "DELETE FROM website WHERE website.website_id = ?";
	private static WebsiteImpl instance = null;
	
	private WebsiteImpl() {}
	public static WebsiteImpl getInstance() {
		if(instance == null) {//If the instance doesn't already exist
			instance = new WebsiteImpl();//Instaniate it just this once
		}
		return instance;//If it exists, ill return it to you.
	}
	
	@Override
	public void createWebsiteForDeveloper(int developerId, Website website) {
		// TODO Auto-generated method stub
		try {
			DeveloperImpl devDao = DeveloperImpl.getInstance();
			Developer dev = devDao.findDeveloperById(developerId);
			dev.insertWebsite(website);
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(CREATE_WEBSITE);
			statement.setInt(1,website.getId());
			statement.setInt(2, developerId);
			statement.setString(3, website.getName());
			statement.setString(4, website.getDescription());
			statement.setDate(5,website.getCreated());
			statement.setDate(6, website.getUpdated());
			statement.setObject(7, website.getVisits(), Types.INTEGER);
			statement.executeUpdate();
			Connection.closeConnection();
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Collection<Website> findAllWebsites() {
		// TODO Auto-generated method stub
		Collection<Website> websites = new ArrayList<Website>();
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(FIND_ALL_WEBSITES);
			ResultSet res = statement.executeQuery();
			while(res.next()) {
				int id = res.getInt("website_id");
				int developerId = res.getInt("developer_id");
				String name = res.getString("name");
				String description = res.getString("description");
				Date created = res.getDate("created");
				Date updated = res.getDate("updated");
				Integer visits = res.getInt("visits");
				Website website = new Website(id,name,description,created,updated,visits);
				website.setDeveloperId(developerId);
				websites.add(website);
			}
			Connection.closeConnection();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return websites;
	}

	@Override
	public Collection<Website> findWebsitesForDeveloper(int developerId) {
		// TODO Auto-generated method stub
		Collection<Website> websites = new ArrayList<Website>();
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(FIND_WEBSITES_BY_DEVELOPER);
			statement.setInt(1, developerId);
			ResultSet res = statement.executeQuery();
			while(res.next()) {
				int id = res.getInt("website_id");
				developerId = res.getInt("developer_id");
				String name = res.getString("name");
				String description = res.getString("description");
				Date created = res.getDate("created");
				Date updated = res.getDate("updated");
				Integer visits = res.getInt("visits");
				Website website = new Website(id,name,description,created,updated,visits);
				website.setDeveloperId(developerId);
				websites.add(website);
			}
			Connection.closeConnection();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return websites;
	}

	@Override
	public Website findWebsiteById(int websiteId) {
		// TODO Auto-generated method stub
		Website website = null;
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(FIND_WEBSITE_BY_ID);
			statement.setInt(1, websiteId);
			ResultSet res = statement.executeQuery();
			if(res.next()) {
				websiteId = res.getInt("website_id");
				int developerId = res.getInt("developer_id");
				String name = res.getString("name");
				String description = res.getString("description");
				Date created = res.getDate("created");
				Date updated = res.getDate("updated");
				Integer visits = res.getInt("visits");
				website = new Website(websiteId,name,description,created,updated,visits);
				website.setDeveloperId(developerId);
			}
			Connection.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return website;
	}

	@Override
	public int updateWebsite(int websiteId, Website website) {
		// TODO Auto-generated method stub
		int res = -1;
		try{
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(UPDATE_WEBSITE_BY_ID);
			statement.setString(1,website.getName());
			statement.setString(2,website.getDescription());
			statement.setDate(3,website.getCreated());
			statement.setDate(4,website.getUpdated());
			statement.setObject(5,website.getVisits(), Types.INTEGER);
			statement.setInt(6,websiteId);
			statement.executeUpdate();
			Connection.closeConnection();
			res = 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int deleteWebsite(int websiteId) {
		// TODO Auto-generated method stub
		int res = -1;
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement person_statement = conn.prepareStatement(DELETE_WEBSITE_BY_ID);
			person_statement.setInt(1, websiteId);
			res = person_statement.executeUpdate();
			Connection.closeConnection();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return res;
	}

}
