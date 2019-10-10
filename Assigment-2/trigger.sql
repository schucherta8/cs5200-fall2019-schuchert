DELIMITER $$
CREATE 
		TRIGGER create_website_priviledges AFTER INSERT
        ON website_role
		FOR EACH ROW BEGIN
				CASE 
						WHEN NEW.role = 'OWNER' OR NEW.role = 'ADMIN' THEN
								INSERT INTO website_priviledge(developer_id, website_id, priviledge) VALUES (NEW.developer_id, NEW.website_id, 'CREATE');
								INSERT INTO website_priviledge(developer_id, website_id, priviledge) VALUES (NEW.developer_id, NEW.website_id, 'READ');
								INSERT INTO website_priviledge(developer_id, website_id, priviledge) VALUES (NEW.developer_id, NEW.website_id, 'UPDATE');
								INSERT INTO website_priviledge(developer_id, website_id, priviledge) VALUES (NEW.developer_id, NEW.website_id, 'DELETE');
						WHEN NEW.role = 'WRITER' THEN
								INSERT INTO website_priviledge(developer_id, website_id, priviledge) VALUES (NEW.developer_id, NEW.website_id, 'CREATE');
								INSERT INTO website_priviledge(developer_id, website_id, priviledge) VALUES (NEW.developer_id, NEW.website_id, 'READ');
								INSERT INTO website_priviledge(developer_id, website_id, priviledge) VALUES (NEW.developer_id, NEW.website_id, 'UPDATE');
						WHEN NEW.role = 'EDITOR' THEN
								INSERT INTO website_priviledge(developer_id, website_id, priviledge) VALUES (NEW.developer_id, NEW.website_id, 'READ');
								INSERT INTO website_priviledge(developer_id, website_id, priviledge) VALUES (NEW.developer_id, NEW.website_id, 'UPDATE');
						WHEN NEW.role = 'REVIEWER' THEN
								INSERT INTO website_priviledge(developer_id, website_id, priviledge) VALUES (NEW.developer_id, NEW.website_id, 'READ');
						ELSE
								BEGIN
                                END;
				END CASE;
		END$$
	DELIMITER ;

DELIMITER $$
CREATE
		TRIGGER update_website_priviledge AFTER UPDATE
        ON website_role
        FOR EACH ROW BEGIN
				DELETE FROM website_priviledge WHERE OLD.developer_id = website_priviledge.developer_id AND OLD.website_id = website_priviledge.website_id;
                CASE 
						WHEN NEW.role = 'OWNER' AND NEW.role = 'ADMIN' THEN
								INSERT INTO website_priviledge(developer_id, website_id, priviledge) VALUES (NEW.developer_id, NEW.website_id, 'CREATE');
								INSERT INTO website_priviledge(developer_id, website_id, priviledge) VALUES (NEW.developer_id, NEW.website_id, 'READ');
								INSERT INTO website_priviledge(developer_id, website_id, priviledge) VALUES (NEW.developer_id, NEW.website_id, 'UPDATE');
								INSERT INTO website_priviledge(developer_id, website_id, priviledge) VALUES (NEW.developer_id, NEW.website_id, 'DELETE');
						WHEN NEW.role = 'WRITER' THEN
								INSERT INTO website_priviledge(developer_id, website_id, priviledge) VALUES (NEW.developer_id, NEW.website_id, 'CREATE');
								INSERT INTO website_priviledge(developer_id, website_id, priviledge) VALUES (NEW.developer_id, NEW.website_id, 'READ');
								INSERT INTO website_priviledge(developer_id, website_id, priviledge) VALUES (NEW.developer_id, NEW.website_id, 'UPDATE');
						WHEN NEW.role = 'EDITOR' THEN
								INSERT INTO website_priviledge(developer_id, website_id, priviledge) VALUES (NEW.developer_id, NEW.website_id, 'READ');
								INSERT INTO website_priviledge(developer_id, website_id, priviledge) VALUES (NEW.developer_id, NEW.website_id, 'UPDATE');
						WHEN NEW.role = 'REVIEWER' THEN
								INSERT INTO website_priviledge(developer_id, website_id, priviledge) VALUES (NEW.developer_id, NEW.website_id, 'READ');
						ELSE
								BEGIN
                                END;
				END CASE;
        END$$
DELIMITER ;

DELIMITER $$
CREATE 
		TRIGGER delete_website_priviledges AFTER DELETE
        ON website_role
		FOR EACH ROW BEGIN
				DELETE FROM website_priviledge WHERE OLD.developer_id = website_priviledge.developer_id AND OLD.website_id = website_priviledge.website_id;
		END$$
