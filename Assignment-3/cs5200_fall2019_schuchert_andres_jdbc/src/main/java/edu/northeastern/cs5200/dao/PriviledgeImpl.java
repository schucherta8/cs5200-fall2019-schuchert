package edu.northeastern.cs5200.dao;

import edu.northeastern.cs5200.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class PriviledgeImpl implements PriviledgeDao {

	private static final String ASSIGN_WEBSITE_PRIVILEDGE = "INSERT INTO website_priviledge"
			+ "(developer_id, website_id, priviledge) "
			+ "VALUES (?, ?, ?)";
	private static final String ASSIGN_PAGE_PRIVILEDGE = "INSERT INTO page_priviledge"
			+ "(developer_id, page_id, priviledge) "
			+ "VALUES (?, ?, ?)";
	private static final String DELETE_WEBSITE_PRIVILEDGE = "DELETE FROM website_priviledge " +
			"WHERE website_priviledge.developer_id = ? AND website_priviledge.website_id = ? " +
			"AND website_priviledge.priviledge = ?";
	private static final String DELETE_PAGE_PRIVILEDGE = "DELETE FROM page_priviledge " +
			"WHERE page_priviledge.developer_id = ? AND page_priviledge.page_id = ? " +
			"AND page_priviledge.priviledge = ?";

	private static PriviledgeImpl instance = null;

	private PriviledgeImpl() {}
	public static PriviledgeImpl getInstance() {
		if(instance == null) {
			instance = new PriviledgeImpl();
		}
		return instance;
	}

	@Override
	public void assignWebsitePriviledge(int developerId, int websiteId, String priviledge) {
		try{
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(ASSIGN_WEBSITE_PRIVILEDGE);
			statement.setInt(1,developerId);
			statement.setInt(2,websiteId);
			statement.setString(3,priviledge);
			statement.executeUpdate();
			//Connection.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void assignPagePriviledge(int developerId, int pageId, String priviledge) {
		try{
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(ASSIGN_PAGE_PRIVILEDGE);
			statement.setInt(1,developerId);
			statement.setInt(2,pageId);
			statement.setString(3,priviledge);
			statement.executeUpdate();
			//Connection.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteWebsitePriviledge(int developerId, int websiteId, String priviledge) {
		try{
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(DELETE_WEBSITE_PRIVILEDGE);
			statement.setInt(1,developerId);
			statement.setInt(2,websiteId);
			statement.setString(3,priviledge);
			statement.executeUpdate();
			//Connection.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	@Override
	public void deletePagePriviledge(int developerId, int pageId, String priviledge) {
		try{
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(DELETE_PAGE_PRIVILEDGE);
			statement.setInt(1,developerId);
			statement.setInt(2,pageId);
			statement.setString(3,priviledge);
			statement.executeUpdate();
			//Connection.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}

}
