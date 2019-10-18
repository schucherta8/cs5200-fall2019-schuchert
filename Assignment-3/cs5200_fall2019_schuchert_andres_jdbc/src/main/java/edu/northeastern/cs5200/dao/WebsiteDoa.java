package edu.northeastern.cs5200.dao;

import java.util.Collection;

import edu.northeastern.cs5200.model.Website;

public interface WebsiteDoa {

	void createWebsiteForDeveloper(int developerId, Website website);
	
	Collection<Website> findAllWebsites();
	
	Collection<Website> findWebsitesForDeveloper(int developerId);
	
	Website findWebsiteById(int websiteId);
	
	int updateWebsite(int websiteId, Website website);
	
	int deleteWebsite(int websiteId);
}
