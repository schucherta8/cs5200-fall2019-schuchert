package edu.northeastern.cs5200.dao;
//Missing return type on paper. What should it be?
public interface RoleDao {
	void assignWebsiteRole(int developerId, int websiteId, int roleId);
	
	void assignPageRole(int developerId, int pageId, int roleId);
	
	int deleteWebsiteRole(int developerId, int websiteId, int roleId);
	
	int deletePageRole(int developerId, int pageId, int roleId);
}
