/*
Question 1 
*/
UPDATE phone SET phone.phone = '334-444-555'
WHERE phone.person_id = (SELECT person_id FROM person_generalization WHERE person_generalization.firstname = 'Alice') 
AND phone.primary = '0';

/*
Question 2
*/
UPDATE widget_generalization SET widget_generalization.order = 3
WHERE widget_generalization.name = 'head345';

/*
Question 3
*/
UPDATE `page` SET `page`.title = CONCAT('CNET - ',`page`.title)
WHERE `page`.website_id = (SELECT website_id FROM website WHERE website.`name` = 'CNET');

/*
Question 4
*/
SET @bob_role = (SELECT role FROM page_role WHERE page_role.developer_id = '23' AND page_id = '123');
SET @charlie_role = (SELECT role FROM page_role WHERE page_role.developer_id = '34' AND page_id = '123');