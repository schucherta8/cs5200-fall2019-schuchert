package edu.northeastern.cs5200.dao;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.model.Priviledge;
import edu.northeastern.cs5200.model.Role;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoleImpl implements RoleDao {

	private static final String ASSIGN_WEBSITE_ROLE = "INSERT INTO website_role " +
			"(developer_id, website_id, role) " +
			"VALUES(?,?,?)";
	private static final String ASSIGN_PAGE_ROLE = "INSERT INTO page_role " +
			"(developer_id,page_id,role)" +
			"VALUES (?,?,?)";
	private static final String DELETE_WEBSITE_ROLE = "DELETE FROM website_role " +
			"WHERE website_role.website_id = ? AND website_role.developer_id = ?";

	private static final String DELETE_PAGE_ROLE = "DELETE FROM page_role " +
			"WHERE page_role.website_id = ? AND page_role.page_id = ?";

	private static RoleImpl instance = null;

	private RoleImpl() {}
	public static RoleImpl getInstance() {
		if(instance == null) {
			instance = new RoleImpl();
		}
		return instance;
	}
	@Override
	public void assignWebsiteRole(int developerId, int websiteId, int roleId) {
		// TODO Auto-generated method stub
		try{
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(ASSIGN_WEBSITE_ROLE);
			statement.setInt(1,developerId);
			statement.setInt(2,websiteId);
			PriviledgeImpl priviledgeDao = PriviledgeImpl.getInstance();
			switch (roleId){
				case 1:
					statement.setString(3, Role.OWNER.name());
					priviledgeDao.assignWebsitePriviledge(developerId,websiteId, Priviledge.CREATE.name());
					priviledgeDao.assignWebsitePriviledge(developerId,websiteId, Priviledge.READ.name());
					priviledgeDao.assignWebsitePriviledge(developerId,websiteId, Priviledge.UPDATE.name());
					priviledgeDao.assignWebsitePriviledge(developerId,websiteId, Priviledge.DELETE.name());
					break;
				case 2:
					statement.setString(3, Role.ADMIN.name());
					priviledgeDao.assignWebsitePriviledge(developerId,websiteId, Priviledge.CREATE.name());
					priviledgeDao.assignWebsitePriviledge(developerId,websiteId, Priviledge.READ.name());
					priviledgeDao.assignWebsitePriviledge(developerId,websiteId, Priviledge.UPDATE.name());
					priviledgeDao.assignWebsitePriviledge(developerId,websiteId, Priviledge.DELETE.name());
					break;
				case 3:
					statement.setString(3, Role.WRITER.name());
					priviledgeDao.assignWebsitePriviledge(developerId,websiteId, Priviledge.CREATE.name());
					priviledgeDao.assignWebsitePriviledge(developerId,websiteId, Priviledge.READ.name());
					priviledgeDao.assignWebsitePriviledge(developerId,websiteId, Priviledge.UPDATE.name());
					break;
				case 4:
					statement.setString(3, Role.EDITOR.name());
					priviledgeDao.assignWebsitePriviledge(developerId,websiteId, Priviledge.READ.name());
					priviledgeDao.assignWebsitePriviledge(developerId,websiteId, Priviledge.UPDATE.name());
					break;
				case 5:
					statement.setString(3,Role.REVIEWER.name());
					priviledgeDao.assignWebsitePriviledge(developerId,websiteId, Priviledge.READ.name());
					break;
			}
			statement.executeQuery();
			conn.close();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	@Override
	public void assignPageRole(int developerId, int pageId, int roleId) {
		// TODO Auto-generated method stub
		try{
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(ASSIGN_PAGE_ROLE);
			statement.setInt(1,developerId);
			statement.setInt(2,pageId);
			PriviledgeImpl priviledgeDao = PriviledgeImpl.getInstance();
			switch (roleId){
				case 1:
					statement.setString(3, Role.OWNER.name());
					priviledgeDao.assignPagePriviledge(developerId,pageId,Priviledge.CREATE.name());
					priviledgeDao.assignPagePriviledge(developerId,pageId,Priviledge.READ.name());
					priviledgeDao.assignPagePriviledge(developerId,pageId,Priviledge.UPDATE.name());
					priviledgeDao.assignPagePriviledge(developerId,pageId,Priviledge.DELETE.name());
					break;
				case 2:
					statement.setString(3, Role.ADMIN.name());
					priviledgeDao.assignPagePriviledge(developerId,pageId,Priviledge.CREATE.name());
					priviledgeDao.assignPagePriviledge(developerId,pageId,Priviledge.READ.name());
					priviledgeDao.assignPagePriviledge(developerId,pageId,Priviledge.UPDATE.name());
					priviledgeDao.assignPagePriviledge(developerId,pageId,Priviledge.DELETE.name());
					break;
				case 3:
					statement.setString(3, Role.WRITER.name());
					priviledgeDao.assignPagePriviledge(developerId,pageId,Priviledge.CREATE.name());
					priviledgeDao.assignPagePriviledge(developerId,pageId,Priviledge.READ.name());
					priviledgeDao.assignPagePriviledge(developerId,pageId,Priviledge.UPDATE.name());
					break;
				case 4:
					statement.setString(3, Role.EDITOR.name());
					priviledgeDao.assignPagePriviledge(developerId,pageId,Priviledge.READ.name());
					priviledgeDao.assignPagePriviledge(developerId,pageId,Priviledge.UPDATE.name());
					break;
				case 5:
					statement.setString(3,Role.REVIEWER.name());
					priviledgeDao.assignPagePriviledge(developerId,pageId,Priviledge.READ.name());
					break;
			}
			statement.executeQuery();
			conn.close();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	@Override
	public int deleteWebsiteRole(int developerId, int websiteId, int roleId) {
		// TODO Auto-generated method stub
		int res = -1;
		try{
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(DELETE_WEBSITE_ROLE);
			statement.setInt(1,developerId);
			statement.setInt(2,websiteId);
			PriviledgeImpl priviledgeDao = PriviledgeImpl.getInstance();
			switch (roleId){
				case 1:
					priviledgeDao.deleteWebsitePriviledge(developerId,websiteId,Priviledge.CREATE.name());
					priviledgeDao.deleteWebsitePriviledge(developerId,websiteId,Priviledge.READ.name());
					priviledgeDao.deleteWebsitePriviledge(developerId,websiteId,Priviledge.UPDATE.name());
					priviledgeDao.deleteWebsitePriviledge(developerId,websiteId,Priviledge.DELETE.name());
					break;
				case 2:
					priviledgeDao.deleteWebsitePriviledge(developerId,websiteId,Priviledge.CREATE.name());
					priviledgeDao.deleteWebsitePriviledge(developerId,websiteId,Priviledge.READ.name());
					priviledgeDao.deleteWebsitePriviledge(developerId,websiteId,Priviledge.UPDATE.name());
					priviledgeDao.deleteWebsitePriviledge(developerId,websiteId,Priviledge.DELETE.name());
					break;
				case 3:
					priviledgeDao.deleteWebsitePriviledge(developerId,websiteId,Priviledge.CREATE.name());
					priviledgeDao.deleteWebsitePriviledge(developerId,websiteId,Priviledge.READ.name());
					priviledgeDao.deleteWebsitePriviledge(developerId,websiteId,Priviledge.UPDATE.name());
					break;
				case 4:
					priviledgeDao.deleteWebsitePriviledge(developerId,websiteId,Priviledge.READ.name());
					priviledgeDao.deleteWebsitePriviledge(developerId,websiteId,Priviledge.UPDATE.name());
					break;
				case 5:
					priviledgeDao.deleteWebsitePriviledge(developerId,websiteId,Priviledge.READ.name());
					break;
			}
			statement.executeQuery();
			res = 0;
			conn.close();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int deletePageRole(int developerId, int pageId, int roleId) {
		// TODO Auto-generated method stub
		int res = -1;
		try{
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(DELETE_PAGE_ROLE);
			statement.setInt(1,developerId);
			statement.setInt(2,pageId);
			PriviledgeImpl priviledgeDao = PriviledgeImpl.getInstance();
			switch (roleId){
				case 1:
					priviledgeDao.deletePagePriviledge(developerId,pageId,Priviledge.CREATE.name());
					priviledgeDao.deletePagePriviledge(developerId,pageId,Priviledge.UPDATE.name());
					priviledgeDao.deletePagePriviledge(developerId,pageId,Priviledge.READ.name());
					priviledgeDao.deletePagePriviledge(developerId,pageId,Priviledge.DELETE.name());
					break;
				case 2:
					priviledgeDao.deletePagePriviledge(developerId,pageId,Priviledge.CREATE.name());
					priviledgeDao.deletePagePriviledge(developerId,pageId,Priviledge.UPDATE.name());
					priviledgeDao.deletePagePriviledge(developerId,pageId,Priviledge.READ.name());
					priviledgeDao.deletePagePriviledge(developerId,pageId,Priviledge.DELETE.name());
					break;
				case 3:
					priviledgeDao.deletePagePriviledge(developerId,pageId,Priviledge.CREATE.name());
					priviledgeDao.deletePagePriviledge(developerId,pageId,Priviledge.UPDATE.name());
					priviledgeDao.deletePagePriviledge(developerId,pageId,Priviledge.READ.name());
					break;
				case 4:
					priviledgeDao.deletePagePriviledge(developerId,pageId,Priviledge.UPDATE.name());
					priviledgeDao.deletePagePriviledge(developerId,pageId,Priviledge.READ.name());
					break;
				case 5:
					priviledgeDao.deletePagePriviledge(developerId,pageId,Priviledge.READ.name());
					break;
			}
			statement.executeQuery();
			res = 0;
			conn.close();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		return res;
	}

}
