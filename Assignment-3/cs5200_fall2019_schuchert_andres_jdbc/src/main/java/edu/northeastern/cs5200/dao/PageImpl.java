package edu.northeastern.cs5200.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.model.Page;
import edu.northeastern.cs5200.model.Website;

public class PageImpl implements PageDao {

	private static final String CREATE_PAGE_FOR_WEBSITE =  "INSERT INTO page "
			+ "(page_id,website_id,title,description,created,updated,views) "
			+ "VALUES (?,?,?,?,?,?,?)";
	private static final String FIND_ALL_PAGES = "SELECT * FROM page";
	private static final String FIND_PAGE_BY_ID = "SELECT * FROM page WHERE page.page_id = ?";
	private static final String FIND_ALL_PAGES_FOR_WEBSITE = "SELECT * FROM page WHERE page.website_id = ?";
	private static final String UPDATE_PAGE = "UPDATE page " +
			"SET website_id = ?, title = ?, description = ?, created = ?, updated = ?, views = ? " +
			"WHERE page.page_id = ?";
	private static final String DELETE_PAGE = "DELETE FROM page WHERE page.page_id = ?";
	
	private static PageImpl instance = null;
	
	private PageImpl() {}
	public static PageImpl getInstance() {
		if(instance == null) {//If the instance doesn't already exist
			instance = new PageImpl();//Instaniate it just this once
		}
		return instance;//If it exists, ill return it to you.
	}
	
	@Override
	public void createPageForWebsite(int websiteId, Page page) {
		// TODO Auto-generated method stub
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(CREATE_PAGE_FOR_WEBSITE);
			WebsiteImpl websiteDao = WebsiteImpl.getInstance();
			Website website = websiteDao.findWebsiteById(websiteId);
			website.insertPage(page);
			statement.setInt(1, page.getId());
			statement.setInt(2, websiteId);
			statement.setString(3,page.getTitle());
			statement.setString(4, page.getDescription());
			statement.setDate(5, page.getCreated());
			statement.setDate(6, page.getUpdated());
			statement.executeUpdate();
			Connection.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Collection<Page> findAllPages() {
		// TODO Auto-generated method stub
		Collection<Page> pages = new ArrayList<Page>();
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(FIND_ALL_PAGES);
			ResultSet res = statement.executeQuery();
			while(res.next()) {
				int id = res.getInt("page_id");
				int websiteId = res.getInt("website_id");
				String title = res.getString("title");
				String description = res.getString("description");
				Date created = res.getDate("created");
				Date updated = res.getDate("updated");
				Integer views = res.getInt("views");
				Page page = new Page(id,title,description,created,updated,views);
				page.setWebsiteId(websiteId);
				pages.add(page);
			}
			Connection.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return pages;
	}

	@Override
	public Page findPageById(int pageId) {
		// TODO Auto-generated method stub
		Page page = null;
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(FIND_PAGE_BY_ID);
			statement.setInt(1, pageId);
			ResultSet res = statement.executeQuery();
			if(res.next()) {
				pageId = res.getInt("page_id");
				int websiteId = res.getInt("website_id");
				String title = res.getString("title");
				String description = res.getString("description");
				Date created = res.getDate("created");
				Date updated = res.getDate("updated");
				Integer views = res.getInt("views");
				page = new Page(pageId,title,description,created,updated,views);
				page.setWebsiteId(websiteId);
			}
			Connection.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return page;
	}

	@Override
	public Collection<Page> findPagesForWebsite(int websiteId) {
		// TODO Auto-generated method stub
		Collection<Page> pages = new ArrayList<Page>();
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(FIND_ALL_PAGES_FOR_WEBSITE);
			ResultSet res = statement.executeQuery();
			while(res.next()) {
				int id = res.getInt("page_id");
				websiteId = res.getInt("website_id");
				String title = res.getString("title");
				String description = res.getString("description");
				Date created = res.getDate("created");
				Date updated = res.getDate("updated");
				Integer views = res.getInt("views");
				Page page = new Page(id,title,description,created,updated,views);
				page.setWebsiteId(websiteId);
				pages.add(page);
			}
			Connection.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return pages;
	}

	@Override
	public int updatePage(int pageId, Page page) {
		// TODO Auto-generated method stub
		int res = -1;
		try{
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(UPDATE_PAGE);
			statement.setInt(1,page.getWebsiteId());
			statement.setString(2,page.getTitle());
			statement.setString(3,page.getDescription());
			statement.setDate(4,page.getCreated());
			statement.setDate(5,page.getUpdated());
			statement.setInt(6,page.getViews());
			statement.setInt(7,pageId);
			statement.executeUpdate();
			res = 0;
			Connection.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int deletePage(int pageId) {
		// TODO Auto-generated method stub
		int res = -1;
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(DELETE_PAGE);
			statement.setInt(1, pageId);
			statement.executeUpdate();
			res = 0;
			Connection.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return res;
	}

}
