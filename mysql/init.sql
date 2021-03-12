set @CID = -1;

CREATE TABLE company (
            companyid int AUTO_INCREMENT primary key NOT NULL,
            name VARCHAR(64) NOT NULL
);

CREATE TABLE contacts (
            contactid int AUTO_INCREMENT primary key NOT NULL,
            companyid int NOT NULL,
            name VARCHAR(64) NOT NULL,
            email VARCHAR(128) NOT NULL,
            hash VARCHAR(32) NOT NULL
);

CREATE TABLE response (
        reseponseid int AUTO_INCREMENT primary key NOT NULL,
        hash VARCHAR(32) NOT NULL,
        event_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
        browser_version VARCHAR(32) NOT NULL,
        browser_name VARCHAR(32) NOT NULL,
        platform VARCHAR(16) NOT NULL
);

INSERT INTO company(name) VALUES('SERPENT');

select max(companyid) into @CID from company;


INSERT INTO contacts(companyid, name,email,hash) VALUES
(@CID ,'Some User', 'someuser@mail.com', '4d0c733ca9f0f43fcebe3d33cc4ae4e4'),
(@CID ,'Another User', 'anotheruser@dodoo.com', '7702b3548f8f64b2cd395745d8f3eaa4'),
(@CID , 'Me You', 'me@you.com', 'ca013b30f4ef743d22e6e91853c441cf');

