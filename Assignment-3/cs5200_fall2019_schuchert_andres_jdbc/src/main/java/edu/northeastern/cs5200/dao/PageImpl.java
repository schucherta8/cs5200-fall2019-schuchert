package edu.northeastern.cs5200.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.model.Page;

public class PageImpl implements PageDao {

	private static final String CREATE_PAGE_FOR_WEBSITE =  "INSERT INTO page "
			+ "() "
			+ "VALUES ()";
	
	@Override
	public void createPageForWebsite(int websiteId, Page page) {
		// TODO Auto-generated method stub
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(CREATE_PAGE_FOR_WEBSITE);
			
			conn.close();
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
			PreparedStatement statement = conn.prepareStatement("");
			conn.close();
		} catch (SQLException e) {
			
		} catch (ClassNotFoundException e) {
			
		}
		return pages;
	}

	@Override
	public Page findPageById(int pageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Page> findPagesForWebsite(int websiteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePage(int pageId, Page page) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePage(int pageId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
