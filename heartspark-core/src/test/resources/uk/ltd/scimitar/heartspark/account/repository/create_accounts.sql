INSERT INTO profile (id, gender, matched_gender, date_of_birth, profile_name, profile_message, tag_line, created_at, updated_at) VALUES (1, 'MALE', 'FEMALE', '1940-11-27', 'Bruce', 'Welcome', 'Tag line', NOW(), NOW());
INSERT INTO account_credit (id, tokens, created_at, updated_at) VALUES (1, 5000, NOW(), NOW());
INSERT INTO account (id, email_address, first_name, terms_conditions_accept, postal_code, country, credit_id, profile_id, created_at, updated_at) VALUES (1, 'bruce.lee@jeetkune.do', 'Bruce', 1, '98101', 'en-US', 1, 1, NOW(), NOW());
INSERT INTO credential (email_address, password) VALUES ('bruce.lee@jeetkune.do', 'password');
INSERT INTO account_role_map VALUES (1, 'USER');
INSERT INTO tag (id, profile_id, name, enabled, tag_type, created_at, updated_at) VALUES (1, 1, 'Matches', 1, 'MATCHED', NOW(), NOW());
