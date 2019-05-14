CREATE TABLE account (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    email_address VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE credential (
    email_address VARCHAR(255) NOT NULL,
    password CHAR(60) NOT NULL,
    PRIMARY KEY (email_address)
) ENGINE = InnoDB;

CREATE TABLE role (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE account_role_map (
    account_id BIGINT UNSIGNED NOT NULL,
    role_id BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (account_id, role_id),
    FOREIGN KEY (account_id) REFERENCES account (id),
    FOREIGN KEY (role_id) REFERENCES role (id)
) ENGINE = InnoDB;
