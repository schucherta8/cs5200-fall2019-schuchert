package edu.northeastern.cs5200;

import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

import edu.northeastern.cs5200.dao.*;
import edu.northeastern.cs5200.model.*;

public class hw_jdbc_schuchert_andres {
    public static void main(String[] args){
        /******************************************************************************************
         *                                  INSERTS LOCATED HERE                                  *
         *****************************************************************************************/
        //Create Users and Developers
        DeveloperImpl devdao = DeveloperImpl.getInstance();
        Developer alice = new Developer("4321rewq",12,"Alice",
                "Wonder","alice","alice","alice@wonder.com",
                new java.sql.Date(2000,1,1));
        devdao.createDeveloper(alice);
        Address alicePrimary = new Address(alice.getId(),"123 Adam St.",null,
                "Alton",null,"01234",true);
        AddressImpl addressDao = AddressImpl.getInstance();
        addressDao.createAddress(alicePrimary);
        Developer bob = new Developer("5432trew",23,"Bob",
                "Marley","bob","bob","bob@marley.com",
                new java.sql.Date(1990,1,1));
        devdao.createDeveloper(bob);
        Developer charlie = new Developer("6543ytre",34,"Charles",
                "Garcia","charlie","charlie","chuch@garcia.com",
                new java.sql.Date(1980,1,1));
        devdao.createDeveloper(charlie);
        Phone charliePrimary = new Phone(charlie.getId(),"321-432-5435",true);
        PhoneImpl phoneDao = PhoneImpl.getInstance();
        phoneDao.createPhone(charliePrimary);
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
                new java.sql.Date(Calendar.getInstance().getTime().getTime()),//Check this
                new java.sql.Date(Calendar.getInstance().getTime().getTime()),1234234);
        Website twitter = new Website(234,"Twitter",
                "an online news and social networking service",
                new java.sql.Date(Calendar.getInstance().getTime().getTime()),
                new java.sql.Date(Calendar.getInstance().getTime().getTime()),4321543);
        Website wikipedia = new Website(345,"Wikipedia",
                "a free online encyclopedia",
                new java.sql.Date(Calendar.getInstance().getTime().getTime()),
                new java.sql.Date(Calendar.getInstance().getTime().getTime()),3456654);
        Website cnn = new Website(456,"CNN",
                "an American basic cable and satellite television news channel",
                new java.sql.Date(Calendar.getInstance().getTime().getTime()),
                new java.sql.Date(Calendar.getInstance().getTime().getTime()),6543345);
        Website cnet = new Website(567,"CNET",
                "an American media website that publishes reviews, news, articles, blogs," +
                        " podcasts and videos on technology and consumer electronics",
                new java.sql.Date(Calendar.getInstance().getTime().getTime()),
                new java.sql.Date(Calendar.getInstance().getTime().getTime()),5433455);
        Website gizmodo = new Website(678,"Gizmodo",
                "a design, technology, science and science fiction website that also writes" +
                        " articles on politics",
                new java.sql.Date(Calendar.getInstance().getTime().getTime()),
                new java.sql.Date(Calendar.getInstance().getTime().getTime()),4322345);

