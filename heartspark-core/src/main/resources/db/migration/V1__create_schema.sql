CREATE TABLE account (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    email_address VARCHAR(255) NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    terms_conditions_accept TINYINT(1) DEFAULT 0,
    postal_code VARCHAR(20) NULL,
    country VARCHAR(6) NULL,
    profile_id BIGINT UNSIGNED NOT NULL,
    credit_id BIGINT UNSIGNED NOT NULL,
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

CREATE TABLE account_credit (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    tokens INTEGER DEFAULT 0,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE profile (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    gender VARCHAR(6) NOT NULL,
    matched_gender VARCHAR(6) NOT NULL,
    date_of_birth DATE NULL,
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

CREATE TABLE tag_profile_map (
    tag_id BIGINT UNSIGNED NOT NULL,
    profile_id BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (tag_id, profile_id),
    FOREIGN KEY (tag_id) REFERENCES tag (id) ON DELETE CASCADE,
    FOREIGN KEY (profile_id) REFERENCES profile (id) ON DELETE CASCADE
) ENGINE = InnoDB;

CREATE TABLE payment_type (
    type VARCHAR(15) NOT NULL,
    enabled TINYINT(1) DEFAULT 1,
    PRIMARY KEY (type)
);

CREATE TABLE currency_type (
    code VARCHAR(3) NOT NULL,
    payment_type VARCHAR(15) NOT NULL,
    enabled BIT DEFAULT 1,
    name VARCHAR(25) NOT NULL,
    symbol VARCHAR(5) NULL,
    lowest_denom_ratio INTEGER NOT NULL,
    PRIMARY KEY (code),
    FOREIGN KEY (payment_type) REFERENCES payment_type (type)
);

CREATE TABLE token_modifier (
    id VARCHAR (30) NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE store (
   id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
   name  VARCHAR (30) NOT NULL,
   created_at DATETIME NOT NULL,
   updated_at DATETIME NOT NULL,
   PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE store_item_category (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    parent_id BIGINT UNSIGNED NULL,
    store_id BIGINT UNSIGNED NOT NULL,
    name VARCHAR(40) NOT NULL,
    description VARCHAR (255) NULL,
    display_text VARCHAR (255) NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (store_id) REFERENCES store (id) ON DELETE CASCADE,
    FOREIGN KEY (parent_id) REFERENCES store_item_category (id) ON DELETE CASCADE
) ENGINE = InnoDB;

CREATE TABLE store_item (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    store_item_category_id BIGINT UNSIGNED NULL,
    enabled BIT DEFAULT 1,
    name VARCHAR(40) NOT NULL,
    short_description VARCHAR(255) NULL,
    token_modifier VARCHAR (30) NOT NULL DEFAULT 'DEFAULT',
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (store_item_category_id) REFERENCES store_item_category (id) ON DELETE CASCADE,
    FOREIGN KEY (token_modifier) REFERENCES token_modifier (id)
) ENGINE = InnoDB;

CREATE TABLE store_item_price (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    store_item_id BIGINT UNSIGNED NOT NULL,
    sku VARCHAR(36) NOT NULL,
    code VARCHAR(3) NOT NULL,
    value INTEGER NOT NULL,
    tokens INTEGER NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (code) REFERENCES currency_type (code),
    FOREIGN KEY (store_item_id) REFERENCES store_item (id) ON DELETE CASCADE
) ENGINE = InnoDB;

CREATE TABLE basket_status (
    status VARCHAR(10) NOT NULL,
    PRIMARY KEY (status)
) ENGINE = InnoDB;

CREATE TABLE basket (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    account_id BIGINT UNSIGNED NOT NULL,
    status VARCHAR(10) NOT NULL DEFAULT 'PENDING',
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (account_id) REFERENCES account (id) ON DELETE CASCADE,
    FOREIGN KEY (status) REFERENCES basket_status (status)
) ENGINE = InnoDB;

CREATE TABLE basket_item (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    basket_id BIGINT UNSIGNED NOT NULL,
    store_item_price_id BIGINT UNSIGNED NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (basket_id) REFERENCES basket (id) ON DELETE CASCADE,
    FOREIGN KEY (store_item_price_id) REFERENCES store_item_price (id)
) ENGINE = InnoDB;

CREATE TABLE basket_transaction (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    basket_id BIGINT UNSIGNED NOT NULL,
    error_code VARCHAR (255) NULL,
    error_reason TEXT NULL,
    purchase_token VARCHAR (255) NULL,
    ext_customer_id VARCHAR (255) NULL,
    ext_receipt VARCHAR (255) NULL,
    ext_status VARCHAR (255) NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (basket_id) REFERENCES basket (id) ON DELETE CASCADE
) ENGINE = InnoDB;

CREATE TABLE message (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    source_profile_id BIGINT UNSIGNED NOT NULL,
    dest_profile_id BIGINT UNSIGNED NOT NULL,
    content TEXT,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (source_profile_id) REFERENCES profile (id) ON DELETE CASCADE,
    FOREIGN KEY (dest_profile_id) REFERENCES profile (id) ON DELETE CASCADE
) ENGINE = InnoDB;

-- Security
INSERT INTO role VALUES ('USER');
INSERT INTO role VALUES ('ADMINISTRATOR');

-- Token Modifiers
INSERT INTO token_modifier (id) VALUES ('DEFAULT');
INSERT INTO token_modifier (id) VALUES ('TOKEN_INCREMENTER');
INSERT INTO token_modifier (id) VALUES ('TOKEN_DECREMENTER');

INSERT INTO payment_type (type, enabled) VALUES ('CURRENCY', 1);
INSERT INTO payment_type (type, enabled) VALUES ('TOKEN', 1);

INSERT INTO currency_type (code, payment_type, name, symbol, lowest_denom_ratio) VALUES ('GBP', 'CURRENCY', 'Pound', '£', 100);
INSERT INTO currency_type (code, payment_type, name, symbol, lowest_denom_ratio) VALUES ('EUR', 'CURRENCY', 'Euro', '€', 100);
INSERT INTO currency_type (code, payment_type, name, lowest_denom_ratio) VALUES ('TOK', 'TOKEN', 'Token', 1);

-- Store
INSERT INTO store (id, name, created_at, updated_at) VALUES (1, 'HeartSpark Store', NOW(), NOW());

INSERT INTO store_item_category (id, store_id, name, description, display_text, created_at, updated_at) VALUES (1, 1, 'SPARKS_PACK', 'Sparks Pack', 'Sparks Packs', NOW(), NOW());
INSERT INTO store_item_category (id, store_id, name, description, display_text, created_at, updated_at) VALUES (2, 1, 'TEXT_MESSAGE', 'Send a message', 'Text Messages', NOW(), NOW());

INSERT INTO store_item (id, store_item_category_id, enabled, name, short_description, token_modifier, created_at, updated_at) VALUES (1, 1, true, '100 Sparks Pack', 'Sparks Pack containing 100 Sparks', 'TOKEN_INCREMENTER', NOW(), NOW());
INSERT INTO store_item (id, store_item_category_id, enabled, name, short_description, token_modifier, created_at, updated_at) VALUES (2, 1, true, '200 Sparks Pack', 'Sparks Pack containing 200 Sparks', 'TOKEN_INCREMENTER', NOW(), NOW());
INSERT INTO store_item (id, store_item_category_id, enabled, name, short_description, token_modifier, created_at, updated_at) VALUES (3, 1, true, '500 Sparks Pack', 'Sparks Pack containing 500 Sparks', 'TOKEN_INCREMENTER', NOW(), NOW());
INSERT INTO store_item (id, store_item_category_id, enabled, name, short_description, token_modifier, created_at, updated_at) VALUES (4, 1, true, '1000 Sparks Pack', 'Sparks Pack containing 1000 Sparks', 'TOKEN_INCREMENTER', NOW(), NOW());
INSERT INTO store_item (id, store_item_category_id, enabled, name, short_description, token_modifier, created_at, updated_at) VALUES (5, 1, true, '2000 Sparks Pack', 'Sparks Pack containing 2000 Sparks', 'TOKEN_INCREMENTER', NOW(), NOW());
INSERT INTO store_item (id, store_item_category_id, enabled, name, short_description, token_modifier, created_at, updated_at) VALUES (6, 1, true, '5000 Sparks Pack', 'Sparks Pack containing 5000 Sparks', 'TOKEN_INCREMENTER', NOW(), NOW());
INSERT INTO store_item (id, store_item_category_id, enabled, name, short_description, token_modifier, created_at, updated_at) VALUES (7, 1, true, '10000 Sparks Pack', 'Sparks Pack containing 10000 Sparks', 'TOKEN_INCREMENTER', NOW(), NOW());
INSERT INTO store_item (id, store_item_category_id, enabled, name, short_description, token_modifier, created_at, updated_at) VALUES (8, 1, true, '15000 Sparks Pack', 'Sparks Pack containing 15000 Sparks', 'TOKEN_INCREMENTER', NOW(), NOW());
INSERT INTO store_item (id, store_item_category_id, enabled, name, short_description, token_modifier, created_at, updated_at) VALUES (9, 2, true, 'Text message', 'Sending a text message', 'TOKEN_DECREMENTER', NOW(), NOW());

INSERT INTO store_item_price (id, store_item_id, sku, code, value, tokens, created_at, updated_at) VALUES (1, 1, 'e4be7c76-139d-4162-8928-565b678ad39d', 'GBP', 49, 100, NOW(), NOW());
INSERT INTO store_item_price (id, store_item_id, sku, code, value, tokens, created_at, updated_at) VALUES (2, 2, 'e4be7c76-139d-4162-8928-565b678ad39e', 'GBP', 99, 200, NOW(), NOW());
INSERT INTO store_item_price (id, store_item_id, sku, code, value, tokens, created_at, updated_at) VALUES (3, 3, 'e4be7c76-139d-4162-8928-565b678ad39f', 'GBP', 149, 500, NOW(), NOW());
INSERT INTO store_item_price (id, store_item_id, sku, code, value, tokens, created_at, updated_at) VALUES (4, 4, 'e4be7c76-139d-4162-8928-565b678ad3a0', 'GBP', 199, 1000, NOW(), NOW());
INSERT INTO store_item_price (id, store_item_id, sku, code, value, tokens, created_at, updated_at) VALUES (5, 5, 'e4be7c76-139d-4162-8928-565b678ad3a1', 'GBP', 349, 2000, NOW(), NOW());
INSERT INTO store_item_price (id, store_item_id, sku, code, value, tokens, created_at, updated_at) VALUES (6, 6, 'e4be7c76-139d-4162-8928-565b678ad3a2', 'GBP', 599, 5000, NOW(), NOW());
INSERT INTO store_item_price (id, store_item_id, sku, code, value, tokens, created_at, updated_at) VALUES (7, 7, 'e4be7c76-139d-4162-8928-565b678ad3a3', 'GBP', 999, 10000, NOW(), NOW());
INSERT INTO store_item_price (id, store_item_id, sku, code, value, tokens, created_at, updated_at) VALUES (8, 8, 'e4be7c76-139d-4162-8928-565b678ad3a4', 'GBP', 1299, 15000, NOW(), NOW());
INSERT INTO store_item_price (id, store_item_id, sku, code, value, created_at, updated_at) VALUES (9, 9, 'e4be7c76-139d-4162-8928-565b678bd39d', 'TOK', 10, NOW(), NOW());
