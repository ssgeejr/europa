CREATE TABLE clients (
	    clientid int AUTO_INCREMENT primary key NOT NULL,
	    name VARCHAR(64) NOT NULL,
	    email VARCHAR(255) NOT NULL,
	    tracking_key VARCHAR(255) NOT NULL 
);

INSERT INTO clients(name,email,tracking_key) VALUES
('Some User', 'someuser@mail.com','4d0c733ca9f0f43fcebe3d33cc4ae4e4'),
('Another User','anotheruser@dodoo.com','7702b3548f8f64b2cd395745d8f3eaa4'),
('Me You', 'me@you.com','ca013b30f4ef743d22e6e91853c441cf');
