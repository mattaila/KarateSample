DROP TABLE IF EXISTS SAMPLE;

CREATE TABLE SAMPLE (
    ID IDENTITY NOT NULL PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    DESCRIPTION VARCHAR(255)
);