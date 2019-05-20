CREATE TABLE account (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    email_address VARCHAR(255) NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE credential (
    email_address VARCHAR(255) NOT NULL,
    password CHAR(60) NOT NULL,
    PRIMARY KEY (email_address)
) ENGINE = InnoDB;

CREATE TABLE role (
    name VARCHAR(15) NOT NULL,
    PRIMARY KEY (name)
) ENGINE = InnoDB;

CREATE TABLE account_role_map (
    account_id BIGINT UNSIGNED NOT NULL,
    role_name VARCHAR(15) NOT NULL,
    PRIMARY KEY (account_id, role_name),
    FOREIGN KEY (account_id) REFERENCES account (id),
    FOREIGN KEY (role_name) REFERENCES role (name)
) ENGINE = InnoDB;

INSERT INTO role VALUES ('USER');
INSERT INTO role VALUES ('ADMINISTRATOR')
