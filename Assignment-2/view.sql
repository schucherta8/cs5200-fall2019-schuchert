CREATE VIEW developer_roles_and_priviledges
AS SELECT person_generalization.firstname, person_generalization.lastname, person_generalization.username, person_generalization.email, 
website.`name`, website.visits, website.updated AS website_updated,
website_role.role AS website_role, website_priviledge.priviledge AS website_priviledge,
 `page`.title, `page`.views, `page`.updated AS page_updated,
 page_role.role AS  page_role, page_priviledge.priviledge AS page_priviledge
FROM website 
				INNER JOIN `page`
						ON website.website_id  = `page`.page_id
                INNER JOIN website_role
						ON website_role.website_id = website.website_id
				INNER JOIN website_priviledge
						ON website_priviledge.website_id = website.website_id
				INNER JOIN developer_person_generalization
						ON developer_person_generalization.developer_id  = website_role.developer_id
				INNER JOIN person_generalization
						ON person_generalization.person_id = developer_person_generalization.developer_id
				INNER JOIN page_role
						ON page_role.page_id = `page`.page_id
				INNER JOIN page_priviledge
						ON page_priviledge.page_id = `page`.page_id