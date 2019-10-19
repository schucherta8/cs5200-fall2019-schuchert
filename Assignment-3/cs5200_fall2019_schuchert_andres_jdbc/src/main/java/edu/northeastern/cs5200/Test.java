package edu.northeastern.cs5200;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;

import edu.northeastern.cs5200.dao.DeveloperImpl;
import edu.northeastern.cs5200.dao.WebsiteImpl;
import edu.northeastern.cs5200.model.Developer;
import edu.northeastern.cs5200.model.Website;

public class Test {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		DeveloperImpl devImpl = DeveloperImpl.getInstance();
		/*
		Developer dev1 = new Developer("12jdj19jd",25,"Andres","Schuchert","aschuchert","password","throwaway@gmail.com",
				new Date(2019,8,17));
		devImpl.createDeveloper(dev1);
		Developer dev2 = new Developer("j1923j9",30,"John","Smith","jon","doe","throwaway@hotmail.com",
				new Date(2018,8,17));
		devImpl.createDeveloper(dev2);
		
		System.out.println("TESTING FIND_ALL_DEVELOPERS");
		Collection<Developer> developers = devImpl.findAllDevelopers();
		for(Developer dev: developers) {
			System.out.println("Developer Key: " + dev.getDeveloperKey());
			System.out.println("Developer Id: " + dev.getId());
			System.out.println("Developer Firstname: " + dev.getFirstName());
			System.out.println("Developer Lastname: " + dev.getLastName());
			System.out.println("Developer Username: " + dev.getUsername());
			System.out.println("Developer Password: " + dev.getPassword());
			System.out.println("Developer Email: " + dev.getEmail());
			System.out.println("Developer DOB: " + dev.getDob().getMonth() + " " + dev.getDob().getDay() + 
				" " + dev.getDob().getYear()+ "\n");
		}
		
		System.out.println("TESTING FIND_DEVELOPER_BY_ID");
		Developer dev = devImpl.findDeveloperById(30);
		System.out.println("Developer Key: " + dev.getDeveloperKey());
		System.out.println("Developer Id: " + dev.getId());
		System.out.println("Developer Firstname: " + dev.getFirstName());
		System.out.println("Developer Lastname: " + dev.getLastName());
		System.out.println("Developer Username: " + dev.getUsername());
		System.out.println("Developer Password: " + dev.getPassword());
		System.out.println("Developer Email: " + dev.getEmail());
		System.out.println("Developer DOB: " + dev.getDob().getMonth() + " " + dev.getDob().getDay() + 
				" " + dev.getDob().getYear()+ "\n");
		
		
		System.out.println("TESTING FIND_DEVELOPER_BY_USERNAME");
		Developer dev = devImpl.findDeveloperByUsername("jon");
		System.out.println("Developer Key: " + dev.getDeveloperKey());
		System.out.println("Developer Id: " + dev.getId());
		System.out.println("Developer Firstname: " + dev.getFirstName());
		System.out.println("Developer Lastname: " + dev.getLastName());
		System.out.println("Developer Username: " + dev.getUsername());
		System.out.println("Developer Password: " + dev.getPassword());
		System.out.println("Developer Email: " + dev.getEmail());
		System.out.println("Developer DOB: " + dev.getDob().getMonth() + " " + dev.getDob().getDay() + 
				" " + dev.getDob().getYear()+ "\n");
		
		System.out.println("TESTING FIND_DEVELOPER_BY_CREDENTIALS");
		Developer dev = devImpl.findDeveloperByCredentials("aschuchert","password");
		System.out.println("Developer Key: " + dev.getDeveloperKey());
		System.out.println("Developer Id: " + dev.getId());
		System.out.println("Developer Firstname: " + dev.getFirstName());
		System.out.println("Developer Lastname: " + dev.getLastName());
		System.out.println("Developer Username: " + dev.getUsername());
		System.out.println("Developer Password: " + dev.getPassword());
		System.out.println("Developer Email: " + dev.getEmail());
		System.out.println("Developer DOB: " + dev.getDob().getMonth() + " " + dev.getDob().getDay() + 
				" " + dev.getDob().getYear()+ "\n");
		*/
		WebsiteImpl websiteDao = WebsiteImpl.getInstance();
		System.out.println("TESTING FIND WEBSITE FOR DEVELOPERS");
		Collection<Website> websites = websiteDao.findWebsitesForDeveloper(25);
		for(Website website: websites) {
			System.out.println("Name: " + website.getName());
		}
		System.out.println("End of Test.");
	}
}
