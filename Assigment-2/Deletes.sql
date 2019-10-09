/*
QUESTION 1
*/
DELETE FROM address
WHERE address.person_id = (SELECT person_id FROM person_generalization WHERE person_generalization.firstname = 'Alice')
AND address.`primary` = 0;

/*
QUESTION 2
*/
SET @max := (SELECT MAX(widget_generalization.`order`) FROM widget_generalization);
DELETE FROM widget_generalization
WHERE widget_generalization.page_id = (SELECT website_id FROM website WHERE website.`name` = 'Wikipedia') #WILL CHANGE LATER
AND widget_generalization.`order` = @max;

/*
QUESTION 3
*/
SET @most_recent := 
(SELECT MAX(updated) 
FROM `page` 
WHERE `page`.website_id = 
	(SELECT website_id
    FROM website
    WHERE website.`name` = 'Wikipedia'));
DELETE FROM `page`
WHERE  `page`.updated = @most_recent;

/*
QUESTION 4
*/

/*
TESTING DELETE TRIGGER
*/
DELETE FROM website_role
WHERE website_role.developer_id = 12 and website_role.role = 'OWNER'