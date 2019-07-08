INSERT INTO profile (id, created_at, updated_at) VALUES (1, NOW(), NOW());
INSERT INTO account (id, email_address, first_name, terms_conditions_accept, postal_code, country, profile_id, created_at, updated_at) VALUES (1, 'bruce.lee@jeetkune.do', 'Bruce', 1, '98101', 'en-US', 1, NOW(), NOW());
INSERT INTO credential (email_address, password) VALUES ('bruce.lee@jeetkune.do', 'password');
INSERT INTO account_role_map VALUES (1, 'USER');
INSERT INTO tag (id, profile_id, name, enabled, tag_type, created_at, updated_at) VALUES (1, 1, 'Matches', 1, 'MATCHED', NOW(), NOW());
