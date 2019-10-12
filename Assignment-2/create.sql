/*
Create schema cs5200_fall2019_schuchert
*/
CREATE SCHEMA cs5200_fall2019_schuchert;
USE cs5200_fall2019_schuchert;
/*
Person, User and Developer tables. 
*/
CREATE TABLE person_generalization (
person_id int NOT NULL AUTO_INCREMENT,
firstname varchar(255) NOT NULL,
lastname varchar(255) NOT NULL,
username varchar(255) NOT NULL,
`password` varchar(255) NOT NULL, 
email varchar(255) NOT NULL,
dob varchar(255),
PRIMARY KEY(person_id)
);
CREATE TABLE user_person_generalization (
user_id int NOT NULL AUTO_INCREMENT,
user_agreement boolean NOT NULL,
PRIMARY KEY(user_id),
CONSTRAINT user_person_generalization 
FOREIGN KEY(user_id) REFERENCES person_generalization(person_id) 
);
CREATE TABLE developer_person_generalization (
developer_id int NOT NULL AUTO_INCREMENT,
developer_key varchar(255) NOT NULL,
PRIMARY KEY(developer_id),
CONSTRAINT developer_person_generalization
FOREIGN KEY(developer_id) REFERENCES person_generalization(person_id)
);

/*
Website and Page tables
*/
CREATE TABLE website (
website_id int NOT NULL AUTO_INCREMENT,
`name` varchar(255) NOT NULL,
description varchar(255) NOT NULL,
created date,
updated date,
visits int NOT NULL,
PRIMARY KEY(website_id)
);

CREATE TABLE `page` (
page_id int NOT NULL AUTO_INCREMENT,
website_id int,
title varchar(255) NOT NULL,
description varchar(255) NOT NULL,
created date default '2019-09-04',
updated date default '2019-10-16',
views int NOT NULL,
PRIMARY KEY(page_id),
FOREIGN KEY(website_id) REFERENCES website(website_id) #1 to 0..*
	ON UPDATE CASCADE
    ON DELETE CASCADE
);

/*
Widget, Youtube,Image, Heading, and HTML tables.
*/
CREATE TABLE d_type(
`name` varchar(255) NOT NULL,
PRIMARY KEY(`name`)
);
INSERT INTO d_type(`name`) values ('YOUTUBE');
INSERT INTO d_type(`name`) values ('IMAGE');
INSERT INTO d_type(`name`) values ('HTML');
INSERT INTO d_type(`name`) values ('HEADING');


CREATE TABLE widget_generalization (
widget_id int NOT NULL AUTO_INCREMENT,
d_type varchar(255) NOT NULL,
page_id int,
`name` varchar(255) NOT NULL,
width int,
height int,
css_class varchar(255),
css_style varchar(255),
`text` varchar(255),
`order` int NOT NULL,
heading_size int DEFAULT 2, 
html varchar(255),
image_src varchar(255),
youtube_url varchar(255),
youtube_sharable varchar(255),
youtube_expandable boolean,
PRIMARY KEY(widget_id),
FOREIGN KEY(d_type) REFERENCES d_type(`name`), #ENUM
FOREIGN KEY(page_id)  REFERENCES `page`(page_id)#1 to 0..*
	ON UPDATE CASCADE
    ON DELETE CASCADE
);

/*
Person has Phone and Address tables
*/
CREATE TABLE phone(
phone_id int NOT NULL AUTO_INCREMENT,
person_id int NOT NULL,
phone varchar(255),
`primary` boolean NOT NULL,
PRIMARY KEY(phone_id),
FOREIGN KEY(person_id) REFERENCES person_generalization(person_id)
	on UPDATE CASCADE
	on DELETE CASCADE
);
CREATE TABLE address(
address_id int NOT NULL AUTO_INCREMENT,
person_id int NOT NULL,
street1 varchar(255) NOT NULL,
street2 varchar(255),
city varchar(255) NOT NULL,
state varchar(255),
zip varchar(255) NOT NULL,
`primary` boolean NOT NULL,
PRIMARY KEY(address_id),
FOREIGN KEY(person_id) REFERENCES person_generalization(person_id)
	on UPDATE CASCADE
	on DELETE CASCADE
);


/*
CREATE ENUM PRIVILEDGE AND ROLE
*/
CREATE TABLE priviledge (
`name` varchar(7) NOT NULL,
PRIMARY KEY(`name`)
);
INSERT INTO priviledge(`name`) values ('CREATE');
INSERT INTO priviledge(`name`) values ('READ');
INSERT INTO priviledge(`name`) values ('UPDATE');
INSERT INTO priviledge(`name`) values ('DELETE');

CREATE TABLE role (
`name` varchar(9) NOT NULL,
PRIMARY KEY(`name`)
);
INSERT INTO role(`name`) values ('OWNER');
INSERT INTO role(`name`) values ('ADMIN');
INSERT INTO role(`name`) values ('WRITER');
INSERT INTO role(`name`) values ('EDITOR');
INSERT INTO role(`name`) values ('REVIEWER');

/*
WebsitePriiledge, WebsiteRole, PagePriviledge, PageRole tables
*/
CREATE TABLE website_priviledge (
web_priviledge_id int NOT NULL AUTO_INCREMENT,
developer_id int NOT NULL,
website_id int NOT NULL,
priviledge varchar(7) NOT NULL,
PRIMARY KEY(web_priviledge_id),
FOREIGN KEY(priviledge) REFERENCES priviledge(`name`), #Enum
FOREIGN KEY(developer_id) REFERENCES developer_person_generalization(developer_id) ,#1 to 1..*
FOREIGN KEY(website_id) REFERENCES website(website_id) #1 to 1..*
         on DELETE CASCADE
);

CREATE TABLE website_role (
web_role_id int NOT NULL AUTO_INCREMENT,
role varchar(9) NOT NULL,
developer_id int NOT NULL,
website_id int NOT NULL,
PRIMARY KEY(web_role_id),
FOREIGN KEY(role) REFERENCES role(`name`), #ENUM
FOREIGN KEY(developer_id) REFERENCES developer_person_generalization(developer_id), #1 to 1..*
FOREIGN KEY(website_id) REFERENCES website(website_id)#1 to 1..*
		on DELETE CASCADE
);

CREATE TABLE page_priviledge (
page_priviledge_id int NOT NULL AUTO_INCREMENT,
developer_id int NOT NULL,
page_id int NOT NULL,
priviledge varchar(7) NOT NULL,
PRIMARY KEY(page_priviledge_id),
FOREIGN KEY(priviledge) REFERENCES priviledge(`name`),
FOREIGN KEY(developer_id) REFERENCES developer_person_generalization(developer_id),
FOREIGN KEY(page_id) REFERENCES `page`(page_id)
		on DELETE CASCADE
);

CREATE TABLE page_role (
page_role_id int NOT NULL AUTO_INCREMENT,
role varchar(9) NOT NULL,
developer_id int NOT NULL,
page_id int NOT NULL,
PRIMARY KEY(page_role_id),
FOREIGN KEY(role) REFERENCES role(`name`), #ENUM
FOREIGN KEY(developer_id) REFERENCES developer_person_generalization(developer_id), #1 to 1..*
FOREIGN KEY(page_id) REFERENCES `page`(page_id)#1 to 1..*
		on DELETE CASCADE
);