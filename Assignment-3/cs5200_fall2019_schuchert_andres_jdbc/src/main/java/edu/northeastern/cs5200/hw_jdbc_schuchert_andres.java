package edu.northeastern.cs5200;

import edu.northeastern.cs5200.dao.*;
import edu.northeastern.cs5200.model.*;

public class hw_jdbc_schuchert_andres {
    public static void main(String[] args){
        //Create Users and Developers
        DeveloperImpl devdao = DeveloperImpl.getInstance();
        Developer alice = new Developer("4321rewq",12,"Alice",
                "Wonder","alice","alice","alice@wonder.com",
                new java.sql.Date(2000,1,1));
        devdao.createDeveloper(alice);
        Developer bob = new Developer("5432trew",23,"Bob",
                "Marley","bob","bob","bob@marley.com",
                new java.sql.Date(1990,1,1));
        devdao.createDeveloper(bob);
        Developer charlie = new Developer("6543ytre",34,"Charles",
                "Garcia","charlie","charlie","chuch@garcia.com",
                new java.sql.Date(1980,1,1));
        devdao.createDeveloper(charlie);
        UserImpl userdao = UserImpl.getInstance();
        User dan = new User(45,"Dan", "Martin","dan","dan","dan@martin.com",
                new java.sql.Date(2012,1,1));
        userdao.createUser(dan);
        User ed = new User(56,"Ed","Karaz","ed","ed","ed@kar.com",
                new java.sql.Date(2010,1,1));
        userdao.createUser(ed);
        //Create Websites
        WebsiteImpl websiteDao = WebsiteImpl.getInstance();
        Website facebook = new Website(123,"Facebook",
                "an online social media and social networking service",
                new java.sql.Date(2019,10,20),
                new java.sql.Date(2019,10,20),1234234);
        Website twitter = new Website(234,"Twitter",
                "an online news and social networking service",
                new java.sql.Date(2019,10,20),
                new java.sql.Date(2019,10,20),4321543);
        Website wikipedia = new Website(345,"Wikipedia",
                "a free online encyclopedia",
                new java.sql.Date(2019,10,20),
                new java.sql.Date(2019,10,20),3456654);
        Website cnn = new Website(456,"CNN",
                "an American basic cable and satellite television news channel",
                new java.sql.Date(2019,10,20),
                new java.sql.Date(2019,10,20),6543345);
        Website cnet = new Website(567,"CNET",
                "an American media website that publishes reviews, news, articles, blogs," +
                        " podcasts and videos on technology and consumer electronics",
                new java.sql.Date(2019,10,20),
                new java.sql.Date(2019,10,20),5433455);
        Website gizmodo = new Website(678,"Gizmodo",
                "a design, technology, science and science fiction website that also writes" +
                        " articles on politics",
                new java.sql.Date(2019,10,20),
                new java.sql.Date(2019,10,20),4322345);

        /*
            Assign website roles to Developers
         */
        RoleImpl roleDao = RoleImpl.getInstance();
        //Alice Roles
        roleDao.assignWebsiteRole(alice.getId(),facebook.getId(),Role.OWNER.getId());
        websiteDao.createWebsiteForDeveloper(alice.getId(),facebook);
        roleDao.assignWebsiteRole(alice.getId(),twitter.getId(),Role.EDITOR.getId());
        roleDao.assignWebsiteRole(alice.getId(),wikipedia.getId(),Role.ADMIN.getId());
        roleDao.assignWebsiteRole(alice.getId(),cnn.getId(),Role.OWNER.getId());
        websiteDao.createWebsiteForDeveloper(alice.getId(),cnn);
        roleDao.assignWebsiteRole(alice.getId(),cnet.getId(),Role.ADMIN.getId());
        roleDao.assignWebsiteRole(alice.getId(),gizmodo.getId(),Role.EDITOR.getId());
        //Bob roles
        roleDao.assignWebsiteRole(bob.getId(),facebook.getId(),Role.EDITOR.getId());
        roleDao.assignWebsiteRole(bob.getId(),twitter.getId(),Role.OWNER.getId());
        websiteDao.createWebsiteForDeveloper(bob.getId(),twitter);
        roleDao.assignWebsiteRole(bob.getId(),wikipedia.getId(),Role.ADMIN.getId());
        roleDao.assignWebsiteRole(bob.getId(),cnn.getId(),Role.EDITOR.getId());
        roleDao.assignWebsiteRole(bob.getId(),cnet.getId(),Role.OWNER.getId());
        websiteDao.createWebsiteForDeveloper(bob.getId(),cnet);
        roleDao.assignWebsiteRole(bob.getId(),gizmodo.getId(),Role.ADMIN.getId());
        //Charlie roles
        roleDao.assignWebsiteRole(charlie.getId(),facebook.getId(),Role.OWNER.getId());
        websiteDao.createWebsiteForDeveloper(charlie.getId(),facebook);
        roleDao.assignWebsiteRole(charlie.getId(),twitter.getId(),Role.EDITOR.getId());
        roleDao.assignWebsiteRole(charlie.getId(),wikipedia.getId(),Role.ADMIN.getId());
        roleDao.assignWebsiteRole(charlie.getId(),cnn.getId(),Role.OWNER.getId());
        websiteDao.createWebsiteForDeveloper(charlie.getId(),cnn);
        roleDao.assignWebsiteRole(charlie.getId(),cnet.getId(),Role.ADMIN.getId());
        roleDao.assignWebsiteRole(charlie.getId(),gizmodo.getId(),Role.EDITOR.getId());

        //Create pages
        PageImpl pageDao = PageImpl.getInstance();
        Page home = new Page(123,"Home","Landing Page", new java.sql.Date(2019,9,4),
                new java.sql.Date(2019,10,20),
                123434);
        pageDao.createPageForWebsite(cnet.getId(),home);
        Page about = new Page(234,"About","Website description",
                new java.sql.Date(2019,9,4),
                new java.sql.Date(2019,10,20),
                234545);
        pageDao.createPageForWebsite(gizmodo.getId(),about);
        Page contact = new Page(345,"Contact","Addresses, phones, and contact info",
                new java.sql.Date(2019,9,4),
                new java.sql.Date(2019,10,20),
                345656);
        pageDao.createPageForWebsite(wikipedia.getId(),contact);
        Page preferences = new Page(456,"Preferences","Where users can configure their preferences",
                new java.sql.Date(2019,9,4),
                new java.sql.Date(2019,10,20),
                456776);
        pageDao.createPageForWebsite(cnn.getId(),preferences);
        Page profile = new Page(567,"Profile","Users can configure their personal information",
                new java.sql.Date(2019,9,4),
                new java.sql.Date(2019,10,20),
                567878);
        pageDao.createPageForWebsite(cnet.getId(),profile);

        /*
            Assign page roles for developers.
         */
        //Alice page roles
        roleDao.assignPageRole(alice.getId(),home.getId(),Role.EDITOR.getId());
        roleDao.assignPageRole(alice.getId(),about.getId(),Role.WRITER.getId());
        roleDao.assignPageRole(alice.getId(),contact.getId(),Role.REVIEWER.getId());
        roleDao.assignPageRole(alice.getId(),preferences.getId(),Role.EDITOR.getId());
        roleDao.assignPageRole(alice.getId(),profile.getId(),Role.WRITER.getId());
        //Bob page roles
        roleDao.assignPageRole(bob.getId(),home.getId(),Role.REVIEWER.getId());
        roleDao.assignPageRole(bob.getId(),about.getId(),Role.EDITOR.getId());
        roleDao.assignPageRole(bob.getId(),contact.getId(),Role.WRITER.getId());
        roleDao.assignPageRole(bob.getId(),preferences.getId(),Role.REVIEWER.getId());
        roleDao.assignPageRole(bob.getId(),profile.getId(),Role.EDITOR.getId());
        //Charlie page Roles
        roleDao.assignPageRole(charlie.getId(),home.getId(),Role.WRITER.getId());
        roleDao.assignPageRole(charlie.getId(),about.getId(),Role.REVIEWER.getId());
        roleDao.assignPageRole(charlie.getId(),contact.getId(),Role.EDITOR.getId());
        roleDao.assignPageRole(charlie.getId(),preferences.getId(),Role.WRITER.getId());
        roleDao.assignPageRole(charlie.getId(),profile.getId(),Role.REVIEWER.getId());

        //Create widgets for pages
        WidgetImpl widgetDao = WidgetImpl.getInstance();
        Widget head123 = new HeadingWidget(123,"head123",null,null,
                null,null,"Welcome",0,2);
        widgetDao.createWidgetForPage(home.getId(),head123);
        Widget post234 = new HtmlWidget(234,"post234",null,null,
                null,null,null,0,"<p>Lorem</p>");
        widgetDao.createWidgetForPage(about.getId(),post234);
        Widget head345 = new HeadingWidget(345,"head345",null,null,
                null,null,"Hi",1,2);
        widgetDao.createWidgetForPage(contact.getId(),head345);
        Widget intro456 = new HtmlWidget(456,"intro456",null,null,
                null,null,null,2,"<h1>Hi</h1>");
        widgetDao.createWidgetForPage(contact.getId(),intro456);
        Widget image345 = new ImageWidget(567,"image345",50,100,
                null,null,null,3,"/img/567.png");
        widgetDao.createWidgetForPage(contact.getId(),image345);
        Widget video456 = new YouTubeWidget(678,"video456",400,300,
                null,null,null,0,"https://youtu.be/h67VX51QXiQ",
                false,false);
        widgetDao.createWidgetForPage(preferences.getId(),video456);
    }
}
