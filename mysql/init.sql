CREATE TABLE contacts (
            contactid int AUTO_INCREMENT primary key NOT NULL,
            name VARCHAR(64) NOT NULL,
            email VARCHAR(128) NOT NULL,
            hash VARCHAR(32) NOT NULL
);

CREATE TABLE responses (
	reseponseid int AUTO_INCREMENT primary key NOT NULL,
	hash VARCHAR(32) NOT NULL,
	event_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	browser_codename VARCHAR(32) NOT NULL,
	browser_name VARCHAR(32) NOT NULL,
	platform VARCHAR(16) NOT NULL,
	browser_version VARCHAR(128) NOT NULL,
	agent_header VARCHAR(128) NOT NULL
);

INSERT INTO clients(name,email,hash) VALUES
('Some User', 'someuser@mail.com','4d0c733ca9f0f43fcebe3d33cc4ae4e4'),
('Another User','anotheruser@dodoo.com','7702b3548f8f64b2cd395745d8f3eaa4'),
('Me You', 'me@you.com','ca013b30f4ef743d22e6e91853c441cf');
