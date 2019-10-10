/*
QUESTION 1
*/
DELETE FROM address
WHERE address.person_id = (SELECT person_id FROM person_generalization WHERE person_generalization.firstname = 'Alice')
AND address.`primary` = 0;

/*
QUESTION 2
*/
#Allows me to run delete without turning safe mode off
SET @max := (SELECT MAX(widget_generalization.`order`) FROM widget_generalization WHERE widget_generalization.page_id = (SELECT page_id FROM `page` WHERE `page`.title = 'Contact'));
DELETE FROM widget_generalization
WHERE widget_generalization.page_id = (SELECT page_id FROM `page` WHERE `page`.title = 'Contact')
AND widget_generalization.`order` = @max;
/*
QUESTION 3
*/
SET @most_recent := 
(SELECT MAX(updated) 
FROM `page` 
WHERE `page`.website_id = (SELECT website_id FROM website WHERE website.`name` = 'Wikipedia'));
DELETE FROM `page`
WHERE  `page`.updated = @most_recent;

/*
QUESTION 4
*/
DELETE FROM website
WHERE website.website_id = (SELECT website_id FROM website WHERE website.`name` = 'CNET')