        websiteDao.createWebsiteForDeveloper(alice.getId(),facebook);
        websiteDao.createWebsiteForDeveloper(alice.getId(),cnn);
        websiteDao.createWebsiteForDeveloper(bob.getId(),twitter);
        websiteDao.createWebsiteForDeveloper(bob.getId(),cnet);
        websiteDao.createWebsiteForDeveloper(charlie.getId(),wikipedia);
        websiteDao.createWebsiteForDeveloper(charlie.getId(), gizmodo);
        /*
            Assign website roles to Developers
         */
        RoleImpl roleDao = RoleImpl.getInstance();
        //Alice Roles
        roleDao.assignWebsiteRole(alice.getId(),facebook.getId(),Role.OWNER.getId());
        roleDao.assignWebsiteRole(alice.getId(),twitter.getId(),Role.EDITOR.getId());
        roleDao.assignWebsiteRole(alice.getId(),wikipedia.getId(),Role.ADMIN.getId());
        roleDao.assignWebsiteRole(alice.getId(),cnn.getId(),Role.OWNER.getId());
        roleDao.assignWebsiteRole(alice.getId(),cnet.getId(),Role.ADMIN.getId());
        roleDao.assignWebsiteRole(alice.getId(),gizmodo.getId(),Role.EDITOR.getId());
        //Bob roles
        roleDao.assignWebsiteRole(bob.getId(),facebook.getId(),Role.EDITOR.getId());
        roleDao.assignWebsiteRole(bob.getId(),twitter.getId(),Role.OWNER.getId());
        roleDao.assignWebsiteRole(bob.getId(),wikipedia.getId(),Role.ADMIN.getId());
        roleDao.assignWebsiteRole(bob.getId(),cnn.getId(),Role.EDITOR.getId());
        roleDao.assignWebsiteRole(bob.getId(),cnet.getId(),Role.OWNER.getId());
        roleDao.assignWebsiteRole(bob.getId(),gizmodo.getId(),Role.ADMIN.getId());
        //Charlie roles - Issues with Charlie
        roleDao.assignWebsiteRole(charlie.getId(),facebook.getId(),Role.OWNER.getId());
        roleDao.assignWebsiteRole(charlie.getId(),twitter.getId(),Role.EDITOR.getId());
        roleDao.assignWebsiteRole(charlie.getId(),wikipedia.getId(),Role.ADMIN.getId());
        roleDao.assignWebsiteRole(charlie.getId(),cnn.getId(),Role.OWNER.getId());
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
                null,null);
        widgetDao.createWidgetForPage(preferences.getId(),video456);
        System.out.println("End of Inserts");

        /******************************************************************************************
         *                                  UPDATES LOCATED HERE                                  *
         *****************************************************************************************/
        //Update 1
        Phone charliePrimaryUpdate = new Phone("333-444-5555",true);
        phoneDao.updatePhonePrimary(charlie.getId(),charliePrimaryUpdate);
        //Update 2

        //Update 3
        Collection<Page> pages = pageDao.findPagesForWebsite(cnet.getId());
        for(Page p : pages){
            Page updatePage = new Page(p.getId(),"CNET - " + p.getTitle(),p.getDescription(),
                    p.getCreated(),p.getUpdated(),p.getViews());
            pageDao.updatePage(p.getId(),updatePage);
        }
        //Update 4
        Collection<Page> cnetPages = pageDao.findPagesForWebsite(cnet.getId());
        Page cnetHomePage = null;
        for(Page p : cnetPages){
            if(p.getId() == home.getId()){
                cnetHomePage = p;
                break;
            }
        }
        roleDao.deletePageRole(charlie.getId(), cnetHomePage.getId(),Role.WRITER.getId());
        roleDao.deletePageRole(bob.getId(), cnetHomePage.getId(),Role.REVIEWER.getId());
        roleDao.assignPageRole(charlie.getId(),cnetHomePage.getId(), Role.REVIEWER.getId());
        roleDao.assignPageRole(bob.getId(),cnetHomePage.getId(),Role.WRITER.getId());
        System.out.println("End of Updates");

        /******************************************************************************************
         *                                  DELETES LOCATED HERE                                  *
         *****************************************************************************************/
        //Delete 1
        addressDao.deleteAddressPrimary(alice.getId());

        //Delete 2
        Collection<Widget> widgets = widgetDao.findWidgetsForPage(contact.getId());
        Widget maxWidget = null;
        //Widget widget;
        int maxOrder = -1;
        for(Widget widget : widgets){
            if(widget.getOrder() > maxOrder){
                maxOrder = widget.getOrder();
                maxWidget = widget;
            }
        }
        widgetDao.deleteWidget(maxWidget.getId());
        //Delete 3
        Collection<Page> wikipediaPages = pageDao.findPagesForWebsite(wikipedia.getId());
        if(!wikipediaPages.isEmpty()){
            //Set page pointer to first page in collection
            Page lastUpdated = wikipediaPages.iterator().next();
            //Search pages for the last updated page
            for(Page p : wikipediaPages){
                if(p.getUpdated().compareTo(lastUpdated.getUpdated()) > 0){
                    lastUpdated = p;
                }
            }
            //Remove page
            pageDao.deletePage(lastUpdated.getId());
        }
        //Delete 4
        websiteDao.deleteWebsite(cnet.getId());
        System.out.println("End of Deletes");
    }
}
