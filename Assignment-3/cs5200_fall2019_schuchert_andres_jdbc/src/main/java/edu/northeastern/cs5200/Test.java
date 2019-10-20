package edu.northeastern.cs5200;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import edu.northeastern.cs5200.dao.*;
import edu.northeastern.cs5200.model.*;

public class Test {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		DeveloperImpl devImpl = DeveloperImpl.getInstance();
		/*
		Phone p1 = new Phone("123-234-3456",true);
		Phone p2 = new Phone("234-345-4566",false);
		List<Phone> phones = new LinkedList<>();
		phones.add(p1);
		phones.add(p2);
		Address a1 = new Address("123 Adam St.",null,"Alton",null,"01234",true);
		Address a2 = new Address("234 Birch St.",null,"Boston",null,"02345",false);
		List<Address> addresses = new LinkedList<>();
		addresses.add(a1);
		addresses.add(a2);
		Developer dev1 = new Developer("12jdj19jd",25,"Andres","Schuchert",
				"aschuchert","password","throwaway@gmail.com",
				new Date(2019,8,17),phones,addresses);
		devImpl.createDeveloper(dev1);
		Developer dev2 = new Developer("j1923j9",30,"John","Smith","jon",
				"doe","throwaway@hotmail.com",
				new Date(2018,8,17));
		devImpl.createDeveloper(dev2);

		UserImpl userdao = UserImpl.getInstance();
		User dan = new User(45,"Dan", "Martin","dan","dan","dan@martin.com",
				new java.sql.Date(2012,1,1));
		userdao.createUser(dan);

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


		System.out.println("Testing UPDATE DEVELOPER");
		Developer dev1Update = new Developer("123hello123",25,"Andres","Schuchert",
				"aschuchert","eagles","throwaway@gmail.com",
				new Date(2019,8,17),phones,addresses);
		devImpl.updateDeveloper(dev1.getId(),dev1Update);

		System.out.println("TESTING DELETE DEVELOEPR");
		devImpl.deleteDeveloper(25);

		Website facebook = new Website(123,"Facebook",
				"an online social media and social networking service",
				new java.sql.Date(2019,10,20),
				new java.sql.Date(2019,10,20),1234234);

		WebsiteImpl websiteDao = WebsiteImpl.getInstance();
		//websiteDao.createWebsiteForDeveloper(30,facebook);

		System.out.println("TESTING FIND ALL WEBSITES");
		Collection<Website> websites = websiteDao.findAllWebsites();
		for(Website website: websites) {
			System.out.println("Website id: " + website.getId());
			System.out.println("Name: " + website.getName());
			System.out.println("Description: " + website.getDescription());
			System.out.println("Created: " + website.getCreated().getMonth()
					+ " " + website.getCreated().getDay() + " " + website.getCreated().getYear());
			System.out.println("Updated: " + website.getUpdated().getMonth()
					+ " " + website.getUpdated().getDay() + " " + website.getUpdated().getYear());
			System.out.println("Visits: " + website.getVisits());
			System.out.println("Developer id: " + website.getDeveloperId());
		}
		System.out.println();
		System.out.println("TESTING FIND WEBSITE FOR DEVELOPERS");
		websites = websiteDao.findWebsitesForDeveloper(30);
		for(Website website: websites) {
			System.out.println("Website id: " + website.getId());
			System.out.println("Name: " + website.getName());
			System.out.println("Description: " + website.getDescription());
			System.out.println("Created: " + website.getCreated().getMonth()
					+ " " + website.getCreated().getDay() + " " + website.getCreated().getYear());
			System.out.println("Updated: " + website.getUpdated().getMonth()
					+ " " + website.getUpdated().getDay() + " " + website.getUpdated().getYear());
			System.out.println("Visits: " + website.getVisits());
			System.out.println("Developer id: " + website.getDeveloperId());
		}
		System.out.println();
		System.out.println("TESTING FIND WEBSITE BY ID");
		Website website = websiteDao.findWebsiteById(123);
		System.out.println("Website id: " + website.getId());
		System.out.println("Name: " + website.getName());
		System.out.println("Description: " + website.getDescription());
		System.out.println("Created: " + website.getCreated().getMonth()
				+ " " + website.getCreated().getDay() + " " + website.getCreated().getYear());
		System.out.println("Updated: " + website.getUpdated().getMonth()
				+ " " + website.getUpdated().getDay() + " " + website.getUpdated().getYear());
		System.out.println("Visits: " + website.getVisits());
		System.out.println("Developer id: " + website.getDeveloperId());
		Website facebookUpdate = new Website(123,"Facebook",
				"an online social media and social networking service",
				new java.sql.Date(2019,10,20),
				new java.sql.Date(2019,12,20),2000000);
		websiteDao.updateWebsite(123,facebookUpdate);

		System.out.println("TESTING CREATE PAGE");
		PageImpl pagedao = PageImpl.getInstance();
		Page home = new Page(123,"Home","Landing Page", new java.sql.Date(2019,9,4),
				new java.sql.Date(2019,10,20),
				123434);
		Page about = new Page(234,"About","Website description",
				new java.sql.Date(2019,9,4),
				new java.sql.Date(2019,10,20),
				234545);
		pagedao.createPageForWebsite(123,home);
		pagedao.createPageForWebsite(123,about);

		PageImpl pageDao = PageImpl.getInstance();
		System.out.println("TESTING FIND ALL PAGES");
		Collection<Page> pages = pageDao.findAllPages();
		for(Page page : pages){
			System.out.println("Page id: " + page.getId());
			System.out.println("Website id: " + page.getWebsiteId());
			System.out.println("Title: " + page.getTitle());
			System.out.println("Description: " + page.getDescription());
			System.out.println("Created: " + page.getCreated());
			System.out.println("Updated: " + page.getUpdated());
			System.out.println("Views: " + page.getViews());
			System.out.println();
		}
		System.out.println();
		System.out.println("TESTING FIND PAGES BY ID");
		Page page = pageDao.findPageById(234);
		System.out.println("Page id: " + page.getId());
		System.out.println("Website id: " + page.getWebsiteId());
		System.out.println("Title: " + page.getTitle());
		System.out.println("Description: " + page.getDescription());
		System.out.println("Created: " + page.getCreated());
		System.out.println("Updated: " + page.getUpdated());
		System.out.println("Views: " + page.getViews());
		System.out.println();
		System.out.println("TESTING FIND ALL PAGES FOR WEBSITE");
		pages = pageDao.findPagesForWebsite(123);
		for(Page p : pages){
			System.out.println("Page id: " + p.getId());
			System.out.println("Website id: " + p.getWebsiteId());
			System.out.println("Title: " + p.getTitle());
			System.out.println("Description: " + p.getDescription());
			System.out.println("Created: " + p.getCreated());
			System.out.println("Updated: " + p.getUpdated());
			System.out.println("Views: " + p.getViews());
			System.out.println();
		}
		System.out.println();

		Page homeUpdate = new Page(123,"Welcome","Introduction", new java.sql.Date(2019,9,4),
				new java.sql.Date(2019,10,20),
				123434);
		PageImpl pageDao = PageImpl.getInstance();
		pageDao.updatePage(123,homeUpdate);

		WidgetImpl widgetDao = WidgetImpl.getInstance();
		Widget head123 = new HeadingWidget(123,"head123",null,null,
				null,null,"Welcome",0,2);
		widgetDao.createWidgetForPage(123,head123);
		Widget post234 = new HtmlWidget(234,"post234",null,null,
				null,null,null,0,"<p>Lorem</p>");
		widgetDao.createWidgetForPage(234,post234);

		WidgetImpl widgetDao = WidgetImpl.getInstance();
		Collection<Widget> widgets = widgetDao.findAllWidgets();
		for(Widget widget : widgets){
			System.out.println("Widget id: " + widget.getId());
			System.out.println("Page id: " + widget.getPageId());
			System.out.println("Type: " + widget.getType().name());
			System.out.println("Name: " + widget.getName());
			System.out.println("Width: " + widget.getWidth());
			System.out.println("Height: " + widget.getHeight());
			System.out.println("CSS Class: " + widget.getCssClass());
			System.out.println("CSS Style: " + widget.getCssStyle());
			System.out.println("Text: " + widget.getText());
			System.out.println("Order: " + widget.getOrder());
			System.out.println();
		}
		widgets = widgetDao.findWidgetsForPage(123);
		for(Widget widget : widgets){
			System.out.println("Widget id: " + widget.getId());
			System.out.println("Page id: " + widget.getPageId());
			System.out.println("Type: " + widget.getType().name());
			System.out.println("Name: " + widget.getName());
			System.out.println("Width: " + widget.getWidth());
			System.out.println("Height: " + widget.getHeight());
			System.out.println("CSS Class: " + widget.getCssClass());
			System.out.println("CSS Style: " + widget.getCssStyle());
			System.out.println("Text: " + widget.getText());
			System.out.println("Order: " + widget.getOrder());
			System.out.println();
		}
		Widget widget = widgetDao.findWidgetById(234);
		System.out.println("Widget id: " + widget.getId());
		System.out.println("Page id: " + widget.getPageId());
		System.out.println("Type: " + widget.getType().name());
		System.out.println("Name: " + widget.getName());
		System.out.println("Width: " + widget.getWidth());
		System.out.println("Height: " + widget.getHeight());
		System.out.println("CSS Class: " + widget.getCssClass());
		System.out.println("CSS Style: " + widget.getCssStyle());
		System.out.println("Text: " + widget.getText());
		System.out.println("Order: " + widget.getOrder());
		System.out.println();
		*/
		WidgetImpl widgetDao = WidgetImpl.getInstance();
		Widget head123Update = new HeadingWidget(123,"head123",null,null,
				"halloween.css",null,"Spooky",0,5);
		widgetDao.updateWidget(123,head123Update);
		System.out.println("End of Test.");
	}
}
