CREATE TABLE account (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    email_address VARCHAR(255) NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    terms_conditions_accept TINYINT(1) DEFAULT 0,
    postal_code VARCHAR(20) NULL,
    country VARCHAR(6) NULL,
    profile_id BIGINT UNSIGNED NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,
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

CREATE TABLE profile (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE tag (
     id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
     profile_id BIGINT UNSIGNED NOT NULL,
     name VARCHAR (30) NOT NULL,
     enabled TINYINT(1) DEFAULT 1,
     tag_type VARCHAR (20) NOT NULL,
     created_at DATETIME NOT NULL,
     updated_at DATETIME NOT NULL,
     PRIMARY KEY (id),
     FOREIGN KEY (profile_id) REFERENCES profile (id) ON DELETE CASCADE
) ENGINE = InnoDB;

INSERT INTO role VALUES ('USER');
INSERT INTO role VALUES ('ADMINISTRATOR')