DELIMITER ;

DELIMITER $$
CREATE 
		TRIGGER create_page_priviledges AFTER INSERT
        ON page_role
		FOR EACH ROW BEGIN
				CASE 
						WHEN NEW.role = 'OWNER' OR NEW.role = 'ADMIN' THEN
								INSERT INTO papage_priviledgege_priviledge(developer_id, page_id, priviledge) VALUES (NEW.developer_id, NEW.page_id, 'CREATE');
								INSERT INTO page_priviledge(developer_id, page_id, priviledge) VALUES (NEW.developer_id, NEW.page_id, 'READ');
								INSERT INTO page_priviledge(developer_id, page_id, priviledge) VALUES (NEW.developer_id, NEW.page_id, 'UPDATE');
								INSERT INTO page_priviledge(developer_id, page_id, priviledge) VALUES (NEW.developer_id, NEW.page_id, 'DELETE');
						WHEN NEW.role = 'WRITER' THEN
								INSERT INTO page_priviledge(developer_id, page_id, priviledge) VALUES (NEW.developer_id, NEW.page_id, 'CREATE');
								INSERT INTO page_priviledge(developer_id, page_id, priviledge) VALUES (NEW.developer_id, NEW.page_id, 'READ');
								INSERT INTO page_priviledge(developer_id, page_id, priviledge) VALUES (NEW.developer_id, NEW.page_id, 'UPDATE');
						WHEN NEW.role = 'EDITOR' THEN
								INSERT INTO page_priviledge(developer_id, page_id, priviledge) VALUES (NEW.developer_id, NEW.page_id, 'READ');
								INSERT INTO page_priviledge(developer_id, page_id, priviledge) VALUES (NEW.developer_id, NEW.page_id, 'UPDATE');
						WHEN NEW.role = 'REVIEWER' THEN
								INSERT INTO page_priviledge(developer_id, page_id, priviledge) VALUES (NEW.developer_id, NEW.page_id, 'READ');
						ELSE
								BEGIN
                                END;
				END CASE;
		END$$
	DELIMITER ;

DELIMITER $$
CREATE
		TRIGGER update_page_priviledge AFTER UPDATE
        ON page_role
        FOR EACH ROW BEGIN
				DELETE FROM page_priviledge WHERE OLD.developer_id = page_priviledge.developer_id AND OLD.page_id = page_priviledge.page_id;
                CASE 
						WHEN NEW.role = 'OWNER' AND NEW.role = 'ADMIN' THEN
								INSERT INTO page_priviledge(developer_id, page_id, priviledge) VALUES (NEW.developer_id, NEW.page_id, 'CREATE');
								INSERT INTO page_priviledge(developer_id, page_id, priviledge) VALUES (NEW.developer_id, NEW.page_id, 'READ');
								INSERT INTO page_priviledge(developer_id, page_id, priviledge) VALUES (NEW.developer_id, NEW.page_id, 'UPDATE');
								INSERT INTO page_priviledge(developer_id, page_id, priviledge) VALUES (NEW.developer_id, NEW.page_id, 'DELETE');
						WHEN NEW.role = 'WRITER' THEN
								INSERT INTO page_priviledge(developer_id, page_id, priviledge) VALUES (NEW.developer_id, NEW.page_id, 'CREATE');
								INSERT INTO page_priviledge(developer_id, page_id, priviledge) VALUES (NEW.developer_id, NEW.page_id, 'READ');
								INSERT INTO page_priviledge(developer_id, page_id, priviledge) VALUES (NEW.developer_id, NEW.page_id, 'UPDATE');
						WHEN NEW.role = 'EDITOR' THEN
								INSERT INTO page_priviledge(developer_id, page_id, priviledge) VALUES (NEW.developer_id, NEW.page_id, 'READ');
								INSERT INTO page_priviledge(developer_id, page_id, priviledge) VALUES (NEW.developer_id, NEW.page_id, 'UPDATE');
						WHEN NEW.role = 'REVIEWER' THEN
								INSERT INTO page_priviledge(developer_id, page_id, priviledge) VALUES (NEW.developer_id, NEW.page_id, 'READ');
						ELSE
								BEGIN
                                END;
				END CASE;
        END$$
DELIMITER ;

DELIMITER $$
CREATE 
		TRIGGER delete_page_priviledges AFTER DELETE
        ON page_role
		FOR EACH ROW BEGIN
				DELETE FROM page_priviledge WHERE OLD.developer_id = page_priviledge.developer_id AND OLD.page_id = page_priviledge.page_id;
		END$$
DELIMITER ;


