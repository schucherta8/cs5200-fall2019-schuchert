/*
PERSON TABLE
*/
INSERT INTO person_generalization(person_id,firstname,lastname,username,`password`,email) VALUES ('12','Alice','Wonder','alice','alice','alice@wonder.com');
INSERT INTO person_generalization(person_id,firstname,lastname,username,`password`,email) VALUES ('23','Bob','Marley','bob','bob','bob@marley.com');
INSERT INTO person_generalization(person_id,firstname,lastname,username,`password`,email) VALUES ('34','Charles','Garcia','charlie','charlie','chuch@garcia.com');
INSERT INTO person_generalization(person_id,firstname,lastname,username,`password`,email) VALUES ('45','Dan','Martin','dan','dan','dan@martin.com');
INSERT INTO person_generalization(person_id,firstname,lastname,username,`password`,email) VALUES ('56','Ed','Karaz','ed','ed','ed@kar.com');

/*
DEVELOPER TABLE
*/
INSERT INTO developer_person_generalization(developer_id, developer_key) VALUES ('12','4321rewq');
INSERT INTO developer_person_generalization(developer_id, developer_key) VALUES ('23','5432trew');
INSERT INTO developer_person_generalization(developer_id, developer_key) VALUES ('34','6543ytre');

/*
USER TABLE
*/
INSERT INTO user_person_generalization(user_id, user_agreement) VALUES ('45','0');
INSERT INTO user_person_generalization(user_id, user_agreement) VALUES ('56','0');

/*
WEBSITE TABLE
*/
INSERT INTO website(website_id, `name`, description, visits, created, updated) VALUES ('123','Facebook','an online social media and social networking service','1234234',CURDATE(), CURDATE());
INSERT INTO website(website_id, `name`, description, visits, created, updated) VALUES ('234','Twitter','an online news and social networking service','4321543',CURDATE(), CURDATE());
INSERT INTO website(website_id, `name`, description, visits, created, updated) VALUES ('345','Wikipedia','a free online encyclopedia','3456654',CURDATE(), CURDATE());
INSERT INTO website(website_id, `name`, description, visits, created, updated) VALUES ('456','CNN','an American basic cable and satellite television news channel','6543345',CURDATE(), CURDATE());
INSERT INTO website(website_id, `name`, description, visits, created, updated) VALUES ('567','CNET','an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics','5433455',CURDATE(), CURDATE());
INSERT INTO website(website_id, `name`, description, visits, created, updated) VALUES ('678','Gizmodo','a design, technology, science, and science fiction website that also writes articles on politics','4322345',CURDATE(), CURDATE());

/*
FACEBOOK WEBSITE ROLE TABLE
*/
INSERT INTO website_role(website_id, developer_id, role) VALUES ('123','12','OWNER');
INSERT INTO website_role(website_id, developer_id, role) VALUES ('123','23','EDITOR');
INSERT INTO website_role(website_id, developer_id, role) VALUES ('123','34','ADMIN');

/*
TWITER WEBSITE ROLE TABLE
*/
INSERT INTO website_role(website_id, developer_id, role) VALUES ('234','23','OWNER');
INSERT INTO website_role(website_id, developer_id, role) VALUES ('234','34','EDITOR');
INSERT INTO website_role(website_id, developer_id, role) VALUES ('234','12','ADMIN');

/*
WIKIPEDIA WEBSITE ROLE TABLE
*/
INSERT INTO website_role(website_id, developer_id, role) VALUES ('345','34','OWNER');
INSERT INTO website_role(website_id, developer_id, role) VALUES ('345','12','EDITOR');
INSERT INTO website_role(website_id, developer_id, role) VALUES ('345','23','ADMIN');

/*
CNN WEBSITE ROLE TABLE
*/
INSERT INTO website_role(website_id, developer_id, role) VALUES ('456','12','OWNER');
INSERT INTO website_role(website_id, developer_id, role) VALUES ('456','23','EDITOR');
INSERT INTO website_role(website_id, developer_id, role) VALUES ('456','34','ADMIN');

/*
CNET WEBSITE ROLE TABLE
*/
INSERT INTO website_role(website_id, developer_id, role) VALUES ('567','23','OWNER');
INSERT INTO website_role(website_id, developer_id, role) VALUES ('567','34','EDITOR');
INSERT INTO website_role(website_id, developer_id, role) VALUES ('567','12','ADMIN');

/*
GIZMODO WEBSITE ROLE TABLE
*/
INSERT INTO website_role(website_id, developer_id, role) VALUES ('678','34','OWNER');
INSERT INTO website_role(website_id, developer_id, role) VALUES ('678','12','EDITOR');
INSERT INTO website_role(website_id, developer_id, role) VALUES ('678','23','ADMIN');

