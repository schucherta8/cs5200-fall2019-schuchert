/*
QUESTION 1
*/
SELECT firstname, lastname
FROM developer_person_generalization JOIN person_generalization
ON developer_person_generalization.developer_id = person_generalization.person_id;

SELECT firstname, lastname
FROM developer_person_generalization, person_generalization
WHERE person_generalization.firstname = 'Charles' AND person_generalization.person_id = developer_person_generalization.developer_id;

SELECT firstname, lastname
FROM person_generalization
WHERE person_generalization.person_id IN 
		(SELECT developer_id
		FROM website_role, website
		WHERE website.website_id = 234 AND website.website_id = website_role.website_id AND website_role.role != 'OWNER');

SELECT firstname, lastname
FROM person_generalization
WHERE person_generalization.person_id IN 
		(SELECT developer_id
		FROM page_role
		WHERE page_role.role = 'REVIEWER' AND page_role.page_id IN (
				SELECT page_id
				FROM `page`
				WHERE views  < 300000)
		GROUP BY developer_id);

SELECT person_generalization.firstname, person_generalization.lastname
FROM person_generalization
	INNER JOIN developer_person_generalization
		ON developer_person_generalization.developer_id = person_generalization.person_id
	INNER JOIN page_role
		ON page_role.developer_id = developer_person_generalization.developer_id
	INNER JOIN `page`
		ON page_role.page_id = `page`.page_id
	INNER JOIN widget_generalization
		ON widget_generalization.page_id = `page`.page_id
	WHERE page_role.role = 'WRITER' AND widget_generalization.d_type = 'HEADING' AND `page`.title = 'HOME';

/*
Question 2
*/
SELECT MIN(visits) AS smallest_visits
FROM website;

SELECT `name`
FROM website
WHERE website.website_id = 678;

SELECT `name`
FROM website
WHERE website.website_id IN
		(SELECT page_id
		FROM page_role
		WHERE developer_id = 23 AND page_role.role = 'REVIEWER' AND page_role.page_id IN
				(SELECT page_id
				FROM widget_generalization
				WHERE widget_generalization.d_type = 'YOUTUBE')); 

SELECT `name`
FROM website
WHERE website.website_id IN
		(SELECT website_id
		FROM website_role
		WHERE website_role.role = 'OWNER' AND website_role.developer_id = 12);

SELECT `name`
FROM website
WHERE website.visits > 6000000 AND website.website_id IN
		(SELECT website_id
		FROM website_role
		WHERE website_role.role = 'ADMIN' AND website_role.developer_id = 34);
        
/*
QUESTION 3
*/
SET @max_views := (SELECT MAX(views) FROM `page`);
SELECT title
FROM `page`
WHERE `page`.views = @max_views;

SELECT title
FROM `page`
WHERE page_id = 234;

SELECT page_id 
FROM page_role
WHERE page_role.developer_id = 12 AND page_role.role = 'EDITOR';

SELECT SUM(views)
FROM `page`
WHERE `page`.website_id = 567;

SELECT AVG(views)
FROM `page`
WHERE `page`.website_id = 345;

/*
QUESTION 4
*/
SELECT title
FROM `page`
WHERE website_id = 567;

SELECT d_type
FROM widget_generalization
WHERE widget_generalization.d_type = 'YOUTUBE' AND page_id IN 
		(SELECT page_id
		FROM `page`, website
        WHERE `page`.website_id = website.website_id AND website.website_id = 456);
        
SELECT d_type
FROM widget_generalization
WHERE widget_generalization.d_type = 'IMAGE' AND  page_id IN
		(SELECT page_id
		FROM page_role
		WHERE page_role.role = 'REVIEWER' AND developer_id = 12);

SELECT COUNT(d_type) AS number_of_widgets
FROM widget_generalization
WHERE widget_generalization.page_id IN
		(SELECT page_id
        FROM `page`, website
        WHERE website.website_id = 345 AND `page`.website_id = website.website_id);
/*
QUESTION 5
*/
SELECT `name`
FROM website
WHERE website.website_id IN
		(SELECT website_id
		FROM website_priviledge
		WHERE developer_id = '23' AND website_priviledge.priviledge = 'DELETE');

SELECT title
FROM `page`
WHERE `page`.page_id IN
		(SELECT page_id
		FROM page_priviledge
		WHERE developer_id = '34' AND page_priviledge.priviledge = 'CREATE');