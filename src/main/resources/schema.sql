CREATE TABLE person (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    firstname VARCHAR(128) NOT NULL,
    lastname VARCHAR(128) NOT NULL,
    age  INTEGER      NOT NULL,
    PRIMARY KEY (id)
);

COMMIT;