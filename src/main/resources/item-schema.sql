DROP TABLE IF EXISTS item CASCADE;
CREATE TABLE item (
                      id BIGINT NOT NULL AUTO_INCREMENT,
                      brand VARCHAR(255),
                      colour VARCHAR(255),
                      name VARCHAR(255),
                      subtype VARCHAR(255),
                      type VARCHAR(255),
                      PRIMARY KEY (id)
);