/*PAGE TABLE*/
INSERT INTO `page`(page_id,title,description,website_id,views) VALUES ('123','Home','Landing page','567','123434');
INSERT INTO `page`(page_id,title,description,website_id,views) VALUES ('234','About','Website description','678','234545');
INSERT INTO `page`(page_id,title,description,website_id,views) VALUES ('345','Contact','Addresses, phones, and contact info','345','345656');
INSERT INTO `page`(page_id,title,description,website_id,views) VALUES ('456','Preferences','Where users can configure their preferences','456','456776');
INSERT INTO `page`(page_id,title,description,website_id,views) VALUES ('567','Profile','Users can configure their personal information','567','567878'); #MISTAKE?

/*
 HOME PAGE ROLE
*/
INSERT INTO page_role(page_id,developer_id,role) VALUES ('123','12','EDITOR');
INSERT INTO page_role(page_id,developer_id,role) VALUES ('123','23','REVIEWER');
INSERT INTO page_role(page_id,developer_id,role) VALUES ('123','34','WRITER');

/*
 ABOUT PAGE ROLE
*/
INSERT INTO page_role(page_id,developer_id,role) VALUES ('234','23','EDITOR');
INSERT INTO page_role(page_id,developer_id,role) VALUES ('234','34','REVIEWER');
INSERT INTO page_role(page_id,developer_id,role) VALUES ('234','12','WRITER');

/*
 CONTACT PAGE ROLE
*/
INSERT INTO page_role(page_id,developer_id,role) VALUES ('345','34','EDITOR');
INSERT INTO page_role(page_id,developer_id,role) VALUES ('345','12','REVIEWER');
INSERT INTO page_role(page_id,developer_id,role) VALUES ('345','23','WRITER');

/*
 PREFERENCES PAGE ROLE
*/
INSERT INTO page_role(page_id,developer_id,role) VALUES ('456','12','EDITOR');
INSERT INTO page_role(page_id,developer_id,role) VALUES ('456','23','REVIEWER');
INSERT INTO page_role(page_id,developer_id,role) VALUES ('456','34','WRITER');

/*
 PROFILE PAGE ROLE
*/
INSERT INTO page_role(page_id,developer_id,role) VALUES ('567','23','EDITOR');
INSERT INTO page_role(page_id,developer_id,role) VALUES ('567','34','REVIEWER');
INSERT INTO page_role(page_id,developer_id,role) VALUES ('567','12','WRITER');

/*
WIDGET TABLE
*/
#HEADING
INSERT INTO widget_generalization(widget_id,`name`,d_type,`text`,`order`,width,height, page_id) VALUES ('123','head123','HEADING','WELCOME','0',null,null,'123');
INSERT INTO widget_generalization(widget_id,`name`,d_type,`text`,`order`,width,height, page_id) VALUES ('345','head345','HEADING','Hi','1',null,null,'345');

#HTML
INSERT INTO widget_generalization(widget_id,`name`,d_type,html,`order`,width,height, page_id) VALUES ('234','post234','HTML','<p>Lorem</p>','0',null,null,'234');
INSERT INTO widget_generalization(widget_id,`name`,d_type,html,`order`,width,height, page_id) VALUES ('456','intro456','HTML','<h1>Hi</h1>','2',null,null,'345');

#IMAGE
INSERT INTO widget_generalization(widget_id,`name`,d_type,`text`,`order`,width,height, page_id, image_src) VALUES ('567','image345','IMAGE',null,'3','50','100','345','/img/567.png');

#YOUTUBE
INSERT INTO widget_generalization(widget_id,`name`,d_type,`text`,`order`,width,height, page_id, youtube_url) VALUES ('678','video456','YOUTUBE',null,'0','400','300','456','https://youtu.be/h67VX51QXIQ');

/*
PHONE TABLE
*/
INSERT INTO phone(person_id,phone,`primary`) VALUES ('12','123-234-3456','0');
INSERT INTO phone(person_id,phone,`primary`) VALUES ('12','234-345-4566','1');
INSERT INTO phone(person_id,phone,`primary`) VALUES ('23','345-456-5677','0');
INSERT INTO phone(person_id,phone,`primary`) VALUES ('34','321-432-5435','0');
INSERT INTO phone(person_id,phone,`primary`) VALUES ('34','432-432-5433','1');
INSERT INTO phone(person_id,phone,`primary`) VALUES ('34','543-543-6544','1');
/*
ADDRESS TABLE
*/
INSERT INTO address(person_id,street1,city,zip,`primary`) VALUES ('12','123 Adam St.','Alton','01234','0');
INSERT INTO address(person_id,street1,city,zip,`primary`) VALUES ('12','234 Birch St.','Boston','02345','1');
INSERT INTO address(person_id,street1,city,zip,`primary`) VALUES ('23','345 Charles St.','Chelms','03455','0');
INSERT INTO address(person_id,street1,city,zip,`primary`) VALUES ('23','456 Down St.','Dalton','04566','1');
INSERT INTO address(person_id,street1,city,zip,`primary`) VALUES ('23','543 East St.','Everett','01112','1');
INSERT INTO address(person_id,street1,city,zip,`primary`) VALUES ('34','Frank St.','Foulton','04322','0');